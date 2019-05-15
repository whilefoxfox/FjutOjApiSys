package com.fjut.oj.util;

public class ContextLevel {
    private static String province = "ACM福建省省赛";
    private static String regional = "ACM/ICPC亚洲区域赛";
    private static String ec_final = "ACM/ICPC东亚赛区总决赛(EC-Final)";
    private static String world_final = "ICPC世界总决赛";
    private static String lanqiaobei = "全国蓝桥杯软件设计大赛";
    private static String yaoqingsai = "ACM/ICPC全国邀请赛";
    private static String ccpc = "中国大学生程序设计竞赛";
    private static String none = "其他";

    private static String judgeCode(int code){
        String info;
        switch (code){
            case -1:
                info = none;
                break;
            case 0:
                info = province;
                break;
            case 1:
                info = regional;
                break;
            case 2:
                info = ec_final;
                break;
            case 3:
                info = world_final;
                break;
            case 4:
                info = lanqiaobei;
                break;
            case 5:
                info = yaoqingsai;
                break;
            case 6:
                info = ccpc;
                break;
            default:
                info = none;
                break;
        }
        return info;
    }
}
