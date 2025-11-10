package seleniumgluecode;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import java.io.FileReader;
import java.io.IOException;

public class Test extends TestBase{

    // Inicio Escenario agregar exitosamente un usuario
    @Given("El usuario se encuentra en la página de registro de usuarios")
    public void el_usuario_se_encuentra_en_la_página_de_registro_de_usuarios() {

    }
    @When("El usuario completa datos del formulario")
    public void el_usuario_completa_datos_del_formulario() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();

        try {
            FileReader reader = new FileReader("./src/test/resources/jsonfiles/Usuarios.json");
            Object obj = jsonParser.parse(reader);
            JSONObject usuariojsonobj = (JSONObject)obj;

            // Se completan los datos del formulario con input del json
            homeForm.setInputNombre((String)usuariojsonobj.get("nombre"));
            homeForm.setInputEmail((String)usuariojsonobj.get("email"));
            homeForm.setInputEdad((String) usuariojsonobj.get("edad"));
            homeForm.setInputPass((String) usuariojsonobj.get("contrasena"));
            homeForm.setInputRepass((String) usuariojsonobj.get("repContrasena"));

        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }

    }

    @When("Presiona botón Enviar")
    public void presiona_botón_enviar() throws Exception {
        homeForm.clickBotonEnviar();
    }

    @Then("Se muestra mensaje de Registro Exitoso")
    public void se_muestra_mensaje_de_registro_exitoso() {
        WebElement pageMsgOkLocator = driver.findElement(homeForm.getMsgOkLocator());
        // Guardamos el mensaje recibido en pantalla luego de registrar un usuario
        String msgOk = pageMsgOkLocator.getText();
        // Se valida que el mensaje recibido en pantalla luego de registrar un usuario, sea el definido como Ok
        Assert.assertTrue(msgOk.contains(homeForm.getMsgOk()));
    }
    // Fin agregar exitosamente un usuario

    // Inicio Escenario Agregar usuario con email invalido
    @When("El usuario completa formulario con email invalido del formulario")
    public void el_usuario_completa_formulario_con_email_invalido_del_formulario() throws IOException, ParseException {
        el_usuario_completa_datos_del_formulario();
    }
    @Then("Se muestra mensaje Por favor, introduce un email válido.")
    public void se_muestra_mensaje_por_favor_introduce_un_email_válido() {
        WebElement pageMsgErrorEmail = driver.findElement(homeForm.getMsgErrorEmailLocator());
        // Se valida que el mensaje recibido, sea el definido
        Assert.assertEquals(homeForm.getMsgErrorEmail(), pageMsgErrorEmail.getText());
    }
    // Fin escenario agregar usuario con email inválido

    // Inicio escenario Agregar usuario con contraseñas no coincidentes
    @When("El usuario completa formulario con contraseñas no coincidentes")
    public void el_usuario_completa_formulario_con_contraseñas_no_coincidentes() throws IOException, ParseException {
        el_usuario_completa_datos_del_formulario();
    }
    @Then("Se muestra mensaje Las contraseñas no coinciden.")
    public void se_muestra_mensaje_las_contraseñas_no_coinciden() {
        WebElement pageMsgErrorPass = driver.findElement(homeForm.getMsgErrorPassLocator());
        // Valida que el mensaje de error recibido, sea igual al definido
        Assert.assertEquals(homeForm.getMsgErrorPass(), pageMsgErrorPass.getText());
    }
    // Fin escenario Agregar usuario con contraseñas no coincidentes

    // Inicio escenario Agregar usuario con edad menor a 1
    @When("El usuario completa formulario con edad menor a {int}")
    public void el_usuario_completa_formulario_con_edad_menor_a(Integer int1) throws IOException, ParseException {
        el_usuario_completa_datos_del_formulario();
    }
    @Then("Se muestra mensaje La edad debe ser mayor a {int}")
    public void se_muestra_mensaje_la_edad_debe_ser_mayor_a(Integer int1) {
        WebElement pageMsgErrorEdad = driver.findElement(homeForm.getMsgErrorEdadLocator());
        // Se valida que el mensaje de error recibido, sea el definido
        Assert.assertEquals(homeForm.getMsgErrorEdad(),pageMsgErrorEdad.getText());
    }
    // Fin escenario Agregar usuario con edad menor a 1
}
