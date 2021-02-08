pipeline {
    agent {
        docker {
            image 'maven:3.6.3-openjdk-8'
        }
    }
    parameters {
        choice(
          choices: ['VERSION=20.12.0-SNAPSHOT', 'VERSION=20.11.0-SNAPSHOT', 'VERSION=20.10.0-SNAPSHOT', 'VERSION=20.9.0-SNAPSHOT'],
          description: 'Select an agent version.',
          name: 'AGENT')
        choice(
          choices: ['ePod', 'MT'],
          description: 'Select an environment.',
          name: 'ENVIRONMENT')
        choice(
          choices: ['All', 'Attachment', 'Blast', 'Echo', 'Registration'],
          description: 'Select an environment.',
          name: 'SUITE')
    }
    environment {
        AUTOMATED_AGENT_VERSION = "${params.AGENT}"
        AUTOMATED_AGENT_SUITE = "${params.AGENT}"
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
                    def properties = "${env.AUTOMATED_AGENT_VERSION}"
                    properties += "\nSUITE=${env.AUTOMATED_AGENT_SUITE}"
                    properties += "\nENVIRONMENT=${env.AUTOMATED_AGENT_ENV}"
                    writeFile(file: "allure-results/environment.properties", text: properties, encoding: "UTF-8")
                    allure([
                        includeProperties: false,
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
