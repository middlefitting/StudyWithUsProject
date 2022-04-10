package com.studywithus.web.controller.board.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostAndCommentListDTO {

    private ArrayList<PostDto> postDto;

    private ArrayList<CommentDto> commentsList;

}
