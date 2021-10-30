package org.example;
import org.example.entities.AccountData;
import org.example.entities.TodoItem;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
    public ChromeDriver driver;

    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
    };

    public void auth(AccountData user) {
        driver.get("https://todo--spring--boot.herokuapp.com/sign-in");
        driver.manage().window().setSize(new Dimension(1536, 824));
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).sendKeys(user.email);
        driver.findElement(By.id("password")).sendKeys(user.password);
        driver.findElement(By.cssSelector(".send-button")).click();
    };

    public void createTodo(TodoItem todo) {
        driver.get("https://todo--spring--boot.herokuapp.com/main");
        driver.findElement(By.name("todoText")).click();
        driver.findElement(By.name("todoText")).sendKeys(todo.text);
        driver.findElement(By.cssSelector(".todo-form > button")).click();
    };
}
