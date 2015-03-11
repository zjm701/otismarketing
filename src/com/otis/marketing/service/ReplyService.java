package com.otis.marketing.service;

import com.otis.marketing.entity.Question;
import com.otis.marketing.entity.Reply;

public interface ReplyService {
	public void saveReply(Reply reply);
	
	public Question getQuestionById(Integer questionId);
}
