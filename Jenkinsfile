pipeline {
    agent any
    stages {
        stage('Run the Test') {
            steps {
                sh '/usr/local/bin/docker-compose up --abort-on-container-exit'
            }
        post {
            always {
                script {
                    echo 'Reporting ...'
                    def properties = "VERSION=20.11.0-SNAPSHOT"
                    properties += "\nSUITE=all-test-suite"
                    properties += "\nENVIRONMENT=warpdrive-lab"
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
