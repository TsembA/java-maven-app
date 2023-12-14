pipeline {
    agent any
    parameters {
        choice(name: 'VESRION', choices: ['1.1.0','1.2.0','1.3.0'], description:'')
        booleanParam(name: 'executeTests', defaultValue: true, description:'')
    }

    stages {

        stage("build") {

            steps {
                echo 'bulding the application...'

            }
        }
        stage("test") {
            when{
                expression {
                    param.executeTests == True
                }
            }
            steps {
                echo 'testing the application...'                
            }
        }
        stage("deploy") {

            steps {
                echo 'deploy the application...'
                echo "deploying version ${params.VERSION}"                
            }
        }
    }
}