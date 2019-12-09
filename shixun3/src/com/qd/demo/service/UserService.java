package com.qd.demo.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public interface UserService {
	public List<Map> getUserList(Map map);
	public List<Map> getUserListParams(Map map);


}
