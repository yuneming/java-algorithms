package basicalgorithm;

/**
 * 创建最大推
 */
// 在堆的有关操作中，需要比较堆中元素的大小，所以Item需要extends Comparable
public class MaxHeap<Item extends Comparable> {
    private Item[] data;
    private int count;
    protected int capacity;
    // 构造函数, 构造一个空堆, 可容纳capacity个元素
    public MaxHeap(int capicity){
        // 创建泛型数组
        //data = (Item[])new Object[capicity+1];
        // 创建接口对象
        data = (Item[])new Comparable[capicity+1];
        count = 0;
        this.capacity = capicity;
    }

    // 构造函数，通过一个给定数组创建一个最大堆
    // 该构造堆的过程，时间复杂读为O(n)
    public MaxHeap(Item arr[]){
        int n = arr.length;
        data = (Item[]) new Comparable[n+1];
        capacity = n;
        for (int i = 0; i < n; i++){
            data[i+1] = data[i];
        }
        count = n;
        // heapify的过程，取第一个非叶子节点依次向上调整堆
        for (int  i = count/2; i >= 1; i--){
            shiftDown(i);
        }
    }

    // 返回堆中的元素个数
    public int size(){
        return count;
    }
    // 返回一个布尔值，表示堆中是否为空
    public boolean isEmpty(){
        return count==0;
    }
    //* 最大堆核心辅助函数
    private void shiftUp(int k){
        while( k > 1 && data[k/2].compareTo(data[k]) < 0 ){
            swap(k, k/2);
            k /= 2;
        }
    }
    // 像最大堆中插入一个新的元素 item
    public void insert(Item item){
        assert count + 1 <= capacity;
        data[count+1] = item;
        count ++;
        shiftUp(count);
    }

    //从最大堆中取出堆顶元素，即堆中所存储的最大数据
    public Item extractMax(){
        assert count>0;
        Item ret = data[1];
        swap(1,count);
        count--;
        shiftDown(1);
        return ret;
    }

    private void shiftDown(int k) {
        // 左孩子的下标比总数少
        while (2*k <= count){
            // 左孩子的下标
            int j = 2*k;
            // 如果有右孩子且比左孩子大，更新j
            if (j+1 <= count && data[j+1].compareTo(data[j]) > 0){
                j++;
            }
            // 父节点大于左右自子孩子，则结束循环
            if (data[k].compareTo(data[j]) > 0){
                break;
            }
            swap(k,j);
            k = j;
        }

    }

    // 交换堆中索引为i和j的两个元素
    private void swap(int i, int j){
        Item t = data[i];
        data[i] = data[j];
        data[j] = t;
    }
    public static void main(String[] args) {

        MaxHeap<Integer> maxHeap = new MaxHeap<Integer>(100);
        int N = 50; // 堆中元素个数
        int M = 100; // 堆中元素取值范围[0, M)
        for( int i = 0 ; i < N ; i ++ ) {
            maxHeap.insert(new Integer((int) (Math.random() * M)));
        }
        System.out.println(maxHeap.size());
        Integer[] arr = new Integer[N];
        // 讲maxHeap中的数据逐渐使用extraMax取出来
        // 取出来的顺序应该是按照从大到小的顺序取出来的
        for (int i = 0; i < N; i++){
            arr[i] = maxHeap.extractMax();
            System.out.println(arr[i]+" ");
        }
        System.out.println();
        // 确保arr数组是从大到小排列的
        for (int  i = 0; i < N; i++){
            assert arr[i] >= arr[i];
        }
    }

}

