package com.elad.CouponSystemV3Spring.utills;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;




public class DateUtills {
	
	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

	public static Date getDate(int dd, int MM, int yyyy) throws ParseException{
		String str = String.format("%2d/%2d/%4d", dd, MM, yyyy);
		return simpleDateFormat.parse(str);

	}

	public static String beautifyDate(Date date) {
		return simpleDateFormat.format(date);
	}
	
}
