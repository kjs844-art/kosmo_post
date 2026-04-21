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

	private Long boardNum;
	private String boardTitle;
	private String boardWriter;
	private String boardContents;
	private LocalDateTime boardDate;
	private Long boardHit;
	private List<FileDTO> list;
}
