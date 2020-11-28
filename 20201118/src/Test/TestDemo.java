package Test;

import java.util.Scanner;

public class TestDemo {
    public static void main(String[] args) {
        MyQueue myQueue=new MyQueue();
        myQueue.push(9);
        myQueue.push(8);
        myQueue.push(3);

        System.out.println(myQueue.peek());
    }



        public static void main2(String[] args) {
            Scanner sc=new Scanner(System.in);
            int n=sc.nextInt();
            int m=sc.nextInt();
            int[][] arr=new int[n+1][m+1];
            int a=0,b=0,max=0;
            for (int i=1;i<=n;i++){
                for (int j=1;j<=m;j++){
                    arr[i][j]=sc.nextInt();
                    if(arr[i][j]>max){
                        max=arr[i][j];
                        a=i;
                        b=j;
                    }
                }
            }
            System.out.print(a+" "+b);
        }

    private static int sumMethods(int n, int[] array){

        int sum=0;
        for(int i=0;i<array.length;i++){
            sum+=array[i];
        }
        if(sum<40){
            System.out.println(0);

        }else{

        }
        return 0;
    }
    public static void main1(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] array=new int[n];
        for(int i=0;i<array.length;i++){
            int nn=sc.nextInt();
            array[i]=nn;
        }
        System.out.println(sumMethods(3, array));


        //现在要怎样进行挑选，让n个物品的体积之和为40呢？
            //1.所有n的和小于40，那么就直接退出
            //2.
//         while(sc.hasNext()){
//            int w=sc.nextInt();


        }
}
