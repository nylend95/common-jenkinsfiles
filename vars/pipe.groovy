
def call(Map overrides) {

  def label = "mypod-${UUID.randomUUID().toString()}"
	
  podTemplate(cloud: 'openshift', label: label, containers: [
        containerTemplate(name: 'maven', image: 'docker.io/library/maven:3.6-jdk-11-slim',
             ttyEnabled: true, command: 'cat')
      ]) {

        node(label) {
            checkout scm

            stage('Stage OUTSIDE container') {
                echo "Hello World!"   
            }

            container('maven') {
                stage('First stage IN container') {
                    echo "Hello Container"
                }
                stage('Final stage IN container') {
                    echo "Goodbye Container"
                }
            }
            
            stage('Final stage OUTSIDE container') {
                echo "Goodbye Jenkins"   
            }
        }
    }
}
return this;
