package edu.hm.test;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import edu.hm.shareit.client.MediaClientTest;
import edu.hm.shareit.model.BookTest;
import edu.hm.shareit.model.CopyTest;
import edu.hm.shareit.model.DiscTest;
import edu.hm.shareit.model.MediumTest;
import edu.hm.shareit.resource.CopyResourceTest;
import edu.hm.shareit.resource.MediaResourceTest;
import edu.hm.shareit.util.MediumUtilTest;

@RunWith(Suite.class)

@Suite.SuiteClasses({ BookTest.class, CopyTest.class, DiscTest.class, MediumTest.class, MediaClientTest.class,
		CopyResourceTest.class, MediaResourceTest.class, MediumUtilTest.class })

public class ShareItTestSuite {

	public static final String APP_URL = "/";
	public static final int PORT = 8080;
	public static final String WEBAPP_DIR = "./src/main/webapp/";
	public static Server jetty;

	@BeforeClass
	public static void setUp() {
		jetty = new Server(PORT);

		jetty.setHandler(new WebAppContext(WEBAPP_DIR, APP_URL));
		try {
			jetty.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterClass
        public static void tearDown() {
			try {
				jetty.stop();
			} catch (Exception e) {
				e.printStackTrace();
			}
        }

}
