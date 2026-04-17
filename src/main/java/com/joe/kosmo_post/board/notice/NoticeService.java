package com.joe.kosmo_post.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joe.kosmo_post.board.BoardDTO;
import com.joe.kosmo_post.board.BoardService;
import com.joe.kosmo_post.pager.Pager;

@Service
public class NoticeService implements BoardService {

    @Autowired
    private NoticeMapper noticeMapper;

    @Override
    public List<BoardDTO> list(Pager pager) throws Exception {
        pager.makeStartNum();
        return noticeMapper.list(pager);
    }

    @Override
    public BoardDTO detail(BoardDTO boardDTO) throws Exception {
        return noticeMapper.detail(boardDTO);
    }

    @Override
    public int create(BoardDTO boardDTO) throws Exception {
        return noticeMapper.create(boardDTO);
    }

    @Override
    public int update(BoardDTO boardDTO) throws Exception {
        return noticeMapper.update(boardDTO);
    }

	@Override
	public int delete(BoardDTO boardDTO) throws Exception {
		return noticeMapper.delete(boardDTO);
	}
}
