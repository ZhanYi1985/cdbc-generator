pipeline {
    agent any
    stages {
        tool name: '', type: 'maven'
        stage('Build') { 
            steps {
                sh '${M3}/bin/mvn -B -DskipTests package' 
            }
        }
      
        stage('Publish') { 
            steps {
                echo " Done. "
            }
        }
    }
}
