# Documentación del Proyecto

Este proyecto consta de una carpeta que contiene el código del Frontend de la aplicación, y una carpeta que contiene el Backend de la misma.

Para desarrollarlo tomé en cuenta que toda la información debía estar reunida en un único repositorio; por ello la decisión de dividir el código en dos carpetas.
Entre las dos opciones entregadas (PHP Symfony y ReactJs), seleccioné ReactJs ya que, al igual que TypeScript, son tecnologías que manejo y que me estoy tomando el tiempo de estudiar para profundizar mis conocimientos y pulis mis habilidades. Por otro lado, si bien estoy abierta a aprender PHP Symfony, no contaba con el tiempo suficiente para investigar, aprender y realizar este proyecto.
Me encanta Java Spring Boot y considero que tengo un dominio excelente de las herramientas, así que mi decisión fue unánime para el backend.

Para el desarrollo del proyecto, se utilizaron las siguientes tecnologías:

## Frontend
- ReactJs v18.2.0
- TypeScript v5.2.2
- NodeJs v21.7.3

## Backend
- Java v17
- Spring Framework v3.2.5
- MySQL Server v8.0.36

## ¿Cómo correr el proyecto?

Necesitas tener instalado:
- MySQL Workbench 8.0.
- IntelliJ IDEA versión paga o gratuita (opcional).
- Java v17 o superior.
- Visual Studio Code (opcional).
- Yarn v1.22.19 o superior.
- NodeJs v21.7.3 o superior.
 
1. Al instalar MySQL Workbench, crear usuario y contraseña (importante no olvidar).
2. Ejecutar IntelliJ IDEA o IDE de preferencia para abrir carpeta backend.
3. Iniciar Maven en caso de que el IDE no lo detecte por su cuenta para que se instalen las dependencias del proyecto.
4. Dirigirse al archivo "application.properties" dentro de "src/main/resources".
5. En application.properties, cambiar valores de línea 6 y 7 por el usuario y contraseña de su cuenta de MySQL Workbench (creado en paso 1).
6. Dirigirse al archivo de ejecuión del proyecto en "src/main/java/com-evaluacion-backend", nombre de archivo: BackendApplication.
7. Correr backend del proyecto en la parte superior derecha del IDE, icono de "run" o "play".
8. Con el backend corriendo, abrir carpeta de frontend en VSC o IDE de preferencia.
9. En la terminal integrada con posición en la carpeta frontend, correr el comando "yarn" o "yarn i" para instalar las dependencias.
10. Correr comando "yarn dev" para montar el frontend del proyecto en "http://localhost:5173/".

## Rutas del Proyecto

* El Frontend cuenta con tres rutas:
  - "/home": eres redireccionado a esta ruta cuando accedes a "http://localhost:5173/"; se muestra una tabla con los datos de tu IP, fecha y hora de acceso.
  - "/record": puedes acceder mediante el NavBar de la aplicación o directamente desde el url; se mostrará una tabla con la IP, cantidad de visitas, posibilidad de bloqueo de IP, categoría a seleccionar y un área para dejar comentarios. [EN PROCESO]
  - "/category": puedes acceder mediante el NavBar de la aplicación o directamente desde el url; se muestra una tabla con las categorías existentes.
 
## Endpoints del Proyecto

* El Backend cuenta con tres endpoints habilitados:
  - "/home":
    * GET: la petición se realiza automáticamente al acceder al endpoint para obtener los siguientes datos: IP, fecha y hora de acceso.
    * POST: la petición se realiza automáticamente al acceder al endpoint para enviar los siguientes datos a la base de datos: IP, fecha y hora de acceso, devolviéndolos para ser mostrados en una tabla.
  - "/record": [EN PROCESO]
    * GET: la petición se realiza automáticamente al acceder al endpoint para obtener los siguientes datos de los visitantes: ID, IP, visitas totales, estado de bloqueo de la IP, categoría y comentario.
    * POST: la petición se realiza cuando se modifican los datos de la tabla, tomando la información para persistirla en la base de datos.
  -"/category":
    * GET: la petición se realiza automáticamente al acceder al endpoint para obtener los nombres de las categorías existentes.
    * POST: [EN PROCESO]
    * PUT: [EN PROCESO]
    * DELETE: [EN PROCESO]
   
Cualquier duda, contactarme a mi correo: pviloriasilva@gmail.com
