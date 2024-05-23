pipeline {
    agent any
    stages {
        stage('Verify if browsers are installed') {
            steps {
                script {
                    def chromeVersion = sh(script: 'google-chrome --version || echo "Google Chrome is not installed"', returnStdout: true).trim()

                    echo "Chrome Version: ${chromeVersion}"

                }
            }
        }

           environment {
                MAVEN_HOME = '/usr/share/maven'
                PATH = "$PATH:$MAVEN_HOME/bin"
            }

        stage('Run Tests') {
            steps {
                
                sh './mvn clean test'
            }
        }
    }
}
