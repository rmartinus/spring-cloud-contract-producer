# spring-cloud-contract-producer

### Publishing artifact to artifactory
```$xslt
$ cd docker
$ docker-compose up --build -d

export APPLICATION_BASE_URL=http://192.168.0.2:8080
export PROJECT_NAME=producer
export PROJECT_GROUP=com.example.spring.cloud.contract
export REPO_WITH_BINARIES_URL=http://192.168.0.2:8081/artifactory/libs-release-local
export PROJECT_VERSION=0.0.1.RELEASE
export CONTRACTS=/Users/robbiemartinus/dev/rmartinus/spring-cloud-contract-producer/src/test/resources/contracts/
export CONTRACT_OUTPUT=/Users/robbiemartinus/dev/rmartinus/spring-cloud-contract-producer/src/test/resources/contracts/output

$ docker run --rm -e "APPLICATION_BASE_URL=$APPLICATION_BASE_URL" -e "PUBLISH_ARTIFACTS=true" -e "PROJECT_NAME=$PROJECT_NAME" -e "PROJECT_GROUP=$PROJECT_GROUP" -e "REPO_WITH_BINARIES_URL=$REPO_WITH_BINARIES_URL" -e "PROJECT_VERSION=$PROJECT_VERSION" -v "$CONTRACTS:/contracts:ro" -v "$CONTRACT_OUTPUT:/spring-cloud-contract-output/" springcloud/spring-cloud-contract:2.1.0.RELEASE
```