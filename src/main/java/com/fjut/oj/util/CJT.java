package com.fjut.oj.util;

import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

public class CJT {

    public static String ProblemURL= "http://www.fjutacm.com/Problem.jsp?pid=";
    public static String TitleSelect="h1";
    public static String SubmitURL = "http://www.fjutacm.com/Problem.jsp?pid=";
    public static String LoginURL = "http://www.fjutacm.com/Login.jsp";
    private static MyClient hc = new MyClient();

    public static String submit(){
        String ret = Login();
        if (ret.equals("error")) return "error";
        String pid = "1000";
        String language = "G++";
        String code = "#include<cstdio>\n" +
                "using namespace std;\n" +
                "int main()\n" +
                "{ \n" +
                "     int a, b;\n" +
                "     while(scanf(\"%d %d\",&a ,&b) != EOF)\n" +
                "     {\n" +
                "       printf(\"%d\\n\", a + b);\n" +
                "     }\n" +
                "     return 0;" +
                "}\n";
        List<BasicNameValuePair> formparams = new ArrayList<BasicNameValuePair>();
        formparams.add(new BasicNameValuePair("pidinput", pid));
        formparams.add(new BasicNameValuePair("language", language));
        formparams.add(new BasicNameValuePair("codeinput",code));

        if (hc.Post(SubmitURL + pid, formparams) == null)
        {
            System.out.println("errorsubmit");
            return "error";
        }
        // rid = getRid(submitusername[1]);
        System.out.println("successsubmit");
        return "success";
    }

    public static String Login(){
        List<BasicNameValuePair> formparams = new ArrayList<>();

        formparams.add(new BasicNameValuePair("username","cjt152"));
        formparams.add(new BasicNameValuePair("password","chijintao123"));
        if(hc.Post(LoginURL, formparams)==null)
        {
            System.out.println("error");
            return "error";
        }
        System.out.println("success");
        // check[i] = true;
        return "success";
    }

    public static void main(String[] args){
        Login();

        submit();
    }


}
