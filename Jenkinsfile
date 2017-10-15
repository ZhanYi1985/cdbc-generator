node () {
    def artServer
    def rtMaven
    stage ('prepare') {
        artServer = Artifactory.server('local_artifactory')
        rtMaven = Artifactory.newMavenBuild()
    }
    
    stage('Build') { 

        rtMaven.resolver server: artServer, releaseRepo: 'libs-release', snapshotRepo: 'libs-snapshot'
        rtMaven.deployer server: artServer, releaseRepo: 'libs-release-local', snapshotRepo: 'libs-snapshot-local'
        rtMaven.tool = 'maven'
        rtMaven.deployer.addProperty("status", "in-qa").addProperty("compatibility", "1", "2", "3")
        rtMaven.deployer.deployArtifacts = false
        def buildInfo = rtMaven.run pom: 'pom.xml', goals: 'clean package'

    }

    stage('Publish') { 
        rtMaven.deployer.deployArtifacts buildInfo 
        echo " Done. "
    }
}
