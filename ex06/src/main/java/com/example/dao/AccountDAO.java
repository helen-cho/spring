package com.example.dao;
import com.example.domain.*;
import java.util.*;

public interface AccountDAO {
	public List<AccountVO> list();
	public AccountVO read(String uid);
	public void update(TradeVO vo);
}
