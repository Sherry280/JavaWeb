package Niuke;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        double[] array=new double[5];
        double sum=0.0;
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                array[j]=sc.nextDouble();
                sum+=array[j];
            }
            for(int m=0;m<5;m++){
                System.out.println(array[i]+" ");
            }
            System.out.print(sum);
        }

    }



    //输入两个升序排列的序列，将两个序列合并为一个有序序列并输出。
    //5 6
    //1 3 7 9 22
    //2 8 10 17 33 44
    public static void main4(String[] args) {
        List<Integer> list=new ArrayList<>();
        Scanner sc=new Scanner(System.in);
        int n1=sc.nextInt();
        int n2=sc.nextInt();
        for(int i=0;i<n1+n2;i++){
           int n=sc.nextInt();
           list.add(n);
        }

        Collections.sort(list);
        for(Integer i:list){
            System.out.print(i+" ");
        }

//        int[] array1=new int[n1];
//        for(int i:array1){
//            array1[i]=sc.nextInt();
//        }

//        for(int i=0;i<n2;i++){
//            int n=sc.nextInt();
//            list.add(n);
//        }

        Object[] objects=list.toArray();
        Arrays.sort(objects);
        List<Object> atrArray=Arrays.asList(objects);
        System.out.println(atrArray);
//        List<Integer> list1=new ArrayList<>();
//        Collections.addAll(list1, new Object[][]{objects});
//
        //System.out.println(Arrays.toString(objects));


//        int[] array2=new int[n2];
//        for(int j:array2){
//            array2[j]=sc.nextInt();
//        }

//        int[] array3=new int[n1+n2];
//        for(int i=0;i<array3.length;i++){
//            //将数组1和数组2都放进数组3中
//
//        }
//



    }
}
