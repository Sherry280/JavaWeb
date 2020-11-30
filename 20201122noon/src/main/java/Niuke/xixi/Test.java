package Niuke.xixi;
import java.io.*;
import java.lang.*;
import java.util.*;
public class Test {
    public static void main(String[] args) throws IOException {
        //小乐乐从老师口中听到了二段数这个名词，想更深入的了解二段数。
        //二段数是这样的正整数：恰好包含两种不同的十进制数字s和t，s不是0，
        // 并且s的所有出现均排列在所有的t的前面。例如，44444411是二段数（s是4，t是1），
        // 41、10000000和5555556也是。但4444114和44444都不是二段数。
        //这时老师问小乐乐：给你一个任意的正整数n，你能求出比n大并且是n的倍数的最小二段数吗？
        // 请你帮助小乐乐解答这个问题。
        //自测是可以的，但是这环境跑不出来，可能超时了。。。


                BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
                String str=null;
                while((str=br.readLine())!=null){
                    int n=Integer.parseInt(str);
                    if(n>=1&&n<=99999){
                        long result=0;
                        for(int i=1;i<=2000000;i++){
                            result =(long)i*n;
                            if(bnum(result)){
                                System.out.println(n+": "+result);
                                break;
                            }
                        }
                    }else{
                        break;
                    }
                }
            }
            public static boolean bnum(long num){
                String s=""+num;
                char [] c=s.toCharArray();
                int isNum=0;
                for(int i=1;i<c.length;i++){
                    if(c[i]!=c[i-1]){
                        isNum++;
                    }
                }
                if(isNum==1){
                    return true;
                }else{
                    return false;
                }
            }

    }

