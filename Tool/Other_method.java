package Tool;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Other_method implements MyTool {

    /**
     *
     * @param list
     * @param value
     * @return 迭代的方式用二分法查找集合中的元素
     */
    public static int listBinarySearch01(List<Integer> list,int value){
        int low  = 0;
        int high = list.size() - 1;
        while (low <= high){
            int mid = (low + high) / 2;
            if(value == list.get(mid)){
                return mid;
            }
            else if(value > list.get(mid)){
                low = mid + 1;
            }
            else {high = mid - 1;}
        }
        return -1;
    }


    /**
     *
     * @param list
     * @param value
     * @param low
     * @param high
     * @return 递归的方式用二分法查找集合中的元素
     */
    public static int listBinarySearch02(List<Integer> list, int value, int low, int high){
        if (low <= high) {
            int mid = (low + high) / 2;
            if(value == list.get(mid)){
                return mid;
            }
            else if(value < list.get(mid)){
                return listBinarySearch02(list,value,low,mid - 1);
            }
            else {
                return listBinarySearch02(list,value,mid + 1,high);
            }
        }
        return -1;
    }

    /**
     *
     * @param list
     * @return 采用递归合并排序一个整数列表
     */
    public static List myMergesort(List<Integer> list){
        if(list.size() == 1) return list;
        int mid = (list.size() - 1) / 2;
        List<Integer> list1 = new LinkedList<Integer>();
        List<Integer> list2 = new LinkedList<Integer>();
        for (int i = 0; i < mid + 1; i++) {
            list1.add(list.get(i));
        }
        for (int i = mid + 1; i < list.size(); i++) {
            list2.add(list.get(i));
        }
        list1 = myMergesort(list1);
        list2 = myMergesort(list2);
        List<Integer> returnList = new LinkedList<Integer>();
        while (list1.size() > 0 && list2.size() > 0){
            if(list1.get(0) < list2.get(0)){
                returnList.add(list1.get(0));
                list1.remove(0);
            }
            else{
                returnList.add(list2.get(0));
                list2.remove(0);
            }
        }
        while (list1.size() > 0){
            returnList.addAll(list1);
            list1.clear();
        }
        while (list2.size() > 0) {
            returnList.addAll(list2);
            list2.clear();
        }
        return returnList;
    }

     /**  用于查看程序执行时间 */
//    long start= System.currentTimeMillis();   /*开始时间*/
//    System.out.println("-----------程序执行时间为：" + (System.currentTimeMillis() - start) +"毫秒---------------");

    /**
     * 产生随机数，seed要设置成-1
     */
     public static int generateRandom(int min, int max, int seed) {
         Random generator = new Random();
         if(seed>=0){
             generator.setSeed(seed);
         }
         int i = generator.nextInt(max-min-1);
         return i+min+1;
     }








}
