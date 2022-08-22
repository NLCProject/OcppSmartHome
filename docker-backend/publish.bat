cd ..
echo "Deleting old jar files"
del .\build\libs\SmartHome.jar
del .\docker-backend\SmartHome.jar

echo "-- LINTING --"
echo "ktlint Format"
call .\gradlew ktlintFormat

echo "ng lint with fixing"
cd .\src\main\kotlin\org\ocpp\smart\home\frontend
call ng lint --fix
cd ..\..\..\..\..\..\..\

echo "-- BUILDING JAR --"
echo "Gradle build without tests. Run tests manually if required
call .\gradlew build -x test
echo "Copying jar file"
copy .\build\libs\SmartHome.jar .\docker-backend\SmartHome.jar

echo "-- DEPLOYMENT --"
cd .\docker-backend
echo "Docker compose"
call docker-compose build
echo "-- FINISHED --"
