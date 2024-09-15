FROM maven:3.9.9-amazoncorretto-17-al2023

LABEL maintainer="UNLAM trabajo final"

COPY ./. /

RUN mvn compile package -DskipTests

ENTRYPOINT ["sh", "-c"]

CMD ["mvn exec:java -Dexec.mainClass=com.example.demo.DemoApplication"]