package com.joe.kosmo_post.board.qna;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.joe.kosmo_post.board.BoardDTO;


@SpringBootTest
class QnaMapperTest {
	@Autowired
	private QnaMapper qnaMapper;
	
	@Test
    void testCreate() throws Exception {
        for(int i=0; i<100; i++) {
            BoardDTO boardDTO = new BoardDTO();
            boardDTO.setBoardTitle("테스트 제목 " + i);
            boardDTO.setBoardWriter("작성자 " + i);
            boardDTO.setBoardContents("내용 " + i);
            
            qnaMapper.add(boardDTO);
        }
    }

    @Test
    void testList() throws Exception {
        List<BoardDTO> ar = qnaMapper.list();
        assertNotEquals(0, ar.size());
    }
}

		// 여기에 이제 for문 코드를 적으시면 됩니다.

	
	

	
	


