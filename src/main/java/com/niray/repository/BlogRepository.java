package com.niray.repository;

import com.niray.model.BlogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Mac on 16/10/10.
 */
@Repository
public interface BlogRepository extends JpaRepository<BlogEntity, Integer> {

    @Modifying
    @Transactional
    @Query("update BlogEntity blog set blog.title = :newTitle,blog.content=:newContent,blog.pubDate =:newDate,blog.userById=:newUser where blog.id = :newId")
    void updateBlog(@Param("newTitle") String title,
                    @Param("newContent") String content,
                    @Param("newUser") Integer userId,
                    @Param("newDate") String date,
                    @Param("newId") Integer id);
}
