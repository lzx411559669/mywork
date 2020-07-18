package com.youkeda.bmach;

import java.io.*;

public class FileApplication {
    public static void main(String[] args) {
        read();
        write();
    }
    public static void write(){
        File file =new File("hello.txt");
        BufferedWriter bw=null;
        try {
             bw=new BufferedWriter(new FileWriter(file));
            bw.write("你好，刘正星！！");
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (bw!=null){
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void read() {
        File file=new File("bmatch.txt");
        BufferedReader br=null;
       // FileReader fr=null;
        try {
            br=new BufferedReader(new FileReader(file));
          String str=null;
            while((str=br.readLine())!=null){
                System.out.println(str);
                //str =br.readLine();
            }



           //  fr=new FileReader(file);
            /*int tmp=fr.read();
            while (tmp!=-1){
                System.out.print((char)tmp);
                tmp=fr.read();
            }*/

        }  catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (br!=null)
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
