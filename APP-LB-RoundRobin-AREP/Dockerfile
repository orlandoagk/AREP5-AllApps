FROM ubuntu:latest
ENV PORT 4567
ENV Environment cloud
ARG DEBIAN_FRONTEND=noninteractive
RUN apt-get update && apt-get upgrade
RUN apt-get install -y git
RUN apt-get install -y openjdk-8-jdk openjdk-8-jre
RUN apt-get install -y maven
RUN git clone https://github.com/orlandoagk/AREP5-AllApps.git
WORKDIR AREP5-AllApps/APP-LB-RoundRobin-AREP
RUN mvn compile
RUN mvn clean package
CMD ["java","-cp","target/classes:target/dependency/*","edu.escuelaing.arep.Main"]