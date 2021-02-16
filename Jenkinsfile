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
          name: 'BASEURL')
        string(
          defaultValue: '20.10.0',
          description: 'Select a pod version.',
          name: 'PODVERSION')
        string(
          defaultValue: '2.62.2',
          description: 'Select an agent version.',
          name: 'AGENTVERSION')
        choice(
          choices: ['ePod', 'MT'],
          description: 'Select an infrastructure.',
          name: 'ENVIRONMENT')
        choice(
          choices: ['All', 'Attachment', 'Datafeed', 'Firehose', 'Healthcheck', 'Messaging', 'Registration', 'Signals'],
          description: 'Select a test suite.',
          name: 'SUITE')
    }
    environment {
        AUTOMATED_AGENT_BASEURL = "${params.BASEURL}"
        AUTOMATED_POD_VERSION = "${params.PODVERSION}"
        AUTOMATED_AGENT_VERSION = "${params.AGENTVERSION}"
        AUTOMATED_AGENT_SUITE = "${params.SUITE}"
        AUTOMATED_AGENT_ENV = "${params.ENVIRONMENT}"
    }
    stages {
        stage('Run the E2E Tests') {
            steps {
                script {
                    def apiProperties = "api.agent.baseurl=${env.AUTOMATED_AGENT_BASEURL}"
                    def dataProperties = "pod.version=${env.AUTOMATED_POD_VERSION}"
                    dataProperties += "\nagent.version=${env.AUTOMATED_AGENT_VERSION}"
                    writeFile(file: "src/test/resources/configuration/environment/api.properties",
                        text: apiProperties,
                        encoding: "UTF-8")
                    writeFile(file: "src/test/resources/configuration/environment/data.properties",
                        text: dataProperties,
                        encoding: "UTF-8")
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
                def properties = "AGENT_VERSION   =   ${env.AUTOMATED_AGENT_VERSION}"
                properties += "\nPOD_VERSION    =   ${env.AUTOMATED_POD_VERSION}"
                properties += "\nSUITE          =   ${env.AUTOMATED_AGENT_SUITE}"
                properties += "\nINFRASTRUCTURE =   ${env.AUTOMATED_AGENT_ENV}"
                properties += "\nDATE           =   ${TODAY}"
                writeFile(file: "allure-results/environment.properties", text: properties, encoding: "UTF-8")
                allure([
                    includeProperties: false,
                    jdk: '',
                    properties: [],
                    configPath: 'src/test/resources/config.yml',
                    reportBuildPolicy: 'ALWAYS',
                    results: [[path: 'allure-results']]
                ])
            }
        }
    }
}

