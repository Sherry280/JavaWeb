package Niuke;

import java.util.*;

public class Main {
    public boolean chkParenthesis(String A, int n) {
        //1.对n进行判断是否为偶数
        if (n % 2 != 0) {
            return false;
        }
        //准备一个放字符的栈
        Deque<Character> stack = new LinkedList<>();
        //现在进行字符串的遍历
        for (int i = 0; i < A.length(); i++) {
            char c = A.charAt(i);
            switch (c) {
                case '(':
                case '[':
                case '{':
                    stack.push(c);
                    break;
                default: {
                    //一定为右括号
                    if (stack.isEmpty()) {
                        return false;
                    }
                    //取出栈顶元素
                    char left = stack.pop();
                    //进行右括号的匹配
                    if (!compareBracket(left, c)) {
                        return false;
                    }
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }


    }

    private boolean compareBracket(char left, char right) {

        if (left == '(' && right == ')') {
            return true;
        }
        if (left == '[' && right == ']') {
            return true;
        }
        if (left == '{' && right == '}') {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Main main = new Main();
        String A = "{[]()}";
        int k = 6;
        System.out.println(main.chkParenthesis(A, k));
    }


    public static void main7(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] ss = s.replaceAll("[^0-9]", ",").split(",");
        int max = 0;
        String str = "";
        for (int i = 0; i < ss.length - 1; i++) {
            // max=ss[0].length();//保留最大的值
            if (max < ss[i + 1].length()) {
                max = ss[i + 1].length();
                str = ss[i + 1];
            }
//            if(max>ss[i+1].length()){
//                System.out.println(max);
//            }else{
//                max=ss[i+1].length();
//                System.out.println(max);
//            }


        }
        System.out.println(str);
        //System.out.println(Arrays.toString(ss));
    }

    public int count(int[] A, int n) {
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = i; j < A.length; j++) {
                if (A[i] > A[j]) {
                    sum++;
                }
            }
        }
        return sum;


    }

    public static void main6(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 0};
        int n = 8;
        Main main = new Main();
        main.count(array, n);
        System.out.println(main.count(array, n));
    }


    public static void main5(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] array = new double[5];
        double sum = 0.0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                array[j] = sc.nextDouble();
                sum += array[j];
            }
            for (int m = 0; m < 5; m++) {
                System.out.println(array[i] + " ");
            }
            System.out.print(sum);
        }

    }


    //输入两个升序排列的序列，将两个序列合并为一个有序序列并输出。
    //5 6
    //1 3 7 9 22
    //2 8 10 17 33 44
    public static void main4(String[] args) {
        List<Integer> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        for (int i = 0; i < n1 + n2; i++) {
            int n = sc.nextInt();
            list.add(n);
        }

        Collections.sort(list);
        for (Integer i : list) {
            System.out.print(i + " ");
        }

//        int[] array1=new int[n1];
//        for(int i:array1){
//            array1[i]=sc.nextInt();
//        }

//        for(int i=0;i<n2;i++){
//            int n=sc.nextInt();
//            list.add(n);
//        }

        Object[] objects = list.toArray();
        Arrays.sort(objects);
        List<Object> atrArray = Arrays.asList(objects);
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

