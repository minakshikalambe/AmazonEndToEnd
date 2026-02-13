package amazonProject;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class REtryLogic implements IRetryAnalyzer {

    int retryCount = 0;
    int maxRetryCount = 2; // retry 2 times

    @Override
    public boolean retry(ITestResult result) {

        if (retryCount < maxRetryCount) {
            retryCount++;
            return true;   // retry test
        }
        return false;      // stop retrying
    }
}
