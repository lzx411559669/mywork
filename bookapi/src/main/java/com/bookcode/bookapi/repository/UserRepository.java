package com.bookcode.bookapi.repository;

import com.bookcode.bookapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    /**
     * 登录
     */
    @Query(name="login",nativeQuery = true,value = "select * from user where username=:username and password=:password")
    User login(@Param("username") String username, @Param("password") String password);
}
