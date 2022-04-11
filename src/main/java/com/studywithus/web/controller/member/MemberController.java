package com.studywithus.web.controller.member;

import com.studywithus.web.controller.common.SuccessResult;
import com.studywithus.web.controller.member.form.CreateMemberForm;
import com.studywithus.web.controller.member.form.DeleteMemberForm;
import com.studywithus.web.controller.member.form.UpdateMemberForm;
import com.studywithus.web.controller.member.form.UpdateMemberPasswordForm;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;

public interface MemberController {
    SuccessResult joinMember(@RequestBody @Validated CreateMemberForm requestForm, BindingResult bindingResult);

    SuccessResult selectMember(HttpServletRequest request, @PathVariable Long id);

    SuccessResult updateMember(HttpServletRequest request, @PathVariable Long id, @RequestBody @Validated UpdateMemberForm requestForm, BindingResult bindingResult);

    SuccessResult deleteMember(HttpServletRequest request, @PathVariable Long id, @RequestBody @Validated DeleteMemberForm requestForm, BindingResult bindingResult);

    SuccessResult updateMemberPassword(HttpServletRequest request, @PathVariable Long id, @RequestBody @Validated UpdateMemberPasswordForm requestForm, BindingResult bindingResult);

//    SuccessResult selectAllMembers();

}
