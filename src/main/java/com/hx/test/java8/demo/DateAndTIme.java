package com.hx.test.java8.demo;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import static java.time.temporal.ChronoUnit.DAYS;
import static java.time.temporal.ChronoUnit.YEARS;


public class DateAndTIme {
    public static void main(String[] args) {
        // 本地时间 LocalDate LocalTime
        // ---------例子------------
        // 在Java 8中获取当天的日期
        LocalDate today = LocalDate.now();
        System.out.println("Today's Local date : " + today);

        //在Java 8中获取当前的年月日
        int year = today.getYear();
        int month = today.getMonthValue();
        Month month1 = today.getMonth();
        int day = today.getDayOfMonth();
        int dayOfYear = today.getDayOfYear();
        System.out.println("Today in year"+dayOfYear);
        System.out.printf("Year : %d Month : %d day : %d \t %n", year, month, day);

        //在Java 8中获取某个特定的日期
        LocalDate dateOfBirth = LocalDate.of(1990, 8, 6);
        System.out.println("Your birthday is : " + dateOfBirth);

        //在Java 8中检查两个日期是否相等
        LocalDate date1 = LocalDate.of(2017, 3, 26);
        if (date1.equals(today)) {
            System.out.printf("Today %s and date1 %s are same date %n", today, date1);
        }

        //在Java 8中检查重复事件，比如说生日
        MonthDay birthday = MonthDay.of(dateOfBirth.getMonth(), dateOfBirth.getDayOfMonth());
        MonthDay currentMonthDay = MonthDay.from(today);
        if (currentMonthDay.equals(birthday)) {
            System.out.println("Many Many happy returns of the day !!");
        } else {
            System.out.println("Sorry, today is not your birthday");
        }

        //在Java 8中获取当前时间
        LocalTime time = LocalTime.now();
        System.out.println("local time now : " + time);

        //增加时间里面的小时数
        LocalTime newTime = time.plusHours(2); // 增加两个小时
        System.out.println("Time after 2 hours : " + newTime);

        //获取1周后的日期
        LocalDate nextWeek = today.plus(1, ChronoUnit.WEEKS);
        System.out.println("Today is : " + today);
        System.out.println("Date after 1 week : " + nextWeek);

        // 一年前后的日期
        LocalDate previousYear = today.minus(1, YEARS);// ChronoUnit.YEARS
        System.out.println("Date before 1 year : " + previousYear);
        LocalDate nextYear = today.plus(1, YEARS);
        System.out.println("Date after 1 year : " + nextYear);

        //Java 8中自带了一个Clock类，你可以用它来获取某个时区下当前的瞬时时间，日期或者时间。
        // 可以用Clock来替代System.currentTimeInMillis()

        // 在Java 8中使用时钟
        Clock clock = Clock.systemUTC();
        System.out.println("Clock : " + clock);
        Clock.systemDefaultZone();
        System.out.println("Clock : " + clock);

        //比较日期
        LocalDate tomorrow = LocalDate.of(2017, 3, 26);
        if (tomorrow.isAfter(today)) {
            System.out.println("Tomorrow comes after today");
        }
        LocalDate yesterday = today.minus(1, DAYS);
        if (yesterday.isBefore(today)) {
            System.out.println("Yesterday is day before today");
        }

        //在Java 8中处理不同的时区
        ZoneId america = ZoneId.of("America/New_York");
        LocalDateTime localDateAndTime = LocalDateTime.now();
        ZonedDateTime dateAndTimeInNewYork = ZonedDateTime.of(localDateAndTime, america);
        System.out.println("Current date and time in a particular timezone : " + dateAndTimeInNewYork);

        //表示固定的日期，比如信用卡过期时间
        YearMonth currentYearMonth = YearMonth.now();
        System.out.printf("Days in month year %s: %d%n", currentYearMonth, currentYearMonth.lengthOfMonth());
        YearMonth creditCardExpiry = YearMonth.of(2018, Month.FEBRUARY);
        System.out.printf("Your credit card expires on %s %n", creditCardExpiry);

        //检查闰年
        if(today.isLeapYear()){
            System.out.println("This year is Leap year");
        }else {
            System.out.println("2017 is not a Leap year");
        }

        // Instant 对象表示时间轴上的一个点
        // 元年 ： 1970-1-1
        // Instant.MIN 10亿年前
        // Instant.MAX 1000000000年12月31日
        Instant start = Instant.now();

        System.out.println(Instant.MIN);
        System.out.println(start);
        System.out.println(Instant.MAX);

        Instant end = Instant.now();

        Duration timeElapsed = Duration.between(start, end);
        long millis = timeElapsed.toMillis();
        System.out.println("经过时间" + millis + "ms");

        // api
        /*
         *  plus,minus    对当前Instant或者Duration 添加或减少一段时间
         *  plusNanos,plusMillis,plusSeconds,plusMinutes,plusHours,plusDays
         *  减法为 minusXxxx
         *
         * */
        // 与旧api 之间的转换
        Date date = Date.from(start);
        Instant instant = date.toInstant();

        //两个日期之间包含多少天，多少个月
        LocalDate java8Release1 = LocalDate.of(2016, Month.JULY, 15);
        LocalDate java8Release2 = LocalDate.of(2018, Month.JULY, 15);
        Period periodToNextJavaRelease1 = Period.between(today, java8Release1); // period 表示时间段
        Period periodToNextJavaRelease2 = Period.between(today, java8Release2); // period 表示时间段
        System.out.println("Months left between today and Java 8 release1 : " + periodToNextJavaRelease1.getMonths() );
        System.out.println("Months left between today and Java 8 release2 : " + periodToNextJavaRelease2.getMonths() );

        //在Java 8中使用预定义的格式器来对日期进行解析/格式化
        String dayAfterTomorrow = "20170326";
        LocalDate formatted = LocalDate.parse(dayAfterTomorrow, DateTimeFormatter.BASIC_ISO_DATE);
        System.out.printf("Date generated from String %s is %s %n", dayAfterTomorrow, formatted);

        //在Java中使用自定义的格式器来解析日期
        String goodFriday = "03 18 2016";
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM dd yyyy");
            LocalDate holiday = LocalDate.parse(goodFriday, formatter);
            System.out.printf("Successfully parsed String %s, date is %s%n", goodFriday, holiday);
        } catch (DateTimeParseException ex) {
            System.out.printf("%s is not parsable!%n", goodFriday);
            ex.printStackTrace();
        }

        //在Java 8中对日期进行格式化，转换成字符串
        LocalDateTime arrivalDate = LocalDateTime.now();
        try {
            DateTimeFormatter format = DateTimeFormatter.ofPattern("MMM dd yyyy hh:mm a");
            String landing = arrivalDate.format(format);
            System.out.printf("Arriving at : %s %n", landing);
        } catch (DateTimeException ex) {
            System.out.printf("%s can't be formatted!%n", arrivalDate);
            ex.printStackTrace();
        }
    }
}
