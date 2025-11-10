package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v137.audits.model.SRIMessageSignatureError;
import org.openqa.selenium.devtools.v137.layertree.model.StickyPositionConstraint;

public class HomeForm extends BasePage{

    private By inputNombre = By.xpath("//input[contains(@name,'nombre')]");
    private By inputEmail = By.xpath("//input[contains(@name,'email')]");
    private By inputEdad = By.xpath("//input[contains(@name,'edad')]");
    private By inputPass = By.xpath("//input[contains(@name,'contrasena')]");
    private By inputRepass = By.xpath("//input[contains(@name,'repetirContrasena')]");
    private By botonEnviar = By.className("submit-btn");
    private String msgOk = "Registro exitoso. Bienvenido/a,";
    private By msgOkLocator = By.id("mensajeExito");
    private String msgErrorEmail = "Por favor, introduce un email válido.";
    private By msgErrorEmailLocator = By.id("error-email");
    private String msgErrorPass = "Las contraseñas no coinciden.";
    private By msgErrorPassLocator = By.id("error-repetirContrasena");
    private String msgErrorEdad = "La edad debe ser mayor a 0.";
    private By msgErrorEdadLocator = By.id("error-edad");

    public String getMsgOk(){
        return msgOk;
    }
    public By getMsgOkLocator() {
        return msgOkLocator;
    }

    public String getMsgErrorEmail(){ return msgErrorEmail;}
    public By getMsgErrorEmailLocator(){ return msgErrorEmailLocator;}

    public String getMsgErrorPass(){ return msgErrorPass;}
    public By getMsgErrorPassLocator(){ return msgErrorPassLocator;}

    public String getMsgErrorEdad(){ return msgErrorEdad;}
    public By getMsgErrorEdadLocator(){ return msgErrorEdadLocator;}

    public void setInputNombre(String _nombre){ type(_nombre,inputNombre);}

    public void setInputEmail(String _email){type(_email, inputEmail);}

    public void setInputEdad(String _edad){ type(_edad,inputEdad);}

    public void setInputPass(String _pass){ type(_pass, inputPass);}

    public void setInputRepass(String _rePass){ type(_rePass,inputRepass);}

    public void clickBotonEnviar() throws Exception {
        this.click(botonEnviar);
    }

    public HomeForm (WebDriver driver){ super(driver); }
}
