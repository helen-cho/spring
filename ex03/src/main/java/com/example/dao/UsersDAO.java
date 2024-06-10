package com.example.dao;
import java.util.*;
import com.example.domain.UserVO;

public interface UsersDAO {
	public List<HashMap<String,Object>> list();
	public HashMap<String,Object> read(String uid);
	public void insert(UserVO vo);
}
