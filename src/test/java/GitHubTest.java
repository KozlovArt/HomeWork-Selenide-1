import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class GitHubTest {
    @BeforeAll
    static void beforeAll(){
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize="1200x800";
        Configuration.baseUrl = "https://github.com";
    }
    @Test
    void testFindJunt5() {
        open("/selenide/selenide");
        $("#wiki-tab").click();
        $$("[type='button']").findBy(text("Show 2 more pages")).click();
        $$("span.Truncate").shouldHave(itemWithText("SoftAssertions"));
        $$("span.Truncate").findBy(text("SoftAssertions")).click();
        $$("div.highlight-source-java").shouldHave(itemWithText("@ExtendWith({SoftAssertsExtension.class})\n" +
                "class Tests {\n" +
                "  @Test\n" +
                "  void test() {\n" +
                "    Configuration.assertionMode = SOFT;\n" +
                "    open(\"page.html\");\n" +
                "\n" +
                "    $(\"#first\").should(visible).click();\n" +
                "    $(\"#second\").should(visible).click();\n" +
                "  }\n" +
                "}"));


        /*
        Ответ на вопрос:
        Разница есть:
        $("h1 div") - вернет первый попавшийся элемент div, который находится под элементом h1
        не находились.
        $("h1").$("div"); - найдет первый попавшийся элемент h1 и будет искать у него дочерний
        елемент div
        Для данного случая код $("h1").$("div") упадет в ошибку:
        <h1>
             <a>Text1</a>
        </h1>
        <h1>
             <div>Text2</div>
        </h1>
        */


    }

}
