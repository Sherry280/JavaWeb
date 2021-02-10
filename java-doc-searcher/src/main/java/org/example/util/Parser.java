package org.example.util;

import org.example.model.DocInfo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 步骤一：
 * 从本地的api目录，遍历静态的html文件
 * 每一个html需要构建正文索引：本地某个文件
 * 正文索引信息List<DocInfo>
 * </DocInfo>(id,title,content,url)
 */
public class Parser {
    //api目录
    public static final String API_PATH="D:\\docs\\api";
    //构建的本地文件正排索引
    public static final String RAW_DATA="D:/raw_data.txt";//生成的api目标文件
    //官方api文档的根路径
    public static final String API_BASE_PATH=" https://docs.oracle.com/javase/8/docs/api";

    public static void main(String[] args) throws IOException {
        //找到api本地路径下的所有的html文件
        List<File> htmls=listHtml(new File(API_PATH));

        FileWriter fw=new FileWriter(RAW_DATA);
        //BufferedWriter bw=new BufferedWriter(fw);//使用缓冲流进行输出
        PrintWriter pw=new PrintWriter(fw,true);


        //List<DocInfo> docs=new ArrayList<>();

        for(File html:htmls){
            //测试一下：获取本地路径下所有html文件
            //System.out.println(html.getAbsolutePath());
            //一个html解析为一个DocInfo有的属性
            DocInfo doc=parseHtml(html);

            //docs.add(doc);
           // System.out.println(doc);
            //输出的格式为：一行数据，一行为一个doc，title+\3+url+\3+content
            String uri=html.getAbsolutePath().substring(API_PATH.length());
            System.out.println("Parse:"+uri);
            pw.println(doc.getTitle()+"\3"+doc.getUrl()+"\3"+doc.getContent());


        }
        //保存本地正排索引文件
    }

    /**
     * 将html文件处理为doc对象
     */
    private static DocInfo parseHtml(File html) {
        DocInfo doc=new DocInfo();
        //ArrayList.length()-5也可以
        doc.setTitle(html.getName().substring(0,html.getName().length()-".html".length()));
        //获取相对路径
        String uri=html.getAbsolutePath().substring(API_PATH.length());
        doc.setUrl(API_BASE_PATH+uri);//方便直接在网页上直接访问
        doc.setContent(parseContent(html));
        return doc;//目前是从本地api目录的html文件解析为文档对象，这步操作不需要设置id

    }

    /**
     * 解析html文档内容
     * <标签>内容</标签>
     * 只去内容，如果有多个标签，就拼接
     */
    private static String parseContent(File html) {
        //字符串拼接
        StringBuilder sb=new StringBuilder();
        try {
            FileReader fr=new FileReader(html);
            int i ;
            boolean isContent=false;

            //一个字符一个字符的来读取
            while ((i=fr.read())!=-1){
                char c=(char)i;
                //根据读取的字符c是否是‘<','>',isContent决定是否要进行拼接字符，continue
                if(isContent) {
                    if (c == '<') {
                        isContent=false;
                        continue;
                    }else if(c=='\n'||c=='\r'){
                        //换行符的写法：\r,\n
                        sb.append(" ");
                    }else {
                        sb.append(c);//拼接标签内容
                    }
                }else if(c=='>'){//当前不是正文，并且读取到>,之后就是正文
                    isContent=true;

                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }


    //递归遍历所有的html文件
    private static List<File> listHtml(File dir){
        //返回的List
        List<File> list=new ArrayList<>();

        File[] children=dir.listFiles();
        for(File child:children){
            if(child.isDirectory()){//文件夹
                list.addAll(listHtml(child));

            }else if(child.getName().endsWith(".html")){
                list.add(child);
            }
        }
        return list;
    }

}
