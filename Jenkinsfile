pipeline {
    agent any



    stages {
        stage('verifica browser') {
            steps {
                sh 'google-chrome --version'
            }
        }




        stage('Run Tests') {
            steps {


                sh './mvn clean test'
            }
        }
    }


}


