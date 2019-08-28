package com.example.demo.entiy;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: lijian
 * @create: 2019-08-28
 **/
@XStreamAlias("xml")
public class TestMessage extends Message {
    @XStreamAlias("Content")
    private String content ;

    public TestMessage() {

    }

    public TestMessage(Map<String,Object> map,String content) {
        super(map);
        setMsgType("text");
        this.content = content ;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "TestMessage{" +
                "content='" + content + '\'' +
                "} " + super.toString();
    }

    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("FromUserName", "FromUserName");
        map.put("ToUserName", "ToUserName");
        map.put("MsgType", "MsgType");
        TestMessage testMessage = new TestMessage(map, "hihao");
        XStream xStream = new XStream();
        xStream.processAnnotations(TestMessage.class);
        System.out.println(xStream.toXML(testMessage));
    }
}
