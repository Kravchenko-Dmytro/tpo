package com.company;
import java.util.*;

public class SortThread  extends Thread {
    public ArrayList<Integer> arrayList;
    private Integer[] array;
    public SortThread(ArrayList<Integer> array){
        arrayList = array;
    }
    @Override
    public void run(){
        try{
            Integer key, j;
            array = new Integer[arrayList.size()];
            for (int f = 0; f < arrayList.size(); f++) {
                array[f] = arrayList.get(f);
            }
            int n = array.length;
            for (int i = 1; i < n; ++i) {
                key = array[i];
                j = i - 1;
                while (j >= 0 && array[j] > key) {
                    array[j + 1] = array[j];
                    j = j - 1;
                }
                array[j + 1] = key;
            }
            arrayList = new ArrayList<Integer>();
            for (int f = 0; f < array.length; f++) {
                arrayList.add(array[f]);
            }
        }
        catch(Exception e){
            System.out.println("Thread name = "+ Thread.currentThread().getName()+" "+e.getMessage());
        }
    }
}
