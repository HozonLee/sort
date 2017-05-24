//冒泡排序是非常容易理解和实现，，以从小到大排序举例：
//设数组长度为N。
//1．比较相邻的前后二个数据，如果前面数据大于后面的数据，就将二个数据交换。
//2．这样对数组的第0个数据到N-1个数据进行一次遍历后，最大的一个数据就“沉”到数组第N-1个位置。
//3．N=N-1，如果N不为0就重复前面二步，否则排序完成。
//冒泡排序1  
void BubbleSort1(int a[], int n)  
{  
       int i, j;  
       for (i = 0; i < n; i++)  
              for (j = 1; j < n - i; j++)  
                     if (a[j - 1] > a[j])  
                            Swap(a[j - 1], a[j]);  
}  

//下面对其进行优化，设置一个标志，如果这一趟发生了交换，则为true，否则为false。明显如果有一趟没有发生交换，说明排序已经完成。
//冒泡排序2  
void BubbleSort2(int a[], int n)  
{  
       int j, k;  
       bool flag;  
  
       k = n;  
       flag = true;  
       while (flag)  
       {  
              flag = false;  
              for (j = 1; j < k; j++)  
                     if (a[j - 1] > a[j])  
                     {  
                            Swap(a[j - 1], a[j]);  
                            flag = true;  
                     }  
              k--;  
       }  
}  

//再做进一步的优化。如果有100个数的数组，仅前面10个无序，后面90个都已排好序且都大于前面10个数字，那么在第一趟遍历后，
//最后发生交换的位置必定小于10，且这个位置之后的数据必定已经有序了，记录下这位置，第二次只要从数组头部遍历到这个位置就可以了。
//冒泡排序3  
void BubbleSort3(int a[], int n)  
{  
    int j, k;  
    int flag;  
      
    flag = n;  
    while (flag > 0)  
    {  
        k = flag;  
        flag = 0;  
        for (j = 1; j < k; j++)  
            if (a[j - 1] > a[j])  
            {  
                Swap(a[j - 1], a[j]);  
                flag = j;  
            }  
    }  
}  
