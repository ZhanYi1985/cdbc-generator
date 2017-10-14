node () {

  tool name: 'maven', type: 'maven'
  
  stage ('build') {
    sh 'mvn package'
  }
  
  stage ('test') {
    sh 'mvn test'
  }
  
  stage ('publish') {
    echo 'hello'
  }
  
}
