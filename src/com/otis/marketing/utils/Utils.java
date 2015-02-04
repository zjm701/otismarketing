package com.otis.marketing.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

	private static final String DATE_FORMAT = "yyyy-MM-dd";
	
	public static String formateDate (Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		return sdf.format(date);
	}
}
