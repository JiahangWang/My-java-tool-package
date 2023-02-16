package Tool;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Convert implements MyTool {
    /**
     输入一个文件路径，输出反斜杠被转换后的结果
     */
    public static void pathConvert(){
        System.out.println("请输入想要转换的路径：");
        java.util.Scanner s = new Scanner(System.in);
        String inputStr = s.nextLine();
        StringBuilder outStr = new StringBuilder();

        for (int i = 0; i < inputStr.length(); i++) {
            String tmp = inputStr.substring(i,i+1);
            if(tmp.equals("\\")){
                tmp = "/";
            }
            outStr.append(tmp);
        }

        System.out.println("转换路径为:\n" + outStr);
    }

    /**
     *
     * @param ask
     * @return 返回反斜杠被转换后的结果
     */
    public static String FilePathConvert(String ask){
        System.out.println(ask);
        java.util.Scanner s = new Scanner(System.in);
        String inputStr = s.nextLine();
        StringBuilder outStr = new StringBuilder();

        for (int i = 0; i < inputStr.length(); i++) {
            String tmp = inputStr.substring(i,i+1);
            if(tmp.equals("\\")){
                tmp = "/";
            }
            outStr.append(tmp);
        }

        return outStr.toString();
    }


    /**
     * 修改excel产生的逻辑表达式供Logisim使用。
     */
    public static void logicConvert(){
        System.out.println("请输入想要修改的逻辑表达式：");
        java.util.Scanner s = new Scanner(System.in);
        String inputStr = s.nextLine();
        StringBuilder outStr = new StringBuilder();

        boolean judge = false;

        for (int i = 0; i < inputStr.length(); i++) {
            String tmp = inputStr.substring(i,i+1);
            if(tmp.equals("+")){
                judge = true;
                tmp = ")+(";
            }
            outStr.append(tmp);
        }

        if(judge){
            outStr = new StringBuilder("(" + outStr);
            outStr.append(")");
        }

        System.out.println("修改的逻辑表达式为:\n" + outStr);
    }

    /**
     *
     * @param time
     * @return 毫秒数转换后的时间
     */
    public static String millisecond_to_time(long time){
        long day = TimeUnit.MILLISECONDS.toDays(time);
        long hours = TimeUnit.MILLISECONDS.toHours(time) - TimeUnit.DAYS.toHours(TimeUnit.MILLISECONDS.toDays(time));
        long minutes = TimeUnit.MILLISECONDS.toMinutes(time) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(time));
        long sec = TimeUnit.MILLISECONDS.toSeconds(time) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(time));
        long ms = TimeUnit.MILLISECONDS.toMillis(time) - TimeUnit.SECONDS.toMillis(TimeUnit.MILLISECONDS.toSeconds(time));
        return day + "天 " + hours + "小时 " + minutes + "分钟 " + sec + "秒 " + ms + "毫秒 ";
    }

}
