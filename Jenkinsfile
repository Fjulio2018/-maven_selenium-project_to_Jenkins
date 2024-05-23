pipeline {
    agent any

    environment {
        MAVEN_HOME = '/usr/share/maven'
        PATH = "$PATH:$MAVEN_HOME/bin"
        CHROME_VERSION = '125.0.6422.76'
    }

    stages {
        stage('Checkout SCM') {
            steps {
                checkout scm
            }
        }

        stage('Update WebDriverManager') {
            steps {
                sh "sudo webdriver-manager update --versions.chrome=${CHROME_VERSION}"
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean test'
            }
        }
    }

    post {
        always {
            // Comandos para limpar efeitos colaterais, se necessário
        }
        success {
            // Comandos a serem executados em caso de sucesso
        }
        failure {
            // Comandos a serem executados em caso de falha
        }
    }
}
