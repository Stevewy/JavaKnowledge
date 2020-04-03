package small.date;

import lombok.Getter;

/**
 * @author WangYao
 * @date 2020/4/3
 * @function
 */
@Getter
public class MyDate {
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;
    private int sound;

    public MyDate() {
    }

    public MyDate(int year, int month, int day) {
        this(year, month, day, 0, 0, 0);
    }

//    public MyDate(int hour, int minute, int sound){
//        this(0, 1, 1, hour, minute, sound);
//    }

    public MyDate(int year, int month, int day, int hour, int minute, int sound) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
        this.sound = sound;
    }

    public boolean isLeap() {
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }
}
