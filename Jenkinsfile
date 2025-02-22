pipeline {
    agent any  // Runs on any available Jenkins agent

    environment {
        MAVEN_OPTS = "-Xmx2G" // Set Maven memory limit
    }

    stages {
        stage('Checkout Code') {
            steps {
                git 'https://github.com/thuynguyentd37/liveproject1.git'
            }
        }

        stage('Setup Java & Maven') {
            steps {
                sh 'java -version'
                sh 'mvn -version'
            }
        }

        stage('Run Tests') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Publish Reports') {
            steps {
                publishHTML([path: 'target/surefire-reports/', reportName: 'TestNG Report'])
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: 'target/surefire-reports/*', fingerprint: true
        }
    }
}
