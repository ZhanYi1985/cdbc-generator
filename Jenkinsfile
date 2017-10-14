pipeline {
    agent any
    stages {
        def artServer;
        def rtMaven;
        
        stage('Build') { 
            steps {
                script {
                    artServer = Artifactory.getArtifactoryServer()
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
