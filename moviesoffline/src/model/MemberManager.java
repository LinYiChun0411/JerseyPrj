package model;

import java.util.ArrayList;

import configuration.DbConfig;
import dao.MemberDAO;
import dto.Member;

public class MemberManager {
	public ArrayList<Member> getAllMember() {
		ArrayList<Member> listMember = new ArrayList<Member>();
		DbConfig dbLink;
		try {
			dbLink = new DbConfig();
			
			MemberDAO memberAccessObject = new MemberDAO();
			listMember = memberAccessObject.getAllMembers(dbLink);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listMember;
	}
	
	public Member getMember(String email,String password) {	
		DbConfig dbLink;
		Member member=null;
		try {
			dbLink = new DbConfig();			
			MemberDAO memberAccessObject = new MemberDAO();
			member = memberAccessObject.getMember(dbLink, email, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return member;
	}
	public Member getMember(String user_id) {	
		DbConfig dbLink;
		Member member=null;
		try {
			dbLink = new DbConfig();			
			MemberDAO memberAccessObject = new MemberDAO();
			member = memberAccessObject.getMember(dbLink,user_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return member;
	}
}
