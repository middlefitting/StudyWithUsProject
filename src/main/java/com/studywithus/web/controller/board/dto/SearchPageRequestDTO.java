package com.studywithus.web.controller.board.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


@Builder
@AllArgsConstructor
@Data
public class SearchPageRequestDTO {
    private int page = 1;
    private int size = 10;
    private String type;
    private String keyword;

    public SearchPageRequestDTO() {}

    public Pageable getPageable(Sort sort) {
        return PageRequest.of(page -1, size, sort);
    }
}
