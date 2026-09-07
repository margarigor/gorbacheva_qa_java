package lesson9;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class MyTest {

    // Сделали драйвер статичным, чтобы он был доступен в static-методах
    private static WebDriver driver;

    @BeforeAll
    static void setupClass() {
        // 1. Настраиваем менеджер драйверов
        WebDriverManager.chromedriver().setup();
        // 2. ОДИН РАЗ запускаем браузер для ВСЕХ тестов в этом классе
        driver = new ChromeDriver();
        driver.get("https://mts.by");
        driver.findElement(By.id("cookie-agree")).click();

    }

    @AfterEach
    void cleanUpAfterTest() {
        driver.get("https://mts.by");
    }

    @AfterAll
    static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    void checkBlockTitle() {
        WebElement blockTitle = new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class, 'pay')]//h2")));
        String actualText = blockTitle.getText();

        // Печатаем для самопроверки
        System.out.println("Текст из профиля элемента: " + actualText);
        Assertions.assertEquals("ОНЛАЙН ПОПОЛНЕНИЕ\n" + "БЕЗ КОМИССИИ", actualText);
    }


    @Test
    void checkLogos() {
        List<WebElement> allCards = driver.findElements(By.xpath("//div[contains(@class, 'pay__partners')]//img"));
        Assertions.assertEquals(5, allCards.size());

        // Чтобы посмотреть точные названия
        System.out.println("=== НАЧАЛО СПИСКА  ===");
        for (WebElement header : allCards) {
            System.out.println("Платежные системы: [" + header.getAttribute("alt") + "]");
        }
        System.out.println("=== КОНЕЦ СПИСКА  ===");
    }

    @Test
    void checkLink() {
        WebElement link = driver.findElement(By.xpath("//div[contains(@class, 'pay')]//a"));
        link.click();
        Assertions.assertEquals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/", driver.getCurrentUrl());
    }

    @Test
    void checkPayment() {
        WebElement phoneInputField = driver.findElement(By.xpath("//div//input[contains(@id, 'connection-phone')]"));
        phoneInputField.click();
        phoneInputField.sendKeys("297777777");
        WebElement sumInputField = driver.findElement(By.xpath("//div//input[contains(@id, 'connection-sum')]"));
        sumInputField.click();
        sumInputField.sendKeys("12");
        WebElement continueButton = driver.findElement(By.xpath("//button[@class='button button__default ']"));
        continueButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@class='payment-widget-iframe']")));

        WebElement creditCardField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@formcontrolname='creditCard']"))
        );
        Assertions.assertTrue(creditCardField.isDisplayed());
        driver.switchTo().defaultContent();
    }
}



