package small.enums;

import java.util.EnumSet;

/**
 * @author WangYao
 * @date 2020/6/26
 * @function EnumSet(EnumMap与之类似,不多介绍)
 */

enum AlarmPoints{
    STAIR, OFFICE, BATHROOM, UTILITY, KITCHEN
}

public class EnumSets {
    public static void main(String[] args) {
        EnumSet<AlarmPoints> points = EnumSet.noneOf(AlarmPoints.class);

        points.add(AlarmPoints.OFFICE);
        System.out.println(points);
        points.add(AlarmPoints.STAIR);
        System.out.println(points);
        points.add(AlarmPoints.BATHROOM);
        System.out.println(points);
        points.removeAll(EnumSet.of(AlarmPoints.STAIR));  //为减少性能损失,对于1到5个不用可变参数,5个以上使用可变参数
        System.out.println(points);
        points = EnumSet.complementOf(points); //取剩下的
        System.out.println(points);


    }
}
