package com.fjut.oj.util;

public class ResultString {
    public static String getResultString(int resultId){
        if(resultId==1) return "Accepted";
        if(resultId==3) return "Compilation Error";
        if(resultId==9) return "System Error";
        if(resultId==6) return "Memory Limit Exceeded";
        if(resultId==7) return"Output Limit Exceeded";
        if(resultId==8) return "Presentation Error";
        if(resultId==0) return "Pendding...";
        if(resultId==12) return "Judging...";
        if(resultId==4) return "Runtime Error";
        if(resultId==10) return "Running...";
        if(resultId==5) return "Time Limit Exceeded";
        if(resultId==2) return "Wrong Answer";
        if(resultId==11) return "Submit Error";
        if(resultId==13) return "Score";
        return "System Error";
    }
    public static String getSubmitLanguage(int langId){
        if (langId == 0)return "G++";
        if (langId == 1)return "GCC";
        if (langId == 2)return "JAVA";
        if (langId == 3)return "Python3";
        if (langId == 4)return "G++11";
        if (langId == 5)return "GCC11";
        if (langId == 6)return "VC++";
        if (langId == 7)return "C#";
        if (langId == 8)return "GO 1.8";
        if (langId == 9)return "JavaScript";
        if (langId == 10)return "Pascal";
        return "error";
    }
    public static Integer getSubmitLanguage(String lang){
        if ("G++".equals(lang))return 0;  // + 号通过 url 传递时要转化成 %2b
        if ("GCC".equals(lang))return 1;
        if ("JAVA".equals(lang))return 2;
        if ("Python3".equals(lang))return 3;
        if ("G++11".equals(lang))return 4; // + 号通过 url 传递时要转化成 %2b
        if ("GCC11".equals(lang))return 5;
        if ("VC++".equals(lang))return 6;
        if ("C#".equals(lang))return 7;  // # 号 %23
        if ("GO 1.8".equals(lang))return 8;
        if ("JavaScript".equals(lang))return 9;
        return 0;
    }
    public static Integer getResultString(String resultStr){
        if ("Accepted".equals(resultStr)) return 1;
        if ("Compilation Error".equals(resultStr)) return 3;
        if ("System Error".equals(resultStr)) return 9;
        if ("Memory Limit Exceeded".equals(resultStr)) return 6;
        if ("Output Limit Exceeded".equals(resultStr)) return 7;
        if ("Presentation Error".equals(resultStr)) return 8;
        if ("Pendding...".equals(resultStr)) return 0;
        if ("Judging...".equals(resultStr)) return 12;
        if ("Runtime Error".equals(resultStr)) return 4;
        if ("Running......".equals(resultStr)) return 10;
        if ("Time Limit Exceeded".equals(resultStr)) return 5;
        if ("Wrong Answer".equals(resultStr)) return 2;
        if ("Score".equals(resultStr)) return 13;
        return 5;
    }
}
