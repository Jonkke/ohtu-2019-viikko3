package ohtu;

import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
// import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Tester {

    public static void main(String[] args) {
        // WebDriver driver = new ChromeDriver();
        WebDriver driver = new FirefoxDriver();
        final String URL = "http://localhost:4567";
        driver.get(URL);
        //driver.get("http://localhost:4567");
        
        sleep(2);
        
//        WebElement element = driver.findElement(By.linkText("login"));
//        element.click();
//
//        sleep(2);
//
//        element = driver.findElement(By.name("username"));
//        element.sendKeys("pekka");
//        element = driver.findElement(By.name("password"));
//        element.sendKeys("akkep");
//        element = driver.findElement(By.name("login"));
//        
//        sleep(2);
//        element.submit();


        // WRONG PASSWORD LOGIN ATTEMPT
//        WebElement element = driver.findElement(By.linkText("login"));
//        element.click();
//        
//        sleep(1);
//        
//        element = driver.findElement(By.name("username"));
//        element.sendKeys("pekka");
//        element = driver.findElement(By.name("password"));
//        element.sendKeys("wrongpass");
//        element = driver.findElement(By.name("login"));
//        
//        sleep(2);
//        element.submit();
        
        // NEW USER CREATION & LOGOFF AFTERWARDS
        Random r = new Random();
        
        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();
        
        sleep(1);
        
        element = driver.findElement(By.name("username"));
        element.sendKeys("uusikayttaja"+r.nextInt(100000));
        element = driver.findElement(By.name("password"));
        element.sendKeys("salasana");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("salasana");
        element = driver.findElement(By.name("signup"));
        
        sleep(2);
        element.submit();
        
        sleep(2);
        
        element = driver.findElement(By.name("linkToMainPage"));
        element.click();
        
        sleep(2);
        
        element = driver.findElement(By.name("logout"));
        element.click();


        sleep(3);
        
        driver.quit();
    }
    
    private static void sleep(int n){
        try{
            Thread.sleep(n*1000);
        } catch(Exception e){}
    }
}
