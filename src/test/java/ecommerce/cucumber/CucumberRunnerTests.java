package ecommerce.cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = "json:target/cucumber-report.json",
        features = "src/test/resources/features/login_checkout.feature",
        glue="ecommerce/cucumber")
public class CucumberRunnerTests extends AbstractTestNGCucumberTests {

}
