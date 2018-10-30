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
        for( int i = 0 ; i < N ; i ++ )
            maxHeap.insert( new Integer((int)(Math.random() * M)) );
        System.out.println(maxHeap.size());
    }

}

