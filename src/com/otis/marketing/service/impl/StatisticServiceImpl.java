package com.otis.marketing.service.impl;

import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.otis.marketing.dao.StatisticDao;
import com.otis.marketing.entity.Statistic;
import com.otis.marketing.entity.StatisticItem;
import com.otis.marketing.service.StatisticService;

@Service("statisticService")
@Transactional
public class StatisticServiceImpl implements StatisticService {
	
	private HSSFWorkbook workbook;
	
	private HSSFCellStyle cellStyle;
	
	private HSSFSheet sheet;
	
	@Resource
	private StatisticDao statisticDao;
	
	public StatisticServiceImpl() {
		workbook = new HSSFWorkbook();
		sheet = workbook.createSheet();
		cellStyle = workbook.createCellStyle();
	}
	
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
	
	public void exportByQuestion(HttpServletResponse response, Integer surveyId, Integer index) throws Exception {
		int i = 0, j = 0;
		for (Statistic stat : getSurveyStatistic(surveyId)) {
			if (index != j ++ ) {
				continue;
			}
			HSSFRow row = sheet.createRow(i++);
			HSSFCell cell = row.createCell(0);
			cell.setCellType(HSSFCell.CELL_TYPE_STRING);
			cell.setCellValue(stat.getTitle());
			setGridTitle(sheet.createRow(i++));
			for (StatisticItem item : stat.getItems()) {
				setGridValues(sheet.createRow(i++), item);
			}
			
		}
		OutputStream out = response.getOutputStream();
		String fileName="result";
		response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode((((null == fileName) || ("".equals(fileName.trim()))) ? ((new Date().getTime()) + "") : fileName.trim()) + ".xls", "utf-8"));
		workbook.write(out);
		out.flush();
		out.close();
	}
	
	@Override
	public void exportBySurvey(HttpServletResponse response, Integer surveyId) throws Exception {
		int i = 0;
		for (Statistic stat : getSurveyStatistic(surveyId)) {
			HSSFRow row = sheet.createRow(i++);
			HSSFCell cell = row.createCell(0);
			cell.setCellType(HSSFCell.CELL_TYPE_STRING);
			cell.setCellValue(stat.getTitle());
			setGridTitle(sheet.createRow(i++));
			for (StatisticItem item : stat.getItems()) {
				setGridValues(sheet.createRow(i++), item);
			}
			
		}
		OutputStream out = response.getOutputStream();
		String fileName="result";
		response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode((((null == fileName) || ("".equals(fileName.trim()))) ? ((new Date().getTime()) + "") : fileName.trim()) + ".xls", "utf-8"));
		workbook.write(out);
		out.flush();
		out.close();
	}
	
	private void setGridTitle(HSSFRow row) {
		HSSFCell cell = row.createCell(0);
		cell.setCellType(HSSFCell.CELL_TYPE_STRING);
		cell.setCellValue("选项");
		setDefaultCellStyle(cell);
		cell = row.createCell(1);
		cell.setCellType(HSSFCell.CELL_TYPE_STRING);
		cell.setCellValue("选择人数");
		setDefaultCellStyle(cell);
		cell = row.createCell(2);
		cell.setCellType(HSSFCell.CELL_TYPE_STRING);
		cell.setCellValue("百分比");
		setDefaultCellStyle(cell);
	}
	
	private void setGridValues(HSSFRow row, StatisticItem item) {
		HSSFCell cell = row.createCell(0);
		cell.setCellType(HSSFCell.CELL_TYPE_STRING);
		cell.setCellValue(item.getOptionDesc());
		setDefaultCellStyle(cell);
		cell = row.createCell(1);
		cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
		cell.setCellValue(item.getTotal());
		setDefaultCellStyle(cell);
		cell = row.createCell(2);
		cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
		cell.setCellValue(item.getPercentage()*100 + "%");
		setDefaultCellStyle(cell);
	}
	
	private void setDefaultCellStyle(HSSFCell cell) {
		cellStyle.setBorderTop(HSSFCellStyle.SOLID_FOREGROUND);
		cellStyle.setBorderLeft(HSSFCellStyle.SOLID_FOREGROUND);
		cellStyle.setBorderRight(HSSFCellStyle.SOLID_FOREGROUND);
		cellStyle.setBorderBottom(HSSFCellStyle.SOLID_FOREGROUND);
		cell.setCellStyle(cellStyle);
	}
	

}
