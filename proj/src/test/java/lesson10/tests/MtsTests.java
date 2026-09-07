package lesson10.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import lesson10.pages.MtsMainPage;
import lesson10.pages.MtsPaymentWindow;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MtsTests {
    private static WebDriver driver;

    @BeforeAll
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://mts.by");
        driver.findElement(By.id("cookie-agree")).click();
    }

    @AfterEach
    public void cleanUpAfterTest() {
        driver.get("https://mts.by");
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void checkBlockTitle() {
        MtsMainPage title = new MtsMainPage(driver);
        Assertions.assertEquals("ОНЛАЙН ПОПОЛНЕНИЕ\n" + "БЕЗ КОМИССИИ", title.getBlockTitle());
    }

    @Test
    public void checkLogos() {
        MtsMainPage numberOfCards = new MtsMainPage(driver);
        Assertions.assertEquals(5, numberOfCards.getNumLogos());
    }

    @Test
    public void checkLink() {
        WebElement link = driver.findElement(By.xpath("//div[contains(@class, 'pay')]//a"));
        link.click();
        Assertions.assertEquals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/", driver.getCurrentUrl());
    }

    @Test
    public void checkPayment() { // Не забываем public!
        MtsMainPage mainPage = new MtsMainPage(driver);
        mainPage.fillPaymentForm("297777777", "12");
        MtsPaymentWindow paymentWindow = new MtsPaymentWindow(driver);
        Assertions.assertTrue(paymentWindow.isCreditCardFieldDisplayed());
        paymentWindow.leavePaymentWindow();
        driver.navigate().refresh();
    }

    @Test
    public void checkPlaceholdersForAllOptions() {
        MtsMainPage mainPage = new MtsMainPage(driver);
        Assertions.assertEquals("Номер телефона", mainPage.getFieldPlaceholder(mainPage.connectionPhoneLocator));
        Assertions.assertEquals("Сумма", mainPage.getFieldPlaceholder(mainPage.connectionSumLocator));
        Assertions.assertEquals("E-mail для отправки чека", mainPage.getFieldPlaceholder(mainPage.connectionEmailLocator));
        mainPage.selectPaymentOption("Домашний интернет");
        Assertions.assertEquals("Номер абонента", mainPage.getFieldPlaceholder(mainPage.internetPhoneLocator));
        Assertions.assertEquals("Сумма", mainPage.getFieldPlaceholder(mainPage.internetSumLocator));
        Assertions.assertEquals("E-mail для отправки чека", mainPage.getFieldPlaceholder(mainPage.internetEmailLocator));
        mainPage.selectPaymentOption("Рассрочка");
        Assertions.assertEquals("Номер счета на 44", mainPage.getFieldPlaceholder(mainPage.instalmentScoreLocator));
        Assertions.assertEquals("Сумма", mainPage.getFieldPlaceholder(mainPage.instalmentSumLocator));
        Assertions.assertEquals("E-mail для отправки чека", mainPage.getFieldPlaceholder(mainPage.instalmentEmailLocator));
        mainPage.selectPaymentOption("Задолженность");
        Assertions.assertEquals("Номер счета на 2073", mainPage.getFieldPlaceholder(mainPage.arrearsScoreLocator));
        Assertions.assertEquals("Сумма", mainPage.getFieldPlaceholder(mainPage.arrearsSumLocator));
        Assertions.assertEquals("E-mail для отправки чека", mainPage.getFieldPlaceholder(mainPage.arrearsEmailLocator));
    }

    @Test
    public void checkPaymentWidgetFullDetails() {
        MtsMainPage mainPage = new MtsMainPage(driver);
        mainPage.fillPaymentForm("297777777", "12");
        MtsPaymentWindow paymentWindow = new MtsPaymentWindow(driver);
        String descriptionText = paymentWindow.getPaymentDescriptionText();
        Assertions.assertTrue(descriptionText.contains("375297777777"), "Номер телефона отображается некорректно!");
        Assertions.assertEquals("12.00 BYN", paymentWindow.getPaymentCostText().trim());
        Assertions.assertTrue(paymentWindow.getSubmitButtonText().contains("12.00 BYN"), "Сумма на кнопке не совпадает!");
        Assertions.assertEquals("Номер карты", paymentWindow.getCardFieldLabelText(paymentWindow.creditCardLabelLocator));
        Assertions.assertEquals("Срок действия", paymentWindow.getCardFieldLabelText(paymentWindow.expirationCardLabelLocator));
        Assertions.assertEquals("CVC", paymentWindow.getCardFieldLabelText(paymentWindow.cvcLabelLocator));
        Assertions.assertEquals("Имя и фамилия на карте", paymentWindow.getCardFieldLabelText(paymentWindow.holderLabelLocator));
        Assertions.assertEquals(5, paymentWindow.getCardLogosCount(), "Количество логотипов карт в окне оплаты не совпадает!");
        paymentWindow.leavePaymentWindow();
    }
}

