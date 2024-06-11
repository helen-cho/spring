package com.example.dao;

import java.util.*;
import com.example.domain.*;

public interface BBSDAO {
	public List<HashMap<String,Object>> list(QueryVO vo);
}
