pipeline {
    agent any
    tools {
        maven 'maven-3.9'
    }
    stages {
        stage("build jar") {
            steps {
                script{
                    echo "building the application..."
                    sh 'mvn package'
                }
            }
        }
        stage("build image") {
            steps {
                script{
                    echo "building the docker image..."
                    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
                        sh 'docker build -t 24.144.88.233:8083/java-maven-app:3.1 .'
                        sh 'echo $PASS | docker login -u $USER --password-stdin 24.144.88.233:8083'
                        sh 'docker push 24.144.88.233:8083/java-maven-app:3.1'
                    }
                }
            }
        }

        stage("deploy") {
            steps {
                script{
                    echo "deploing the application..."
                }
            }
        }
    }
}