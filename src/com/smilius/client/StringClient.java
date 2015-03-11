package com.smilius.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.Scanner;

public class StringClient {

	public static void main(String args[]) {
		
		String defaultLocalHost = "http://localhost:8080";
		String defaultLocalUrl = "com.smilius.webproj";

		Scanner sc = new Scanner(System.in);
		String string1, string2;
		String address = defaultLocalHost + "/" + defaultLocalUrl;

		System.out.println("Enter string 1: ");
		string1 = sc.nextLine();

		System.out.println("Enter string 2: ");
		string2 = sc.nextLine();

		Form form = new Form();
		form.param("string1", string1);
		form.param("string2", string2);

		
		Client client = ClientBuilder.newClient();
		
		WebTarget target = client.target(address).path("string").path("concatenate")
				.queryParam("string1", string2).queryParam("string2", string2);
		
		Response response = target.request(MediaType.TEXT_PLAIN).get();
		if (response.getStatus() != 200) {
			System.out.println(response.getStatusInfo().getReasonPhrase());
		} else {
			System.out.println(response.readEntity(String.class));
			
		}
				
	}
}
