package com.bookcode.bookapiex.repository;

import com.bookcode.bookapiex.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    /**
     * 登录
     */
    @Query(name="login",nativeQuery = true,value = "select * from user where user_number=:userNumber and password=:password")
    User login(@Param("userNumber") String userNumber, @Param("password") String password);
    void deleteByUserNumber(long userNumber);
}
