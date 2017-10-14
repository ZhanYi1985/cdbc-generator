pipeline {
    agent any
    stages {
        

        stage('Build') { 
            steps {
                withMaven(maven: 'maven') {
                    sh 'mvn -B -DskipTests package' 
                }
            }
        }
      
        stage('Publish') { 
            steps {
                echo " Done. "
            }
        }
    }
}
