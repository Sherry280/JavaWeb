package Examse;

import java.util.*;

public class Test {
    /**
     * 输入n个整数，输出出现次数大于等于数组长度一半的数
     * @param
     */

    //用Map来存储数组中的每个元素它本身和它出现的次数
//    private static Map<Integer,Integer> sumNumber1(Object[] array){
//        Map<Integer,Integer> map=new TreeMap<Integer,Integer>();
//        for(Object ss:array){
//
//        }
//    }
    private static void sumNumber(int[] array){
        int sum=0;
        int k=0;
        for(int i=0;i<array.length;i++){
            for(int j=i+1;j<=array.length-i-1;j++){
                while(array[i]==array[j]){
                    sum++;
                    k=array[i];

                }

            }
        }
        if(sum>=array.length/2){
            System.out.println(k);
        }



    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

       // List<Integer> list=new ArrayList<Integer>();
        String s=sc.nextLine();
        String[] s1 = s.split(" ");
        int[] array=new int[s1.length];

        for(int i=0;i<s1.length;i++){
            int anInt = Integer.parseInt(s1[i]);
            array[i]=anInt;

        }
        //System.out.println(array);
        sumNumber(array);







//        while (sc.hasNext()){
//
//            list.add(sc.nextInt());
//        }

        //把所有的元素放进链表  把链表转为数组
        //Object[] objects = list.toArray();
        //
        //sumNumber(objects);



    }
    public static void main1(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n1=sc.nextInt();   //A-B
        int n2=sc.nextInt();  //B-C
        int n3=sc.nextInt();  //A+B
        int n4=sc.nextInt();   //B+C

        int A=0;
        int B=0;
        int C=0;

         A=(n1+n3)/2;
         B=(n2+n4)/2;
         C=n4+n1-A;
        if(A>0&&B>0&&C>0){
//        if((n1==A+B)&&(n2==B-C)&&(n3==A+B)&&(n4==B+C)){
           System.out.println(A+" "+B+" "+C);

        }else{
            System.out.println("No");
        }
    }
}
