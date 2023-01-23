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
                sh "java -javaagent:\"target/libs/aspectjweaver.jar\" -cp target/UI_Demo_Project-1.0-SNAPSHOT.jar:target/UI_Demo_Project-1.0-SNAPSHOT-tests.jar:target/libs/*  -DtestType=${testType} org.testng.TestNG src/test/resources/${testsuite}"
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