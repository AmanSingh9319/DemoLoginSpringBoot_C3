FROM openjdk
WORKDIR usr/lib
ADD ./target/DemoLoginSpringBoot_C3-0.0.1-SNAPSHOT.jar /usr/lib/DemoLoginSpringBoot_C3-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","DemoLoginSpringBoot_C3-0.0.1-SNAPSHOT.jar"]