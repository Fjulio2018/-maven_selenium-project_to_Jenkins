pipeline {
    agent any

    stages {
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
