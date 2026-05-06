package ru.services.education.scooter.qa;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MainQuestionParametrizedTest {

    @RegisterExtension
    private final DriverExtension extension = new DriverExtension();

    // Метод-источник данных
    public static Stream<Object[]> getQuestionData() {
        return IntStream.range(0, MainPageScooter.QUESTIONS.length)
                .mapToObj(i -> new Object[]{
                        MainPageScooter.QUESTIONS[i],
                        MainPageScooter.ANSWERS[i],
                        MainPageScooter.EXPECTED_TEXTS[i]
                });
    }

    @ParameterizedTest
    @MethodSource("getQuestionData")
    void checkQuestionTest(By question, By answer, String expected) {
        WebDriver driver = extension.getDriver();
        var mainPageScooter = new MainPageScooter(driver);
        mainPageScooter.open();
        mainPageScooter.clickAcceptCookie();
        mainPageScooter.clickQuestion(question);
        mainPageScooter.checkAnswerText(answer, expected);
    }
}
