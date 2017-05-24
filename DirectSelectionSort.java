package dataStructures;  
/**  
 * 类说明  
 * @author hozon 
 * @date 创建时间：2017年5月24日 下午15:40:29  
 */  
public class DirectSelectionSort {  
  
    //实现直接选择排序算法  
    //按从小到大的顺序排序并输出  
    public void directSelectionSort(int str[]){  
        int min = 0;        //定义一个最小值变量，用来做交换时的中间变量  
        for (int i = 0; i < str.length-1; i++) {   //注意这里数组索引越界  
            min = str[i];  
            for (int j = i+1; j < str.length; j++) {   //每一次循环都把最小的数与str[i]交换  
                if (str[i]>str[j]) {  
                    min = str[j];  
                    str[j] = str[i];  
                    str[i] = min;  
                }  
            }  
        }  
    }  
    public static void main(String[] args){  
        int str[] = {25,12,15,3,56,8,98,552};  //初始化一个数组  
        System.out.println("排序前：");  
        for (int i = 0; i < str.length; i++) {  
            System.out.print(str[i]+" ");  
        }  
        DirectSelectionSort sls = new DirectSelectionSort();  
        sls.directSelectionSort(str);          //进行排序  
        System.out.println();  
        System.out.println("排序后：");  
        for (int i = 0; i < str.length; i++) {  
            System.out.print(str[i]+" ");      //排序后输出  
        }  
    }  
}  
