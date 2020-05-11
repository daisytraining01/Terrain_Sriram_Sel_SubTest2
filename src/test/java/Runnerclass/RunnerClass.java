package Runnerclass;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="C:\\Users\\sriramsn\\eclipse-workspace\\SubjectiveSriram\\Feaurefiles\\sample.feature",
		glue="Stepdefinition",
		tags="@transaction1,@transaction2"
		
		)

public class RunnerClass 
{
    
}
