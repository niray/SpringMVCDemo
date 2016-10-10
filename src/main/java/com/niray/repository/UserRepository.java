package com.niray.repository;

import com.niray.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Mac on 16/10/9.
 */

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    @Modifying //修改操作
    @Transactional //事务性操作
    @Query("update UserEntity us set us.nickname=:newNickname,us.password=:newPassword where us.id =:newId")
    void updateUser(@Param("newId") Integer id,
                    @Param("newNickname") String nickname,
                    @Param("newPassword") String password);
}
