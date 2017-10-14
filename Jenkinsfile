pipeline {
    agent any
    
    
    
    stages {
        stage('Build') { 
            steps {
                script {
                    def artServer
                    def rtMaven
                    artServer = Artifactory.getArtifactoryServer('local_artifactory')
                    rtMaven = Artifactory.newMavenBuild()
                    rtMaven.resolver server: artServer, releaseRepo: 'libs-release', snapshotRepo: 'libs-snapshot'
                    rtMaven.deployer server: artServer, releaseRepo: 'libs-release-local', snapshotRepo: 'libs-snapshot-local'
                    rtMaven.tool = 'maven'
                    rtMaven.run pom: 'pom.xml', goals: 'clean package', buildInfo: buildInfo
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
