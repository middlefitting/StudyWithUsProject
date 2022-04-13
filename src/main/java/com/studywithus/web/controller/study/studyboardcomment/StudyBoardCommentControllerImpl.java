package com.studywithus.web.controller.study.studyboardcomment;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.studywithus.config.jwt.JwtProperties;
import com.studywithus.domain.entity.study.StudyBoardCategory;
import com.studywithus.domain.entity.study.StudyBoardComment;
import com.studywithus.domain.repository.study.studyboard.dto.StudyBoardPageSearchCondition;
import com.studywithus.domain.repository.study.studyboard.dto.StudyBoardSingleDto;
import com.studywithus.domain.repository.study.studyboardcomment.dto.StudyBoardCommentDto;
import com.studywithus.domain.service.study.studyboard.dto.CreateStudyBoardDto;
import com.studywithus.domain.service.study.studyboardcomment.StudyBoardCommentService;
import com.studywithus.domain.service.study.studyboardcomment.dto.CreateStudyBoardCommentDto;
import com.studywithus.web.controller.common.SuccessResult;
import com.studywithus.web.controller.study.studyboard.form.CreateStudyBoardForm;
import com.studywithus.web.controller.study.studyboardcomment.dto.StudyBoardCommentSingleDto;
import com.studywithus.web.controller.study.studyboardcomment.form.CreateStudyBoardCommentForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
public class StudyBoardCommentControllerImpl implements StudyBoardCommentController{

    private final StudyBoardCommentService studyBoardCommentService;

    @GetMapping("/studies/{studyId}/studyBoard/{studyBoardId}/studyBoardComments")
    public SuccessResult selectStudyBoards(HttpServletRequest request, @PageableDefault(size = 10, page = 0, sort = "regDate", direction = Sort.Direction.ASC) Pageable pageable,
                                           @PathVariable Long studyId, @PathVariable  Long studyBoardId){
        String jwtToken = request.getHeader("Authorization").replace("Bearer ","");
        DecodedJWT verify = JWT.require(Algorithm.HMAC512(JwtProperties.SECRET)).build().verify(jwtToken);

        Page<StudyBoardCommentDto> pageResults = studyBoardCommentService.selectStudyBoardComments(pageable, studyBoardId);
        return new SuccessResult(pageResults, "댓글 정보 반환 완료", "success");
    }


    @PostMapping("/studies/{studyId}/studyBoards/{studyBoardId}/studyBoardComments")
    public SuccessResult createStudyBoardComment(HttpServletRequest request, @RequestBody @Validated CreateStudyBoardCommentForm requestForm,
                                                 BindingResult bindingResult, @PathVariable Long studyId, @PathVariable Long studyBoardId){
        String jwtToken = request.getHeader("Authorization").replace("Bearer ","");
        DecodedJWT verify = JWT.require(Algorithm.HMAC512(JwtProperties.SECRET)).build().verify(jwtToken);
        Long verifyId = verify.getClaim("id").asLong();

        if (bindingResult.hasErrors()) {
            log.info("errors={} ", bindingResult);
            throw new IllegalArgumentException("입력 값이 잘못되었습니다!");
        }

        CreateStudyBoardCommentDto requestDto = new CreateStudyBoardCommentDto(verifyId, studyId, studyBoardId, requestForm.getContent());


        Long StudyBoardCommentId = studyBoardCommentService.createStudyBoardComments(requestDto);
        if (StudyBoardCommentId.equals(0L)){
            throw new IllegalArgumentException("댓글을 생성할 수 없습니다");
        }

        return new SuccessResult("", "댓글 생성 완료", "success");
    }


    @GetMapping("/studies/{studyId}/studyBoard/{studyBoardId}/studyBoardComments/{studyBoardCommentId}")
    public SuccessResult getStudyBoardSingle(HttpServletRequest request, @PathVariable Long studyId, @PathVariable Long studyBoardId, @PathVariable Long studyBoardCommentId){
        String jwtToken = request.getHeader("Authorization").replace("Bearer ","");
        DecodedJWT verify = JWT.require(Algorithm.HMAC512(JwtProperties.SECRET)).build().verify(jwtToken);
        Long verifyId = verify.getClaim("id").asLong();

        Optional<StudyBoardComment> studyBoardCommentOptional = studyBoardCommentService.selectStudyBoardCommentSingle(verifyId, studyBoardCommentId);
        if(studyBoardCommentOptional.orElseGet(() -> null)!=null){
            StudyBoardComment studyBoardComment = studyBoardCommentOptional.get();
            StudyBoardCommentSingleDto studyBoardCommentSingleDto = StudyBoardCommentSingleDto.builder()
                    .studyBoardCommentId(studyBoardComment.getId())
                    .studyBoardId(studyBoardComment.getStudyBoard().getId())
                    .memberId(studyBoardComment.getMember().getId())
                    .nickname(studyBoardComment.getMember().getNickname())
                    .content(studyBoardComment.getContent())
                    .studyBoardCommentRecommendCount(studyBoardComment.getStudyBoardCommentRecommendCount())
                    .studyBoardCommentReportCount(studyBoardComment.getStudyBoardCommentReportCount())
                    .build();
            return new SuccessResult(studyBoardCommentSingleDto, "게시물 조회 완료", "success");
        }
        throw new RuntimeException();
    }










}
