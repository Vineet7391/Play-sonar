node {
  stage('SCM') {
    git 'https://github.com/Vineet7391/Play-sonar.git'
  }

  stage('Build and Test') {
    sh 'sbt clean coverage test'
  }

  stage('Coverage Report') {
    sh 'sbt coverageReport'
  }

  stage('SonarQube analysis') {
    def scannerHome = tool 'sonar-scanner'; // Must match the name of an actual scanner installation directory on your Jenkins build agent
    withSonarQubeEnv('sonar-scanner') { // If you have configured more than one global server connection, you can specify its name as configured in Jenkins
      sh "${scannerHome}/bin/sonar-scanner"
    }
  }
}
