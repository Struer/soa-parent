package com.soa.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

public class DateTimeUtil {

    public final static String DEFAULT_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public final static String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";

    public final static String DEFAULT_TIME_FORMAT = "HH:mm:ss";

    private static int SERVER_TIME_ZONE = -1;

    public static long ONEWEEK_TIME = 24 * 60 * 60 * 7;// 一周总秒数

    public static long ONEDAY_TIME = 24 * 60 * 60;// 一天总秒数

    /**
     * 时间校验误差，秒
     */
    public final static int TIME_CHECK_INTERVAL = 5;

    /**
     * 时间校验误差，秒
     */
    public final static int TIME_CHECK_INTERVAL2 = 120;

    static {
	// check server time zone
	if (SERVER_TIME_ZONE < 1) {
	    TimeZone zone = TimeZone.getDefault();
	    SERVER_TIME_ZONE = zone.getRawOffset();
	}
    }

    /**
     * 获取当前时间:1970年到现在的秒值
     * 
     */
    public static long currentTimeSecond() {
	return Calendar.getInstance().getTimeInMillis() / 1000;
    }

    public static long getCurrentTimeSecond(Date date) {
	return date.getTime() / 1000;
    }

    public static Date getDateByString2(String date) throws ParseException {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	return sdf.parse(date);
    }

    /**
     * 判断当前时间是否在2个字符串时间范围内，字符串格式为HH:mm:ss
     * 
     * @param bTime
     * @param eTime
     * @return
     * @throws ParseException
     */
    public static boolean isInTime(String bTime, String eTime) throws ParseException {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	String str = sdf.format(new Date());
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	Date beginTime = sdf1.parse(str + " " + bTime);
	Date endTime = sdf1.parse(str + " " + eTime);
	boolean isInTime = DateTimeUtil.isWithin(beginTime, endTime);
	return isInTime;
    }

    public static String parseDate(Date date) throws ParseException {
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	return sdf1.format(date);
    }

    public static String parseDate2(Date date) throws ParseException {
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
	return sdf1.format(date);
    }

    public static String parseDate(Date date, String fmt) throws ParseException {
	SimpleDateFormat sdf1 = new SimpleDateFormat(fmt);
	return sdf1.format(date);
    }

    public static Date getDateTimeFromSecond(long second) {
	Date date = new Date(second * 1000);
	return date;
    }

    /**
     * 获取2个时间秒数之差
     * 
     * @param begin
     * @param end
     * @return
     */
    public static long getBetweenSecond(Date begin, Date end) {
	if (begin == null || end == null) {
	    return 0;
	}
	long time1 = getCurrentTimeSecond(begin);
	long time2 = getCurrentTimeSecond(end);
	if (time2 >= time1) {
	    return time2 - time1;
	}
	return 0;
    }

    /**
     * 取当前时间
     * 
     * @since
     * @return
     */
    public static Date getTime() {
	return Calendar.getInstance().getTime();
    }

    public static Date getDateByString(String date) throws ParseException {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	return sdf.parse(date);
    }

    public static boolean isBetween(Date time, Date startTime, Date endTime) {
	return time.before(endTime) && time.after(startTime);
    }

    public static int getCurrentTimeSecondStartWithToday() {
	Date date = getTime();
	return date.getHours() * 3600 + date.getMinutes() * 60 + date.getSeconds();

    }

    // 是否今天
    public static boolean isToday(Date in) {
	if (in != null && formatDate(in).equals(formatDate(new Date())))
	    return true;
	return false;
    }

    public static String formatDate(Date date) {
	SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
	if (date == null) {
	    return null;
	}
	return sdf.format(date);
    }

    /**
     * 判断当前时间是否在 start 和 end之间(允许120秒误差,配置范围外)
     * 
     * @param start
     * @param end
     * @return
     */
    public static boolean isWithinDifferece2(Date start, Date end) {

	if (start == null || end == null) {
	    throw new NullPointerException("start or end");
	}
	long currentTime = System.currentTimeMillis();
	return (currentTime < end.getTime() + TIME_CHECK_INTERVAL2 && currentTime > start.getTime() - TIME_CHECK_INTERVAL2);
    }

    /**
     * 给一个字符创HH:mm:ss 返回今天的yyyy-MM-dd HH:mm:ss
     * 
     * @param date
     * @return
     */
    public static String getTodayTimeByString(String date) {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	String str = sdf.format(new Date());
	return str + " " + date;
    }

    /**
     * 获取明天的日期
     * 
     * @return
     */
    public static String getTomorrowDate() {
	Date date = new Date();// 取当前时间
	Calendar calendar = new GregorianCalendar();
	calendar.setTime(date);
	calendar.add(calendar.DATE, 1);// 把日期往后增加一天.整数往后推,负数往前移动
	date = calendar.getTime(); // 这个时间就是日期往后推一天的结果
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	String dateString = formatter.format(date);
	return dateString;
    }

    /**
     * 获取明天的日期
     * 
     * @return
     */
    public static String getTomorrowDate(String fmt) {
	Date date = new Date();// 取当前时间
	Calendar calendar = new GregorianCalendar();
	calendar.setTime(date);
	calendar.add(calendar.DATE, 1);// 把日期往后增加一天.整数往后推,负数往前移动
	date = calendar.getTime(); // 这个时间就是日期往后推一天的结果
	SimpleDateFormat formatter = new SimpleDateFormat(fmt);
	String dateString = formatter.format(date);
	return dateString;
    }

    /**
     * 给一个字符创HH:mm:ss 返回明天的yyyy-MM-dd HH:mm:ss
     * 
     * @param date
     * @return
     */
    public static String getTomorrowTimeByString(String date) {
	// 明天日期
	String str = getTomorrowDate();
	return str + " " + date;
    }

    /**
     * 判断当前时间是否在 start 和 end之间(允许end结束后differeceTime秒内仍有效 )
     * 
     * @param start
     * @param end
     * @param differeceTime
     * @return
     */
    public static boolean isWithinDifferece2(Date start, Date end, int differeceTime) {
	if (start == null || end == null) {
	    throw new NullPointerException("start or end");
	}
	long currentTime = System.currentTimeMillis();
	return (currentTime < end.getTime() + differeceTime && currentTime >= start.getTime());
    }

    /**
     * 查询周几
     * 
     * @return 1-6：周一到周六，周日7
     */
    public static int getCurrentDayOfWeek() {
	Calendar now = Calendar.getInstance(TimeZone.getDefault());
	int day = now.get(java.util.Calendar.DAY_OF_WEEK);
	if (day == 1) {// 周日
	    day = 7;
	} else {
	    day--;
	}
	return day;
    }

    /**
     * 判断当前时间是否在2个字符串时间范围内（允许时间误差），字符串格式为HH:mm:ss
     * 
     * @param bTime
     * @param eTime
     * @return
     * @throws ParseException
     */
    public static boolean isInTime2(String bTime, String eTime) throws ParseException {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	String str = sdf.format(new Date());
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	Date beginTime = sdf1.parse(str + " " + bTime);
	Date endTime = sdf1.parse(str + " " + eTime);
	boolean isInTime = DateTimeUtil.isWithinDifferece2(beginTime, endTime);
	return isInTime;
    }

    /**
     * 获取哪一周星期几的日期 (当前小时分钟秒)
     * 
     * @param whichWeek (whichWeek=0 本周， whichWeek=-1上周)
     * @param weekDay （weekDay=1 星期日，weekDay=2 星期1，weekDay=3 星期2，weekDay=4
     *        星期3，weekDay=5 星期4，weekDay=6 星期5，weekDay=7 星期6）
     * @return
     */
    public static Date getDateByWeek(int whichWeek, int weekDay) {
	Calendar date = Calendar.getInstance(Locale.CHINA);
	date.setFirstDayOfWeek(Calendar.MONDAY);// 将每周第一天设为星期一，默认是星期天
	date.add(Calendar.WEEK_OF_MONTH, whichWeek);
	date.set(Calendar.DAY_OF_WEEK, weekDay);
	return date.getTime();
    }

    /**
     * 获取哪一周星期几的日期 yyyy-MM-dd
     * 
     * @param whichWeek
     * @param weekDay
     * @return
     */
    public static String getDateStringByWeek(int whichWeek, int weekDay) {
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	Date date = getDateByWeek(whichWeek, weekDay);
	String dateString = formatter.format(date);
	return dateString;
    }

    /**
     * 获取当前时间的yyyy-MM-dd
     * 
     * @return
     */
    public static String getDateStringForToday() {
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	String dateString = formatter.format(new Date());
	return dateString;
    }

    /**
     * 判断当前时间是否在 start 和 end之间
     * 
     */
    public static boolean isWithin(Date start, Date end) {

	if (start == null || end == null) {
	    throw new NullPointerException("start or end");
	}
	long currentTime = System.currentTimeMillis();
	return (currentTime < end.getTime() && currentTime > start.getTime());
    }

    /**
     * <p>
     * 功能描述：当前时间是否在指定的开始时间和结束时间之间
     * </p>
     */
    public static boolean isBetween(Date startTime, Date endTime) {
	return isBetween(new Date(), startTime, endTime);
    }

    /**
     * 周一至周7，转换成具体的星期几数字
     * 
     * @param rweek
     * @return
     */
    public static int getWeekDay(int rweek) {
	int weekDay = 0;
	switch (rweek) {
	    case 1:
		weekDay = 2;
		break;
	    case 2:
		weekDay = 3;
		break;
	    case 3:
		weekDay = 4;
		break;
	    case 4:
		weekDay = 5;
		break;
	    case 5:
		weekDay = 6;
		break;
	    case 6:
		weekDay = 7;
		break;
	    case 7:
		weekDay = 1;
		break;
	}
	return weekDay;
    }

    /**
     * 字符串类型日期转成Date
     * 
     * @param date
     * @param fmt
     * @return
     * @throws Exception
     */
    public static Date getDateFromString(String date, String fmt) throws Exception {
	if (date == null || date.trim().length() == 0)
	    return null;
	SimpleDateFormat sdf = fmt == null ? new SimpleDateFormat(DEFAULT_DATE_FORMAT) : new SimpleDateFormat(fmt);
	return sdf.parse(date);
    }

    public static int getCurHour() {
	return getHour(new Date());
    }

    public static int getHour(Date date) {
	return date.getHours();
    }

    /**
     * 获取今天凌晨最早的时间
     * 
     * @return
     * @throws Exception
     */
    public static Date getWeehours() throws Exception {
	SimpleDateFormat ss = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
	Calendar tt = Calendar.getInstance();
	return getDateFromString(ss.format(tt.getTime()), null);
    }

    /**
     * 
     * <p>
     * 
     *
     * 获取昨天时间
     * </p>
     * 
     * @param date
     * @return
     * 
     * @author hz15021023
     * @date 2015年3月13日 上午10:42:07
     * @version
     */
    public static Date getYesterDay(Date date) {
	Calendar calendar = Calendar.getInstance();
	calendar.setTime(date);
	calendar.add(Calendar.DAY_OF_MONTH, -1);
	date = calendar.getTime();
	return date;
    }

    /**
     * 获取当期时间yyyyMMddHHmmssSSS 精确到毫秒数
     * 
     * @return
     */
    public static String getDateForSSS() {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
	return sdf.format(new Date());
    }

    /**
     * 
     * <p>
     * 
     * 计算年龄
     *
     * </p>
     * 
     * @param birthday 出生年月日
     * @param calculateDay 计算日期
     * @return
     * 
     * @author hz15031079
     * @date 2015年6月4日 下午7:25:03
     * @version 1.0
     */
    /*
     * public static int getAge(Date birthday, Date calculateDay) { Calendar
     * calarderBirthday = Calendar.getInstance();
     * calarderBirthday.setTime(birthday); int yearBirthday =
     * calarderBirthday.get(Calendar.YEAR);
     * 
     * Calendar calarderCalculate = Calendar.getInstance();
     * calarderCalculate.setTime(calculateDay); int yearCalculate =
     * calarderCalculate.get(Calendar.YEAR);
     * 
     * int age = yearCalculate - yearBirthday;
     * 
     * if (calarderCalculate.get(Calendar.DAY_OF_YEAR) <
     * calarderBirthday.get(Calendar.DAY_OF_YEAR) && age >0) { age--; }
     * 
     * return age; }
     */

    public static int getAge(Date birthDay, Date calculateDay) {
	Calendar cal = Calendar.getInstance();
	cal.setTime(birthDay);
	int yearBirth = cal.get(Calendar.YEAR);
	int monthBirth = cal.get(Calendar.MONTH);
	int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);

	cal.setTime(calculateDay);
	int yearCalculate = cal.get(Calendar.YEAR);
	int monthCalculate = cal.get(Calendar.MONTH);
	int dayOfMonthCalculate = cal.get(Calendar.DAY_OF_MONTH);

	int age = yearCalculate - yearBirth;
	if (age > 0) {
	    if (monthCalculate == monthBirth) {
		if (dayOfMonthCalculate < dayOfMonthBirth) {
		    age--;
		}
	    } else if (monthCalculate < monthBirth) {
		age--;
	    }
	}
	return age;
    }

    /**
     * 
     * <p>
     * 
     * 获取两个时间之间的月份差
     *
     * </p>
     * 
     * @param beginDate 开始时间
     * @param endDate 结束时间
     * @return 返回结束时间和开始时间之间的月份差
     * 
     * @author hz15071545
     * @date 2015年8月12日 上午11:20:25
     * @version
     */
    public static int getMonthSpace(Date beginDate, Date endDate) {
	int result = 0;
	Calendar begin = Calendar.getInstance();
	Calendar end = Calendar.getInstance();
	begin.setTime(beginDate);
	end.setTime(endDate);
	int diffYears = end.get(Calendar.YEAR) - begin.get(Calendar.YEAR);
	int diffMonths = end.get(Calendar.MONTH) - begin.get(Calendar.MONTH);
	int diffdays = end.get(Calendar.DAY_OF_MONTH) - begin.get(Calendar.DAY_OF_MONTH);
	result = diffdays <= 0 ? (12 * diffYears + diffMonths) : (12 * diffYears + diffMonths + 1);
	return result;
    }

    public static void main(String[] args) throws ParseException {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	Date start = sdf.parse("2014-01-31");
	Date end = sdf.parse("2014-03-28");

	int result = getMonthSpace(start, end);
	System.out.println(result);
	// int age = getAge(start, end);
	// System.out.println(age);
    }

    /**
     * 获取今天凌晨最早的时间
     * 
     * @return
     * @throws Exception
     */
    public static Date add(Date date, int field, int amount) {
	Calendar tt = Calendar.getInstance();
	tt.setTime(date);
	tt.add(field, amount);
	return tt.getTime();
    }

}
