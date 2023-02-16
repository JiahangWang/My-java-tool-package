package Tool;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * The type Logger.
 */
public class Logger implements MyTool {

    /**
     * Log.
     *
     * @param msg the msg
     */
    public static void log(String msg){
        // 保存最原始的输出流
        PrintStream out = System.out;
        try {
            // 标准输出流指向日志文件
            PrintStream printStream = new PrintStream(new FileOutputStream("log.txt",true));
            // 改变输出方向
            System.setOut(printStream);
            // 日期格式化
            Date nowTime = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
            String timeStr = sdf.format(nowTime);
            System.out.println(timeStr + ": " + msg);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // 将标准输出流重定向至控制台
        System.setOut(out);
    }

    /**
     * Log to desktop.
     */
    public static void logToDesktop(){
        FileOperation.copyFile(new File("log.txt"),new File("C:\\Users\\Jiahang Wang\\Desktop"));
    }

    /**
     * 指定延迟后按照指定周期记录字符串到日志文件中
     *
     * @param delay   the delay
     * @param period  the period
     * @param message the message
     */
    public static void loggerSchedule(long delay, long period,String message){
        Timer timer = new Timer(true);
        timer.schedule(new MyTimerTask(message),delay,period);
    }

}

/**
 * The type My timer task.
 */
class MyTimerTask extends TimerTask {

    /**
     * The Message.
     */
    String message;

    /**
     * Instantiates a new My timer task.
     *
     * @param message the message
     */
    public MyTimerTask(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        Logger.log(message);
    }
}
