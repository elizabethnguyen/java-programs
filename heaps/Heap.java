import java.util.*;
import java.util.stream.Collectors;
// TODO: fix discrepancies between percolate and heapify?? heapsort.
public class Heap {
    public ArrayList<Integer> heap = null;
    public boolean MIN_HEAP = true;
    public static final int MAX_HEAP = 1;

    public Heap(int heapType) {
        heap = new ArrayList<>();
        if (heapType == MAX_HEAP) {
            MIN_HEAP = false;
        }
    }

    public Heap(ArrayList<Integer> data, int heapType) {
        heap = new ArrayList<Integer>(data);
        if (heapType == MAX_HEAP) {
            MIN_HEAP = false;
        }
    }

    public Heap(int[] data, int heapType) {
        intArrayToArrayList(data);
        if (heapType == MAX_HEAP) {
            MIN_HEAP = false;
        }
    }

    private void intArrayToArrayList(int[] data) {
        heap = new ArrayList<Integer>();

        for (int i = 0; i < data.length; i++) {
            heap.add(data[i]);
        }
    }

    public int size() {
        return heap.size();
    }

    private void swap(int idxA, int idxB) {
        int temp = heap.get(idxA);
        heap.set(idxA, heap.get(idxB));
        heap.set(idxB, temp);
    }

    private void heapify(int idx) {
        if (MIN_HEAP) {
            minHeapify(idx);
        } else {
            maxHeapify(idx);
        }
    }

    private void maxHeapify(int parentIdx) {
        int largestIdx = 0;
        int leftIdx = getLeftChild(parentIdx);
        int rightIdx = getRightChild(parentIdx);

        if (leftIdx < heap.size() && heap.get(leftIdx) > heap.get(parentIdx)) {
            largestIdx = leftIdx;
        } else {
            largestIdx = parentIdx;
        }

        if (rightIdx < heap.size() && heap.get(rightIdx) > heap.get(largestIdx)) {
            largestIdx = rightIdx;
        }

        if (largestIdx != parentIdx) {
            swap(largestIdx, parentIdx);
            heapify(largestIdx);
        }
    }

    private void minHeapify(int parentIdx) {
        int smallestIdx = 0;
        int leftIdx = getLeftChild(parentIdx);
        int rightIdx = getRightChild(parentIdx);

        if (leftIdx < heap.size() && heap.get(leftIdx) < heap.get(parentIdx)) {
            smallestIdx = leftIdx;
        } else {
            smallestIdx = parentIdx;
        }

        if (rightIdx < heap.size() && heap.get(rightIdx) < heap.get(smallestIdx)) {
            smallestIdx = rightIdx;
        }

        if (smallestIdx != parentIdx) {
            swap(smallestIdx, parentIdx);
            heapify(smallestIdx);
        }
    }

    public void buildHeap() {
        int length = heap.size();
        for (int i = length/2; i >= 0; i--) {
            heapify(i);
        }
    }

    public void insert(int item) {
        heap.add(item);
        percolate(heap.size()-1);
    }

    public int pop() {
        if (heap.isEmpty()) {
            throw new EmptyStackException();
        } else if (heap.size() == 1) {
            int retVal = heap.get(0);
            heap.remove(0);
            return retVal;
        } else {
            int retVal = heap.get(0);
            swap(0, heap.size()-1);
            heap.remove(heap.size()-1);
            heapify(0);
            return retVal;
        }
    }

    private int getParent(int idx) {
        if (idx % 2 == 1) {
            return idx/2;
        } else {
            return (idx/2)-1;
        }
    }

    private int getLeftChild(int idx) {
        return 2*idx + 1;
    }

    private int getRightChild(int idx) {
        return 2*idx + 2;
    }

    private void percolate(int idx) {
        if (MIN_HEAP) {
            percolateMin(heap.size()-1);
        } else {
            percolateMax(heap.size()-1);
        }
    }

    private void percolateMin(int idx) {
        int parentIdx = getParent(idx);
        while(parentIdx >= 0 && (heap.get(parentIdx) > heap.get(idx))) {
            swap(parentIdx, idx);
            idx = parentIdx;
            parentIdx = getParent(idx);
        }
    }

    private void percolateMax(int idx) {
        int parentIdx = getParent(idx);
        while(parentIdx >= 0 && (heap.get(parentIdx) < heap.get(idx))) {
            swap(parentIdx, idx);
            idx = parentIdx;
            parentIdx = getParent(idx);
        }
    }

    public String toString() {
        if (heap.size() == 0) {
            return "[]";
        } else if (heap.size() == 1) {
            return "[" + heap.get(0) + "]";
        } else {
            int level = 2;
            int pow = (int) Math.pow(2, level) - 1;
            String heapString = "[" + heap.get(0) +"]\n[";

            for (int i = 1; i < heap.size(); i++) {
                if (i == pow) {
                    heapString += "]\n[";
                    level++;
                    pow = (int) Math.pow(2, level) - 1;
                }
                heapString += heap.get(i);
                if (i != pow-1 && i != heap.size() - 1) {
                    heapString += " ";
                }
            }
            return heapString + "]";
        }
    }

}
