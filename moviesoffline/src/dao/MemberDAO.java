/**
 * 
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.mysql.jdbc.PreparedStatement;

import configuration.DbConfig;
import dto.Member;

public class MemberDAO {
	public Member getMember(DbConfig dbLink,String email,String password){
		Member member=null;
		try {
			String sql = "";			
			dbLink.StartConnection();
								
			sql = "SELECT *"
					+ " FROM member"
					+" WHERE email =? AND password =?";
					
			PreparedStatement ps = (PreparedStatement) dbLink.getDbConnection().prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();			
				rs.next();
				 member = new Member();
				 member.setUser_id(rs.getLong("user_id"));
				 member.setUsername(rs.getString("username"));
				 member.setFirst_name(rs.getString("first_name"));
				 member.setLast_name(rs.getString("last_name"));
				 member.setGender(rs.getString("gender"));
				 member.setEmail(rs.getString("email"));
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbLink.StopConnection();
		}		
		return member;
	}
	public Member getMember(DbConfig dbLink,String user_Id){
		Member member=null;
		try {
			String sql = "";			
			dbLink.StartConnection();
								
			sql = "SELECT * FROM member"
					+" WHERE user_Id =?";
					
			PreparedStatement ps = (PreparedStatement) dbLink.getDbConnection().prepareStatement(sql);
			ps.setString(1, user_Id);						
			ResultSet rs = ps.executeQuery();			
				rs.next();
				 member = new Member();
				 member.setUser_id(rs.getLong("user_id"));
				 member.setUsername(rs.getString("username"));
				 member.setFirst_name(rs.getString("first_name"));
				 member.setLast_name(rs.getString("last_name"));
				 member.setGender(rs.getString("gender"));
				 member.setEmail(rs.getString("email"));
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbLink.StopConnection();
		}		
		return member;
	}
	
	
	public ArrayList<Member> getAllMembers(DbConfig dbLink) {
		ArrayList<Member> memberData = new ArrayList<Member>();
		
		try {
			String sql = "";
			
			// start the connection first
			dbLink.StartConnection();
			
			sql = "SELECT user_id, username, first_name, last_name, gender "
					+ " FROM member ";
			PreparedStatement ps = (PreparedStatement) dbLink.getDbConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Member tmpMember = new Member();
				tmpMember.setUser_id(rs.getLong("user_id"));
				tmpMember.setUsername(rs.getString("username"));
				tmpMember.setFirst_name(rs.getString("first_name"));
				tmpMember.setLast_name(rs.getString("last_name"));
				tmpMember.setGender(rs.getString("gender"));
				
				memberData.add(tmpMember);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbLink.StopConnection();
		}
		
		return memberData;
	}
}
