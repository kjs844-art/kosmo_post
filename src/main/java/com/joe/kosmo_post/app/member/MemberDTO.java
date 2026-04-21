package com.joe.kosmo_post.app.member;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class MemberDTO {
	
	private String username;
	private String name;
	private String password;
	private String email;
	private String phone;
	private String date;
	
	private ProfileDTO profileDTO;
	

}
