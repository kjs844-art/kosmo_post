package com.joe.kosmo_post.board.notice;

import com.joe.kosmo_post.file.FileDTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class NoticeFileDTO extends FileDTO {

	private Long boardNum;
}
