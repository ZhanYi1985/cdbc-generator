node () {

  def mvnHome
  
  stage ('build') {
    mvnHome = tool name: 'maven', type: 'maven'
    sh '${mvnHome}/bin/mvn package'
  }
  
  stage ('test') {
    sh '${mvnHome}/bin/mvn test'
  }
  
  stage ('publish') {
    echo 'hello'
  }
  
}
