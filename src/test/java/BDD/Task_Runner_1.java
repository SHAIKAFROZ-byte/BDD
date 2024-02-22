package BDD;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.testng.annotations.Test

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/FeaturesFile/Task_1.feature",
        glue = "Stepdefintions",
        plugin = {"pretty","html:target/cucumber-reports"}

)
@Test
public class Task_Runner_1 {


}
