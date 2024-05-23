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

        stage('Setup') {
            steps {
                // Atualiza o WebDriverManager
                sh 'webdriver-manager update'
            }
        }
        stage('Start WebDriverManager') {
            steps {
                // Inicia o WebDriverManager
                sh 'webdriver-manager start'
            }
        }
        stage('Run Tests') {
            steps {
                // Execute seus testes aqui
                sh 'mvn clean test'
            }
        }
    } // Faltava este bloco para fechar as stages

    post {
        always {
            // Passos a serem executados independentemente do resultado
            echo 'Pipeline concluded'
        }
        success {
            // Passos a serem executados em caso de sucesso
            echo 'Pipeline succeeded'
        }
        failure {
            // Passos a serem executados em caso de falha
            echo 'Pipeline failed'
        }
    }
}
