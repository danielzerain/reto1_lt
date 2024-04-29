# Configuracion de JAVA JDK 21

Se instala el Binario de OpenJDK de Adoptium en la version 21, se descarga desde el link: https://adoptium.net/es/temurin/releases/?os=windows&arch=x64&package=jdk
![alt text](https://github.com/danielzerain/reto1_lt/blob/main/mdFiles/portal.png?raw=true)

El paquete ZIP se lo descomprime en la carpeta opt y se crean las variables de entorno:
![alt text](https://github.com/danielzerain/reto1_lt/blob/main/mdFiles/variables.png?raw=true)

![alt text](https://github.com/danielzerain/reto1_lt/blob/main/mdFiles/variables2.png?raw=true)

Con el comando java --version se muestra la version con la que se encuentra trabajando

![alt text](https://github.com/danielzerain/reto1_lt/blob/main/mdFiles/java_version.png?raw=true)

# Como ejecutar la aplicacion
Para ejecutar la aplicacion  el usuario primero debera compilar el programa con el comando

<ol>
 <li>Compilar el programa</li>
<p> <em> ./gradlew clean build</em></p>
<li>Para ejecutar la aplicacion en un contenedor docker, debera ejecutar con docker compose con el siguiente comando</li>
</ol>
<ul>
<li>Primero debe crear la red ejecutando</li>
<p><em>docker network create network-retodz1</em></p>
<li>Luego para hacer correr el contenedor ejecutar:</li>
<p><em>docker compose up --build</em></p>
</ul>
![img.png](img.png)
![alt text](https://github.com/danielzerain/reto1_lt/blob/main/mdFiles/docker.png?raw=true)

# Como consumir los servicios
<ol>
 <li>Llamada POST del endpoint para ejecucion</li>
<p>http://localhost:8080/api/v1/reto1/process</p>
<p>payload: {
    "name":"Daniel Zerain"
}</p>
<p>curl --location 'http://localhost:8080/api/v1/reto1/process' \
--header 'Content-Type: application/json' \
--data '{
    "name":"Nombre Persona"
}'</p>
<li>Llamada POST del endpoint para ejecucion y persistencia en la base de datos </li>
<p>http://localhost:8080/api/v1/reto1/process-persist</p>
<p>payload: {
    "name":"Daniel Zerain"
}</p>
<p>curl --location 'http://localhost:8080/api/v1/reto1/process-persist' \
--header 'Content-Type: application/json' \
--data '{
    "name":"Nombre Persona"
}'</p>
<li>Llamada GET del endpoint para ejecucion</li>
<p>http://localhost:8080/api/v1/reto1/process?name=daniel zerain</p>
<p>curl --location --request GET 'http://localhost:8080/api/v1/reto1/process?name=daniel%20zerain' \
--header 'Content-Type: application/json' \
--data '{
    "name":"Nombre Persona"
}'</p>
<li>Endpoint Acutator</li>
<p>Para obtener el estado de la aplicacion se habilito Actuator, para ver el estado debera hacer la llamada al endpoint</p>
<p>http://localhost:8080/api/v1/actuator/health</p>
<p>curl --location 'http://localhost:8080/api/v1/actuator/health</p>
</ol>