package jpabook.jpashop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BoardController {

    private final BoardItemRepository boardItemRepository;

    public BoardController(BoardItemRepository boardItemRepository) {
        this.boardItemRepository = boardItemRepository;
    }

    @GetMapping("board")
    public String getBoard(Model model) {

        List<BoardItem> boardItems = boardItemRepository.findAll();
        model.addAttribute("boardItems", boardItems);


        return "board";
    }
}
