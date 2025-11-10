Respuesta a punto 3:

a. Como interpretó los requerimientos del formulario.
	Respuesta: 1. Generé un formulario HTML local, el cual contiene los campos y validaciones indicados en el enunciado.
Como así también los mensajes de error y éxitos esperados según el caso.
	2. Dado que los selectores de los campos pueden variar dinámicamente, tomé como valor de búsqueda el tag "name" el cual en los formularios suele ser un valor que siempre se encuentra presente. Luego use el método de localizador por "xpath" haciendo uso de contains(@name,'nombre'), el cual busca el tag "name" y dentro del mismo un valor que contenga "nombre". Con la misma lógica para localizar el resto de los campos, usando valores que hagan referencia al campo buscado (ejemplo, email, edad, contraseña).

b. Los casos de prueba fueron elegidos por los solicitados en el punto 1. También incluí un caso del punto 2 (Casos adicionales sugeridos) el cual valida el comportamiento al ingresar una edad negativo.

c. Que criterios de negocio aplicó al validar los datos.
	Respuesta según el escenario de prueba.
	- "Agregar exitosamente registro de usuario": Para validar el registro Ok, tomé el mensaje esperado de éxito "Registro exitoso. Bienvenido/a" (el cual lo guardo en una variable String), y lo comparo con el mensaje efectivamente recibido en el formulario (el cual lo obtengo con su localizador y el método getText()). Para ello, uso un Assert para validar el mensaje esperado.
	- "Agregar usuario con email invalido": Para validar que al ingresar un email inválido se muestre el mensaje correspondiente, comparo el mensaje esperado para dicho caso con el efectivamente recibido en pantalla. Usando un Assert para comparar ambos mensajes. Si son iguales, la prueba termina con un "true", para finalizar Ok.
	- "Agregar usuario con contraseñas no coincidentes": Idem caso anterior, en la PageObject (HomeForm) del formulario, me guardo en un String el mensaje esperado para cuando las contraseñas no coinciden. Luego valido dicho valor con el efectivamente recibido en pantalla.
	- "Agregar usuario con edad menor a 1": Idem lógica anterior.

PARTE 2 (Opcional).
	- Implementación de patrón POM (Page Object Model): Se creó la clase BasePage, el cual contiene las implementaciónes de los métodos de Selenium WebDriver. Con el objetivo de aislar dichos métodos en esta clase. Así luego, crear "n" PageObjects (según las páginas que tengamos), que implementen los métodos extendiendo a BasePage. De dicha manera, si en algún momento los métodos de Selenium se actualizan o modifican, sólo habría que actualizarlo en una única clase (BasePage). Siendo mucho más efectivo, reutilizable y facil de mantener.
	- Implementación de Driver Factory, para crear un driver según el tipo de valor (Chrome/FireFox) se configure (usando una clase Enum). De esta manera, tenemos organizada la creación del driver que corresponda, pudiendo realizar pruebas cross browser de manera más eficiente, sencilla y organizada. Y si se desea agregar más navegadores, sólo se crea la clase correspondiente y el Factory sabrá como crearlo.