package com.joe.kosmo_post.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.joe.kosmo_post.board.BoardDTO;
import com.joe.kosmo_post.board.BoardService;
import com.joe.kosmo_post.file.FileDTO;
import com.joe.kosmo_post.file.FileManager;
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
		return noticeMapper.detail(boardDTO);
	}

	@Override
	public int create(BoardDTO boardDTO, MultipartFile[] attach) throws Exception {
		int result = noticeMapper.create(boardDTO);

		if (attach == null) {
			return result;
		}

		for (MultipartFile f : attach) {
			if (f.isEmpty()) {
				continue;
			}

			String fileName = fileManager.fileSave(name, f);
			NoticeFileDTO noticeFileDTO = new NoticeFileDTO();
			noticeFileDTO.setBoardNum(boardDTO.getBoardNum());
			noticeFileDTO.setOriName(f.getOriginalFilename());
			noticeFileDTO.setFileName(fileName);

			result = noticeMapper.createFile(noticeFileDTO);
		}

		return result;
	}

	@Override
	public int update(BoardDTO boardDTO, MultipartFile[] attach) throws Exception {
		return noticeMapper.update(boardDTO);
	}

	@Override
	public int delete(BoardDTO boardDTO) throws Exception {
		boardDTO = noticeMapper.detail(boardDTO);

		if (boardDTO.getList() != null) {
			for (FileDTO fileDTO : boardDTO.getList()) {
				fileManager.fileDelete(name, fileDTO);
			}
		}

		return noticeMapper.delete(boardDTO);
	}
}
