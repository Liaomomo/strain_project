package com.qd.demo.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;



@Mapper
//mabatis接口   接口在mapper
public interface UserMapper {

	public List<Map> getUserList(Map map);
	public List<Map> getUserListParams(Map map);


}

