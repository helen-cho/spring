package com.example.dao;
import com.example.domain.*;

public interface MessageDAO {
	public void insert(MessageVO vo);
	public MessageVO readSend(int mid);
	public MessageVO readReceive(int mid);
	public void updateReadDate(int mid);
}
