def run() {

	def pipelineParams = [sayDuringCompile:'Default compile message', sayDuringTests:'Default tests message', sayDuringBuild:'Default build message']
	
	pipeline {
		agent any
		stages {
			stage('Compile') {
				steps {
					sh "echo ${pipelineParams.sayDuringCompile}"
					sh 'mvn compile'
				}
			}
			
			stage('Test') {
				steps {
					sh "echo ${pipelineParams.sayDuringTests}"
					sh 'mvn test'
				}
			}

			stage('Build') {
				steps {
					sh "echo ${pipelineParams.sayDuringBuild}"
					sh 'mvn clean package -DskipTests'
				}
			}
		}
	}
}
return this;