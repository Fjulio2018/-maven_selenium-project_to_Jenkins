pipeline {
    agent any
    stages {
       stage('Verify if browsers is installed') {

        steps {
            sh 'google-chrome --version'
            sh 'firefox --version'

        }

       }

       stage('Run Tests') {
        steps {
            sh './mvn clean test'

        }
       }
       
      


    }
}