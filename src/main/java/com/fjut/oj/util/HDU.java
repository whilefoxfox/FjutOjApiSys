package com.fjut.oj.util;

import com.fjut.oj.pojo.CodeLanguage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HDU {

    public static String URL= "http://acm.hdu.edu.cn";
    public static String submitURL="/submit.php?action=submit";
    public static String problemURL="/showproblem.php";
    public static String TitleSelect="h1";
    public static String statusURL="/status.php";
    public static String statusFormUser="user";
    public static String statuSelect="table:nth-child(2) tr:nth-child(4) table tr:nth-child(3)";
    public static String DesSelect=".panel_content";
    public static String SampleInputSelect="pre";
    //private static Map<String,Result> resultMap;
    public static String loginURL="/userloginex.php?action=login";
    public static String Int64 = "%I64d";
    public static Map<String, Result> resultMap;
    public static List<Pair<Integer,CodeLanguage>> languageList;

    static{
        resultMap = new HashMap<String, Result>();
        resultMap.put("Queuing",Result.PENDING);
        resultMap.put("Compiling",Result.PENDING);
        resultMap.put("Running",Result.PENDING);
        resultMap.put("Accepted",Result.AC);
        resultMap.put("Wrong Answer",Result.WA);
        resultMap.put("Runtime Error (ACCESS_VIOLATION)",Result.RE);
        resultMap.put("Runtime Error (ARRAY_BOUNDS_EXCEEDED)",Result.RE);
        resultMap.put("Runtime Error (FLOAT_DENORMAL_OPERAND)",Result.RE);
        resultMap.put("Runtime Error (FLOAT_DIVIDE_BY_ZERO)",Result.RE);
        resultMap.put("Runtime Error (FLOAT_OVERFLOW)",Result.RE);
        resultMap.put("Runtime Error (FLOAT_UNDERFLOW)",Result.RE);
        resultMap.put("Runtime Error (INTEGER_DIVIDE_BY_ZERO)",Result.RE);
        resultMap.put("Runtime Error (INTEGER_OVERFLOW)",Result.RE);
        resultMap.put("Runtime Error (STACK_OVERFLOW)",Result.RE);
        resultMap.put("Time Limit Exceeded",Result.TLE);
        resultMap.put("Memory Limit Exceeded",Result.MLE);
        resultMap.put("Output Limit Exceeded",Result.OLE);
        resultMap.put("Presentation Error",Result.PE);
        resultMap.put("Compilation Error",Result.CE);
        resultMap.put("System Error",Result.DANGER);

        languageList = new ArrayList<>();
        languageList.add(new Pair<>(0,CodeLanguage.GPP));
        languageList.add(new Pair<>(1,CodeLanguage.GCC));
        languageList.add(new Pair<>(4,CodeLanguage.PASCAL));
        languageList.add(new Pair<>(5,CodeLanguage.JAVA));
        languageList.add(new Pair<>(6,CodeLanguage.CSHARP));
    }

    public static String getSubmitURL(){
        return URL+submitURL;
    }

    public static String getLoginURL() {
        return URL+loginURL;
    }

    public static String getStatusURL(String user){
        return URL+statusURL+"?"+statusFormUser+"="+user;
    }

    public String getName(){
        return "HDU";
    }

    public String get64IO(String pid) {
        return Int64;
    }

    public List<Pair<Integer, CodeLanguage>> getLanguageList(String pid) {
        return languageList;
    }

    public static String getProblemURL(String pid){
        return URL+problemURL+"?pid="+pid;
    }

    private static Result getResultMap(String v){
        return resultMap.get(v);
    }

    /**
     * 获得题目标题
     * @param
     */
    public static String getTitle(String pid){
        Document doc;
        try {
            doc = Jsoup.connect(getProblemURL(pid)).get();
            return doc.select(TitleSelect).get(0).text();
        } catch (IOException e) {
            return "获取题目出错";
        }
    }

    public static problemHTML getProblemHTML(String pid){
        Document doc;
        problemHTML p=new problemHTML();
        try {
            doc = Jsoup.connect(getProblemURL(pid)).get();
        } catch (IOException e) {
            System.out.println("未连接到目标oj");
            return null;
        }
        Elements es=doc.select("img");
        for(Element e:es){
            String link=e.attr("src");
            e.attr("src",URL+"/"+link);
        }

        p.setTitle(doc.select(TitleSelect).get(0).text());
        p.setDis(doc.select(DesSelect).get(0).html());
        p.setInput(doc.select(DesSelect).get(1).html());
        p.setOutput(doc.select(DesSelect).get(2).html());
        Elements e2 = doc.select(SampleInputSelect);
        p.addSample("<pre class='sample'>"
                        + e2.get(e2.size() - 2).text() + "</pre>",
                "<pre class='sample'>"
                        + e2.get(e2.size() - 1).text() + "</pre>");
        p.setInt64(Int64);
        String s=doc.select("span").get(0).text();
        //System.out.println(s);
        String s1=s.substring(s.indexOf("/")+1, s.indexOf("(Java/Others)")-4)+"MS";
        String s2=s.substring(s.indexOf("Memory Limit:")+13);
        s2=s2.substring(s2.indexOf("/")+1,s2.indexOf("K (Java/Others)")-1)+"KB";
        p.setTimeLimit(s1);
        p.setMenoryLimit(s2);
        if(s.contains("Special Judge")) p.setSpj(1);
        System.out.println(p);
        return p;
    }

    public static void main(String[] args) {
        String url ="2500";
        getProblemHTML(url);
    }
}