package org.example;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.Before;
import org.junit.runner.RunWith;
import ru.sbtqa.tag.pagefactory.Tag;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true,
        plugin = {"pretty"},
        glue = {"ru.sbtqa.tag.stepdefs",
                "org.example.stepdefs"},
        features = {"src/test/resources/features/"},
        tags = {"@getService.tk1"}
)
public class CucumberTest extends Tag {}