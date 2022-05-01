package com.kevinavy.competitionsys.mapper;

//import com.kevinavy.competitionsys.security.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Insert("INSERT INTO user(username, password, create_time, update_time) VALUES (#{username}, #{password}, #{createTime}, #{createTime}) ")
    void register(String username, String password, Long createTime);

//    @Select("SELECT * FROM user WHERE username = #{username}")
//    User findUserByUsername(String username);
}
