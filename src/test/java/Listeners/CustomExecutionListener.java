package Listeners;

import Utilities.CMDRunner;
import org.testng.IExecutionListener;

public class CustomExecutionListener implements IExecutionListener {

    private final String cleanAllureResultsCommand = "cmd /c del /q /f target\\allure-results\\*";
    private final String generateAllureCommand = "cmd /c allure generate target/allure-results -o reports/ --clean --single-file";

    @Override
    public void onExecutionStart() {
        System.out.println(">>> Cleaning Old Allure Results...");
        CMDRunner.ExecuteCommand(cleanAllureResultsCommand);
    }

    @Override
    public void onExecutionFinish() {
        System.out.println(">>> Generating Allure Single-File Report...");
        CMDRunner.ExecuteCommand(generateAllureCommand);
    }
}