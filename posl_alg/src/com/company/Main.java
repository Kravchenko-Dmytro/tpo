package com.company;
import java.awt.List;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer>data= new ArrayList<Integer>();
        ArrayList<Integer> result=new ArrayList<Integer>();
        try{
            BufferedReader reader = new BufferedReader(new FileReader("C://Users//1234//Desktop//input.txt"));
            String s;
            while ((s = reader.readLine()) != null) {
                data.add(Integer.parseInt(s));
            }
            reader.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        long time = System.currentTimeMillis();
        Integer max=0;
        for(int i:data){
            if(i>max){
                max=i;
            }
        }
        ArrayList<Integer>bucket;
        bucket = new ArrayList<Integer>();
        for (int j : data) {
            if ( j < (max + 1) / 4) {
                bucket.add(j);
            }
        }
        Sort sort1 = new Sort(bucket);
        sort1.sort();
        bucket = new ArrayList<Integer>();
        for (int j : data) {
            if ((max + 1) / 4 <= j & j < (max + 1) / 2) {
                bucket.add(j);
            }
        }
        Sort sort2 = new Sort(bucket);
        sort2.sort();
        bucket = new ArrayList<Integer>();
        for (int j : data) {
            if ((max + 1) / 2 <= j & j < (max + 1)*3 / 4) {
                bucket.add(j);
            }
        }
        Sort sort3 = new Sort(bucket);
        sort3.sort();
        bucket= new ArrayList<Integer>();
        for (int j:data){
            if ((max+1)*3/4<=j ){
                bucket.add(j);
            }
        }
        Sort sort4=new Sort(bucket);
        sort4.sort();
        try {
            result.addAll(sort1.arrayList);
            result.addAll(sort2.arrayList);
            result.addAll(sort3.arrayList);
            result.addAll(sort4.arrayList);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println(System.currentTimeMillis() - time);
        try {
            PrintWriter writer=new PrintWriter("C://Users//1234//Desktop//output.txt");
            for(int i:result){
                writer.println(i);
            }
            writer.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
	}
}
