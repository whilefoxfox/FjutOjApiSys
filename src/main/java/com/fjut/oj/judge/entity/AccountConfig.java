package com.fjut.oj.judge.entity;

import java.util.HashMap;
import java.util.Map;

public class AccountConfig {

    /**
     * 添加一个 oj 的账号时在每个 oj 数组后面按照 账号, 密码 的格式添加即可
     */
    public static String[] hduAccount = {"wuyuxiang", "wuyuxiang"};
    public static String[] bnuojAccount = {"spsmoj", "spsmoj10086"};
    public static String[] nbutAccount = {"fjutvjudge","fjutvjudge123"};
    public static String[] pkuAccount = {"spsmoj","spsmoj123"};
    public static String[] hustAccount = {"spsmoj","spsmoj123"};
    public static String[] cfAccount = {"spsmoj2","spsmoj2123"};
    public static String[] codevsAccount = {"spsmoj","spsmoj123"};
    public static String[] localAccount = {};
    public static String[] acdreamAccount = {"spsmoj","spsmoj123"};
    public static String[] judge_system_gameAccount = {};
    public static String[] cf_gymAccount = {"syiml","Loveshiya"};
    public static String[] fojAccount = {"spsmoj", "spsmoj123"};
    public static String[] newJudgeAccount = {};
    public static String[] bzojAccount = {"spsmoj","spsmoj123"};
    public static String[] zojAccount = {"spsmoj","123456"};
    public static String[] spojAccount = {"spsmoj","spsmoj123"};

    public static Map<String, String[]> mp = new HashMap<>();

    public AccountConfig(){
        mp.put("hdu", hduAccount);
        mp.put("bnuoj", bnuojAccount);
        mp.put("nbut", nbutAccount);
        mp.put("pku", pkuAccount);
        mp.put("hust", hustAccount);
        mp.put("cf", cfAccount);
        mp.put("codevs", codevsAccount);
        mp.put("acdream", acdreamAccount);
        mp.put("cf_gym", cf_gymAccount);
        mp.put("foj", fojAccount);
        mp.put("bzoj", bzojAccount);
        mp.put("zoj", zojAccount);
        mp.put("spoj", spojAccount);
    }
}
