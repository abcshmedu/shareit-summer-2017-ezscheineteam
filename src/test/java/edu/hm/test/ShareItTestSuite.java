package edu.hm.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import edu.hm.shareit.client.MediaClientTest;
import edu.hm.shareit.model.BookTest;
import edu.hm.shareit.model.CopyTest;
import edu.hm.shareit.model.DiscTest;
import edu.hm.shareit.model.MediumTest;
import edu.hm.shareit.resource.*;
import edu.hm.shareit.util.*;

@RunWith(Suite.class)

@Suite.SuiteClasses({
   BookTest.class,
   CopyTest.class,
   DiscTest.class,
   MediumTest.class,
   MediaClientTest.class,
   CopyResourceTest.class,
   MediaResourceTest.class,
   MediumUtilTest.class
})

public class ShareItTestSuite {}
