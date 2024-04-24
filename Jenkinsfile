pipeline {
    
agent any

    stages{
        stage('Extract Source Code'){
            steps{
                git 'https://github.com/raldeskrisnu/compose-destination-sample.git'
            }
        }
        stage('Build'){
            steps{
                sh 'rm -rf /var/lib/jenkins/workspace/kotlin_android_pipeline/app/build/test-results/testReleaseUnitTest/TEST-com.yodle.android.kotlindemo.service.GitHubApiServiceTest.xml'
                sh './gradlew clean test build sonarqube -Dsonar.host.url=http://10.30.10.127:9000'
            }
        }
        stage('Reports'){
            steps{
                androidLint canComputeNew: false, defaultEncoding: '', healthy: '', pattern: '**/lint-results*.xml', unHealthy:''
                junit '**/build/test-results/testReleaseUnitTest/*.xml'
            }
        }
        stage('Deploy'){
            steps([$class : hockyapp.HockeyappRecorder]){
                hockeyApp applications: [[apiToken: 'd17953a8b21940d08b5d09326d842d15', downloadAllowed: true, filePath: '**/*.apk', releaseNotesMethod: none(), uploadMethod: appCreation(true)]],baseUrlHolder: [baseUrl: 'https://rink.hockeyapp.net'], debugMode: false, failGracefully: false
            }
        }
    }
}
