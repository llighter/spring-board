package com.llighter.springboard.controller;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

;

//@Disabled("Spring Data REST 통합테스트는 불핑요하므로 비활성화")
@DisplayName("Data REST - API 테스트")
@Transactional
@AutoConfigureMockMvc
@SpringBootTest
public class DataRestTest {

    private final MockMvc mvc;

    public DataRestTest(@Autowired MockMvc mockMvc) {
        this.mvc = mockMvc;
    }

    @DisplayName(("[api] 게시글 리스트 조회"))
    @Test
    void givenNothing_whenRequestingArticles_thenReturnArticlesJsonResponse() throws Exception {
        // Given

        // When & Then
        mvc.perform(get("/api/articles"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.valueOf("application/hal+json")));
    }

    @DisplayName(("[api] 게시글 단건 조회"))
    @Test
    void givenNothing_whenRequestingArticle_thenReturnArticleJsonResponse() throws Exception {
        // Given

        // When & Then
        mvc.perform(get("/api/articles/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.valueOf("application/hal+json")));
    }

    @DisplayName(("[api] 게시글 -> 댓글 리스트 조회"))
    @Test
    void givenNothing_whenRequestingArticleCommentsFromArticle_thenReturnArticleCommentsJsonResponse() throws Exception {
        // Given

        // When & Then
        mvc.perform(get("/api/articles/1/articleComments"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.valueOf("application/hal+json")));
    }

    @DisplayName(("[api] 댓글 리스트 조회"))
    @Test
    void givenNothing_whenRequestingArticleComments_thenReturnArticleCommentsJsonResponse() throws Exception {
        // Given

        // When & Then
        mvc.perform(get("/api/articleComments"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.valueOf("application/hal+json")));
    }

    @DisplayName(("[api] 댓글 단 건 조회"))
    @Test
    void givenNothing_whenRequestingArticleComment_thenReturnArticleCommentJsonResponse() throws Exception {
        // Given

        // When & Then
        mvc.perform(get("/api/articleComments/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.valueOf("application/hal+json")));
    }

    @DisplayName(("[api] 회원 관련 API 는 일체 제공하지 않는다."))
    @Test
    void givenNothing_whenRequestingUserAccounts_thenThrowsException() throws Exception {
        // Given

        // When & Then
        mvc.perform(get("/api/userAccounts"))
                .andExpect(status().isNotFound());
        mvc.perform(post("/api/userAccounts"))
                .andExpect(status().isForbidden()); // TODO: 왜 404가 아니라 403이 나오는지 확인 필요
        mvc.perform(put("/api/userAccounts/1"))
                .andExpect(status().isForbidden());
        mvc.perform(patch("/api/userAccounts/1"))
                .andExpect(status().isForbidden());
        mvc.perform(delete("/api/userAccounts/1"))
                .andExpect(status().isForbidden());
        mvc.perform(head("/api/userAccounts"))
                .andExpect(status().isNotFound());
    }


}
