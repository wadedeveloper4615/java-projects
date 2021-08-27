package com.wade.spring.examples.springcucumber.bagbasics;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/bagbasics", plugin = { "pretty",
		"html:target/cucumber/bagbasics" }, extraGlue = "com.wade.spring.examples.springcucumber.bagcommons")
public class BagCucumberIntegrationTest {
}
