package ru.services.education.scooter.qa;

import org.junit.jupiter.api.extension.RegisterExtension;
import org.openqa.selenium.WebDriver;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import qa.pageobject.Constants;
import qa.pageobject.MainPageScooter;
import qa.pageobject.OrderPageScooter;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreateOrderParametrizedTest {

    @RegisterExtension
    public final DriverExtension extension = new DriverExtension();

    // Метод-источник данных
    public static Stream<Object[]> getFormData() {
        return IntStream.range(0, 2)
                .mapToObj(i -> new Object[]{
                        Constants.FIRST_NAME[i],
                        Constants.SECOND_NAME[i],
                        Constants.ADDRESS[i],
                        Constants.TEL_NUMBER[i],
                        Constants.DATE[i],
                        Constants.COMMENT[i],
                        OrderPageScooter.METRO_STATION[i],
                        OrderPageScooter.PERIOD[i],
                        OrderPageScooter.CHECK_BOX[i]
                });
    }

    @ParameterizedTest
    @MethodSource("getFormData")
    public void createOrderHeaderTest(String firstName,String secondName,String address,String telNumber,String date,String comment,By metroStation,By period,By checkBox){
        WebDriver driver = extension.getDriver();
        var mainPageScooter = new MainPageScooter(driver);
        mainPageScooter.open();
        mainPageScooter.clickAcceptCookie();
        mainPageScooter.clickCreateOrderHeader();

        var orderPageScooter = new OrderPageScooter(driver);
        orderPageScooter.inputPersonalInformation(firstName,secondName,address,telNumber,metroStation);
        orderPageScooter.inputRentInformation(date,comment,period,checkBox);
        orderPageScooter.clickCreateOrderButton();
        orderPageScooter.clickConfirmOrderButton();

        assertTrue(orderPageScooter.isOrderSuccessDisplayed(),
                "Сообщение об успехе не отображается после создания заказа");
    }

    @ParameterizedTest
    @MethodSource("getFormData")
    public void createOrderTest(String firstName,String secondName,String address,String telNumber,String date,String comment,By metroStation,By period,By checkBox){
        WebDriver driver = extension.getDriver();
        var mainPageScooter = new MainPageScooter(driver);
        mainPageScooter.open();
        mainPageScooter.clickAcceptCookie();
        mainPageScooter.clickCreateOrder();

        var orderPageScooter = new OrderPageScooter(driver);
        orderPageScooter.inputPersonalInformation(firstName,secondName,address,telNumber,metroStation);
        orderPageScooter.inputRentInformation(date,comment,period,checkBox);
        orderPageScooter.clickCreateOrderButton();
        orderPageScooter.clickConfirmOrderButton();

        assertTrue(orderPageScooter.isOrderSuccessDisplayed(),
                "Сообщение об успехе не отображается после создания заказа");
    }
}
