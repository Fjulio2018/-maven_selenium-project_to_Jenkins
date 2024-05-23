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
                // Remover a pasta selenium (caso exista) com permissões de superusuário
                sh 'sudo rm -rf /usr/local/lib/node_modules/webdriver-manager/selenium'
            }
        }

        stage('Start WebDriverManager') {
            steps {
                // Iniciar o WebDriverManager
                sh 'webdriver-manager start'
            }
        }

        stage('Run Tests') {
            steps {
                // Atualizar o WebDriverManager e, em seguida, executar os testes
                sh 'webdriver-manager update'
                sh 'mvn clean test'
            }
        }
    }

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
