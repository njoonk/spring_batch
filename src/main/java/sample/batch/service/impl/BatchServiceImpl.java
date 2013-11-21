package sample.batch.service.impl;

import org.apache.commons.configuration.Configuration;
import org.springframework.beans.factory.annotation.Autowired;

import sample.batch.service.BatchService;

/**
 * This's Class is something to do .....
 * 
 * @author Woong-joon Kim
 * @lastModified $Date: 2012/05/15 08:49:41 $ By $Author: kim_woongjoon $
 * @version $Revision: 1.7 $
 * Copyright: NO
 */
public class BatchServiceImpl implements BatchService {

	@Autowired
    private Configuration configuration;

	public void selectSample(String sample) throws Exception {
		System.out.println("This is sample batch");
	}

}