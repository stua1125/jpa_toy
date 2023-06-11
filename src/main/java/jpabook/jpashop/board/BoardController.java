package jpabook.jpashop.board;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/board/new")
    public String createBoard() {
        return "create_board"; // 게시글 작성 페이지의 템플릿 이름
    }

    @PostMapping("/board/create")
    public String processCreateBoard(@RequestParam("title") String title, @RequestParam("content") String content, Model model) {
        // 게시글 작성 처리 로직 구현
        BoardItem board = new BoardItem();
        board.setTitle(title);
        board.setContent(content);
        boardItemRepository.save(board);

        List<BoardItem> boardItems = boardItemRepository.findAll();

        // 게시판 목록 페이지로 리다이렉트
        return "redirect:/board";
    }

}
