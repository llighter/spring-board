package com.llighter.springboard.controller;

import com.llighter.springboard.domain.Article;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@RequestMapping("/articles")
@Controller
public class ArticleController {

    @GetMapping
    public String articles(ModelMap map) {
        map.addAttribute("articles", List.of());
        return "articles/index";
    }

    @GetMapping("/{article_id}")
    public String article(@PathVariable Long article_id, ModelMap map) {
        map.addAttribute("article", Article.of(null,"제목", "내용", "해시태그")); // TODO: 실제 데이터로 대체
        map.addAttribute("articleComments", List.of());
        return "articles/detail";
    }
}
