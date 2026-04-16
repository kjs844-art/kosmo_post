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
	
	//접근지정자 private : 클래스 내부에서만 접근 가능
	
	//Java 8byte long 들어가는것 롱
	
	
	
}	
	
//DTO 만드는 규칙
	//테이블 만드는것과 동일하게 

