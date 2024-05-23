pipeline {
    agent any

    stages {
        stage('Install Browsers and Maven') {
            steps {
                script {
                    // Instalar Google Chrome
                    sh '''
                        if ! command -v google-chrome &> /dev/null; then
                            wget -q -O - https://dl.google.com/linux/linux_signing_key.pub | sudo apt-key add -
                            sudo sh -c 'echo "deb [arch=amd64] http://dl.google.com/linux/chrome/deb/ stable main" >> /etc/apt/sources.list.d/google-chrome.list'
                            sudo apt-get update
                            sudo apt-get install -y google-chrome-stable
                        else
                            echo "Google Chrome already installed"
                        fi
                    '''

                    // Instalar Firefox
                    sh '''
                        if ! command -v firefox &> /dev/null; then
                            sudo apt-get update
                            sudo apt-get install -y firefox
                        else
                            echo "Firefox already installed"
                        fi
                    '''

                    // Instalar Maven
                    sh '''
                        if ! command -v mvn &> /dev/null; then
                            sudo apt-get update
                            sudo apt-get install -y maven
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
