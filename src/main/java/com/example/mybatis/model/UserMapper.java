package com.example.mybatis.model;

import com.example.mybatis.dto.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from user")
    List<User> findAll();

    @Select("select * from user where id=#{id}")
    User findById(@Param("id") int id);

    @Insert("insert into user(name, email, password) values(#{user.name}, #{user.email}, #{user.password})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    boolean save(@Param("user") final User user);

    @Update("UPDATE user SET name = #{name} WHERE id=#{id}")
    boolean update(@Param("id") int id, @Param("name") String name);
}
