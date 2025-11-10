Frameworks utilizados:  Selenium + Cucumber + Gherkin
Lenguaje de programación:  Java
IDE: Intellij Idea Community Edition

1. En archivo pom.xml figuran las dependencias utilizadas por el script. Hacer click derecho sobre "pom.xml -> maven - sync project" para que descargue dependencias.
2. Paquetes:
   a. features - Contiene archivo test.feature con los escenarios de prueba escritos en lenguaje Gherkin.
   b. runner - Definición de opciónes de Cucumber, y desde donde se ejecutan las automatizaciones.
   c. browser_Manager - Contiene la Factory de drivers, para que se creen según el driver a utilizar.
   d. seleniumgluecode - Contiene las clases:
       d.1. Hooks - Contiene anotaciones de Before (creación de driver según parámetro y abrir el navegador) y After de cada prueba (cerrar navegador).
       d.2. Test - Se encarga de la implementación de la lógica de alto nivel de los escenarios de prueba.
       d.3. TestBase - Encargada de inicializar el Hooks (solicita el driver) y de inicializar los PageObjects que usemos.
   e. pom - Contiene patrón POM (Page Object Model).
     e.1. BasePage - Contiene la implementación de los métodos de Selenium.
     e.2. HomeForm - Contiene la lógica y localizadores de la página Home del formulario de registro de nuevo usuario. Hereda de BasePage.
   f. resources:
     f.1. chromedriver - Contiene chromedriver.exe - IMPORTANTE - Descargar la versión correspondiente a la versión del navegador desde donde se ejecute.
     f.2. geckodriver - Contiene geckodriver.exe (Firefox) - IMPORTANTE - Descargar la versión correspondiente a la versión del navegador desde donde se ejecute.
     f.3. form - Contiene un formulario Prueba.html simple y local para poder realizar la prueba (se asume que los ids y localizadores principales son dinámicos). Se dió importancia a la implementación de un código para acceder mediante un valor, que a los nombres de los campos en sí.
     f.4. json - archivo Usuarios.json con datos de un usuario, usado como input para las pruebas.
4. Para EJECUTAR los scripts:
   3.1. Se usa archivo de entrada del tipo json (Usuarios.json), el cual contiene un único "usuario" que va a servir de input para cada script. Por lo que antes de cada ejecución hay que modificar los datos según la prueba.
   3.2. Las ejecuciónes se realizan desde la clase Testrunner.
     NOTA: Actualmente esta configurado para que sólo se ejecute el escenario 1 (agregar exitosamente un usuario). El resto de los escenarios (archivo test.feature) tiene el tag "@Ignore", lo cual hace que se ignore la ejecución de ese caso.
   3.3. Se puede borrar la notación @Ignore arriba del caso, para ejecutar dicho escenario en particular e ignorar los que sí tengan el tag.
   3.4. También se puede ejecutar el escenario directamente desde el archivo test.feature, seleccionando el caso en cuestión a la izquierda de "Scenario" figura un signo de play, que permite ejecutar directamente el escenario en cuestión.
   3.5. RECORDAR modificar el archivo Usuarios.json (antes de cada prueba) con los datos que se necesiten según la prueba (datos correctos, contraseñas no coincidentes, edad menor a 0, email incorrecto, etc).

Gracias!
