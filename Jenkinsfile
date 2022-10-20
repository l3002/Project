def containerName="docker-pipeline"
def tag="latest"
def dockerHubUser="tanmay32"
def httpPort="8090"

pipeline{
    agent any
    stages{
	stage('Git Checkout'){
	    git credentialsId: '8c0ede61-99b0-41ec-b40f-ded46c222c85', url: 'https://github.com/l3002/Project.git'
	}
        stage('Build'){
            sh "mvn clean install"
        }

        stage("Image Prune"){
            sh "docker image prune -a -f"
        }

        stage('Image Build'){
            sh "docker build -t $containerName:$tag  -t $containerName --pull --no-cache ."
            echo "Image build complete"
        }

        stage('Push to Docker Registry'){
            withCredentials([usernamePassword(credentialsId: 'dockerHubAccount', usernameVariable: 'dockerUser', passwordVariable: 'dockerPassword')]) {
                sh "docker login -u $dockerUser -p $dockerPassword"
                sh "docker tag $containerName:$tag $dockerUser/$containerName:$tag"
                sh "docker push $dockerUser/$containerName:$tag"
                echo "Image push complete"
            }
        }

        stage('Run App'){
            sh "docker rm $containerName -f"
            sh "docker pull $dockerHubUser/$containerName"
            sh "docker run -d --rm -p $httpPort:$httpPort --name $containerName $dockerHubUser/$containerName:$tag"
            echo "Application started on port: ${httpPort} (http)"
    	}
    }
}
