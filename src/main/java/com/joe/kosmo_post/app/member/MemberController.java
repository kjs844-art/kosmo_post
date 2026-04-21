package com.joe.kosmo_post.app.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member/*")


public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@GetMapping("join")
	
	
}
