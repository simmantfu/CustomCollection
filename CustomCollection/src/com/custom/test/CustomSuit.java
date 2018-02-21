package com.custom.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.custom.test.classes.CustomHashMapTest;
import com.custom.test.classes.CustomQueueListTest;

@RunWith(Suite.class)

@Suite.SuiteClasses({ CustomHashMapTest.class, CustomQueueListTest.class

})
public class CustomSuit {

}
