//package com.studywithus.controller.member.dto;
//
//import lombok.Data;
//
//import javax.validation.constraints.NotEmpty;
//
//public class MemberDto {
//    @Data
//    public static class CreateMemberResponse {
//        private Long id;
//
//        public CreateMemberResponse(Long id){
//            this.id = id;
//        }
//    }
//
//    @Data
//    public static class CreateMemberRequest {
//        @NotEmpty
//        private String email;
//        @NotEmpty
//        private String nickname;
//        @NotEmpty
//        private String password;
//        @NotEmpty
//        private String bornDate;
//    }
//
//}
