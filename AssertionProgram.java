package amazonProject;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionProgram {
	@Test(retryAnalyzer = REtryLogic.class )
 public void testCase() {
	 //Assert.assertTrue(false);
		Assert.assertNotEquals(74,56);
 }
}
