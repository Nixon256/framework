package com.testng;

import org.base.BaseClass;
import org.testng.annotations.Test;

public class ClassB extends BaseClass {
	
	@Test
	private void tc_1() {
		 launchChromeBrowser();
		 launchUrl("https://en-gb.facebook.com/");

	}
	
	@Test
	private void tc_2() {
		 launchChromeBrowser();
		 launchUrl("https://www.google.com/");

	}
	
	@Test
	private void tc_3() {
		 launchChromeBrowser();
		 launchUrl("https://www.instagram.com/");

	}

}
