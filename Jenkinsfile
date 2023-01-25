pipeline {
    agent any
    tools {
        maven 'Maven'
    }
    stages {
        stage ('ZAP Start') {
                 steps {

                        echo 'Hello, '

                        sh '''#!/var/jenkins_home/docker

                            CONTAINER_ID=$(docker run -u zap -p 8081:8081 -d owasp/zap2docker-weekly zap.sh -daemon -port 8081 -host 127.0.0.1 -config api.disablekey=true  -config connection.dnsTtlSuccessfulQueries=-1 -config api.addrs.addr.name=.* -config api.addrs.addr.regex=true)

                            echo "TRYING TO STRAT ZAP PROXY CONTAINER"
                            docker logs $CONTAINER_ID
                        '''
                    }
                }


        stage('Build') {
            steps {
                script{
                    currentBuild.displayName = "#${BUILD_NUMBER}"
                }
                sh "mvn clean package -DskipTests"
            }
        }
        stage('Run') {
            steps {
                sh "java -javaagent:\"target/libs/aspectjweaver.jar\" -cp target/UI_Demo_Project-1.0.jar:target/UI_Demo_Project-1.0-tests.jar:target/libs/*  -DHUB_HOST=qa-selenium-hub-nlb-bae199390c5e1ae7.elb.us-east-1.amazonaws.com -Dheadless=true -DtestType=security org.testng.TestNG src/test/resources/zap-test-suite.xml"
            }
            post {
                always{
                    script {
                        allure([
                                includeProperties: false,
                                jdk: '',
                                reportBuildPolicy: 'ALWAYS',
                                results: [[path: 'allure-results']],
                        ])
                    }
                }
            }
        }
    }
}