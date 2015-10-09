package org.oursight.study.jersey.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/hello")
public class HelloJersey {

	@GET
	public String sayHello() {
		return "Hello Jersey";
	}
	
	@GET
	@Path("/{name}")
	public String sayHello(@PathParam("name") String name) {
		return "Hello Jersey to " + name;
	}
}
