pipeline {
    agent any
    stages {
        
        stage('Build') { 
            steps {
                tool name: 'maven', type: 'maven'
                sh '${maven}/bin/mvn -B -DskipTests package' 
            }
        }
      
        stage('Publish') { 
            steps {
                echo " Done. "
            }
        }
    }
}
