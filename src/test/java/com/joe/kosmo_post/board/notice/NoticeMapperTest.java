package com.joe.kosmo_post.board.notice;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.joe.kosmo_post.board.BoardDTO;

@SpringBootTest
class NoticeMapperTest {

    @Autowired
    private NoticeMapper noticeMapper;

    @Test
    void testCreate() throws Exception {
        for(int i=0; i<23; i++) {
            NoticeDTO noticeDTO = new NoticeDTO();
            // 여기에 DTO 세팅 코드가 추가될 수 있습니다.
        }
    }

    @Test
    void testList() throws Exception {
        List<BoardDTO> ar = noticeMapper.list();
        assertNotEquals(0, ar.size());
    }
}