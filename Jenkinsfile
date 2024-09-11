pipeline {
    agent any
    tools {
        maven 'maven-3.9'
    }
    stages {
        stage("build jar") {
            steps {
                script {
                    echo "build the application..."
                    sh 'mvn package'
                }
            }
        }
        stage("build image") {
            steps {
                script {
                    echo "build the docker image..."
                    withCredentials([useramePassword(credentialssId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
                        sh 'docker build -t tsemb/demo-app:jma-5.0 .'
                        sh 'echo $PASS | docker login -u $USER --password-stdin'
                        sh 'docker push tsemb/demo-app:jma-5.0'
                    }

                }
            }
        }
        stage("deploy") {
            steps {
                script {
                    echo "deploying application..."
                }
            }
        }
    }
}