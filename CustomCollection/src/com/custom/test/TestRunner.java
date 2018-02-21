package com.custom.test;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {

	public static void main(String[] args) {
		Result runner = JUnitCore.runClasses(CustomSuit.class);
		
		for(Failure fail : runner.getFailures()){
			System.out.println(fail.toString());
		}

		System.out.println(runner.wasSuccessful());
		
		
	}

}
