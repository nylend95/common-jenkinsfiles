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
					sh "echo ${sayDruingTest}"
					sh 'mvn test'
				}
			}

			stage('Build') {
				steps {
					sh "echo ${sayDruingBuild}"
					sh 'mvn clean package -DskipTests'
				}
			}
		}
	}
}
