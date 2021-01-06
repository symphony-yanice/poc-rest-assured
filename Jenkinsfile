pipeline {
    agent {
        docker {
            image 'openjdk:8-jdk'
        }
    }
    stages {
        stage('Test Build') {
            steps {
                sh 'echo \"Run the Integration tests\"'
                sh 'mvn clean install'
            }
        }
    }
    post {
         always {
             script {
                 echo 'Reporting ...'
                 sh 'chmod -R 755 build'
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