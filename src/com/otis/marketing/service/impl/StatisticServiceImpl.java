package com.otis.marketing.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.otis.marketing.dao.StatisticDao;
import com.otis.marketing.service.StatisticService;

@Service("statisticService")
@Transactional
public class StatisticServiceImpl implements StatisticService {

	@Resource
	private StatisticDao statisticDao;
	
	@Override
	public void getSurveyStatistic() {
		statisticDao.getSurveyStatistic(1L);

	}

}