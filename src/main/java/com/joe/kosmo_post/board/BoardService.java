package com.joe.kosmo_post.board;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.joe.kosmo_post.pager.Pager;

public interface BoardService {

	public List<BoardDTO> list(Pager pager) throws Exception;

	public BoardDTO detail(BoardDTO boardDTO) throws Exception;

	public int create(BoardDTO boardDTO, MultipartFile[] attach) throws Exception;

	public int update(BoardDTO boardDTO, MultipartFile[] attach) throws Exception;

	public int delete(BoardDTO boardDTO) throws Exception;
}
