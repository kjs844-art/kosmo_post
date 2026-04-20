package com.joe.kosmo_post.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.joe.kosmo_post.board.BoardDTO;
import com.joe.kosmo_post.board.BoardService;
import com.joe.kosmo_post.pager.Pager;

@Service
public class NoticeService implements BoardService {
	
	@Autowired
	private NoticeMapper noticeMapper;
	
	@Autowired
	private FileManager fileManager;
	
	@Value("${app.board.notice}")
	private String name;
	

	@Override
	public List<BoardDTO> list(Pager pager) throws Exception {
		
		pager.makePageNum(noticeMapper.getCount(pager));
		pager.makeStartNum();
		
		return noticeMapper.list(pager);
	}

	@Override
	public BoardDTO detail(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return noticeMapper.detail(boardDTO);
	}

	@Override
	public int create(BoardDTO boardDTO, MultipartFile [] attach) throws Exception {
		// 1. 게시판 테이블에 글을 추가
		int result = noticeMapper.create(boardDTO);
		
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
			
			result = noticeMapper.createFile(noticeFileDTO);
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