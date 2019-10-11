package com.example.demo.utils;

import com.example.demo.entiy.Message;
import com.example.demo.entiy.PictureTextMessage;
import com.example.demo.entiy.TestMessage;
import com.thoughtworks.xstream.XStream;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Map;

/**
 * @description:
 * @author: lijian
 * @create: 2019-08-28
 **/
public class WeChatUtils {
    public static String token = "lijian" ;



    public static boolean checParam(String timestamp, String nonce, String signature) {
        String[] array = {token,timestamp,nonce};
        Arrays.sort(array);
        String result = array[0]+array[1]+array[2] ;

        String mysig = sha1(result);

        return mysig.equalsIgnoreCase(signature);

    }

    private static String sha1(String result)  {

        try {
            MessageDigest digest = MessageDigest
                    .getInstance("SHA-1");
            digest.update(result.getBytes());
            byte messageDigest[] = digest.digest();
            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            // 字节数组转换为 十六进制 数
            for (int i = 0; i < messageDigest.length; i++) {
                String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexString.append(0);
                }
                hexString.append(shaHex);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";


    }

    public static String getResponse(Map<String, Object> map) {
        String MsgType= (String) map.get("MsgType");
        Message message = null ;
        switch (MsgType){
            case "text" : message = new TestMessage(map,"你要跟啥") ; break;
            case "image" : break;
            case "voice" : message = new PictureTextMessage(map) ;break;
            case "video" : break;
            case "shortvideo" : break;
            case "location" : break;
        }
        return messageToString(message);
    }

    private static String messageToString(Message message) {
        XStream xStream = new XStream();
//        xStream.processAnnotations(TestMessage.class);
        xStream.processAnnotations(PictureTextMessage.class);
        return xStream.toXML(message);
    }

}
