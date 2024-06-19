package com.example.dao;
import com.example.domain.*;
import java.util.*;

public interface ProDAO {
	public List<ProVO> list(QueryVO vo);
	public int total();
}
