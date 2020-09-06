package small.exception;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author WangYao
 * @date 2020/1/2
 * @function
 */
public class ExceptionDemo {

    public static void main(String[] args) throws Exception {
        try (InputStream in = new FileInputStream("带资源的try语句.txt")){
            byte[] bytes = new byte[1024];
            in.read(bytes);
//            in.close();//不需要
        }
        catch(IOException e){
            e.fillInStackTrace();

            e.printStackTrace(System.out);

            for(StackTraceElement i :e.getStackTrace())//打印
                System.out.print(i);

            throw new Exception("IO", e);//异常链
        }
        finally {
            System.out.println("不要return和throw");
        }

    }
}
