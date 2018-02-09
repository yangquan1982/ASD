package framework.recommendation;

import java.util.HashMap;
import java.util.Map;

public class HeapSort<T extends Comparable<? super T>>{
    private T[] a;
    private int n;
    private int left;
    private int right;
    private int largest;
    
    // Build-Heap Function
    public void buildheap(T[] a) {
        n = a.length - 1;
        for (int i = n / 2; i >= 0; i--) {
            //System.out.println(i);
            maxheap(a, i);
        }
    }
    
    // Max-Heap Function
    public void maxheap(T[] a, int i) {
        left = 2 * i;
        right = 2 * i + 1;
        //System.out.println(i + " " + left + " " + right);
        if (left <= n && (a[left].compareTo(a[i])>0)) {
            largest = left;
        }
        else {
            largest = i;
        }
        if (right <= n && a[right].compareTo(a[largest])>0) {
            largest = right;
        }
        if (largest != i) {
            exchange(i, largest);
            maxheap(a, largest);
        }
    }
    // Exchange Function
    public void exchange(int i, int j) {
        T t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    // Sort Function
    public void sort(T[] a0) {
        a = a0;
        buildheap(a);
        for (int i = n; i > 0; i--) {
            exchange(0, i);
            n = n - 1;
            maxheap(a, 0);
        }
    }
    
    // Sort Function
    public Map<Integer,T> sort(T[] a0, SortType sortType) {
        Map<Integer, T> map = new HashMap<Integer, T>();
        //T[]a = a0;
        //buildheap(a);
        for (int i = n; i > 0; i--) {
            exchange(0, i);
            n = n - 1;
            //maxheap(a, 0);
        }
        return map;
    }
    
    public T[] getA() {
        return a;
    }

    public void setA(T[] a) {
        this.a = a;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public int getLargest() {
        return largest;
    }

    public void setLargest(int largest) {
        this.largest = largest;
    }

    public static void main(String[] args) {
        HeapSort<Integer> heap = new HeapSort<Integer>();
        Integer[] a1 = { 3, 5, 1, 2, 4 };
        heap.sort(a1);
        for (int i = 0; i < a1.length; i++) {
            System.out.print(a1[i] + " ");
        }
    }
}