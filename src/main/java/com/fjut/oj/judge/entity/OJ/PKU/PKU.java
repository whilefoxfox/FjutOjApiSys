package com.fjut.oj.judge.entity.OJ.PKU;

import com.fjut.oj.judge.entity.OJ.CodeLanguage;
import com.fjut.oj.judge.entity.OJ.OTHOJ;
import com.fjut.oj.judge.entity.RES;
import com.fjut.oj.judge.entity.Result;
import com.fjut.oj.judge.util.HTML.problemHTML;
import com.fjut.oj.judge.util.MyClient;
import com.fjut.oj.judge.util.Pair;
import com.fjut.oj.judge.util.Vjudge.VjSubmitter;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by Syiml on 2015/8/11 0011.
 */
public class PKU extends OTHOJ {
    public static Map<String,Result> ResultMap;
    String url= "http://poj.org";
    private static List<Pair<Integer,CodeLanguage>> languageList;
    static {
        ResultMap=new HashMap<String, Result>();
        ResultMap.put("Accepted",Result.AC);
        ResultMap.put("Wrong Answer",Result.WA);
        ResultMap.put("Presentation Error",Result.PE);
        ResultMap.put("Time Limit Exceeded",Result.TLE);
        ResultMap.put("Memory Limit Exceeded",Result.MLE);
        ResultMap.put("Runtime Error",Result.RE);
        ResultMap.put("Output Limit Exceeded",Result.OLE);
        ResultMap.put("Compile Error",Result.CE);
        ResultMap.put("Running & Judging",Result.JUDGING);
        ResultMap.put("Waiting",Result.JUDGING);
        ResultMap.put("Compiling",Result.JUDGING);
        ResultMap.put("System Error",Result.DANGER);
        ResultMap.put("Validator Error",Result.ERROR);

        languageList = new ArrayList<>();
        languageList.add(new Pair<>(0,CodeLanguage.GPP));
        languageList.add(new Pair<>(1,CodeLanguage.GCC));
        languageList.add(new Pair<>(2,CodeLanguage.JAVA));
        languageList.add(new Pair<>(3,CodeLanguage.PASCAL));
    }
    public String getName(){
        return "POJ";
    }

    @Override
    public String get64IO(String pid) {
        return "%lld";
    }

    @Override
    public List<Pair<Integer, CodeLanguage>> getLanguageList(String pid) {
        return languageList;
    }

    public String getRid(String user,VjSubmitter ve){
        Element e;
        Document d;
        try {
            d = Jsoup.connect(url + "/status?user_id=" + user).get();
            try{e = d.select(".a tr").get(1);}catch(IndexOutOfBoundsException ee){return "new";}
            return e.select("td:nth-child(1)").first().text();
        } catch (IOException ignored) {
            //Tool.log(ignored);
        }
        return "error";
    }
    public String getProblemURL(String pid){
        return url+"/problem?id="+pid;
    }
    public problemHTML getProblemHTML(String pid){
        problemHTML ph=new problemHTML();
        Element e=null;
        Document d = null;
        try {
            d = Jsoup.connect(url+"/problem?id="+pid).get();
            Elements es=d.select("img");
            for(Element ee:es){
                String link=ee.attr("src");
                ee.attr("src",url+"/"+link);
            }
            ph.setTitle(d.select(".ptt").first().text());
            ph.setDis(d.select(".ptx").eq(0).html());
            ph.setInput(d.select(".ptx").eq(1).html());
            ph.setOutput(d.select(".ptx").eq(2).html());
            ph.addSample("<pre style='padding:0px;border-style:none;background-color:transparent'>"
                            +d.select(".sio").eq(0).text()+"</pre>",
                    "<pre style='padding:0px;border-style:none;background-color:transparent'>"
                            +d.select(".sio").eq(1).text()+"</pre>" );
            ph.setInt64("%lld");
            //String limit=d.select("#limit").text();
            //System.out.println("get:"+d.select(".plm").select("td").get(2));
            ph.setTimeLimit(d.select(".plm").select("td").get(0).text().substring(12));
            ph.setMenoryLimit(d.select(".plm").select("td").get(2).text().substring(14));
            if(d.select(".plm").text().contains("Special Judge")) ph.setSpj(true);
        } catch (IOException e1) {
            //System.out.print("connect timed out");
            //e1.printStackTrace();
        }
        return ph;
    }
    public String getTitle(String pid){
        Element e=null;
        Document d = null;
        try {
            d = Jsoup.connect(url+"/problem?id="+pid).get();
            return d.select(".ptt").first().text();
        } catch (IOException e1) {
            System.out.print("connect timed out");
            //e1.printStackTrace();
        }
        return GET_TITLE_ERROR;
    }
    public String submit(VjSubmitter s){
        MyClient hc=new MyClient();
        List<NameValuePair> formparams = new ArrayList<NameValuePair>();
        formparams.add(new BasicNameValuePair("user_id1",s.getUsername()));
        formparams.add(new BasicNameValuePair("password1",s.getPassword()));
        formparams.add(new BasicNameValuePair("url","/"));
        //System.out.println("user_id1" + s.getUsername());
        //System.out.println("password1"+s.getPassword());
        hc.Post(url+"/login", formparams);
        //if(hc.Post(url+"/login", formparams)==0) return "error";
        //else {
        List<NameValuePair> formparams1 = new ArrayList<NameValuePair>();
        formparams1.add(new BasicNameValuePair("language",getTrueLanguage(s.getSubmitInfo().language,s.getSubmitInfo().pid)+""));
        formparams1.add(new BasicNameValuePair("problem_id",s.getSubmitInfo().pid));

//        String code= new BASE64Encoder().encode(s.getSubmitInfo().code.getBytes());

//        formparams1.add(new BasicNameValuePair("source",code));
        formparams1.add(new BasicNameValuePair("encoded","1"));
        if(hc.Post(url+"/submit",formparams1)==null) return "error";
        else return "success";
        //}
        //return "success";
    }
    private Result getResultMap(String s){
        return ResultMap.get(s);
    }
    public String getCEInfo(VjSubmitter s){
        MyClient hc=new MyClient();
        Document d = hc.get(url+"/showcompileinfo?solution_id="+s.getOjsrid());
        return d.select("pre").html();
    }
    public RES getResult(VjSubmitter s){
        Element e;
        Document d = null;
        RES r=new RES();
        try {
            d = Jsoup.connect(url + "/status?user_id=" + s.getUsername()).get();
        } catch (IOException e1) {
            e1.printStackTrace();
            r.setR(Result.PENDING);
            return r;
        }
        e = d.select(".a tr").get(1);
//      System.out.println("get:" + e.select("td:nth-child(4)").first().text());
        Result re=getResultMap(e.select("td:nth-child(4)").first().text());
        if(re!=null){
            r.setR(re);
        }else{
            r.setR(Result.ERROR);
        }
        if(r.getR()==Result.AC){
//            System.out.println("time:"+e.select("td:nth-child(5)"));
//            System.out.println("memory:"+e.select("td:nth-child(6)"));
            r.setMemory(e.select("td:nth-child(5)").first().text()+"B");
            r.setTime(e.select("td:nth-child(6)").first().text() + "");
        }
        if(r.getR()==Result.CE){
            r.setCEInfo(getCEInfo(s));
        }
        return r;
    }
}
