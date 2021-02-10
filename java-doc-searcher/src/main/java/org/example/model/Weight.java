package org.example.model;

import javax.print.Doc;

/**
 * 倒排索引Map<String,List<Weight>>中、关键词对应的信息
 */
public class Weight {
    private DocInfo doc;
    private int weight;//权重值：通过标题和正文中，关键词的数量进行计算
    private String keyWord;//关键词

    public DocInfo getDoc() {
        return doc;
    }

    public void setDoc(DocInfo doc) {
        this.doc = doc;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    @Override
    public String toString() {
        return "Weight{" +
                "doc=" + doc +
                ", weight=" + weight +
                ", keyWord='" + keyWord + '\'' +
                '}';
    }
}
