package org.example.util;

import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.ToAnalysis;
import org.example.model.DocInfo;
import org.example.model.Weight;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 构建索引
 * 正排索引：从本地数据中，读取到java内存
 * 倒排索引：构建Map<String,List<信息>>(类似数据库中的hash索引）
 * Map键：关键词（分词来做）
 * Map键-信息：
 * （1）docInfo对象的引用或者docInfo的id
 * （2）权重（标题对应关键词数量*10+正文关键词数量*1）---->自己设置的权重，可以进行灵活调整
 * （3）是关键词否需要，待定
 */
public class Index {
    //正排索引
    private static final List<DocInfo> FORWARD_INDEX=new ArrayList<>();
    //倒排索引
    private   static final Map<String,List<Weight>> INVERTED_INDEX=new HashMap<>();

    /**
     * 构建正排索引的内容：从本地的raw_data.txt读取并保存
     */
    public static void buildForwardIndex()  {
        try {
            FileReader fr=new FileReader(Parser.RAW_DATA);
            BufferedReader br=new BufferedReader(fr);
            int id=0;//定义行号设置为docInfo的id
            String line;
            while((line=br.readLine())!=null){
                //一行对应一个DocInfo对象，类似数据库中的一行数据对应java对象
                if(line.trim().equals("")) continue;//最后一行空行不处理
                DocInfo doc=new DocInfo();
                doc.setId(++id);
                String[] parts=line.split("\3");//每一行按\3间隔符进行切分
                doc.setTitle(parts[0]);
                doc.setUrl(parts[1]);
                doc.setContent(parts[2]);
                //添加到正排索引
                FORWARD_INDEX.add(doc);
            }
        } catch (IOException e) {
            //不要让程序吃异常
            throw new RuntimeException(e);
        }

    }

    /**
     * 构建倒排索引：从java内存中正排索引信息来构建
     */
    public static void buildInvertedIndex(){
        for(DocInfo  doc:FORWARD_INDEX){
            //一个doc。分别对标题和正文进行分词，每一个分词生成一个weight对象，需要计算权重
            //第一次出现的关键词，要new Weight对象，之后出现要获取之前相同关键词对象，更新权重
            Map<String,Weight> cache=new HashMap<>();

            List<Term> titleFencis= ToAnalysis.parse(doc.getTitle()).getTerms();

            for(Term titleFenci:titleFencis){//标题分词，遍历处理
                //获取标题分词对应的weight
                Weight w=cache.get(titleFenci.getName());
                if(w==null){//如果没有就创建一个，放到map中
                    w=new Weight();
                    w.setDoc(doc);
                    w.setKeyWord(titleFenci.getName());//关键词
                    cache.put(titleFenci.getName(),w);
                }
                //标题分词，权重+10
                w.setWeight(w.getWeight()+10);
            }
            //正文分词处理：逻辑和标题的分词处理相同
            List<Term> contentFencis=ToAnalysis.parse(doc.getContent()).getTerms();
            for(Term contentFenci:contentFencis){
                Weight w=cache.get(contentFenci.getName());

                if(w==null){
                    w=new Weight();
                    w.setDoc(doc);
                    w.setKeyWord(contentFenci.getName());
                    cache.put(contentFenci.getName(),w);
                }
                //正文分词，权重+1
                w.setWeight(w.getWeight()+1);
            }
            //把临时保存的，api数据（keyWord+weight）保存到倒排索引
            for(Map.Entry<String,Weight> e:cache.entrySet()){
                String keyWord=e.getKey();
                Weight w=e.getValue();
                //更新保存到到倒排索引里面Map<String,List<Weight>>多个文档，同一关键词，保存在一个List中
                //先在倒排索引中获取已有的值，获取的是一个List
                List<Weight> weights=INVERTED_INDEX.get(keyWord);
                if(weights==null){
                    weights=new ArrayList<>();
                    INVERTED_INDEX.put(keyWord,weights);
                }
                //System.out.print(keyWord+":("+w.getDoc().getId()+","+w.getWeight());
                weights.add(w);//倒排中，添加当前文档中每个分词对应的weights对象

            }

        }
    }
//在倒排中查找对应的文档（多个文档，倒排拉链）
    public static List<Weight> get(String keyword){
        return INVERTED_INDEX.get(keyword);
    }
    public static void main(String[] args) {
        Index.buildForwardIndex();


        //测试正排索引构建是否成功
//        Index.buildForwardIndex();
//        FORWARD_INDEX.
//                stream().
//                forEach(System.out::println);
        Index.buildInvertedIndex();
        //测试倒排内容是否正确
        for(Map.Entry<String,List<Weight>> e:INVERTED_INDEX.entrySet()){
            String keyWord=e.getKey();
            System.out.print(keyWord+":");
            List<Weight> weights=e.getValue();//不校验weight中的doc对象，正排索引已经测试过了
            weights.stream()
                    .map(w->{
                        return "("+w.getDoc().getId()+","+w.getWeight()+")";
                    })//现在转换完变成了一个List<String>
                    //.collect(Collectors.toList());//直接返回list这个对象
                    .forEach(System.out::print);
            System.out.println();


        }
    }




}
