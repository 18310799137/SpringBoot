package com.zgh.springboot.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.zgh.springboot.entity.User;

/**
 * 
 */
@Mapper
public interface UserMapper {
	@Select("select * from t_user where name = #{name}")
	User findUserByName(@Param("name") String name);
}