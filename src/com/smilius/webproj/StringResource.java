package com.smilius.webproj;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/string/concatenate")
public class StringResource {

	public String wisdom = "And once again I am I will not say alone, no, that's not like me, but, how shall I say, I don't know, restored to myself, no, I never left myself, free, yes, I don't know what that means but it's the word I mean to use, free to do what, to do nothing, to know, but what, the laws of the mind perhaps, of my mind, that for example water rises in proportion as it drowns you and that you would do better, at least no worse, to obliterate texts than to blacken margins, to fill in the holes of words till all is blank and flat and the whole ghastly business looks like what is, senseless, speechless, issueless misery.";

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_HTML)
	public String concatStringfromWebpage(
			@FormParam("string1") String string1, 
			@FormParam("string2") String string2) {
		
		String message;
		String sb = new StringBuilder(string1).append(string2).toString();
		
		if(! sb.isEmpty()){
			message = sb.toString();
		} else {
			message = wisdom;
		}
	    return "<html> " + "<title>" + "Two Strings Made One" + "</title>"
        + "<body><h1>" + message + "</body></h1>" + "</html> ";
	}
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String Enlighten() {
		
		return "<html> " + "<title>" + "Two Strings Made One" + "</title>"
        + "<body><h1>" + wisdom + "</body></h1>" + "</html> ";
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response concatStringfromClient(
			@QueryParam("string1") String string1, 
			@QueryParam("string2") String string2) {
		
		String message;
		String sb = new StringBuilder(string1).append(string2).toString();
		
		if(! sb.isEmpty()){
			message = sb.toString();
		} else {
			message = wisdom;
		}
	    return Response
	    		.status(200)
	    		.entity(message).build();
	}
}