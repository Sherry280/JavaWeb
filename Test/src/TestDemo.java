import javax.xml.soap.Node;
import java.util.*;

public class TestDemo {
    public static void main(String[] args) {

    }
    public static void main5(String[] args) {
        Scanner sc=new Scanner(System.in);
        LinkedHashSet<Integer> set=new LinkedHashSet<Integer>();
        while(sc.hasNext()){
            int n=sc.nextInt();
            int[] array=new int[n];
            for(int i=0;i<n;i++){
                array[i]=sc.nextInt();
            }
            for(int i=0;i<array.length;i++){
                set.add(array[i]);
            }
            for(int e:set){
                System.out.print(e+" ");
            }
        }


//        Set<Integer> set=new TreeSet<>();
//        Scanner sc=new Scanner(System.in);
//        while(sc.hasNext()){
//            int n=sc.nextInt();
//            set.add(n);
//        }
//        System.out.println(set);
    }
//第一行输入一个整数(0≤N≤50)。
//第二行输入N个整数，输入用空格分隔的N个整数。
//第三行输入想要进行删除的一个整数。
    public static void main3(String[] args) {
        Scanner sc=new Scanner(System.in);
        List<Integer> list=new ArrayList<>();
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            int nn=sc.nextInt();
            list.add(nn);
        }
        //现在要进行遍历找到要删除的数字
        //1.找到数字  2.没有找到要删除的数字
        int s=sc.nextInt();
        for(int i=0;i<list.size();i++){
            if(list.get(i)==s){
                list.remove(i);
            }
        }
        for(Integer e:list){
            System.out.print(e+" ");
        }

//for (int i = 0; i < list.size(); i++) {
//        if(list.get(i)==m) {
//            list.remove(i);




    }

    //输入一个整数序列，判断是否是有序序列，有序，指序列中的整数从小到大排序或者从大到小排序。
    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            int nn = sc.nextInt();
            array[i] = nn;

        }
        //1  5  9  3  2
        //现在要进行构建一个升序和降序的数组
        int[] n1=Arrays.copyOf(array,array.length);//升序
        //int[] n2=Arrays.copyOf(array,array.length);//降序
        Arrays.sort(n1);

        for(int start=0, end=n1.length-1;start<end;start++,end--){
             int tmp=n1[end];
            n1[end]=n1[start];
             n1[start]=tmp;
        }
        //System.out.println(Arrays.toString(n1));
        int[] n2=Arrays.copyOf(n1,n1.length);
        Arrays.sort(n1);

        if(Arrays.equals(array,n1)){
            System.out.println("sorted");
        }else if(Arrays.equals(array,n2)){
            System.out.println("sorted");
        }else{
            System.out.println("unsorted");
        }



//        //现在要进行判断是否为有序序列
//      for(int i=1;i<array.length;i++){
//          if(array[i]>array[i-1]){
//             continue;
//          }
//          //不知道怎样判断才能停下来
//
//      }


        //for (int i = 0; i < array.length; i++) {
//            for (int j = 0; j < array.length; j++) {
//               if((array[j] > array[j + 1]) || array[j] < array[j + 1]) {
//                    System.out.println("sorted");
//                } else {
//                    System.out.println("unsorted");
//                }
//            }
        //}
    }
}
