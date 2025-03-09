На macOS
Установите OpenJDK с помощью Homebrew:

bash
Copy
brew install openjdk@17
Свяжите установленную версию:

bash
Copy
sudo ln -sfn /usr/local/opt/openjdk@17/libexec/openjdk.jdk /Library/Java/JavaVirtualMachines/openjdk-17.jdk
Проверьте установку:

bash
Copy
java -version
javac -version



2. Запуск с помощью Maven
Если вы используете Maven, вы можете запустить приложение через командную строку.
Откройте терминал в корневой директории проекта (где находится pom.xml).
Выполните команду:
./mvnw spring-boot:run
Приложение запустится, и вы увидите логи в терминале.


4. Запуск собранного JAR-файла
Если вы уже собрали проект в JAR-файл, выполните следующие шаги:

Соберите проект с помощью Maven или Gradle:

Для Maven:

bash
Copy
./mvnw clean package
Для Gradle:

bash
Copy
./gradlew clean build
Перейдите в папку target (для Maven) или build/libs (для Gradle).

Найдите файл с расширением .jar (например, socialnetwork-1.0.0.jar).

Запустите JAR-файл:

bash
Copy
java -jar target/socialnetwork-1.0.0.jar
Приложение запустится, и вы увидите логи в терминале.


5. Запуск в Docker
Если вы используете Docker, выполните следующие шаги:

Убедитесь, что у вас есть Dockerfile в корневой директории проекта. Пример Dockerfile:

dockerfile
Copy
FROM openjdk:17-jdk-alpine
VOLUME /tmp
COPY target/socialnetwork-1.0.0.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
Соберите Docker-образ:

bash
Copy
docker build -t socialnetwork .
Запустите контейнер:

bash
Copy
docker run -p 8080:8080 socialnetwork
Приложение запустится в контейнере, и вы сможете получить доступ к нему по адресу http://localhost:8080.




cd backend/
./mvnw clean package
cd ../
docker-compose down
docker-compose up --build --force-recreate

docker exec -it postgres psql -U admin -d social_network
\dt
SELECT * FROM users;

Подведя итоги, давай начнем с начала и простого, необходимо создать сайт, бек будет на springboot, фронт на React и БД Postgres.
бек и фронт имеют собственные dockerfile, и все приложения оркестрируются dockercompose, функционал сайта будет форма для регистрации новых пользователей, и дальнейшая запись их данных в бд, а так же реализовать авторизацию.
Распиши всю структуру проекта, все необходимые файлы для того что бы все это заработало без ошибок.