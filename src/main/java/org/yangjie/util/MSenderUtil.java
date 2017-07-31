package org.yangjie.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

/**
 * 消息发送者
 * @author Yangjie [2017年7月31日 下午5:12:41]
 */
@Component
public class MSenderUtil {
	
	private Logger logger = LoggerFactory.getLogger(MSenderUtil.class);
	
	@Autowired // 由springboot自动创建
	private JmsTemplate jmsTemplate;

	
	/**
	 * 发送消息
	 * @author Yangjie [2017年7月31日 下午5:14:34]
	 * @param destinationName
	 * @param message
	 */
	public void send(String destinationName, String message){
		logger.info("发送消息, destinationName={}, message={}", destinationName, message);
		jmsTemplate.convertAndSend(destinationName, message);
	}

}
