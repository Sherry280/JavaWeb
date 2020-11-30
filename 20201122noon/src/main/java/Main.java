import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s1=sc.nextLine();
        String s2=sc.nextLine();

        String ss="";
        Set<Character> set=new TreeSet<>();
        for(char ch:s2.toCharArray()){
            set.add(ch);
        }
        for(int i=0;i<s1.length();i++){
            if(!set.contains(s1.charAt(i))){
                ss+=s1.charAt(i);
            }
        }
        System.out.println(ss);
//        for (int i=0;i<ss.length();i++){
//            System.out.print(ss.charAt(i));
//        }

    }

    private static String removeSameLetter(String s1,String s2){
        String ss="";
        for(int i=0;i<s1.length();i++){
            for(int j=0;j<s2.length();j++){
                if(s1.charAt(i)!=s2.charAt(j)){
                    ss+=s1.charAt(i);
                }
            }
        }
        return ss;
    }

    public static void main3(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s1=sc.nextLine();
        String s2=sc.nextLine();
        String[] ss=s1.split("");
        System.out.println(Arrays.toString(ss));

//        String s = removeSameLetter(s1, s2);
//
//        for(int i=0;i<s.length();i++){
//            System.out.print(s.charAt(i));
//        }

    }

    public static void main2(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s1=sc.nextLine();
        String s2=sc.nextLine();

        Set<Character> set1=new TreeSet<>();
        //Set<Character> set2=new TreeSet<>();

//       for(char ch:s2.toCharArray()){
//           set2.add(ch);
//       }
        //输入的字符串
       for(char ch:s1.toCharArray()){
           set1.add(ch);

       }
       //遍历删除的s2字符串
       for(char ch:s2.toCharArray()){
           if(set1.contains(ch)){
               set1.remove(ch);

           }
       }
       Object[] array=set1.toArray();
        System.out.println(Arrays.toString(array));


    }










    //采用快排的思想来找到第K大的数字
    public int findKth(int[] a, int n, int K) {

        return 0;
    }


    //判断合法的括号
    public boolean chkParenthesis(String A, int n) {
        if(n%2!=0){
            return false;
        }
        //准备一个放字符的栈
        Deque<Character> stack=new LinkedList<>();
        //现在要进行字符串的遍历
        for(int i=0;i<A.length();i++){
            char c=A.charAt(i);
            switch (c){
                case '(':
                case '[':
                case '{':
                    stack.push(c);
                    break;
                default:{
                    //现在为右括号
                    if(stack.isEmpty()){
                        return false;
                    }
                    char left=stack.pop();
                    if(!compareBracket(left,c)){
                        return false;
                    }
                }
            }
        }
        if(stack.isEmpty()){
            return true;
        }
        return false;
    }
    private boolean compareBracket(char left,char right){
        if(left=='('&&right==')'){
            return true;
        }
        if(left=='{'&&right=='}'){
            return true;
        }
        if(left=='['&&right==']'){
            return true;
        }
        return false;
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
    public static void main1(String[] args) {
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
