# ============================================================
# 第一步:构建前端(node 构建出 dist)
# ============================================================
FROM node:22-alpine AS frontend
WORKDIR /fe
COPY frontend/package.json frontend/package-lock.json ./
RUN npm ci
COPY frontend/ .
# build 会先跑 vue-tsc 类型检查再 vite build,产物在 dist/
RUN npm run build

# ============================================================
# 第二步:构建后端(maven 打成 jar,并把前端产物塞进静态资源)
# ============================================================
FROM maven:3.9-eclipse-temurin-21 AS backend
WORKDIR /build
COPY pom.xml .
COPY src ./src
# 把前端构建产物放到 Spring Boot 的静态资源目录,打进 jar
COPY --from=frontend /fe/dist ./src/main/resources/static
RUN mvn -q -DskipTests package

# ============================================================
# 第三步:运行镜像(只带 JRE,体积小)
# ============================================================
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=backend /build/target/*.jar app.jar
ENV JAVA_OPTS="-Xms128m -Xmx256m"
EXPOSE 8080
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
