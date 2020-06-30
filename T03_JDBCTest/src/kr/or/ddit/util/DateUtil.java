package kr.or.ddit.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtil {
	// 날짜 체크
	// System.out.println(DateUtil.dateCheck("aaaaaa", "yyyyMMdd")); dateCheck 함수사용 예시
	public static boolean dateCheck(String date, String format) {
		SimpleDateFormat dateFormatParser = new SimpleDateFormat(format, Locale.KOREA);
		dateFormatParser.setLenient(false);
		try {
			dateFormatParser.parse(date);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	// 날짜 형식 지정
	public static String dateFormat(Date day) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		String date = format.format(day);
		return date;
	}

	// 날짜 차이 계산
	public static long diffOfDay(Date first, Date second) {
		long diffDay = 0;
		try {
			diffDay = (first.getTime() - second.getTime()) / (24 * 60 * 60 * 1000);
			return diffDay;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return diffDay;
	}
}
