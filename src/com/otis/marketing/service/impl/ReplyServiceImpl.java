package com.otis.marketing.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.otis.marketing.dao.QuestionDao;
import com.otis.marketing.dao.ReplyDao;
import com.otis.marketing.entity.Question;
import com.otis.marketing.entity.Reply;
import com.otis.marketing.service.ReplyService;

@Service("replyService")
@Transactional
public class ReplyServiceImpl implements ReplyService {
	@Resource
	private ReplyDao replyDao;
	
	@Resource
	private QuestionDao questionDao;
	
	@Override
	public void saveReply(Reply reply) {
		replyDao.save(reply);
	}
	
	@Override
	public Question getQuestionById(Integer questionId) {
		return questionDao.get(questionId);
	}

}
