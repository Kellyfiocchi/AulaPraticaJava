package br.com.juliodelima.taskit.signup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.gen5.api.Assertions;
import org.junit.gen5.api.DisplayName;
import org.junit.gen5.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;



@DisplayName("Testes Automatizados da Funcionalidade de Sign Up")
public class SignUpTests {
    @Test
    @DisplayName("Registrar um novo usuário com dados válidos")
    public static void main(String[] args) {

        // Abrir o navegador
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver =  new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        // Mavegar até a página taskit
        driver.get("http://www.juliodelima.com.br/taskit");

        // Vou clicar no botão que tem o ID igual a signup
        driver.findElement(By.id("signup")).click();

        // Vou digitar o ome no campo ID igual a name-sign-up
        driver.findElement(By.id("name-sign-up")).sendKeys("vovó");

        // Vou digitar o login no campo ID igual a login-sign-up
        driver.findElement(By.id("login-sign-up")).sendKeys("Ju");

        // Vou digitar o senha no campo ID igual a password-sign-up
        driver.findElement(By.id("password-sign-up")).sendKeys("123456");

        // Vou clicar no botão Save ID btn-submit-sign-up
        driver.findElement(By.id("btn-submit-sign-up")).click();

        // Validar o texto Hi, Julio foi apresentado no elemento que possui a class = me
        String saudacaoAtual = driver.findElement(By.className("me")).getText();
        Assertions.assertEquals("Hi, vovó", saudacaoAtual);

        // Fechar o navegador
        driver.quit();


    }

}
