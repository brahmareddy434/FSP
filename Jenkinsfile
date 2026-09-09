pipeline {

    agent any


    environment {

        APP_NAME = "spring-k8s-demo"

        DOCKER_USERNAME = "7671860643"

        IMAGE_TAG = "${BUILD_NUMBER}"

    }


    stages {


        stage('Checkout Code') {

            steps {

                git(
                    branch: 'feature/user-api',
                    url: 'https://github.com/brahmareddy434/FSP.git'
                )

            }
        }



        stage('Build Application') {

            steps {

                echo "Building Spring Boot Application"

                sh './mvnw clean package'

            }

        }



        stage('Docker Build') {

            steps {

                echo "Building Docker Image"


                sh """

                docker build \
                -t ${DOCKER_USERNAME}/${APP_NAME}:${IMAGE_TAG} .

                """

            }

        }



        stage('Docker Login & Push') {

            steps {


                withCredentials([usernamePassword(
                    credentialsId: 'dockerhub-token',
                    usernameVariable: 'USERNAME',
                    passwordVariable: 'PASSWORD'
                )]) {


                    sh """

                    echo \$PASSWORD | docker login \
                    -u \$USERNAME \
                    --password-stdin


                    docker push \
                    ${DOCKER_USERNAME}/${APP_NAME}:${IMAGE_TAG}

                    """

                }

            }

        }


    }


    post {

        success {

            echo "Build Successful"

        }


        failure {

            echo "Build Failed"

        }

    }


}