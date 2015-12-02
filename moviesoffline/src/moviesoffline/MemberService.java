/**
 * 
 */
package moviesoffline;

import java.util.ArrayList;




import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.google.gson.Gson;

import dto.Member;
import model.MemberManager;

/**
 * @author Alexander
 *
 */
@Path("/members")
public class MemberService {
	@GET
	@Path("/list")
	@Produces("application/json")
	public String getAllMemberData() {
		String listMemberData = null;
		Gson gson = new Gson();
		
		ArrayList<Member> listMember = new ArrayList<Member>();
		MemberManager memberManager = new MemberManager();
		
		listMember = memberManager.getAllMember();
		listMemberData = gson.toJson(listMember);
		
		return listMemberData;
	}
	@GET
	@Path("/login/{email}/{password}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getMember(@PathParam("email") String email,
		    @PathParam("password") String password){
		Member member=null;
		Gson gson = new Gson();
		MemberManager memberManager = new MemberManager();
		member =memberManager.getMember(email, password);
		
		return gson.toJson(member);
		
	}
	@GET
	@Path("/member/{user_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getMember(@PathParam("user_id") String user_id){
		Member member=null;
		Gson gson = new Gson();
		MemberManager memberManager = new MemberManager();
		member =memberManager.getMember(user_id);
		
		return gson.toJson(member);
		
	}
	
}
