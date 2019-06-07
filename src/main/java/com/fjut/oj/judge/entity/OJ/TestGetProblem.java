package com.fjut.oj.judge.entity.OJ;

import com.fjut.oj.judge.entity.OJ.HDU.HDU;
import com.fjut.oj.judge.entity.OJ.PKU.PKU;

public class TestGetProblem{

    private static HDU hdu = new HDU();
    private static PKU pku = new PKU();

    public static void main(String[] args){
        System.out.println(hdu.getTitle(1001 + "")+"\n\n");
        System.out.println(hdu.getProblemHTML(1001 + "").getDis()+"\n\n");
        System.out.println(hdu.getProblemHTML(1001 + "").getSampleInput()+"\n\n");
        System.out.println(hdu.getProblemHTML(1001 + "").getSampleOutput()+"\n\n");

        //System.out.println(pku.getProblemHTML(1000 + "").getSampleInput());
    }
}