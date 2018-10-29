def call(def sayDuringCompile, def sayDuringTests, def sayDuringBuild) {

	pipeline {
		agent any
		stages {
			stage('Compile') {
				steps {
					sh "echo ${sayDuringCompile}"
					sh 'mvn compile'
				}
			}
			
			stage('Test') {
				steps {
					sh "echo ${sayDuringTests}"
					sh 'mvn test'
				}
			}

			stage('Build') {
				steps {
					sh "echo ${sayDuringBuild}"
					sh 'mvn clean package -DskipTests'
				}
			}
		}
	}
}
