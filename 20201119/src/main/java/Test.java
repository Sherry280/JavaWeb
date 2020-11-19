import java.util.Arrays;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] array=new int[n+1];
        //把输入的整数放进数组保存着
        for(int i=0;i<n;i++){
            int c=sc.nextInt();
            array[i]=c;
        }
        //输入要进行插入插入的数字
        int index=sc.nextInt();
        array[n]=index;
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
    }
    public static void main1(String[] args) {
        //两行，
        //第1行，正整数n（1≤n≤100）
        //第2行，n科成绩（范围0.0~100.0），用空格分隔。
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
       double[] array=new double[n];
        for(int i=0;i<n;i++){
            double a=sc.nextDouble();
            array[i]=a;
        }
        Arrays.sort(array);
        double sum=0;
        for(int i=0;i<array.length;i++){
            sum+=array[i];
        }
        double aver=sum/n;
        //输出一行，三个浮点数，分别表示，最高分，最低分以及平均分（小数点后保留2位），用空格分隔。
        //System.out.print("%.2f,%.2f,%.2",array[n-1],array[0],aver);
        System.out.print(String.format("%.2f",array[n-1]));
        System.out.print(" ");
        System.out.print(String.format("%.2f",array[0]));
        System.out.print(" ");
        System.out.print(String.format("%.2f",aver));

    }
}
