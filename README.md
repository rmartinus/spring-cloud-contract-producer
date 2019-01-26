# spring-cloud-contract-producer

### Publishing artifact to artifactory
```$xslt
$ cd docker
$ docker-compose up --build
$ docker run --rm -e "APPLICATION_BASE_URL=http://192.168.0.2:8080" -e "PUBLISH_ARTIFACTS=true" -e "PROJECT_NAME=producer" -e "PROJECT_GROUP=com.example.spring.cloud.contract" -e "REPO_WITH_BINARIES_URL=http://192.168.0.2:8081/artifactory/libs-release-local" -e "PROJECT_VERSION=0.0.1.RELEASE" -v "/Users/robbiemartinus/dev/rmartinus/spring-cloud-contract-producer/src/test/resources/contracts/:/contracts:ro" -v "/Users/robbiemartinus/dev/rmartinus/spring-cloud-contract-producer/src/test/resources/contracts/output:/spring-cloud-contract-output/" springcloud/spring-cloud-contract:2.1.0.RELEASE
```