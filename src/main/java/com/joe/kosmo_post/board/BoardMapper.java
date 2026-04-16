package com.joe.kosmo_post.board;

import java.util.List;

public interface BoardMapper {
	
	//CRUD
	
	
	//R-Read
	//list
	public List<BoardDTO> list()throws Exception;
	
	
	public BoardDTO detail(BoardDTO boardDTO)throws Exception;
	
	//C-Create
	public int create(BoardDTO boardDTO)throws Exception; 
	
	//R-Read
	
	//U-Update
	
	//D-Delete

}
