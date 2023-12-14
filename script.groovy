def buildJar() {
    echo 'building the application'
    sh 'mvn package'
}

def buildImage() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t tsemb/demo-app:jma-2.0 .'
        sh 'echo $PASS | docker login -u $USER --password-stdin'
        sh 'docker push tsemb/demo-app:jma-2.0'
    }
}

def deployImage() {
    echo "deploing the application..."
}

return this