package com.joe.kosmo_post.board;

import java.time.LocalDateTime;
import java.util.List;

import com.joe.kosmo_post.file.FileDTO;

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

	private List<FileDTO> list; //첨부파일 리스트
	
}	
