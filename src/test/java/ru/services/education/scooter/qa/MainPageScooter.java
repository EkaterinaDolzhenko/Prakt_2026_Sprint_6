package ru.services.education.scooter.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class MainPageScooter {
    //Кнопка "да все привыкли"
    protected final By cookieButton = By.className("App_CookieButton__3cvqF");

    // Статические локаторы для вопросов
    public static final By FIRST_QUESTION = By.id("accordion__heading-0");
    public static final By SECOND_QUESTION = By.id("accordion__heading-1");
    public static final By THIRD_QUESTION = By.id("accordion__heading-2");
    public static final By FOURTH_QUESTION = By.id("accordion__heading-3");
    public static final By FIFTH_QUESTION = By.id("accordion__heading-4");
    public static final By SIXTH_QUESTION = By.id("accordion__heading-5");
    public static final By SEVENTH_QUESTION = By.id("accordion__heading-6");
    public static final By EIGHTH_QUESTION = By.id("accordion__heading-7");

    // Статические локаторы для ответов
    public static final By FIRST_ANSWER = By.id("accordion__panel-0");
    public static final By SECOND_ANSWER = By.id("accordion__panel-1");
    public static final By THIRD_ANSWER = By.id("accordion__panel-2");
    public static final By FOURTH_ANSWER = By.id("accordion__panel-3");
    public static final By FIFTH_ANSWER = By.id("accordion__panel-4");
    public static final By SIXTH_ANSWER = By.id("accordion__panel-5");
    public static final By SEVENTH_ANSWER = By.id("accordion__panel-6");
    public static final By EIGHTH_ANSWER = By.id("accordion__panel-7");

    // Статические массивы с тестовыми данными
    public static final By[] QUESTIONS = {
            FIRST_QUESTION,
            SECOND_QUESTION,
            THIRD_QUESTION,
            FOURTH_QUESTION,
            FIFTH_QUESTION,
            SIXTH_QUESTION,
            SEVENTH_QUESTION,
            EIGHTH_QUESTION
    };

    public static final By[] ANSWERS = {
            FIRST_ANSWER,
            SECOND_ANSWER,
            THIRD_ANSWER,
            FOURTH_ANSWER,
            FIFTH_ANSWER,
            SIXTH_ANSWER,
            SEVENTH_ANSWER,
            EIGHTH_ANSWER
    };

    public static final String[] EXPECTED_TEXTS = {
            Constants.FIRST_ANSWER_TEXT,
            Constants.SECOND_ANSWER_TEXT,
            Constants.THIRD_ANSWER_TEXT,
            Constants.FOURTH_ANSWER_TEXT,
            Constants.FIFTH_ANSWER_TEXT,
            Constants.SIXTH_ANSWER_TEXT,
            Constants.SEVENTH_ANSWER_TEXT,
            Constants.EIGHTH_ANSWER_TEXT
    };

    //Кнопка «Заказать» вверху страницы
    public static final By ORDER_BUTTON_HEADER = By.cssSelector("div.Header_Nav__AGCXC > button.Button_Button__ra12g");
    //Кнопка «Заказать» в центре страницы
    public static final By ORDER_BUTTON = By.cssSelector("div.Home_FinishButton__1_cWm > button.Button_Button__ra12g");

    //Добавили поле driver и wait
    private final WebDriver driver;
    private final WebDriverWait wait;

    //Добавили конструктор класса page object
    public MainPageScooter(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Constants.EXPLICIT_TIMEOUT);
    }

    //Метод для открытия главной страницы
    public void open() {
        driver.get(Constants.BASE_URL);
    }

    //Метод для для нажатия на кнопку "да все привыкли"
    public void clickAcceptCookie() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(cookieButton));
        driver.findElement(cookieButton).click();
    }
    //Метод для клика по вопросу
    public void clickQuestion(By question) {
        wait.until(ExpectedConditions.elementToBeClickable(question));
        driver.findElement(question).click();
    }
    // Метод для проверки ответа с параметром
    public void checkAnswerText(By answer, String expectedText) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(answer));
        String actualText = driver.findElement(answer).getText();
        assertEquals(expectedText, actualText);
    }
    //Метод для клика по кнопке заказать в шапке
    public void clickCreateOrderHeader() {
        wait.until(ExpectedConditions.elementToBeClickable(ORDER_BUTTON_HEADER));
        driver.findElement(ORDER_BUTTON_HEADER).click();
    }
    //Метод для клика по кнопке заказать в центре страницы
    public void clickCreateOrder() {
        wait.until(ExpectedConditions.elementToBeClickable(ORDER_BUTTON));
        driver.findElement(ORDER_BUTTON).click();
    }
}
