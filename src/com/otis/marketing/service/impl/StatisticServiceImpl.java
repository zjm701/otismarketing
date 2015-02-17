package com.otis.marketing.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.otis.marketing.dao.StatisticDao;
import com.otis.marketing.entity.Statistic;
import com.otis.marketing.service.StatisticService;

@Service("statisticService")
@Transactional
public class StatisticServiceImpl implements StatisticService {

	@Resource
	private StatisticDao statisticDao;
	
	@Override
	public List<Statistic> getSurveyStatistic(Integer surveyId) {
//		Survey survey = statisticDao.getSurveyById(surveyId);
//		List<Question> questions = survey.getQuestions();
		List<Statistic> list = statisticDao.getSurveyStatistic(surveyId);
		for (Statistic stat : list) {
			stat.build4UI();
		}
		return list;
	}

}
