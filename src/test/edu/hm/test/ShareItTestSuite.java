package edu.hm.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import edu.hm.shareit.model.BookTest;
import edu.hm.shareit.model.CopyTest;
import edu.hm.shareit.model.DiscTest;
import edu.hm.shareit.model.MediumTest;

@RunWith(Suite.class)

@Suite.SuiteClasses({
   BookTest.class,
   CopyTest.class,
   DiscTest.class,
   MediumTest.class
})

public class ShareItTestSuite {}
