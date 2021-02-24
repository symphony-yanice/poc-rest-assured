@Library(['sym-pipeline@master'])

import com.symphony.cicd.SymphonyCICDUtils

pipeline {
    agent {
        docker {
            image   'maven:3.6.3-openjdk-8'
        }
    }
    parameters {
        string(
          defaultValue: 'https://develop2.symphony.com/agent',
          description: 'Select a base URL.',
          name: 'AUTOMATED_AGENT_BASEURL')
        string(
          defaultValue: '20.10.0',
          description: 'Select a pod version.',
          name: 'AUTOMATED_POD_VERSION')
        string(
          defaultValue: '2.62.2',
          description: 'Select an agent version.',
          name: 'AUTOMATED_AGENT_VERSION')
        choice(
          choices: ['ePod', 'MT'],
          description: 'Select an infrastructure.',
          name: 'AUTOMATED_AGENT_ENV')
        choice(
          choices: ['All', 'Attachment', 'Datafeed', 'Firehose', 'Healthcheck', 'Messaging', 'Registration', 'Signals'],
          description: 'Select a test suite.',
          name: 'AUTOMATED_AGENT_SUITE')
    }
    environment {
        AUTOMATED_AGENT_BASEURL = "${params.AUTOMATED_AGENT_BASEURL}"
        AUTOMATED_POD_VERSION = "${params.AUTOMATED_POD_VERSION}"
        AUTOMATED_AGENT_VERSION = "${params.AUTOMATED_AGENT_VERSION}"
        AUTOMATED_AGENT_SUITE = "${params.AUTOMATED_AGENT_SUITE}"
        AUTOMATED_AGENT_ENV = "${params.AUTOMATED_AGENT_ENV}"
    }
    stages {
        stage('Run the E2E Tests') {
            withCredentials([[$class: 'AmazonWebServicesCredentialsBinding', credentialsId: 'sym-aws-qa', accessKeyVariable: 'AWS_ACCESS_KEY_ID', secretKeyVariable: 'AWS_SECRET_ACCESS_KEY']]) {
                env.xRayUser = sh(script: "AWS_ACCESS_KEY_ID=${AWS_ACCESS_KEY_ID} AWS_SECRET_ACCESS_KEY=${AWS_SECRET_ACCESS_KEY} aws ssm get-parameter --name /qa/xray/user --with-decryption --region us-east-1 --query Parameter.Value", returnStdout: true).trim()
                env.xRayToken = sh(script: "AWS_ACCESS_KEY_ID=${AWS_ACCESS_KEY_ID} AWS_SECRET_ACCESS_KEY=${AWS_SECRET_ACCESS_KEY} aws ssm get-parameter --name /qa/xray/token --with-decryption --region us-east-1 --query Parameter.Value", returnStdout: true).trim()
            }
            steps {
                script {
                    sh 'mvn clean test && chmod -R 777 ./allure-results'
                }
            }
        }
    }
    post {
        always {
            script {
                def now = new Date()
                TODAY = now.format("MMM dd, yyyy - hh:mm", TimeZone.getTimeZone('UTC'))
                def properties = "AGENT_VERSION             =   ${env.AUTOMATED_AGENT_VERSION}"
                properties += "\nPOD_VERSION                =   ${env.AUTOMATED_POD_VERSION}"
                properties += "\nSUITE                      =   ${env.AUTOMATED_AGENT_SUITE}"
                properties += "\nINFRASTRUCTURE             =   ${env.AUTOMATED_AGENT_ENV}"
                properties += "\nDATE                       =   ${TODAY}"
                def jiraProperties = "ALLURE_JIRA_ENDPOINT  =   https://perzoinc.atlassian.net/rest"
                jiraProperties += "\nALLURE_JIRA_USERNAME   =   ${env.xRayUser}"
                jiraProperties += "\nALLURE_JIRA_PASSWORD   =   ${env.xRayToken}"
                jiraProperties += "\nALLURE_XRAY_ENABLED=true"
                writeFile(file: "allure-results/environment.properties", text: properties, encoding: "UTF-8")
                writeFile(file: "allure-results/jira.properties", text: jiraProperties, encoding: "UTF-8")
                allure([
                    configPath: 'src/test/resources/config.yml',
                    reportBuildPolicy: 'ALWAYS',
                    results: [[path: 'allure-results']]
                ])
            }
        }
    }
}

