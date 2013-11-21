package sample.batch.main;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * the <code>BatchMain</code> class represents the batch main.
 * 
 * @author  Woong-Joon Kim
 * @version 1.00, 10/02/17
 * @see     jp.ameblo.invite.batch.main.InviteBatchMain#main()
 * @since   JDK1.7
 * Copyright: CYBER AGENT. LTD
 */
public class BatchMain {

	final static Logger logger = LoggerFactory.getLogger(BatchMain.class);

	public static void main(String[] args) throws Exception {

		try {
			BeanFactory beanFactory = new ClassPathXmlApplicationContext("springConfig.xml");
			File stopFile = (File) beanFactory.getBean("stopFile");

			// Execute the start and stop
			logger.info("quarts >>> start");
	        while(!stopFile.exists()){
	            try {
	                Thread.sleep(10000);
	                logger.info("quarts >>> working");
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }

			logger.info("quarts >>> stop");
		} catch (Exception e) {
			logger.error("Main Exception error", e);
		}
	}

}