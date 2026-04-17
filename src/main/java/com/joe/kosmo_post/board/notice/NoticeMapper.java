package com.joe.kosmo_post.board.notice;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.joe.kosmo_post.board.BoardDTO;
import com.joe.kosmo_post.pager.Pager;

@Mapper
public interface NoticeMapper {

    public List<BoardDTO> list(Pager pager) throws Exception;

    public BoardDTO detail(BoardDTO boardDTO) throws Exception;

    public int create(BoardDTO boardDTO) throws Exception;

    public int update(BoardDTO boardDTO) throws Exception;

    public int delete(BoardDTO boardDTO) throws Exception;
}
