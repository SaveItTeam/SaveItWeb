# ============================
# Etapa 1: Build da aplicação
# ============================
FROM maven:3.9.9-eclipse-temurin-23 AS build
WORKDIR /app

# Copia pom.xml e baixa dependências (cache eficiente)
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copia o restante do código e faz o build
COPY . .
RUN mvn clean package -DskipTests

# ============================
# Etapa 2: Runtime (Tomcat + JDK 23)
# ============================
FROM eclipse-temurin:23-jdk
WORKDIR /usr/local/tomcat

ENV TOMCAT_VERSION=10.1.30
ENV CATALINA_HOME=/usr/local/tomcat
ENV PATH=$CATALINA_HOME/bin:$PATH

# Instala dependências mínimas e baixa o Tomcat
RUN apt-get update && apt-get install -y curl tar gzip && \
    curl -fsSL https://archive.apache.org/dist/tomcat/tomcat-10/v${TOMCAT_VERSION}/bin/apache-tomcat-${TOMCAT_VERSION}.tar.gz -o tomcat.tar.gz && \
    mkdir -p ${CATALINA_HOME} && \
    tar -xzf tomcat.tar.gz --strip-components=1 -C ${CATALINA_HOME} && \
    rm tomcat.tar.gz && \
    rm -rf webapps/* && \
    apt-get clean && rm -rf /var/lib/apt/lists/*

# Copia o WAR gerado
COPY --from=build /app/target/*.war ./webapps/ROOT.war

# Porta padrão
EXPOSE 8080

# Inicializa o Tomcat
CMD ["catalina.sh", "run"]
