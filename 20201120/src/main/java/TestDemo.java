import java.util.Scanner;

public class TestDemo {
    public static void main(String[] args) {
        //一行，逆序输出输入的10个整数，用空格分隔。
        Scanner sc=new Scanner(System.in);
        int[] array=new int[10];
        for(int i=0;i<10;i++){
            int n=sc.nextInt();
            array[i]=n;
        }
        //现在打印出来
        for(int i=9;i>=0;i--){
            System.out.print(array[i]+" ");
        }
    }
}
