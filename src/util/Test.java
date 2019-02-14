package util;

import java.io.File;
import java.util.Date;

public class Test {
public static void main(String[] args) {
	File  f = new  File("C:/WINDOWS");
	int  max = 0;
	int min = 0;
    File  []  files = f.listFiles();
    for(int i = 0;i<files.length;i++){
    	if(files[i].length()>files[i+1].length()  && i<=files.length){
    		max = i;
    		min = i+1;
    	}else{
    		break;
    	}
    }
    System.out.println("最大的文件是："+files[max].getName()+",长度是："+files[max].length());
    System.out.println("最小的文件是："+files[min].getName()+",长度是："+files[min].length());
/*	System.out.println("================="+f.getPath());
	//文件是否存在
    System.out.println("判断是否存在："+f.exists());
     
    //是否是文件夹
    System.out.println("判断是否是文件夹："+f.isDirectory());
      
    //是否是文件（非文件夹）
    System.out.println("判断是否是文件："+f.isFile());
      
    //文件长度
    System.out.println("获取文件的长度："+f.length());
      
   //文件最后修改时间
    long time = f.lastModified();
    Date d = new Date(time);
    System.out.println("获取文件的最后修改时间："+d);
    //设置文件修改时间为1970.1.1 08:00:00
      
    //文件重命名
    File f2 =new File("D:/QQ下载/图片.png");
    f.renameTo(f2);
    System.out.println("把LOL.exe改名成了DOTA.exe");
     System.out.println("新的文件名=============="+f.getName());
    System.out.println("注意： 需要在D:\\LOLFolder确实存在一个LOL.exe,\r\n才可以看到对应的文件长度、修改时间等信息");*/
}
}
