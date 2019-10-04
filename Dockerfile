FROM arifpurwandaru/centos7jdk8u181:2.0

MAINTAINER Arif Nazar Purwandaru (arif.purwandaru@gmail.com)

COPY build/libs/BootCamp-0.0.1-SNAPSHOT.jar /home/

EXPOSE 7070

CMD java -jar -Dserver.port=7070 /home/BootCamp-0.0.1-SNAPSHOT.jar

