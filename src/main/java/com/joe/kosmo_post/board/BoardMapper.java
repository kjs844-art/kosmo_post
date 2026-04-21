package com.joe.kosmo_post.board;

import java.util.List;

import com.joe.kosmo_post.file.FileDTO;
import com.joe.kosmo_post.pager.Pager;

public interface BoardMapper {

	public Long getCount(Pager pager) throws Exception;

	public List<BoardDTO> list(Pager pager) throws Exception;

	public BoardDTO detail(BoardDTO boardDTO) throws Exception;

	public int create(BoardDTO boardDTO) throws Exception;

	public int createFile(FileDTO fileDTO) throws Exception;

	public int update(BoardDTO boardDTO) throws Exception;

	public int delete(BoardDTO boardDTO) throws Exception;
}
