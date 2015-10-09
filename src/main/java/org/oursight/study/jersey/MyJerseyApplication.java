package org.oursight.study.jersey;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("rest")
public class MyJerseyApplication extends ResourceConfig {

	public MyJerseyApplication() {
		packages("org.oursight.study.jersey.services");
	}
}
