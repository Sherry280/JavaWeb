package lesson4;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Test {
    public static final double PI=3.14;

    public static void main2(String[] args) {
        Scanner sc=new Scanner(System.in);
        LinkedHashSet<Integer> set=new LinkedHashSet<>();
        int n=sc.nextInt();
        int[] array=new int[n];
        for(int i=0;i<n;i++){
            array[i]=sc.nextInt();
        }
        Arrays.sort(array);
        for (int a :
                array) {
            set.addAll(Collections.singleton(a));
        }
        for (Integer e :
                set) {
            System.out.print(e+" ");
        }
    }


    public static void main1(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int count=0;
        while(sc.hasNext()){
                int a=sc.nextInt();
                int b=sc.nextInt();
                int c=sc.nextInt();
                int avg=(a+b+c)/3;
                if(avg<60){
                    count++;
                }
        }
        System.out.println(count);
    }
}
