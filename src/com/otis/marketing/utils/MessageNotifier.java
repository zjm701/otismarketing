package com.otis.marketing.utils;

import java.util.ArrayList;
import java.util.List;

import javapns.devices.Device;
import javapns.devices.implementations.basic.BasicDevice;
import javapns.notification.AppleNotificationServerBasicImpl;
import javapns.notification.PushNotificationManager;
import javapns.notification.PushNotificationPayload;
import javapns.notification.PushedNotification;

import org.apache.log4j.Logger;

public class MessageNotifier {
	
	private static Logger logger = Logger.getLogger(MessageNotifier.class);
	
	//p12 path
	protected static final String path = "";

	public void pushMessage(List<String> tokens, String password, String message, Integer count) {
		try{
			PushNotificationPayload payLoad =  PushNotificationPayload.fromJSON(message);  
            payLoad.addAlert("iphone推送测试 www.baidu.com"); // 消息内容  
            payLoad.addBadge(count); // iphone应用图标上小红圈上的数值  
            payLoad.addSound("default"); // 铃音 默认  
            
            PushNotificationManager pushManager = new PushNotificationManager();  
            //true：表示的是产品发布推送服务 false：表示的是产品测试推送服务  
            pushManager.initializeConnection(new AppleNotificationServerBasicImpl(path, password, false));  
              
            List<PushedNotification> notifications = new ArrayList<PushedNotification>();   
            // 发送push消息  
            logger.debug("--------------------------apple 推送 群-------");  
            List<Device> device = new ArrayList<Device>();  
			for (String token : tokens) {
				device.add(new BasicDevice(token));
				notifications = pushManager.sendNotifications(payLoad, device);
			}
			
            List<PushedNotification> failedNotifications = PushedNotification.findFailedNotifications(notifications);  
            List<PushedNotification> successfulNotifications = PushedNotification.findSuccessfulNotifications(notifications);  
            int failed = failedNotifications.size();  
            int successful = successfulNotifications.size();  
            if (successful > 0 && failed == 0) {  
            	logger.debug("-----All notifications pushed 成功 (" + successfulNotifications.size() + "):");  
            } else if (successful == 0 && failed > 0) {  
            	logger.debug("-----All notifications 失败 (" + failedNotifications.size() + "):");  
            } else if (successful == 0 && failed == 0) {  
            	logger.warn("No notifications could be sent, probably because of a critical error");  
            } else {  
            	logger.debug("------Some notifications 失败 (" + failedNotifications.size() + "):");  
            	logger.debug("------Others 成功 (" + successfulNotifications.size() + "):");  
            }
		}catch(Exception e){
			logger.error(e);
		}
	}
}
