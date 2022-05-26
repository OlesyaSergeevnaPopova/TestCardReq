package ru.netology.cardreq;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CardReqTest {
    private WebDriver driver;

    @BeforeEach
    void setUp() {
        System.setProperty("webdriver.chrome.driver", "driver/win/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
        driver = null;
    }

    @Test
    void shouldValidReq () {
        driver.get("http://localhost:9999");
        driver.findElement(By.cssSelector("[data-test-id=\"name\"] input")).sendKeys("Иванов Иван");
        driver.findElement(By.cssSelector("[data-test-id=\"phone\"] input")).sendKeys("+79004442233");
        driver.findElement(By.cssSelector("[data-test-id=\"agreement\"]")).click();
        driver.findElement(By.cssSelector("[type=\"button\"]")).click();
        String text = driver.findElement(By.cssSelector("[data-test-id]")).getText();
        assertEquals("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.", text.trim());

    }
}
