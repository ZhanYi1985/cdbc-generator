node () {

  def mvnHome = tool name: 'maven', type: 'maven'
  
  stage ('build') {
    sh '${mvnHome}/mvn package'
  }
  
  stage ('test') {
    sh '${mvnHome}/mvn test'
  }
  
  stage ('publish') {
    echo 'hello'
  }
  
}
