pipeline {
    agent any



    stages {
        stage('verify browser') {
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


