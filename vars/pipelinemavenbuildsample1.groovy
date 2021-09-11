#!groovy

def call(String repoUrl) {
  pipeline {
       agent any
       tools {
           //maven 'Maven 3.8.2'
           //jdk 'jdk1.8.0_301'
       }
       stages {
           stage("Tools initialization") {
               steps {
				   sh "export M2_HOME=/opt/maven/apache-maven-3.8.2"
				   sh "JAVA_HOME=/opt/jdk1.8.0_301"
                   sh "mvn --version"
                   sh "java -version"
               }
           }
           stage("Checkout Code") {
               steps {
                   git branch: 'master',
                       url: "${repoUrl}"
               }
           }
           stage("Cleaning workspace") {
               steps {
                   sh "mvn clean"
               }
           }
           stage("Running Testcase") {
              steps {
                   sh "mvn test"
               }
           }
           stage("Packing Application") {
               steps {
                   sh "mvn package -DskipTests"
               }
           }
       }
   }
}