//package com.niray.controller;
//
//import com.niray.model.UserEntity;
//import com.niray.service.MemberService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.servlet.ModelAndView;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@Controller
//@RequestMapping("/member")
//public class UserDaoController extends BaseMultiController {
//
//    @Autowired
//    private MemberService memberService;
//
//    public void setMemberService(MemberService memberService) {
//        this.memberService = memberService;
//    }
//
//    public UserDaoController(){}
//
//    @RequestMapping("/member/create")
//    @ResponseBody
//    public ModelAndView create(@RequestParam(value = "nickname", defaultValue = "") String nickname,
//                               @RequestParam(value = "password", defaultValue = "") String password) {
//        Map<String, Object> map = new HashMap<>();
//        UserEntity member = new UserEntity();
//        member.setId(1);
//        member.setNickname("guoxiaoming");
//        memberService.add(member);
//        return toView("add", map);
//    }
//
//    @RequestMapping("/member/search")
//    @ResponseBody
//    public Object searchUser(@RequestParam(value = "user_id", defaultValue = "") String user_id) {
//        return memberService.get(user_id);
//    }
//
////    @RequestMapping("/member/update")
////    @ResponseBody
////    public Object renameUser(@RequestParam(value = "nickname", defaultValue = "") String nickname,
////                             @RequestParam(value = "password", defaultValue = "") String password) {
////        return memberService.update(new UserEntity());
////    }
//
//    @RequestMapping("/member/delete")
//    @ResponseBody
//    public Object deleteUser(@RequestParam(value = "user_id", defaultValue = "") String user_id) {
//        memberService.delete(user_id);
//        return "deleted";
//    }
//
//}