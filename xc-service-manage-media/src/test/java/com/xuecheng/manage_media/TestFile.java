package com.xuecheng.manage_media;/*
 @author WangQ
 @DESCRIPTION ${DESCRIPTION}
 @create 2019/5/23
*/

import org.aspectj.apache.bcel.classfile.SourceFile;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestFile {
    //测试文件分块
    @Test
    public void testChunk() throws IOException{
        //源文件
        File courceFile = new File("G:\\ffmpeg_test\\1.avi");
        //块文件目录
        String chunkFileFolder = "G:\\ffmpeg_test\\chunks\\";
        //先定义块文件大小
        long chunkFileSize = 1*1024*1024;
        //块数
        long chunkFileNum = (long)Math.ceil(courceFile.length()*1.0 / chunkFileSize);
        //创建文件的对象
        RandomAccessFile raf_read = new RandomAccessFile(courceFile, "r");
        //缓冲区
        byte[] b = new byte[1024];
        for (int i=0;i<chunkFileNum;i++){
            //块文件
            File chunkFile = new File(chunkFileFolder + i);
            //创建向块文件的写对象
            RandomAccessFile raf_write = new RandomAccessFile(chunkFile, "rw");
            int len = -1;
            while((len = raf_read.read(b))!=-1){
                raf_write.write(b,0,len);
                //如果块文件的大小达到1M开始写下一块
                if(chunkFile.length()>=chunkFileSize){
                    break;
                }
            }
            raf_write.close();
        }
        raf_read.close();
    }
    //测试文件合并
    @Test
    public void testMergeFile()throws IOException{
        //块文件目录
        String chunkFileFolderPath = "G:\\ffmpeg_test\\chunks";
        //块文件目录对象
        File chunkFileFolder = new File(chunkFileFolderPath);
        //块文件列表
        File[] files = chunkFileFolder.listFiles();
        //将块文件排序，按名称升序
        List<File> filesList = Arrays.asList(files);
        Collections.sort(filesList, new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                if(Integer.parseInt(o1.getName())>Integer.parseInt(o2.getName())){
                    return 1;
                }
                return -1;
            }
        });
        //合并文件
        File mergeFile = new File("G:\\ffmpeg_test\\luncene_merge.avi");
        //创建新文件
        boolean newFile = mergeFile.createNewFile();
        //创建写对象
        RandomAccessFile raf_write = new RandomAccessFile(mergeFile, "rw");
        byte[] b = new byte[1024];
        for (File chunkFile:filesList){
            //创建一个读块文件的对象
            RandomAccessFile raf_read = new RandomAccessFile(chunkFile, "r");
            int len = -1;
            while((len = raf_read.read(b)) !=-1){
                raf_write.write(b,0,len);
            }
            raf_read.close();
        }
        raf_write.close();
    }
}
