public class Heap {
    public ArrayList<Integer> heap = null;
    public int size = 0;
    public boolean MIN_HEAP = true;
    public static final int MAX_HEAP = 1;

    public Heap(ArrayList<Integer> array, int heapType) {
        heap = array.clone();
        size = heap.length;
        if (heapType == MAX_HEAP) {
            MIN_HEAP = false;
        }
    }

    public Heap(int heapType) {
        heap = new ArrayList<>();
        if (heapType == MAX_HEAP) {
            MIN_HEAP = false;
        }
    }

    private static void swap(int idxA, int idxB) {
        int temp = heap.get(idxA);
        heap.set(idxA, heap.get(idxB));
        heap.set(idxB, temp);
    }

    public void heapify() {
    }

    public void insert(int item) {
        heap.add(item);
        if (MIN_HEAP) {
            percolateMin(heap.size()-1);
        } else {
            percolateMax(heap.size()-1);
        }
    }

    public int getParent(int idx) {
        if (idx % 2 == 1) {
            return idx/2;
        } else {
            return (idx/2)-1;
        }
    }

    public void percolateMin(int idx) {
        int parentIdx = getParent(idx);
        while(heap.get(parentIdx) > heap.get(idx)) {
            swap(parentIdx, idx);
            idx = parentIdx;
            parentIdx = getParent(idx);
        }
    }

    public void percolateMax(int idx) {
        int parentIdx = getParent(idx);
        while(heap.get(parentIdx) < heap.get(idx)) {
            swap(parentIdx, idx);
            idx = parentIdx;
            parentIdx = getParent(idx);
        }
    }

}
