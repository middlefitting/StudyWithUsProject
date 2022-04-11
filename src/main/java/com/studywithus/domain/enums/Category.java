package com.studywithus.domain.enums;

public enum Category {
    notice("공지사항"),
    free("자유게시판"),
    question("질문게시판"),
    level_up("등업게시판");

    private final String type;

    Category(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
