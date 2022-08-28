package com.company;
import java.util.*;

public class SortThread  extends Thread {
    public ArrayList<Double> arrayList;
    private Double[] array;
    public SortThread(ArrayList<Double> array){
        arrayList = array;
    }
    @Override
    public void run(){
        try{
            Double key;
            Integer j;
            array = new Double[arrayList.size()];
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
            arrayList = new ArrayList<Double>();
            for (int f = 0; f < array.length; f++) {
                arrayList.add(array[f]);
            }
        }
        catch(Exception e){
            System.out.println("Thread name = "+ Thread.currentThread().getName()+" "+e.getMessage());
        }
    }
}
