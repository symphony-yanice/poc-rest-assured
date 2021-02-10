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
        stage('Run the Test') {
            steps {
                sh '/usr/local/bin/docker-compose up --abort-on-container-exit'
            }
        post {
            always {
                script {
                    echo 'Reporting ...'
                    def now = new Date()
                    TODAY = now.format("MMM dd, yyyy", TimeZone.getTimeZone('UTC'))
                    def properties = "${env.AUTOMATED_AGENT_VERSION}"
                    properties += "\nSUITE          =   ${env.AUTOMATED_AGENT_SUITE}"
                    properties += "\nARCHITECTURE   =   ${env.AUTOMATED_AGENT_ENV}"
                    properties += "\nDATE           =   ${TODAY}"
                    writeFile(file: "allure-results/environment.properties", text: properties, encoding: "UTF-8")
                    def patterns = "allure.issues.tracker.pattern=https://perzoinc.atlassian.net/browse/%s"
                    writeFile(file: "allure-results/allure.properties", text: patterns, encoding: "UTF-8")
                    allure([
                        includeProperties: true,
                        jdk: '',
                        properties: [],
                        reportBuildPolicy: 'ALWAYS',
                        results: [[path: 'allure-results']]
                        ])
                    }
                }
            }
        }
    }
}
