package com.niray.dao;

import com.niray.model.UserEntity;

public interface IUserDao {

    boolean insertUser(UserEntity user); // 插入一条城市记录

    void deleteUser(String user_id); // 根据 UserEntity_code 删除城市

    UserEntity searchUser(String User_id); // 根据 UserEntity_code 查询城市信息

    boolean updateUser(UserEntity user); // 根据 UserEntity_code，UserEntity_name 重命名城市信息

}
