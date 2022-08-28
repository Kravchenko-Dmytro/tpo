package com.company;
import java.awt.List;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Double>data= new ArrayList<Double>();
        ArrayList<Double> result=new ArrayList<Double>();
        try{
            BufferedReader reader = new BufferedReader(new FileReader("C://Users//1234//Desktop//input.txt"));
            String s;
            while ((s = reader.readLine()) != null) {
                data.add(Double.parseDouble(s));
            }
            reader.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        long time = System.currentTimeMillis();
        Double max=0.0;
        Double min=100000.0;
        int nthread=4;
        for(Double i:data){
            if(i<min){
                min=i;
            }
            if(i>max){
                max=i;
            }
        }
        ArrayList<Sort>sorts=new ArrayList<Sort>();
        ArrayList<ArrayList<Double>>bucket= new ArrayList<ArrayList<Double>>();
        for(int i=0;i<nthread;i++){
            bucket.add(new ArrayList<Double>());
        }
        int i=(int) Math.ceil((max-min+1)/nthread);
        for (Double j : data){
            bucket.get((int) Math.floor((j-min)/i)).add(j);
        }
        for( i=0;i<nthread;i++) {
            Sort sort = new Sort(bucket.get(i));
            sort.sort();
            sorts.add(sort);
        }
        for (Sort s : sorts) {
            try {
                result.addAll(s.arrayList);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(System.currentTimeMillis() - time);
        try {
            PrintWriter writer=new PrintWriter("C://Users//1234//Desktop//output.txt");
            for(Double r:result){
                writer.println(r);
            }
            writer.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        Test test = new Test(data,result);
        test.test();
	}
}
class Test{
    ArrayList<Double>arrayList1,arrayList2;
    Double d;
    public Test(ArrayList<Double> array1,ArrayList<Double> array2){
        arrayList1=array1;
        arrayList2=array2;
    }
    void test(){
        Collections.sort( arrayList1);
        if (arrayList1.equals(arrayList2)){
            System.out.println("Test passed");
        }
        else {
            System.out.println("Test did not pass");
        }
    }
}