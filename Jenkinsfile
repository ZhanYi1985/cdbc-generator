pipeline {
    agent any
    
    
    
    stages {
        stage('Build') { 
            steps {
                script {
                    def artServer
                    def rtMaven
                    artServer = Artifactory.server('local_artifactory')
                    rtMaven = Artifactory.newMavenBuild()
                    rtMaven.env.capture = true
                    rtMaven.resolver server: artServer, releaseRepo: 'libs-release', snapshotRepo: 'libs-snapshot'
                    rtMaven.deployer server: artServer, releaseRepo: 'libs-release-local', snapshotRepo: 'libs-snapshot-local'
                    rtMaven.tool = 'maven'
                    rtMaven.run pom: 'pom.xml', goals: 'clean package'
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
