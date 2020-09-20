FROM ubuntu:latest
ENV PORT 34000
ENV Environment ec2-user_redis_1
ARG DEBIAN_FRONTEND=noninteractive
RUN apt-get update && apt-get upgrade
RUN apt-get install -y git
RUN apt-get install -y openjdk-8-jdk openjdk-8-jre
RUN apt-get install -y maven
RUN git clone https://github.com/orlandoagk/AREP5-LogService.git
WORKDIR AREP5-LogService
RUN mvn compile
RUN mvn clean package
CMD ["java","-cp","target/classes:target/dependency/*","edu.escuelaing.arep.Main"]
