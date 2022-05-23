# Taller8_AplicacionFullStack

Aplicación básica Full Stack usando Java con el módulo Spring Boot de Spring, MySQL y React.
Esta aplicación guarda el nombre, número de teléfono, email y fecha de nacimiento de un contacto en la lista de contactos, también elimina un contacto de la lista de contactos por medio de un identificador que es único para cada contacto. 

## Requerimientos 
1. [IntelliJ IDEA Ultimate](https://www.jetbrains.com/es-es/idea/download/#section=windows)
2. [NodeJs](https://nodejs.org/es/download/)
3. [MySQL](https://dev.mysql.com/downloads/workbench/)
## Ejecución
1. Descargar el código del repositorio
2. Abrir la carpeta BackendMySQL con IntelliJ IDEA Ultimate
3. Ir hasta el archivo application.properties que se encuentra en la carpeta main/resources
4. Cambiar la configuración de la base de datos
```python
spring.datasource.username =#### (Colocar su nombre de usuario)
spring.datasource.password = #### (Colocar su contraseña)
```
5. Correr la aplicación ingresando al archivo BackContactApplication.java y darle al botón **RUN**
6. Ahora abra la carpeta FrontendReact en VScode
7. Abra una nueva terminal dentro de esa carpeta y ejecute los siguientes comandos:
```python
npm install
npm start
```
8. Se abrirá la aplicación en la ruta **http://localhost:3000/**
