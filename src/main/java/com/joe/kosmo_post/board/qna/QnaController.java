package com.joe.kosmo_post.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.joe.kosmo_post.board.BoardDTO;
import com.joe.kosmo_post.pager.Pager;

@Controller
@RequestMapping("/qna/*")
public class QnaController { 
	
	@Autowired
	private QnaService qnaService;
	
	@GetMapping("list")
	public String list(Pager pager, Model model) throws Exception{
		List<BoardDTO> ar = qnaService.list(pager);
		model.addAttribute("list", ar);
		return "Board/list";
	}
}
