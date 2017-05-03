package edu.hm;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 * Start the application without an AppServer like tomcat.
 * @author ab@cs.hm.edu
 *
 */
public final class JettyStarter {

    public static final String APP_URL = "/";
    public static final int PORT = 8080;
    public static final String WEBAPP_DIR = "./src/main/webapp/";

    /**
     * Can't be created.
     */
    private JettyStarter() { }

    /**
     * Creates a new jetty server instance.
     * @param args - the program arguments.
     * @throws Exception thrown if server failed to start.
     */
    public static void main(String... args) throws Exception {
        Server jetty = new Server(PORT);

        jetty.setHandler(new WebAppContext(WEBAPP_DIR, APP_URL));
        jetty.start();
        System.out.println("Jetty listening on port " + PORT);
        jetty.join();
    }
}
