package jpabook.jpashop;

import jpabook.jpashop.board.BoardItem;
import jpabook.jpashop.board.BoardItemRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.List;

@DataJpaTest
public class BoardRepositoryTest {

    @Autowired
    BoardItemRepository boardItemRepository;

    @Test
    public void testFindAll() {
        // 테스트용 게시판 데이터 추가
        BoardItem item1 = new BoardItem();
        item1.setTitle("Title 1");
        item1.setContent("Content 1");
        boardItemRepository.save(item1);

        BoardItem item2 = new BoardItem();
        item2.setTitle("Title 2");
        item2.setContent("Content 2");
        boardItemRepository.save(item2);

        // findAll() 메소드를 테스트
        List<BoardItem> boardItems = boardItemRepository.findAll();

        // 결과 확인
        Assertions.assertEquals(2, boardItems.size());
        Assertions.assertEquals("Title 1", boardItems.get(0).getTitle());
        Assertions.assertEquals("Content 1", boardItems.get(0).getContent());
        Assertions.assertEquals("Title 2", boardItems.get(1).getTitle());
        Assertions.assertEquals("Content 2", boardItems.get(1).getContent());

    }
}
