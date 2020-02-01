package com.it.controller;


import com.it.bean.IoTable;
import com.it.service.IoTableServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Controller
public class IoTableController {
    @Autowired
    IoTableServer ioTableServer;

    @RequestMapping("index")
    public String index(){
        return "index";
    }
    //页面加载的时候读取所有tag存入本地文件
    @RequestMapping(value = "selectAllTag",method = {RequestMethod.POST,RequestMethod.GET},produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<String> selectAllTag(){
        List<String> listTag= ioTableServer.findTag();
        File file=null;
        FileWriter fw=null;
        List<String> msg=new ArrayList<String>();
        try{
             file=new File("../allTag.txt");
             fw=new FileWriter("../allTag.txt");
            fw.write(listTag.toString());
            fw.flush();
            fw.close();
            msg.add("Tag写入成功");
            System.out.println("写入成功了");
            return msg;
        }catch (Exception e){

            e.printStackTrace();
            System.out.println("写入失败");
            msg.add("Tag写入失败");
            return msg;
        }
    }
    //点击添加文本框按钮比较所有tag
    @RequestMapping(value = "bjAllTag",method = {RequestMethod.POST},produces = "application/json;charset=UTF-8")
    @ResponseBody
    public int bjAllTag(){
        int number=0;
        FileReader fr = null;
        BufferedReader br = null;
        StringBuffer txt = new StringBuffer();
        try {
            File file = new File("../allTag.txt");
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            String line = null;
            while((line = br.readLine()) != null){
                txt.append(line);
               // txt.append("\n");
            }
            br.close();
            fr.close();
            String txtTag = txt.toString();
            //获取数据库Tag
            List<String> sqlTag = ioTableServer.findTag();
            //System.out.println(txtTag);
            //System.out.println(sqlTag.toString());
            if (txtTag.equals(sqlTag.toString())){
                //相等返回1,不相等返回2，异常返回3
                number = 1;
                System.out.println("相等");
            }else{
                number = 2;
                System.out.println("不相等");

            }
        } catch (IOException e) {
            e.printStackTrace();
            number = 3;
            System.out.println("异常");
        } finally {
            if(br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return number;
        }
    }
    @RequestMapping(value = "findByTag",method = {RequestMethod.POST},produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<IoTable> findByTag(@RequestBody() String Tag, HttpServletRequest request){
//        Cookie[] cookies = request.getCookies();
//        for (Cookie cookie:cookies){
//            System.out.println("cookie:"+cookie.getName());
//            System.out.println("value:"+cookie.getValue());
//        }
        IoTable ioTable1 =new IoTable();
        System.out.println(Tag);
        ioTable1.setTag(Tag);
       List<IoTable> listIo=ioTableServer.findByTag(ioTable1);
        return listIo;
    }
    @RequestMapping(value = "editByTag",method = {RequestMethod.POST},produces = "application/json;charset=UTF-8")
    @ResponseBody
    public int editByTag( IoTable ioTable){

        System.out.println(ioTable.toString());
        try{
            ioTableServer.editByTag(ioTable);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            return 2;
        }


    }
    //删除
    @RequestMapping(value = "deleteByTag",method = {RequestMethod.POST},produces = "application/json;charset=UTF-8")
    @ResponseBody
    public int deleteByTag(@RequestBody String Tag){
        System.out.println("delete:"+Tag);
        IoTable ioTable=new IoTable();
        ioTable.setTag(Tag);
        int number;
        try{
            number= ioTableServer.deleteByTag(ioTable);
            if (number == 1){
                return 1;
            }else{
                return 0;
            }
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }

    }
    @RequestMapping(value = "addTag",method = {RequestMethod.POST},produces = "application/json;charset=UTF-8")
    @ResponseBody
    public int add( IoTable ioTable){

        System.out.println(ioTable.toString());
        try{
            ioTableServer.addTag(ioTable);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            return 2;
        }


    }
}
