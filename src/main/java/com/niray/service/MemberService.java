//package com.niray.service;
//
//import com.niray.dao.IUserDao;
//import com.niray.model.UserEntity;
//
//import javax.annotation.Resource;
//
///**
// * Created by Mac on 16/10/12.
// */
//public class MemberService {
//
//    public MemberService() {
//    }
//
//    @Resource(name = "memberDao")
//    private IUserDao memberDao;
//
//    public void setMemberDao(IUserDao memberDao) {
//        this.memberDao = memberDao;
//    }
//
//    public void add(UserEntity user) {
//        memberDao.insertUser(user);
//    }
//
//    public void delete(String id) {
//        memberDao.deleteUser(id);
//    }
//
//    public UserEntity get(String id) {
//        return memberDao.searchUser(id);
//    }
//
//}
