package webresource;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import models.Member;
import org.glassfish.jersey.client.ClientConfig;
import com.google.gson.Gson;
public class MemberResource {
	WebTarget targetWebservice;
	WebTarget webPath;
	public MemberResource() {	
		URI uri=UriBuilder.fromUri("http://localhost:8080/moviesoffline").build();
		ClientConfig config=new ClientConfig();
		Client client=ClientBuilder.newClient(config);
		targetWebservice=client.target(uri);
		webPath=targetWebservice.path("rest/members");
	}
	public Member getMember(String email,String password){
		Member member=new Member();		
		String jsonString=webPath.path("login").path(email).path(password)
				.request().accept(MediaType.APPLICATION_JSON_TYPE).get(String.class);
		Gson gson=new Gson();
		member= gson.fromJson(jsonString, Member.class);									
		return member;

	}
	public Member getMember(String user_id){
		Member member=new Member();		
		String jsonString=webPath.path("member").path(user_id)
				.request().accept(MediaType.APPLICATION_JSON_TYPE).get(String.class);
		Gson gson=new Gson();
		member= gson.fromJson(jsonString, Member.class);									
		return member;

	} 
}
