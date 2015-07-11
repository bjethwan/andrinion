package com.andrinion.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

@Path("android")
public class DevicePushSubscription {

	@Path("test")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String test() {
		return "Jersey started working....hurray";
	}
	
	@Path("jsonTest")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response jsonTest(){
		SampleBean bean = new SampleBean();
		bean.setName("Bipin Jethwani");
		bean.setAge(33);
		bean.setGender('M');
		return Response.ok(bean).build();
	}
}
