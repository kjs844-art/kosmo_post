package com.joe.kosmo_post.board.notice;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.joe.kosmo_post.board.BoardDTO;
import com.joe.kosmo_post.pager.Pager;

@SpringBootTest
class NoticeMapperTest {

    @Autowired
    private NoticeMapper noticeMapper;
    
    @Override
    public List<BoardDTO> list(Pager pager) throw Exception {
    	pager.makeStartNum();
    	
    }

//    @Test
//    void testCreate() throws Exception {
//        for(int i=0; i<23; i++) {
//            NoticeDTO noticeDTO = new NoticeDTO();
//            // 여기에 DTO 세팅 코드가 추가될 수 있습니다.
//        }
//    }

    @Test
    void testList() throws Exception {
    	Pager pager = new Pager();
    	pager.setSearch("9");
    	pager.setPage(1L);
    	pager.makeStartNum();
    	pager.setPage(1);
        List<BoardDTO> ar = noticeMapper.list(pager);
        Log.info("{}",ar);
        assertNotEquals(0, ar.size());
    }
}