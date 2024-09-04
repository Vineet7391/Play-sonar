pipeline {
    agent any

    triggers {
        pollSCM('* * * * *') // Polls the SCM every minute. You can adjust the schedule as needed.
    }

    stages {
        stage('SCM') {
            steps {
                git 'https://github.com/Vineet7391/Play-sonar.git'
            }
        }

        stage('Build and Test') {
            steps {
                sh 'sbt clean coverage test'
            }
        }

        stage('Coverage Report') {
            steps {
                sh 'sbt coverageReport'
            }
        }

        stage('SonarQube analysis') {
            steps {
                script {
                    def scannerHome = tool 'sonar-scanner1'
                    withSonarQubeEnv('sonar-scanner1') {
                        sh "${scannerHome}/bin/sonar-scanner"
                    }
                }
            }
        }
    }

    post {
        always {
            echo 'This pipeline runs for any branch.'
        }
    }
}
