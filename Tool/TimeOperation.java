package Tool;

/**
 * The type Time operation.
 */
public class TimeOperation implements MyTool {

    /**
     * 按分钟数倒计时
     *
     * @param minutes the minutes
     */
    public static void Timer(int minutes){
        int milliseconds = minutes * 1000 * 60;
        int seconds = minutes * 60;
        System.out.println("Timing begins!");
        for (int i = 1; i <= seconds; i++) {
            System.out.println("Remaining seconds ---> " + (seconds - i));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        MyException exception = new MyException("Time is up!");
        exception.printStackTrace();
    }

    /**
     * 开启一个守护线程查看并输出用户线程执行毫秒数
     */
    public static void countMillis(){
        long start = System.currentTimeMillis();
        Thread countThread = new Thread(() -> {
            while (true){
                long current = System.currentTimeMillis() - start;
                if(current % 5 == 0) {System.out.println("当前已执行：" +current + " 毫秒");}
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        countThread.setDaemon(true);
        countThread.start();
    }

}


