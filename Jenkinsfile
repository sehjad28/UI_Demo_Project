pipeline {
    agent any
    tools {
        maven 'Maven'
    }
    stages {
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
                sh "java -javaagent:\"target/libs/aspectjweaver.jar\" -cp target/UI_Demo_Project-1.0.jar:target/UI_Demo_Project-1.0-tests.jar:target/libs/*  -DtestType=security org.testng.TestNG src/test/resources/zap-test-suite.xml"
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