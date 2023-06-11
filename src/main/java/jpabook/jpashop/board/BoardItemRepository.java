package jpabook.jpashop.board;

import jpabook.jpashop.board.BoardItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BoardItemRepository extends JpaRepository<BoardItem, Long> {

}
