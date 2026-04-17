package com.joe.kosmo_post.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joe.kosmo_post.board.BoardDTO;
import com.joe.kosmo_post.board.BoardService;
import com.joe.kosmo_post.pager.Pager;

@Service
public class QnaService implements BoardService {

	@Autowired
	private QnaMapper qnaMapper;

	@Override
	public List<BoardDTO> list(Pager pager) throws Exception {
		pager.makeStartNum();
		return qnaMapper.list(pager);
	}

	@Override
	public BoardDTO detail(BoardDTO boardDTO) throws Exception {
		return qnaMapper.detail(boardDTO);
	}

	@Override
	public int create(BoardDTO boardDTO) throws Exception {
		return qnaMapper.create(boardDTO);
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		return qnaMapper.update(boardDTO);
	}

	@Override
	public int delete(BoardDTO boardDTO) throws Exception {
		return qnaMapper.delete(boardDTO);
	}
}
