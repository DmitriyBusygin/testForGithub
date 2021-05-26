import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class GithubTests {

    @Test
    public void githubTest() {
        // открыть github.com
        open("https://github.com/");
        // ввести в поле поиска selenide и нажать Enter
        $("[name='q']").setValue("selenide").pressEnter();
        // найти ссылку на selenide и кликнуть
        $("[href='/selenide/selenide']").click();
        // проверка: в заголовке встречается selenide/selenide
        $("h1").shouldHave(text("selenide / selenide"));
        //найти иконку wiki и кликнуть
        $(byText("Wiki")).click();
        //открыть весь список страниц
        $(withText("Show 1 more pages")).click();
        // проверить наличие страницы SoftAssertions и перейти
        $x("//a[text()='SoftAssertions']").should(visible).click();
        // находим текст "Using JUnit5..." поднимаемся выше и проверяем что ниже отображается div блок
        $x("//li[text()='Using JUnit5 extend test class:']/ancestor::ol/following-sibling::div[1]").should(visible);
    }
}
