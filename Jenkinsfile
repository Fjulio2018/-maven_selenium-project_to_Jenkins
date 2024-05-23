pipeline {
    agent any

    stages {
        stage('Install Browsers and Maven') {
            steps {
                script {
                    // Instalar wget para baixar arquivos
                    sh 'apt-get update && apt-get install -y wget'

                    // Instalar Google Chrome
                    sh '''
                        if ! command -v google-chrome &> /dev/null; then
                            curl -sS -o google-chrome.deb https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb
                            dpkg -i google-chrome.deb
                            apt-get install -yf
                        else
                            echo "Google Chrome already installed"
                        fi
                    '''

                    // Instalar Firefox
                    sh '''
                        if ! command -v firefox &> /dev/null; then
                            apt-get install -y firefox
                        else
                            echo "Firefox already installed"
                        fi
                    '''

                    // Instalar Maven
                    sh '''
                        if ! command -v mvn &> /dev/null; then
                            apt-get install -y maven
                        else
                            echo "Maven already installed"
                        fi
                    '''
                }
            }
        }

        stage('Verify if Browsers are Installed') {
            steps {
                script {
                    def chromeVersion = sh(script: 'google-chrome --version || echo "Google Chrome is not installed"', returnStdout: true).trim()
                    def firefoxVersion = sh(script: 'firefox --version || echo "Firefox is not installed"', returnStdout: true).trim()
                    echo "Chrome Version: ${chromeVersion}"
                    echo "Firefox Version: ${firefoxVersion}"
                }
            }
        }

        stage('Run Tests') {
            steps {
                sh 'mvn clean test'
            }
        }
    }
}
