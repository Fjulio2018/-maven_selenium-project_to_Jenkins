pipeline {
    agent any

    stages {
        stage('Install npm and webdriver-manager') {
            steps {
                script {
                    // Instala o npm
                    sh 'sudo apt-get update'
                    sh 'sudo apt-get install -y npm'

                    // Instala o webdriver-manager
                    sh 'sudo npm install -g webdriver-manager'
                }
            }
        }
        stage('Update WebDriverManager') {
            steps {
                script {
                    // Atualiza o WebDriverManager com a versão específica do ChromeDriver
                    sh 'sudo webdriver-manager update --versions.chrome=125.0.6422.77'
                }
            }
        }
        // Outros estágios do seu pipeline aqui
    }
    // Outras definições do pipeline aqui
}
