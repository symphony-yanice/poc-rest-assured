pipeline {
    agent {
        docker {
            image 'maven:3.6.3-openjdk-8'
        }
    }
    stages {
        stage('Run the Test') {
            steps {
                sh 'mvn clean install && chmod -R 777 ./allure-results'
            }
        post {
            always {
                script {
                    echo 'Reporting ...'
                    def properties = "VERSION=20.11.0-SNAPSHOT"
                    properties += "\nSUITE=all-test-suite"
                    properties += "\nENVIRONMENT=warpdrive-lab"
                    writeFile(file: "build/allure-results/environment.properties", text: properties, encoding: "UTF-8")
                    allure results: [[path: 'build/allure-results']]
                }
            }
        }
        }
    }
}
