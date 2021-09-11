#!groovy

def call(body){

	pipeline {
		agent any

		stages {
			stage('init') {
				steps {
					echo 'Init'
				}
			}
			stage('process') {
				steps {
					echo 'Hello World'
				}
			}
			stage('end') {
				steps {
					echo 'End of pipeline'
				}
			}		
		}
	}
}