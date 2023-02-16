package Tool;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * The type Calculate.
 */
public class Calculate implements MyTool {
    /**
     * 输出你出生了多久
     *
     * @throws ParseException the parse exception
     */
    public static void birth() throws ParseException{
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入出生年份： ");
        int year = scanner.nextInt();
        System.out.print("请输入出生月份： ");
        int month = scanner.nextInt();
        System.out.print("请输入出生日： ");
        int day = scanner.nextInt();

        String y = String.valueOf(year);

        DecimalFormat df = new DecimalFormat("00");
        String m = df.format(month);
        String d = df.format(day);

        String day_str = year + "-" + m + "-" + day;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date birthdate = sdf.parse(day_str);
        long diff = System.currentTimeMillis() - birthdate.getTime();
        System.out.println("----------------------------------------------------------------");
        System.out.println("你当前" + String.valueOf(diff / 1000 / 60 / 60 / 24 / 365) + "岁");
        System.out.println("你已经度过：" + Convert.millisecond_to_time(diff));
    }
}
