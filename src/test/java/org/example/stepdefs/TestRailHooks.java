package org.example.stepdefs;

import com.codepine.api.testrail.TestRail;
import com.codepine.api.testrail.model.*;
import cucumber.api.Scenario;
import cucumber.api.java.After;

import java.util.*;

import static java.lang.Boolean.parseBoolean;
import static java.lang.System.getProperty;

public class TestRailHooks {
    private static TestRail testRail;
    private static Project project;
    private static Case testCase;
    private static List<CaseField> caseFields;
    private static List<ResultField> resultFields;
    private static List<Case> allTestCases;
    private static boolean hasTestRunInTestRail =parseBoolean(getProperty("hasTestRunInTestRail"));

    static {
        if (hasTestRunInTestRail) {
            testRail = TestRail
                    .builder(getProperty("TestRail"), getProperty("login"), getProperty("password"))
                    .build();
            project = testRail.projects().get(1).execute();
            caseFields = testRail.caseFields().list().execute();
            resultFields = testRail.resultFields().list().execute();
            allTestCases = testRail.cases().list(project.getId(), caseFields).execute();
        }
    }

    @After(order = 10)
    public void initTestCaseByCucumberScenario(Scenario scenario) {
        if (hasTestRunInTestRail) {
            testCase = allTestCases
                    .stream()
                    .filter(currentTestCase -> currentTestCase.getTitle().equalsIgnoreCase(scenario.getName()))
                    .findFirst()
                    .orElseThrow(() -> new IllegalStateException(scenario.getName() + " is not register in TestRail"));
        }
    }

//    @After(order = 9)
//    public void markScenarioAsAutomated() {
//        if (hasTestRunInTestRail) {
//            // TODO: 23.04.2020 realize
//        }
//    }
//
//    @After(order = 8)
//    public void addTestRailCaseToCucumberReport(Scenario scenario) {
//        if (hasTestRunInTestRail) {
    // TODO: 24.04.2020 realize 
//            scenario.write(testCase.getCustomField("step"));
//        }
//    }

    @After(order = 7)
    public void setExecutionResult (Scenario scenario) {
        // TODO: 24.04.2020 вынечти ран из хуков для прогона всех тестов в одном ране 
        if (hasTestRunInTestRail) {
            int status = getStatusMap().get(scenario.getStatus().name().toString());

            Run run = testRail.runs()
                    .add(project.getId(), new Run().setCaseIds(new ArrayList<>(testCase.getId())).setName("auto" + new Date()))
                    .execute();
            testRail.results()
                    .addForCase(run.getId(), testCase.getId(), new Result().setStatusId(status), resultFields)
                    .execute();
            testRail.runs().close(run.getId()).execute();
            testRail.projects().update(project.setCompleted(true)).execute();
        }
    }

    private Map<String, Integer> getStatusMap() {
        Map<String, Integer> mapCucumberToTestRailStatus = new Hashtable<>();
        int statusPassed = 1;
        int statusBlocked = 2;
        int statusUntested = 3;
        int statusRetest = 4;
        int statusFailed = 5;
        mapCucumberToTestRailStatus.put("PASSED", statusPassed);
        mapCucumberToTestRailStatus.put("FAILED", statusFailed);
        mapCucumberToTestRailStatus.put("UNDEFINED", statusBlocked);
        mapCucumberToTestRailStatus.put("SKIPPED", statusUntested);
        mapCucumberToTestRailStatus.put("PENDING", statusRetest);
        return mapCucumberToTestRailStatus;
    }



}
