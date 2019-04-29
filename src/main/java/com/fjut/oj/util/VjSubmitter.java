package com.fjut.oj.util;

import java.util.LinkedList;

public class VjSubmitter implements Runnable{

    public static final int BUSY = 1;
    public static final int IDLE = 0;
    public LinkedList<String> showstatus;
    public String rid ="";
    public MyClient client = new MyClient();
    public SubmitInfo info;
    int status;
    int ojid;
    int submitterID;
    // VJudge vj;

    private Thread selfThread = null;
    private String username;
    private String password;
    private String ojsrid;
    public VjSubmitter(int ojid, String us, String pas, int id/*, VJudge vj*/){
        this.ojid=ojid;
        username=us;
        password=pas;
        status=IDLE;
        submitterID=id;
        //this.vj=vj;
        showstatus = new LinkedList<>();
        showstatus.addLast("Begin");
    }

    public static int getBUSY() {
        return BUSY;
    }

    public static int getIDLE() {
        return IDLE;
    }

    public LinkedList<String> getShowstatus() {
        return showstatus;
    }

    public void setShowstatus(LinkedList<String> showstatus) {
        this.showstatus = showstatus;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public MyClient getClient() {
        return client;
    }

    public void setClient(MyClient client) {
        this.client = client;
    }

    public SubmitInfo getInfo() {
        return info;
    }

    public void setInfo(SubmitInfo info) {
        this.info = info;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getOjid() {
        return ojid;
    }

    public void setOjid(int ojid) {
        this.ojid = ojid;
    }

    public int getSubmitterID() {
        return submitterID;
    }

    public void setSubmitterID(int submitterID) {
        this.submitterID = submitterID;
    }

    public Thread getSelfThread() {
        return selfThread;
    }

    public void setSelfThread(Thread selfThread) {
        this.selfThread = selfThread;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOjsrid() {
        return ojsrid;
    }

    public void setOjsrid(String ojsrid) {
        this.ojsrid = ojsrid;
    }

    public void setShowstatus(String status){
        this.showstatus.addLast("[" + "]" + status);
        if (this.showstatus.size() > 30){
            this.showstatus.removeFirst();
        }
    }

    @Override
    public void run() {
        /*while(true){
            try {
                // 读取队列执行

            }
        }*/
    }
}
