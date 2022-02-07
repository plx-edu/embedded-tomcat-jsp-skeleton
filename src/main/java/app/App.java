package app;

import java.io.File;

import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {
	// REMINDER: update .getLogger(this.class)
	private static Class<App> self = App.class;
	private static final Logger logger = LoggerFactory.getLogger(self);

	// Set port number here
	private static final int port = 5045;

	public static void main(String[] args) {
		try {
			// Add Project Name (or remove)
			logger.info("::: Starting Tomcat Server (Embedded Demo)");

			tomcatStart();
		} catch (Exception e) {
			logger.error("### Application failed to run" + e);
			// e.printStackTrace();
		}
	}// main()

	private static void tomcatStart() throws Exception {

		String webappDirLocation = "src/main/webapp";
		new File("./" + webappDirLocation).mkdirs(); // Creating directories to be used in jar

		// Creating and setting up Tomcat server
		Tomcat tomcat = new Tomcat();
		tomcat.setBaseDir("temp");
		tomcat.setPort(port);

		// Define a web application context
		// StandardContext context = (StandardContext) tomcat.addWebapp("",
		// self.getResource("/").getPath());
		StandardContext context = (StandardContext) tomcat.addWebapp("", new File(webappDirLocation).getAbsolutePath());

		// Declare an alternative location for your "WEB-INF/classes" dir
		// Servlet 3.0 annotation will work
		File webInfClasses = new File("target/classes");
		WebResourceRoot resources = new StandardRoot(context);
		resources
				.addPreResources(new DirResourceSet(resources, "/WEB-INF/classes", webInfClasses.getAbsolutePath(), "/"));
		context.setResources(resources);

		tomcat.enableNaming();

		// Start Tomcat process and wait for requests
		tomcat.getConnector();
		tomcat.start();
		logger.info("::: Tomcat Server is Live at port: " + port);
		tomcat.getServer().await();
	}// tomcatStart()

}// - App