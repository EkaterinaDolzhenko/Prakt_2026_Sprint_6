package qa.pageobject;

import java.time.Duration;

public class Constants {
    public static final String BASE_URL = "https://qa-scooter.praktikum-services.ru/";
    public static final Duration EXPLICIT_TIMEOUT = Duration.ofSeconds(5);

    public static final String FIRST_ANSWER_TEXT = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    public static final String SECOND_ANSWER_TEXT = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    public static final String THIRD_ANSWER_TEXT = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    public static final String FOURTH_ANSWER_TEXT = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    public static final String FIFTH_ANSWER_TEXT = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    public static final String SIXTH_ANSWER_TEXT = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    public static final String SEVENTH_ANSWER_TEXT = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    public static final String EIGHTH_ANSWER_TEXT = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";


    public static final String[] FIRST_NAME = {"Екатерина", "александр"};
    public static final String[] SECOND_NAME = {"Долженко", "александров"};
    public static final String[] ADDRESS = {"Тверская 11","Центральный проезд дом 7 кв.85"};
    public static final String[] TEL_NUMBER = {"+79955910702","89325580474"};
    public static final String[] DATE = {"10.05.2026","15.06.2026"};
    public static final String[] COMMENT = {"Прошу не опаздывать"," "};
}
