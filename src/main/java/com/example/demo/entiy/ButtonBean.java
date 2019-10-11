package com.example.demo.entiy;

import java.util.List;

/**
 * @description:
 * @author: lijian
 * @create: 2019-08-30
 **/
public class ButtonBean {
    /**
     * type : click
     * name : 今日歌曲
     * key : V1001_TODAY_MUSIC
     * sub_button : [{"type":"view","name":"搜索","url":"http://www.soso.com/"},{"type":"miniprogram","name":"wxa","url":"http://mp.weixin.qq.com","appid":"wx286b93c14bbf93aa","pagepath":"pages/lunar/index"},{"type":"click","name":"赞一下我们","key":"V1001_GOOD"}]
     */
    private String type;
    private String name;
    private String key;
    private List<SubButtonBean> subButton;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public List<SubButtonBean> getSubButton() {
        return subButton;
    }

    public void setSubButton(List<SubButtonBean> subButton) {
        this.subButton = subButton;
    }
}
