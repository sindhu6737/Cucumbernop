package Hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class nopHooks {
	@Before("@Smoke")
	public void setup_browser(Scenario sc) {
		System.out.println("Launch chrome browser");
		System.out.println(sc.getName());
		
	}
	@After("@Smoke")
	public void tearDown_close(Scenario sc) {
		System.out.println("close the browser");
		System.out.println(sc.getName());
		
	}

}
