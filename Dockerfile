# Etapa 1: build da aplicação com Maven
FROM maven:3.9.9-eclipse-temurin-17 AS build
WORKDIR /app

# Copia apenas o pom.xml primeiro para aproveitar o cache
COPY pom.xml .
RUN mvn dependency:go-offline

# Copia o restante do projeto
COPY src ./src

# Compila e empacota o WAR (sem rodar testes)
RUN mvn clean package -DskipTests

# Etapa 2: execução com Tomcat
FROM tomcat:10.1-jdk17

# Remove os aplicativos padrão (ROOT, examples, etc.)
RUN rm -rf /usr/local/tomcat/webapps/*

# Copia o WAR gerado para o Tomcat e renomeia como ROOT.war
COPY --from=build /app/target/*.war /usr/local/tomcat/webapps/ROOT.war

# Expõe a porta padrão
EXPOSE 8080

# Inicia o servidor Tomcat
CMD ["catalina.sh", "run"]
