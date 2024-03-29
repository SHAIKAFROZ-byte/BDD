package BDD;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.testng.annotations.Test;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/FeaturesFile",
        glue = "Stepdefintions",
        plugin = {"pretty","html:target/cucumber-reports","json:target/cucumber-json-reports/cucumber.json"}

)
@Test
public class Task_2_Runner {


}
