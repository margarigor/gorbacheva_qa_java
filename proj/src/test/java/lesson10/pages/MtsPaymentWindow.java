package lesson10.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MtsPaymentWindow {
    private WebDriver driver;
    private final By paymentDescriptionLocator = By.className("pay-description__text");
    private final By paymentCostLocator = By.className("pay-description__cost");
    private final By submitButtonLocator = By.xpath("//button[contains(@class, 'colored')]");
    public final By cardLogosLocator = By.xpath("//div[contains(@class, 'cards-brands__container')]//img");
    public final By creditCardLabelLocator = By.xpath("//input[@formcontrolname='creditCard']/following-sibling::label");
    public final By expirationCardLabelLocator = By.xpath("//input[@formcontrolname='expirationDate']/following-sibling::label");
    public final By cvcLabelLocator = By.xpath("//input[@formcontrolname='cvc']/following-sibling::label");
    public final By holderLabelLocator = By.xpath("//input[@formcontrolname='holder']/following-sibling::label");
    private final By creditCardFieldLocator = By.xpath("//input[@formcontrolname='creditCard']");

    public MtsPaymentWindow(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isCreditCardFieldDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement creditCardField = wait.until(ExpectedConditions.visibilityOfElementLocated(creditCardFieldLocator));
        return creditCardField.isDisplayed();
    }

    public void leavePaymentWindow() {
        driver.switchTo().defaultContent();
    }

    public String getPaymentDescriptionText() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement description = wait.until(ExpectedConditions.visibilityOfElementLocated(paymentDescriptionLocator));
        return description.getText();
    }

    public String getPaymentCostText() {
        return driver.findElement(paymentCostLocator).getText();
    }

    public String getSubmitButtonText() {
        return driver.findElement(submitButtonLocator).getText();
    }

    public int getCardLogosCount() {
        return driver.findElements(cardLogosLocator).size();
    }

    public String getCardFieldLabelText(By locator) {
        return driver.findElement(locator).getText();
    }
}
