pipeline {
    agent any
    parameters {
        choice(
          choices: ['VERSION=20.12.0-SNAPSHOT', 'VERSION=20.11.0-SNAPSHOT', 'VERSION=20.10.0-SNAPSHOT', 'VERSION=20.9.0-SNAPSHOT'],
          description: 'Select an agent version.',
          name: 'AGENT')
        choice(
          choices: ['ePod', 'MT'],
          description: 'Select an architecture.',
          name: 'ENVIRONMENT')
        choice(
          choices: ['All', 'Attachment', 'Datafeed', 'Firehose', 'Healthcheck', 'Messaging', 'Registration', 'Signals'],
          description: 'Select a test suite.',
          name: 'SUITE')
    }
    environment {
        AUTOMATED_AGENT_VERSION = "${params.AGENT}"
        AUTOMATED_AGENT_SUITE = "${params.SUITE}"
        AUTOMATED_AGENT_ENV = "${params.ENVIRONMENT}"
    }
    stages {
        stage('Run the E2E Tests') {
            agent {
                docker {
                    image   'maven:3.6.3-openjdk-8'
                }
            }
            steps {
                timestamps {
                    sh 'mvn clean test'
                }
            }
        }
    }
    post {
        always {
            script {
                def now = new Date()
                TODAY = now.format("MMM dd, yyyy", TimeZone.getTimeZone('UTC'))
                def properties = "${env.AUTOMATED_AGENT_VERSION}"
                properties += "\nSUITE          =   ${env.AUTOMATED_AGENT_SUITE}"
                properties += "\nINFRASTRUCTURE =   ${env.AUTOMATED_AGENT_ENV}"
                properties += "\nDATE           =   ${TODAY}"
                writeFile(file: "allure-results/environment.properties", text: properties, encoding: "UTF-8")
                allure([
                    includeProperties: true,
                    jdk: '',
                    properties: [],
                    configPath: 'src/test/resources/allure-plugins.yml',
                    reportBuildPolicy: 'ALWAYS',
                    results: [[path: 'build/allure-results']]
                ])
            }
        }
    }
}

