pipeline {

    agent any
    environment{
        NEW_VERSION = '1.3.0'
        SERVER_CREDENTIALS = credentials('server-credentials')
    }

    stages {

        stage("build") {

            steps {
                echo 'bulding the application...'
                echo "building version ${NEW_VERSION}"
            }
        }
        stage("test") {
            steps {
                echo 'testing the application...'

                
            }
        }
        stage("deploy") {

            steps {
                echo 'deploy the application...'
                withCredentials([
                    usernamePassword(credentials: 'server-credentials', usernameVariabble: USER, passwordVariable: PWD)
                ]) {
                    sh "some script ${USER} ${PWD}"
                }

                
            }
        }
    }
}