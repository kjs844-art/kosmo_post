package com.joe.kosmo_post.app.member;

import org.apache.ibatis.annotations.Mapper;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Mapper
public interface MemberMapper {

	
	public int insertMember(MemberDTO memberDTO);
	
	public int insertProfile(ProfileDTO profileDTO);
}
