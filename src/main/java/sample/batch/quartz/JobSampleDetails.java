package sample.batch.quartz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.commons.configuration.Configuration;
import org.springframework.beans.factory.annotation.Autowired;

import sample.batch.service.BatchService;

public class JobSampleDetails {

	final Logger logger = LoggerFactory.getLogger(JobSampleDetails.class);

	@Autowired
    private Configuration configuration;
	@Autowired
	private BatchService batchService;

	public JobSampleDetails() {
	}

	public void executeJob() {

		try {
			batchService.selectSample("sample");
		} catch (Exception e) {
			logger.error("Exception >> ", e);
		}

	}

}