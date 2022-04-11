package com.studywithus.controller;

import com.studywithus.domain.entity.board.Post;
import com.studywithus.service.board.PostService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/board")
public class HomeController {
    public HomeController(PostService postService) {
        this.postService = postService;
    }

    private final PostService postService;

    @GetMapping({"", "/"})
    public String board(@RequestParam(value="idx", defaultValue = "0") Long post_id,
                        Model model) {
        model.addAttribute("board", postService.findPostById(post_id));
        return "/board/form";
    }

    @GetMapping("/list")
    public String list(@PageableDefault Pageable pageable, Model model) {
        Page<Post> boardList = postService.findPostList(pageable);
        boardList.stream().forEach(e -> e.getContent());
        model.addAttribute("boardList", boardList);

        return "/board/list";
    }
}
