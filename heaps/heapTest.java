public class heapTest {
    public static final int MIN_HEAP = 0;
    public static final int MAX_HEAP = 1;

    public static void main(String[] args) {

        int[] data = new int[]{5, 12, 15, 0, -5, 2, 18, 21, 1};

        Heap heap = new Heap(data, MIN_HEAP);
        System.out.println("BUILDING HEAP");
        heap.buildHeap();
        System.out.println(heap);
        System.out.println();
        System.out.println();
        int size = heap.size();
        for (int i = 0; i < size; i++) {
            System.out.println("Popped " + heap.pop());
            System.out.println(heap);
            System.out.println();
        }
    }

}
