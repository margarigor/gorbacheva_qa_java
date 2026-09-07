package lesson10.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class MtsMainPage {
    private final WebDriver driver;

    public MtsMainPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By blockTitleLocator = By.xpath("//div[contains(@class, 'pay')]//h2");
    private final By cardsListLocator = By.xpath("//div[contains(@class, 'pay__partners')]//img");
    private final By phoneInputFieldLocator = By.xpath("//div//input[contains(@id, 'connection-phone')]");
    private final By sumInputFieldLocator = By.xpath("//div//input[contains(@id, 'connection-sum')]");
    private final By continueButtonLocator = By.xpath("//button[@class='button button__default ']");
    private final By iframeLocator = By.xpath("//iframe[@class='payment-widget-iframe']");
    private final By paySelectLocator = By.id("pay");
    public final By connectionPhoneLocator = By.id("connection-phone");
    public final By connectionSumLocator = By.id("connection-sum");
    public final By connectionEmailLocator = By.id("connection-email");
    public final By internetPhoneLocator = By.id("internet-phone");
    public final By internetSumLocator = By.id("internet-sum");
    public final By internetEmailLocator = By.id("internet-email");
    public final By instalmentScoreLocator = By.id("score-instalment");
    public final By instalmentSumLocator = By.id("instalment-sum");
    public final By instalmentEmailLocator = By.id("instalment-email");
    public final By arrearsScoreLocator = By.id("score-arrears");
    public final By arrearsSumLocator = By.id("arrears-sum");
    public final By arrearsEmailLocator = By.id("arrears-email");

    public String getBlockTitle() {
        WebElement blockTitle = new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfElementLocated(blockTitleLocator));
        return blockTitle.getText();
    }

    public int getNumLogos() {
        List<WebElement> allCards = driver.findElements(cardsListLocator);
        return allCards.size();
    }

    public void fillPaymentForm(String phone, String sum) {
        WebElement phoneInputField = driver.findElement(phoneInputFieldLocator);
        phoneInputField.click();
        phoneInputField.sendKeys(phone);
        WebElement sumInputField = driver.findElement(sumInputFieldLocator);
        sumInputField.click();
        sumInputField.sendKeys(sum);
        WebElement continueButton = driver.findElement(continueButtonLocator);
        continueButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframeLocator));
    }

    public void selectPaymentOption(String optionName) {
        WebElement selectElement = driver.findElement(paySelectLocator);
        Select paymentSelect = new Select(selectElement);
        paymentSelect.selectByVisibleText(optionName);
    }

    public String getFieldPlaceholder(By locator) {
        return driver.findElement(locator).getAttribute("placeholder");
    }
}



