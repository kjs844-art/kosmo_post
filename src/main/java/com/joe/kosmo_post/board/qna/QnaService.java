package com.joe.kosmo_post.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.joe.kosmo_post.board.BoardDTO;
import com.joe.kosmo_post.board.BoardService;
import com.joe.kosmo_post.board.notice.NoticeFileDTO;
import com.joe.kosmo_post.pager.Pager;

@Service
public class QnaService implements BoardService {

	@Autowired
	private QnaMapper qnaMapper;
	
	@Autowired
	private FileManager fileManager;
	
	@Value("${app.board.qna}")
	private String name;
	

	@Override
	public List<BoardDTO> list(Pager pager) throws Exception {
		pager.makePageNum(qnaMapper.getCount(pager));
		pager.makeStartNum();
		return qnaMapper.list(pager);
	}

	@Override
	public BoardDTO detail(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaMapper.detail(boardDTO);
	}

	@Override
	public int create(BoardDTO boardDTO, MultipartFile[] attach) throws Exception {
		// 1. 게시판 테이블에 글을 추가
		int result = qnaMapper.create(boardDTO);
		
		if(attach==null) {
			return result;
		}
		
		// 2. 파일을 HDD에저장
		for(MultipartFile f: attach) {
			if(f.isEmpty()) {
				continue;
			}
			
			String fileName = fileManager.fileSave(name, f);
			// 3. 파일의 정보들을 DB에 저장
			NoticeFileDTO noticeFileDTO = new NoticeFileDTO();
			noticeFileDTO.setBoardNum(boardDTO.getBoardNum());
			noticeFileDTO.setOriName(f.getOriginalFilename());
			noticeFileDTO.setFileName(fileName);
			
			result = qnaMapper.createFile(noticeFileDTO);
		}
		
		return result;
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}