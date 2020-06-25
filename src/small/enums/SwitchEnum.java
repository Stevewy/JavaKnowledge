package small.enums;

/**
 * @author WangYao
 * @date 2020/6/25
 * @function 枚举在switch
 */
enum Color{GREEN, YELLOW, RED}

public class SwitchEnum {
    Color color = Color.GREEN;
    public void change(){
        switch (color) {
            case GREEN:
                color = Color.YELLOW;
//                return; //调用return也不会报错啊?? java编程思想p594
                break;
            case YELLOW:
                color = Color.RED;
                break;
            case RED:
                color = Color.GREEN;
                break;
        }
    }

    @Override
    public String toString() {
        return "SwitchEnum{" +
                "color=" + color +
                '}';
    }

    public static void main(String[] args) {
        SwitchEnum switchEnum = new SwitchEnum();
        for (int i = 0; i < 7; i++) {
            System.out.println(switchEnum);
            switchEnum.change();
        }
    }
}
