package BDD;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/FeaturesFile",
        glue = "Stepdefintions",
        plugin = {"pretty","html:target/cucumber-reports"}

)
public class Task_2_Runner {


}
