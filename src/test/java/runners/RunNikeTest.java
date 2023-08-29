package runners;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features\\Niki.feature")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty,html:target/html-reports/index.html")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "ui_stepdefinitions")


public class RunNikeTest {
	

}
