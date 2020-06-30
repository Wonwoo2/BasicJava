package h_useful;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateClass {

	public static void main(String[] args) {
		Date today = new Date();
		
		System.out.println(today);
		
		// 날짜를 포멧을 지정하여 문자열로 변경
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm:ss.sss");
		SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sdf4 = new SimpleDateFormat("yy-MM-dd hh:mm:ss a");
		SimpleDateFormat sdf5 = new SimpleDateFormat("HH:mm:ss");
		
		System.out.println(sdf1.format(today));
		System.out.println(sdf2.format(today));
		System.out.println(sdf3.format(today));
		System.out.println(sdf4.format(today));
		System.out.println(sdf5.format(today));
		
		// 문자열의 포멧을 지정하여 날짜로 변경
		String str = "2020년 5월 15일";
		
		SimpleDateFormat sdf6 = new SimpleDateFormat("yyyy년 MM월 dd일");
		try {
			Date dateStr = sdf6.parse(str);
			System.out.println(sdf6.format(dateStr));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Calendar cal = Calendar.getInstance();
		
		cal.setTime(new Date());
		cal.set(2020, 4, 15);
		System.out.println(sdf3.format(cal.getTime()));
		
		cal.add(Calendar.YEAR, 1);
		cal.add(Calendar.MONTH, 2);
		cal.add(Calendar.DAY_OF_MONTH, -3);
		cal.add(Calendar.HOUR, 2);
		cal.add(Calendar.MINUTE, 5);
		cal.add(Calendar.SECOND, -10);
		
		System.out.println(sdf4.format(cal.getTime()));

		
	}
}