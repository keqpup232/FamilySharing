## Что это?
Это тестовый проект сайта:
<br>
бек написан на Java17 SpringBoot 3.4.3
<br>
фронт на react.js
<br>
БД PostgresSQL 13
<br>
Все это объединено с помощью оркестартора Dockercompose, бек и фронт собираются в Dockerfile

Для успешной сборки проекта, перейдите в главную деррикторю и выполните следующий скрипт:
```bash
cd backend/
./mvnw clean package
cd ../
docker-compose down
docker-compose up --build --force-recreate
```
После можно проверить функционал по [http://localhost:3000](http://localhost:3000) 
<br>
Сейчас реализована авторизация-регистрация пользователей, запись в БД, просмотр всех записей, вывод ошибок.
<br>

## Полезные ссылки и команды.
### Установка OpenJDK На macOS с помощью Homebrew:
```bash
brew install openjdk@17
```
Свяжите установленную версию:
```bash
sudo ln -sfn /usr/local/opt/openjdk@17/libexec/openjdk.jdk /Library/Java/JavaVirtualMachines/openjdk-17.jdk
```
Проверьте установку:
```bash
java -version
javac -version
```
<br>

### Запуск бека с помощью Maven
Если вы используете Maven, вы можете запустить приложение через командную строку.
<br>
Откройте терминал в корневой директории проекта (где находится pom.xml).
<br>
Выполните команду:
```bash
./mvnw spring-boot:run
```
Приложение запустится, и вы увидите логи в терминале.
<br>

### Запуск собранного JAR-файла
Если вы уже собрали проект в JAR-файл, выполните следующие шаги:
<br>
Соберите проект с помощью Maven:
<br>
Для Maven:
```bash
./mvnw clean package
```
Найдите файл с расширением .jar (например, socialnetwork-1.0.0.jar).
<br>
Запустите JAR-файл:
```bash
java -jar target/socialnetwork-1.0.0.jar
```
Приложение запустится, и вы увидите логи в терминале.
<br>

### Проверка записией в БД
```bash
docker exec -it postgres psql -U admin -d social_network
\dt
SELECT * FROM users;
```
