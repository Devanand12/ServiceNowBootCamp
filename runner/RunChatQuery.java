package runner;

import org.testng.annotations.BeforeTest;

import com.testleaf.testng.api.base.ProjectSpecificMethods;

import cucumber.api.CucumberOptions;

@CucumberOptions(features="src/main/java/feature/ChatQuery.feature",glue="com.testleaf.selenium.pages",dryRun=false,monochrome=true)
public class RunChatQuery extends ProjectSpecificMethods{

	@BeforeTest
	public void setData() {
		excelFileName="TC001";
		testcaseName="Create New Incident";
		testcaseDec = "Incident-Create New Incident";
		author = "Shobana";
		category = "Documentry";
	}
}
