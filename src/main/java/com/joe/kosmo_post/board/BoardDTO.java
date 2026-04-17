package com.joe.kosmo_post.board;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardDTO {
	
	private Long boardNum; //게시글 번호
	private String boardTitle; //데이터 타입 string varchar(이니까
	private String boardContent; //
	private String boardWriter; //작성자
	private LocalDateTime boardDate; //작성일자
	private Long boardHit; //조회수

	public void setBoardTitle(String string) {
		this.boardTitle = string;
	}

	public void setBoardWriter(String string) {
		this.boardWriter = string;
	}

	public void setBoardContents(String string) {
		this.boardContent = string;
	}
}	
