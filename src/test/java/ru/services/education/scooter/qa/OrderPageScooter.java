package ru.services.education.scooter.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrderPageScooter {
    //Поле с именем
    protected final By firstNameField = By.xpath(".//input[@placeholder='* Имя']");
    //Поле с фамилией
    protected final By secondNameField = By.xpath(".//input[@placeholder='* Фамилия']");
    //Поле с адресом
    protected final By addressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    //Поле со станцией метро
    protected final By metroStationField = By.xpath(".//input[@placeholder='* Станция метро']");
    //станция метро из списка (Парк победы синяя)
    public static final  By METRO_STATION_VICTORY_PARK_BLUE = By.cssSelector("[data-index='53'][data-value='54']");
    //станция метро из списка (Лихоборы)
    public static final  By METRO_STATION_LIHOBORY = By.cssSelector("[data-index='224'][data-value='237']");
    //Поле с телефоном
    protected final By telNumberField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    //Кнопка Далее
    protected final By nextButton = By.cssSelector("div.Order_NextButton__1_rCA > button.Button_Button__ra12g");
    //Поле с датой
    protected final By dateField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    //Поле с периодом
    protected final By periodField = By.className("Dropdown-control");
    //Сутки в списке периода
    public static final By PERIOD_ONE_DAY = By.xpath("//div[@class='Dropdown-option' and text()='сутки']");
    //Семь суток в списке периода
    public static final By PERIOD_SEVEN_DAY = By.xpath("//div[@class='Dropdown-option' and text()='семеро суток']");
    //Чек-бокс чёрный жемчуг
    public static final By BLACK_CHECK_BOX = By.xpath("//label[text()='чёрный жемчуг']");
    //Чек-бокс серая безысходность
    public static final By GREY_CHECK_BOX = By.xpath("//label[text()='серая безысходность']");
    //Поле с комментарием
    protected final By commentField = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    //Кнопка "Заказать"
    protected final By createOrderButton = By.xpath("//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");
    //Кнопка подтверждения заказа "Да"
    protected final By confirmOrderButton = By.xpath("//div[@class='Order_Buttons__1xGrp']/button[text()='Да']");
    //Сообщение об успешном заказе
    protected final By successfulMessage = By.xpath("//div[normalize-space(text())='Заказ оформлен']");

    //Массив со станциями метро
    public static final By[] METRO_STATION = {
            METRO_STATION_VICTORY_PARK_BLUE,
            METRO_STATION_LIHOBORY
    };
    //Массив с периодами
    public static final By[] PERIOD = {
            PERIOD_ONE_DAY,
            PERIOD_SEVEN_DAY
    };
    //Массив с чек-боксами
    public static final By[] CHECK_BOX = {
            BLACK_CHECK_BOX,
            GREY_CHECK_BOX
    };

    //метод ввода имени
    public void inputFirstName(String firstName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField));
        driver.findElement(firstNameField).click();
        driver.findElement(firstNameField).clear();
        driver.findElement(firstNameField).sendKeys(firstName);
    }
    //метод ввода фамилии
    public void inputSecondName(String secondName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(secondNameField));
        driver.findElement(secondNameField).click();
        driver.findElement(secondNameField).clear();
        driver.findElement(secondNameField).sendKeys(secondName);
    }
    //метод ввода адреса
    public void inputAddress(String address) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(addressField));
        driver.findElement(addressField).click();
        driver.findElement(addressField).clear();
        driver.findElement(addressField).sendKeys(address);
    }
    //метод ввода станции метро
    public void inputMetroStation(By metroStation) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(metroStationField));
        driver.findElement(metroStationField).click();
        driver.findElement(metroStation).click();
    }
    //метод ввода телефона
    public void inputTelNumber(String telNumber) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(telNumberField));
        driver.findElement(telNumberField).click();
        driver.findElement(telNumberField).clear();
        driver.findElement(telNumberField).sendKeys(telNumber);
    }
    //метод нажатия на кнопку Далее
    public void clickNextButton() {
        wait.until(ExpectedConditions.elementToBeClickable(nextButton));
        driver.findElement(nextButton).click();
    }
    //метод указания даты
    public void inputDate(String date) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(dateField));
        driver.findElement(dateField).click();
        driver.findElement(dateField).clear();
        driver.findElement(dateField).sendKeys(date);
        driver.findElement(dateField).sendKeys(Keys.ENTER);
    }
    //метод выбора периода
    public void inputPeriod(By period) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(periodField));
        driver.findElement(periodField).click();
        driver.findElement(period).click();
    }
    //метод установки чек-бокса
    public void clickCheckBox(By checkBox) {
        wait.until(ExpectedConditions.elementToBeClickable(checkBox));
        driver.findElement(checkBox).click();
    }
    //метод заполнения комментария
    public void inputCommentField(String comment) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(commentField));
        driver.findElement(commentField).click();
        driver.findElement(commentField).clear();
        driver.findElement(commentField).sendKeys(comment);
    }
    //метод нажатия на кнопку Заказать
    public void clickCreateOrderButton() {
        wait.until(ExpectedConditions.elementToBeClickable(createOrderButton));
        driver.findElement(createOrderButton).click();
    }
    //метод подтверждения заказа
    public void clickConfirmOrderButton() {
        wait.until(ExpectedConditions.elementToBeClickable(confirmOrderButton));
        driver.findElement(confirmOrderButton).click();
    }
    // Метод для проверки успешного сообщения
    public void verifyOrderSuccess() {
        assertTrue(driver.findElement(successfulMessage).isDisplayed(),
                "Сообщение об успехе не отображается");
    }

    //Метод для заполнения персональной информации
    public void inputPersonalInformation(String firstName,String secondName,String address,String telNumber,By metroStation){
        inputFirstName(firstName);
        inputSecondName(secondName);
        inputAddress(address);
        inputMetroStation(metroStation);
        inputTelNumber(telNumber);
        clickNextButton();
    }
    //Метод для заполнения данных по аренде
    public void inputRentInformation(String date,String comment,By period,By checkBox){
        inputDate(date);
        inputPeriod(period);
        clickCheckBox(checkBox);
        inputCommentField(comment);
    }

    //Добавили поле driver и wait
    private final WebDriver driver;
    private final WebDriverWait wait;

    //Добавили конструктор класса page object
    public OrderPageScooter(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Constants.EXPLICIT_TIMEOUT);
    }
}
