package com.cmcc.simulator.job;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.cmcc.simulator.service.SimulatorService;
import com.cmcc.simulator.xml.FileReadyEvent;
import com.cmcc.simulator.xml.Utils;

@Component
@EnableScheduling
public class ScheduleJob {

	private static final Logger logger = LoggerFactory.getLogger(ScheduleJob.class);
	@Autowired
	private SimulatorService service;

	@Value("${ftppath}")
	private String ftpPath;

	@Scheduled(fixedDelayString = "${fixeddelay}")
	public void runThird() throws Exception {
		List<String> nsstIds = service.getActivatedSlices();
		if (!nsstIds.isEmpty()) {
			logger.info("the snssai list is : {}", nsstIds);
			service.createAMF(nsstIds);
			service.createUPF(nsstIds);
			service.gzipFiles();

			List<String> list = new ArrayList<String>();
			list.add(ftpPath);

			FileReadyEvent event = new FileReadyEvent();
			event.setCreateat(Utils.getTimeFormat());
			event.setDatasource("VIM");
			event.setFileuri(list);
			event.setNfvoid("10.10.10.1");
			event.setSourceid("10011001");

			service.notify(event);
			service.delFiles();
			logger.info("notify pm data success: {}", JSONObject.toJSON(event).toString());
		}
	}

}
