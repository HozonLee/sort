//直接插入排序(Insertion Sort)的基本思想是：每次将一个待排序的记录，
//按其关键字大小插入到前面已经排好序的子序列中的适当位置，直到全部记录插入完成为止。

//设数组为a[0…n-1]。
//1. 初始时，a[0]自成1个有序区，无序区为a[1..n-1]。令i=1
//2. 将a[i]并入当前的有序区a[0…i-1]中形成a[0…i]的有序区间。
//3. i++并重复第二步直到i==n-1。排序完成。
//下面给出严格按照定义书写的代码（由小到大排序）：

void Insertsort1(int a[], int n)  
{  
    int i, j, k;  
    for (i = 1; i < n; i++)  
    {  
        //为a[i]在前面的a[0...i-1]有序区间中找一个合适的位置  
        for (j = i - 1; j >= 0; j--)  
            if (a[j] < a[i])  
                break;  
  
        //如找到了一个合适的位置  
        if (j != i - 1)  
        {  
            //将比a[i]大的数据向后移  
            int temp = a[i];  
            for (k = i - 1; k > j; k--)  
                a[k + 1] = a[k];  
            //将a[i]放到正确位置上  
            a[k + 1] = temp;  
        }  
    }  
}  

//这样的代码太长了，不够清晰。现在进行一下改写，将搜索和数据后移这二个步骤合并。
//即每次a[i]先和前面一个数据a[i-1]比较，如果a[i] > a[i-1]说明a[0…i]也是有序的，无须调整。
//否则就令j=i-1,temp=a[i]。然后一边将数据a[j]向后移动一边向前搜索，
//当有数据a[j]<a[i]时停止并将temp放到a[j + 1]处。
void Insertsort2(int a[], int n)  
{  
    int i, j;  
    for (i = 1; i < n; i++)  
        if (a[i] < a[i - 1])  
        {  
            int temp = a[i];  
            for (j = i - 1; j >= 0 && a[j] > temp; j--)  
                a[j + 1] = a[j];  
            a[j + 1] = temp;  
        }  
} 

//再对将a[j]插入到前面a[0…j-1]的有序区间所用的方法进行改写，用数据交换代替数据后移。如果a[j]前一个数据a[j-1] > a[j]，
//就交换a[j]和a[j-1]，再j--直到a[j-1] <= a[j]。
//这样也可以实现将一个新数据新并入到有序区间。
void Insertsort3(int a[], int n)  
{  
    int i, j;  
    for (i = 1; i < n; i++)  
        for (j = i - 1; j >= 0 && a[j] > a[j + 1]; j--)  
            Swap(a[j], a[j + 1]);  
}  
