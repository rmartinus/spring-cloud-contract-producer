# spring-cloud-contract-producer

### Build and run artifactory
```bash
$ docker build -f docker/Dockerfile-artifactory -t artifactory .
$ docker run -p 8081:8081 artifactory -d
```

### Publishing artifact to artifactory
```bash
$ ./mvnw clean package

export MY_IP=`ifconfig | sed -En 's/127.0.0.1//;s/.*inet (addr:)?(([0-9]*\.){3}[0-9]*).*/\2/p'`
export APPLICATION_BASE_URL=http://$MY_IP:8080
export PROJECT_NAME=producer
export PROJECT_GROUP=com.example.spring.cloud.contract
export REPO_WITH_BINARIES_URL=http://$MY_IP:8081/artifactory/libs-release-local
export PROJECT_VERSION=0.0.1.RELEASE
export CONTRACTS=/Users/robbiemartinus/dev/rmartinus/spring-cloud-contract-producer/src/test/resources/contracts/
export CONTRACT_OUTPUT=/Users/robbiemartinus/dev/rmartinus/spring-cloud-contract-producer/target/output

$ docker run --rm -e "APPLICATION_BASE_URL=$APPLICATION_BASE_URL" -e "PUBLISH_ARTIFACTS=true" -e "PROJECT_NAME=$PROJECT_NAME" -e "PROJECT_GROUP=$PROJECT_GROUP" -e "REPO_WITH_BINARIES_URL=$REPO_WITH_BINARIES_URL" -e "PROJECT_VERSION=$PROJECT_VERSION" -v "$CONTRACTS:/contracts:ro" -v "$CONTRACT_OUTPUT:/spring-cloud-contract-output/" springcloud/spring-cloud-contract:2.1.0.RELEASE
```