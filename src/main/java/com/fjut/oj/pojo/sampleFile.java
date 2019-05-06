package com.fjut.oj.pojo;

import java.io.File;

public class sampleFile {

    String pid;
    String filename;
    File samplein;
    String sampleinFileName;
    File sampleout;
    String sampleoutFileName;
    File spj;
    String spjFileName;
    private String fileName;

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public File getSamplein() {
        return samplein;
    }

    public void setSamplein(File samplein) {
        this.samplein = samplein;
    }

    public String getSampleinFileName() {
        return sampleinFileName;
    }

    public void setSampleinFileName(String sampleinFileName) {
        this.sampleinFileName = sampleinFileName;
    }

    public File getSampleout() {
        return sampleout;
    }

    public void setSampleout(File sampleout) {
        this.sampleout = sampleout;
    }

    public String getSampleoutFileName() {
        return sampleoutFileName;
    }

    public void setSampleoutFileName(String sampleoutFileName) {
        this.sampleoutFileName = sampleoutFileName;
    }

    public File getSpj() {
        return spj;
    }

    public void setSpj(File spj) {
        this.spj = spj;
    }

    public String getSpjFileName() {
        return spjFileName;
    }

    public void setSpjFileName(String spjFileName) {
        this.spjFileName = spjFileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
