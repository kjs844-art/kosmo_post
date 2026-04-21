package com.joe.kosmo_post.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.joe.kosmo_post.board.BoardDTO;
import com.joe.kosmo_post.board.BoardService;
import com.joe.kosmo_post.file.FileManager;
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
		return qnaMapper.detail(boardDTO);
	}

	@Override
	public int create(BoardDTO boardDTO, MultipartFile[] attach) throws Exception {
		int result = qnaMapper.create(boardDTO);

		if (attach == null) {
			return result;
		}

		for (MultipartFile f : attach) {
			if (f.isEmpty()) {
				continue;
			}

			String fileName = fileManager.fileSave(name, f);
			QnaFileDTO qnaFileDTO = new QnaFileDTO();
			qnaFileDTO.setBoardNum(boardDTO.getBoardNum());
			qnaFileDTO.setOriName(f.getOriginalFilename());
			qnaFileDTO.setFileName(fileName);

			result = qnaMapper.createFile(qnaFileDTO);
		}

		return result;
	}

	@Override
	public int update(BoardDTO boardDTO, MultipartFile[] attach) throws Exception {
		return qnaMapper.update(boardDTO);
	}

	@Override
	public int delete(BoardDTO boardDTO) throws Exception {
		return 0;
	}
}
