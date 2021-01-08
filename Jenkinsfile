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
                    allure([
                        includeProperties: false,
                        jdk: '',
                        properties: [],
                        reportBuildPolicy: 'ALWAYS',
                        results: [[path: 'build/allure-results']]
                    ])
                    cucumber buildStatus: "UNSTABLE",
                                        fileIncludePattern: "**/cucumber.json",
                                        jsonReportDirectory: 'build'
                }
            }
        }
        }
    }
}
