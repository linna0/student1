package com.example.feign.socket;

/**
 * @author:yln
 * @create:2022-06-05
 */
import lombok.Data;

import java.util.Date;

/**
 * 定义消息体
 * @author zheng
 * @version 1.0.0
 * @date 2021/6/22 10:13
 */
@Data
public class MessageBody {

    /**
     * 发送人姓名
     */
    private String fromName;

    /**
     * 接收人姓名
     */
    private String toName;

    /**
     * 消息内容
     */
    private String content;

    /**
     *
     * 发送时间
     */
    private Date sendTime;
}