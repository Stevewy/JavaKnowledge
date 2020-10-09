package small.jul;

import java.io.InputStream;
import java.util.logging.*;

/**
 * @author WangYao
 * @date 2020/10/9
 * @function 使用java.util.log里面的日志
 */
public class utilLogDemo {

    public static void main(String[] args) throws Exception {
        /*
         * 日志 Level类级别 SEVERE WARNING INFO CONFIG FINE FINER FINEST      OFF ALL
         */
        Logger logger = Logger.getLogger("test.Main");//唯一标识符,一般使用全限定类名
        //日志记录输出
        logger.info("hello");
        //通用方法
        logger.log(Level.INFO, "msg");
        //占位符
        logger.log(Level.INFO, "你={0}",new Object[]{1});

        //自定义配置,并保存到文件
        logger.setUseParentHandlers(false);

        ConsoleHandler consoleHandler = new ConsoleHandler();
        SimpleFormatter simpleFormatter = new SimpleFormatter();
        consoleHandler.setFormatter(simpleFormatter);
        FileHandler fileHandler = new FileHandler("./resource/log/jul.log");
        fileHandler.setFormatter(simpleFormatter);

        logger.addHandler(consoleHandler);
        logger.addHandler(fileHandler);
        logger.setLevel(Level.ALL);
        consoleHandler.setLevel(Level.ALL);
        fileHandler.setLevel(Level.ALL);

        logger.config("config");
        logger.fine("fine");
        logger.finer("finer");
        logger.finest("finest");

        //通过配置文件
        InputStream ins = utilLogDemo.class.getClassLoader().getResourceAsStream("log/logging.properties");
        LogManager logManager = LogManager.getLogManager();
        logManager.readConfiguration(ins);

        Logger logger2 = Logger.getLogger("test.Main");
        logger2.config("config");
        logger2.fine("fine");
        logger2.finer("finer");
        logger2.finest("finest");
    }
}
