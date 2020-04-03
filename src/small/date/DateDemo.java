package small.date;

import java.util.Scanner;

/**
 * @author WangYao
 * @date 2019/11/22
 * @function 以前的日期,以2019为基准
 */
@Deprecated
public class DateDemo {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int year;
        int month;
        System.out.println("请输入年份");
        year = in.nextInt();
        System.out.println("请输入月份");
        month = in.nextInt();
        int week = DateDemo.Week(year, month);
        int monthday = DateDemo.MonthDay(year, month);
        System.out.println("日 一 二 三 四 五 六");
        for(int i = 0; i < week; i++)
            System.out.print("   ");
        for(int i = 1; i <= monthday; i++){
            if(i < 10)
                System.out.print(i+"  ");
            else
                System.out.print(i + " ");
            if((i + week) % 7 == 0)
                System.out.println();
        }
    }

    public static int MonthDay(int year, int month){
        if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0){
            switch (month){
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    return 31;
                case 2:
                    return 29;
                case 4:
                case 6:
                case 9:
                case 11:
                    return 30;
            }
        }else{
            switch (month){
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    return 31;
                case 2:
                    return 28;
                case 4:
                case 6:
                case 9:
                case 11:
                    return 30;
            }
        }
        return -1;
    }

    public static int Week(int year, int month){
        int day = 0;
        if(year < 2019){
            for(int i = year; i < 2019; i++){
                if((i % 4 == 0 && i % 100 != 0) || i % 400 == 0)
                    day += 366;
                else
                    day += 365;
            }
        }
        else {
            for(int i = 2019; i < year; i++){
                if((i % 4 == 0 && i % 100 != 0) || i % 400 == 0)
                    day += 366;
                else
                    day += 365;
            }
        }
        if(year >= 2019){
            for(int i = 1; i < month; i++)
                day += MonthDay(year, i);
            return day % 7 + 2 >= 7 ? day % 7 - 5 : day % 7 + 2;
        }else {
            for(int i = 1; i < month; i++)
                day -= MonthDay(year, i);
            return 2 - day % 7 >= 0 ? 2 - day % 7 : 9 - day % 7;
        }
    }
}
