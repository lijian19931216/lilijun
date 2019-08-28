package com.example.demo.controller;

import org.dom4j.DocumentHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;

/**
 * @description:
 * @author: lijian
 * @create: 2019-08-28
 **/
@RestController
@RequestMapping("/hh")
public class TestController {
    @RequestMapping("/hh")
    public String test(HttpServletRequest request){
        String signature = request.getParameter("signature");
        System.out.println(signature);
        String timestamp = request.getParameter("timestamp");
        System.out.println(timestamp);
        String nonce = request.getParameter("nonce");
        System.out.println(nonce);
        String echostr = request.getParameter("echostr");
        System.out.println(echostr);

        try {
            ServletInputStream inputStream = request.getInputStream();
            byte[] box = new byte[1024];
            int len = 0;
            StringBuilder builder = new StringBuilder();
            while(-1!=(len = inputStream.read(box))) {
                System.out.println(len);
                String msg = new String(box, 0, len);
                builder.append(msg);
            }
            System.out.println(builder.toString());
            System.out.println(XmlUtils.Dom2Map(DocumentHelper.parseText(builder.toString())));
        } catch (Exception e) {
            e.printStackTrace();
        }


        if(WeChatUtils.checParam(timestamp,nonce,signature)){

            System.out.println("chengongo");
            return echostr;
        }else {

        }
        System.out.println("hhhh");
        return null ;
    }
    @RequestMapping("/hhh")
    public void test(){
        System.out.println("hhhh");
    }
}
