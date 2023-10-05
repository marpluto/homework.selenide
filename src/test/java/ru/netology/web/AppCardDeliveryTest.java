package ru.netology.web;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AppCardDeliveryTest {

    String generateDate(int daysToAdd, String pattern) {
        return LocalDate.now().plusDays(daysToAdd).format(DateTimeFormatter.ofPattern(pattern));
    }

    @Test
    void shouldReturnSuccessDateInThreeDays() {
        open("http://localhost:9999");
        String date = generateDate(3, "dd.MM.yyyy");
        $("[data-test-id='city'] input").setValue("Казань");
        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME, Keys.DELETE));
        $("[data-test-id='date'] input").setValue(date);
        $("[data-test-id='name'] input").setValue("Михайлов Михаил");
        $("[data-test-id='phone'] input").setValue("+71234567890");
        $("[data-test-id='agreement']").click();
        $("button.button").click();
        $("[data-test-id='notification']").shouldBe(visible, Duration.ofSeconds(15));
        $("[data-test-id='notification']").shouldHave(exactText("Успешно!\n" +
                "Встреча успешно забронирована на " + date));
    }

    @Test
    void shouldReturnSuccessDateInFourDays() {
        open("http://localhost:9999");
        String date = generateDate(4, "dd.MM.yyyy");
        $("[data-test-id='city'] input").setValue("Казань");
        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME, Keys.DELETE));
        $("[data-test-id='date'] input").setValue(date);
        $("[data-test-id='name'] input").setValue("Михайлов Михаил");
        $("[data-test-id='phone'] input").setValue("+71234567890");
        $("[data-test-id='agreement']").click();
        $("button.button").click();
        $("[data-test-id='notification']").shouldBe(visible, Duration.ofSeconds(15));
        $("[data-test-id='notification']").shouldHave(exactText("Успешно!\n" +
                "Встреча успешно забронирована на " + date));
    }

    @Test
    void shouldReturnSuccessDateInThirtyDays() {
        open("http://localhost:9999");
        String date = generateDate(30, "dd.MM.yyyy");
        $("[data-test-id='city'] input").setValue("Казань");
        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME, Keys.DELETE));
        $("[data-test-id='date'] input").setValue(date);
        $("[data-test-id='name'] input").setValue("Михайлов Михаил");
        $("[data-test-id='phone'] input").setValue("+71234567890");
        $("[data-test-id='agreement']").click();
        $("button.button").click();
        $("[data-test-id='notification']").shouldBe(visible, Duration.ofSeconds(15));
        $("[data-test-id='notification']").shouldHave(exactText("Успешно!\n" +
                "Встреча успешно забронирована на " + date));
    }

    @Test
    void shouldReturnSuccessDoubleSurname() {
        open("http://localhost:9999");
        String date = generateDate(4, "dd.MM.yyyy");
        $("[data-test-id='city'] input").setValue("Казань");
        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME, Keys.DELETE));
        $("[data-test-id='date'] input").setValue(date);
        $("[data-test-id='name'] input").setValue("Петров-Михайлов Михаил");
        $("[data-test-id='phone'] input").setValue("+71234567890");
        $("[data-test-id='agreement']").click();
        $("button.button").click();
        $("[data-test-id='notification']").shouldBe(visible, Duration.ofSeconds(15));
        $("[data-test-id='notification']").shouldHave(exactText("Успешно!\n" +
                "Встреча успешно забронирована на " + date));
    }
}