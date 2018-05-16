FROM java:8-jre
MAINTAINER Sailendra <sqshq@sqshq.com>

RUN yum -y install wget
RUN yum -y install curl

RUN yum -y install epel-release

RUN yum -y install java initscripts && yum clean all

RUN wget --no-verbose -O /tmp/apache-maven-3.2.2.tar.gz http://archive.apache.org/dist/maven/maven-3/3.2.2/binaries/apache-maven-3.2.2-bin.tar.gz

RUN echo "87e5cc81bc4ab9b83986b3e77e6b3095 /tmp/apache-maven-3.2.2.tar.gz" | md5sum -c

RUN tar xzf /tmp/apache-maven-3.2.2.tar.gz -C /opt/

RUN ln -s /opt/apache-maven-3.2.2 /opt/maven

RUN ln -s /opt/maven/bin/mvn /usr/local/bin

RUN rm -f /tmp/apache-maven-3.2.2.tar.gz

ENV MAVEN_HOME /opt/maven

RUN mvn install

ADD ./target/task-microservice.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/task-microservice.jar"]

EXPOSE 8080