/*
 * 文件名：UUIDGen.java
 * 版权：Copyright by will_awoke
 * 描述：
 * 修改人：lyh
 * 修改时间：2014-3-25
 * 跟踪单号：
 * 修改单号：
 * 修改内容：
 */

package com.baidu.ueditor;


import java.util.UUID;


/**
 * UUID生成器
 * @author will_awoke lyh_hnufe@aliyun.com
 * @version 2014-3-25
 * @see UUIDGen
 * @since
 */
public class UUIDGen
{

    /**
     * 生成32位UUID
     */
    public static String generate()
    {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replaceAll("-", "");
    }

}
