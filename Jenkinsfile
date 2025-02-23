pipeline {
    agent any  // Runs on any available Jenkins agent

    tools {
        maven 'Maven_3'
    }

    parameters {
        string(name: 'LT_USERNAME', defaultValue: 'default_user', description: 'Enter LT username')
        password(name: 'LT_ACCESS_KEY', defaultValue: '', description: 'Enter LT access key')
    }


    environment {
        MAVEN_OPTS = "-Xmx2G" // Set Maven memory limit
        LT_USERNAME = "${params.LT_USERNAME}"
        LT_ACCESS_KEY = "${params.LT_ACCESS_KEY}"
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

        stage('Print Parameters') {
            steps {
                echo "Using LT_USERNAME: ${LT_USERNAME}"
                sh 'echo "LT_ACCESS_KEY is set but hidden for security"'
            }
        }

        stage('Run Tests') {
            steps {
                sh 'mvn test -Dlt.username=${LT_USERNAME} -Dlt.access.key=${LT_ACCESS_KEY}'
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