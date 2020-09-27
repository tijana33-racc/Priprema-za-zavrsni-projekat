package tests;

import org.testng.Assert;
import org.testng.annotations.Test;


public class LogInTest extends BasicTest {
// ovde pisemo smao test jer sve ostalo je setovano
//	u BasicTest klasi
	@Test
	public void test() { 
		this.driver.navigate().to(this.baseUrl+ "/login");
//		idem na login stranicu !!!!
		Assert.assertTrue(false);
//		svi testovi koji padnu za njih se zove after metodi iz basic test i pravi screenshot stranice !!!
	}
}
