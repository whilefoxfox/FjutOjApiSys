package com.fjut.oj.util;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 文件操作，都在 rootPath 目录下操作
 */
public class FILE {
    private static String rootPath;

    /**
     * 为题目创建一个保存数据的目录
     */

    public static boolean createDirectory(int pid){
        File f = new File(rootPath + "data/" + pid);
        return (f.exists() && f.isDirectory()) || f.mkdirs();
    }

    /**
     * 获取指定题目下测试数据路径下的文件列表
     */
    public static List<File> getFiles(int pid){
        File f = new File(rootPath + "Data/" + pid);
        List<File> files = new ArrayList<File>();
        if (f.exists() && f.isDirectory()){
            File[] pathFiles = f.listFiles();
            if (pathFiles != null){
                Collections.addAll(files, pathFiles);
            }
        }
        return files;
    }

    /**
     * 删除题目测试数据目录下的文件
     */
    public static boolean delFile(int pid, String filename){
        File file = new File(rootPath + "data/" + pid + "/" + filename);
        if (file.isFile()) {
            if (! file.delete()) {
                return false;
            }
            return true;
        }
        return false;
    }
}
