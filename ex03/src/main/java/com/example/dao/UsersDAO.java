package com.example.dao;
import java.util.*;
import com.example.domain.UserVO;

public interface UsersDAO {
	public List<HashMap<String,Object>> list();
	public UserVO read(String uid);
	public void insert(UserVO vo);
	public void update(UserVO vo);
	public void delete(String uid);
}
