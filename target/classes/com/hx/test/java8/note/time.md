 + 所有 java.time 对象都是不可变的。
 + 一个瞬间（Instant）是时间上的一个点（与Date类似）
 + 在java实际按中每天都是 86400秒 （即没有闰秒）
 + 持续时间（Duration）是两个瞬间之间的时间
 + LocalDateTime 没有时区信息
 + TemporalAdjuster方法可以处理常用的日历计算，例如找到某个月的第一个星期二
 + ZonedDateTime 是指定时区中的某一个时间点（类似于Gregorian Calendar）
 + 当处理带时区的时间时，请使用时段（Period），而非Duration，以便将夏令谁的变化考虑在内
 + 使用DateTimeFormatter来格式化和解析日期和时间
 
 
 + Java日期和时间Api 规范要求Java使用如下时标”
     + 每天都有86400秒。
     + 每天正午与官方实际按准确匹配
     + 其他时间也要以一种精确定义的方式与其紧密匹配