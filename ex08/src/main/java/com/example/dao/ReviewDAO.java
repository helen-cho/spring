package com.example.dao;
import java.util.*;
import com.example.domain.*;

public interface ReviewDAO {
	public List<ReviewVO> list(String gid);
	public void insert(ReviewVO vo);
	public void delete(int rid);
	public void update(ReviewVO vo);
}
