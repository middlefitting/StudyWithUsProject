package com.studywithus.web.controller.study.studyboard;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.studywithus.config.jwt.JwtProperties;
import com.studywithus.domain.entity.study.Study;
import com.studywithus.domain.entity.study.StudyBoard;
import com.studywithus.domain.entity.study.StudyBoardCategory;
import com.studywithus.domain.repository.study.studyboard.dto.StudyBoardDto;
import com.studywithus.domain.repository.study.studyboard.dto.StudyBoardPageSearchCondition;
import com.studywithus.domain.repository.study.studyboard.dto.StudyBoardSingleDto;
import com.studywithus.domain.service.study.study.dto.CreateStudyDto;
import com.studywithus.domain.service.study.study.dto.UpdateStudyDto;
import com.studywithus.domain.service.study.studyboard.StudyBoardService;
import com.studywithus.domain.service.study.studyboard.dto.CreateStudyBoardDto;
import com.studywithus.domain.service.study.studyboard.dto.UpdateStudyBoardDto;
import com.studywithus.web.controller.common.SuccessResult;
import com.studywithus.web.controller.study.study.dto.GetStudyResponseDto;
import com.studywithus.web.controller.study.study.form.CreateStudyForm;
import com.studywithus.web.controller.study.study.form.UpdateStudyForm;
import com.studywithus.web.controller.study.studyboard.dto.GetStudyBoardResponseDto;
import com.studywithus.web.controller.study.studyboard.form.CreateStudyBoardForm;
import com.studywithus.web.controller.study.studyboard.form.UpdateStudyBoardForm;
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
public class StudyBoardControllerImpl implements StudyBoardController{

    private final StudyBoardService studyBoardService;


    @GetMapping("/studies/{studyId}/studyBoards/{studyBoardCategory}")
    public SuccessResult selectStudyBoards(HttpServletRequest request, @PageableDefault(size = 10, page = 0, sort = "regDate", direction = Sort.Direction.DESC) Pageable pageable,
                                           StudyBoardPageSearchCondition condition, @PathVariable Long studyId, @PathVariable  String studyBoardCategory){
        String jwtToken = request.getHeader("Authorization").replace("Bearer ","");
        DecodedJWT verify = JWT.require(Algorithm.HMAC512(JwtProperties.SECRET)).build().verify(jwtToken);

        condition.setStudyId(studyId);
        condition.setStudyBoardCategory(studyBoardCategory);
        Page<StudyBoardDto> pageResults = studyBoardService.selectStudyBoardPage(pageable, condition);
        return new SuccessResult(pageResults, "페이지 정보 반환 완료", "success");
    }


    @PostMapping("/studies/{studyId}/studyBoards")
    public SuccessResult createStudyBoard(HttpServletRequest request, @RequestBody @Validated CreateStudyBoardForm requestForm, BindingResult bindingResult, @PathVariable Long studyId){
        String jwtToken = request.getHeader("Authorization").replace("Bearer ","");
        DecodedJWT verify = JWT.require(Algorithm.HMAC512(JwtProperties.SECRET)).build().verify(jwtToken);
        Long verifyId = verify.getClaim("id").asLong();

        if (bindingResult.hasErrors()) {
            log.info("errors={} ", bindingResult);
            throw new IllegalArgumentException("입력 값이 잘못되었습니다!");
        }

        if(!requestForm.getStudyBoardCategory().equals("notice") && !requestForm.getStudyBoardCategory().equals("study") && !requestForm.getStudyBoardCategory().equals("free")){
            throw new IllegalArgumentException("카테고리 값이 잘못되었습니다!");
        }

        CreateStudyBoardDto requestDto = new CreateStudyBoardDto(verifyId, studyId, requestForm.getTitle(), requestForm.getContent(), StudyBoardCategory.valueOf(requestForm.getStudyBoardCategory()));


        Long StudyBoardId = studyBoardService.createStudyBoard(requestDto);
        if (StudyBoardId.equals(0L)){
            throw new IllegalArgumentException("게시물을 생성할 수 없습니다");
        }

        return new SuccessResult("", "게시물 생성 완료", "success");
    }


    @GetMapping("/studies/{studyId}/studyBoard/{studyBoardId}")
    public SuccessResult getStudyBoardSingle(HttpServletRequest request, @PathVariable Long studyId, @PathVariable Long studyBoardId){
        String jwtToken = request.getHeader("Authorization").replace("Bearer ","");
        DecodedJWT verify = JWT.require(Algorithm.HMAC512(JwtProperties.SECRET)).build().verify(jwtToken);
        Long verifyId = verify.getClaim("id").asLong();

        Optional<StudyBoardSingleDto> studyBoard = studyBoardService.selectStudyBoard(studyBoardId);
        if(studyBoard.orElseGet(() -> null)!=null){
            return new SuccessResult(studyBoard.get(), "게시물 조회 완료", "success");
        }
        throw new RuntimeException();
    }


    @PutMapping("/studies/{studyId}/studyBoard/{studyBoardId}")
    public SuccessResult updateStudyBoard(HttpServletRequest request, @PathVariable Long studyId, @RequestBody @Validated UpdateStudyBoardForm requestForm, BindingResult bindingResult, @PathVariable Long studyBoardId){
        String jwtToken = request.getHeader("Authorization").replace("Bearer ","");
        DecodedJWT verify = JWT.require(Algorithm.HMAC512(JwtProperties.SECRET)).build().verify(jwtToken);
        Long verifyId = verify.getClaim("id").asLong();

        if (bindingResult.hasErrors()) {
            log.info("errors={} ", bindingResult);
            throw new IllegalArgumentException("입력 값이 잘못되었습니다!");
        }

        if(!requestForm.getStudyBoardCategory().equals("notice") && !requestForm.getStudyBoardCategory().equals("study") && !requestForm.getStudyBoardCategory().equals("free")){
            throw new IllegalArgumentException("카테고리 값이 잘못되었습니다!");
        }

        UpdateStudyBoardDto requestDto = new UpdateStudyBoardDto(studyBoardId, verifyId, requestForm.getTitle(), requestForm.getContent(), StudyBoardCategory.valueOf(requestForm.getStudyBoardCategory()));

        Long StudyBoardId = studyBoardService.updateStudyBoard(requestDto);
        if (StudyBoardId.equals(0L)){
            throw new IllegalArgumentException("게시물을 수정할 수 없습니다");
        }

        return new SuccessResult("", "게시물 수정 완료", "success");
    }


    @DeleteMapping("/studies/{studyId}/studyBoard/{studyBoardId}")
    public SuccessResult deleteStudy(HttpServletRequest request, @PathVariable Long studyId, @PathVariable Long studyBoardId){
        String jwtToken = request.getHeader("Authorization").replace("Bearer ","");
        DecodedJWT verify = JWT.require(Algorithm.HMAC512(JwtProperties.SECRET)).build().verify(jwtToken);
        Long verifyId = verify.getClaim("id").asLong();

        Long result = studyBoardService.deleteStudyBoard(verifyId, studyBoardId);
        if(result.equals(0L)){
            throw new IllegalArgumentException("게시물을 삭제할 수 없습니다");
        }
        return new SuccessResult("", "스터디 삭제 완료", "success");
    }

}
