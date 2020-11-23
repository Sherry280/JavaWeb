import java.util.Scanner;

public class Main {
    //采用快排的思想来找到第K大的数字
    public int findKth(int[] a, int n, int K) {






        return 0;
    }




    //把字符串B插入到A中，判断能否让A字符串成为一个回文结构的
    //A=aba      B=b
    //插入位置总共有字符串的个数+1个位置，然后判断哪一种能成为回文
    public static final String LOWER_CASE_LETTER="^[a-z]+$";
    private static boolean verification(String a,String b){
        if(a.matches(LOWER_CASE_LETTER)&&b.matches(LOWER_CASE_LETTER)&&a.length()<100&&b.length()<100){
            return true;
        }
        return false;
    }


    private static boolean isHuiwen(String str){
        int left=0;
        int right=str.length()-1;
        while(left<right){
            if(str.charAt(left)!=str.charAt(right)){
                return false;
            }
            left++;
                    right--;

        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //System.out.println("请输入字符串A：");
        String A=sc.nextLine();
        //System.out.println("请输入字符串B：");
        String B=sc.nextLine();

        if(!verification(A,B)){
            System.out.println("输入的字符串不合法！");
            return;
        }
        //计算回文的个数
        int count=0;
        for(int i=0;i<A.length();i++){
            StringBuilder sb=new StringBuilder(A);
            sb.insert(i,B);
            if(isHuiwen(sb.toString())){
                count++;
            }
        }
        System.out.println(count);


        //现在计算s1字符串的长度


//        int sum=s1.length()+1;
//        //判断每一种插入位置是否可以组成回文
//        //怎样将B字符串插进A字符串中呢？
//        for(int i=0;i<sum-1;i++){
//
//            char c = s1.charAt(i);//可以得出s1的字符串中的每一个
//
//        }








        //System.out.println("hello world");




    }
}
