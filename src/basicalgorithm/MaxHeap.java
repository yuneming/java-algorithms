package basicalgorithm;

/**
 * 创建最大推
 */
public class MaxHeap<Item> {
    private Item[] data;
    private int count;
    public MaxHeap(int capicity){
        data = (Item[])new Object[capicity+1];
        count = 0;
    }
    public int size(){
        return count;
    }
}
