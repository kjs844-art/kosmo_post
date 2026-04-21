package com.joe.kosmo_post.board.qna;

import com.joe.kosmo_post.board.BoardDTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class QnaDTO extends BoardDTO {

	private Long boardRef;
	private Long boardStep;
	private Long boardDepth;
}
