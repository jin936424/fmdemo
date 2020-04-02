package com.test.demo;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.unzip.UnzipUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/***
 * Created by dz on 2020-1-6
 */
public class ZipTest {
    private static String source = "C:\\Users\\Administrator\\Desktop\\文档\\books\\阿里巴巴Java开发手册（终极版）.zip";
    private static String target = "E:\\temp";
    private static String password = "123qwe"; // abc:/02.+

    public static void main(String[] args) {
        UnzipUtil unzipUtil = new UnzipUtil();
        Extract(source,target,password);

    }

    private static void Extract(String source,String target,String password){
        try {
            ZipFile zFile = new ZipFile(new File(source));
            zFile.setFileNameCharset("gbk");

            File targetFile = new File(target);
            if(!targetFile.isDirectory()) {
                targetFile.mkdirs();
            }

            if (zFile.isEncrypted()){
                zFile.setPassword(password); // set password
            }
            zFile.extractAll(target);

            List<FileHeader> fileHeaders = zFile.getFileHeaders();
            List<File> files = new ArrayList<>();
            if ( null != fileHeaders && !fileHeaders.isEmpty() ){
                fileHeaders.forEach(fileHeader -> {
                    if ( !fileHeader.isDirectory() ) {
                        files.add(new File(targetFile,fileHeader.getFileName()));
                    }
                });
            }

            File[] extractFiles = new File[files.size()];
            files.toArray(extractFiles);
            files.forEach(file -> {
                System.out.println("文件解压成功->" + file.getAbsolutePath() + "--" + file.getName());
            });
        }catch (ZipException zipEx){
            zipEx.printStackTrace();
        }
    }
}
