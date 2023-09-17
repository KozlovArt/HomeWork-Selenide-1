import com.codeborne.selenide.CollectionCondition;
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
        $$("h4").shouldHave(itemWithText("3. Using JUnit5 extend test class:"));


        //sleep(5000);
    }

}
