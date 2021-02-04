package com.cmcc.simulator.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.cmcc.simulator.module.Extension;
import com.cmcc.simulator.module.JobInfo;
import com.cmcc.simulator.module.JobResponse;
import com.cmcc.simulator.module.NSSIChangeNotify;
import com.cmcc.simulator.module.NestedNsInstance;
import com.cmcc.simulator.module.NestedVnfInstance;
import com.cmcc.simulator.module.NetworkSliceSubnet;
import com.cmcc.simulator.module.NsInstanceInfo;
import com.cmcc.simulator.module.Nssi;
import com.cmcc.simulator.module.NssiInfo;
import com.cmcc.simulator.module.NssiResponse;
import com.cmcc.simulator.module.PerfReq;
import com.cmcc.simulator.module.PerfReqEmbb;
import com.cmcc.simulator.module.PnfInfo;
import com.cmcc.simulator.module.ResponseDescriptor;
import com.cmcc.simulator.module.ResponseHistory;
import com.cmcc.simulator.module.SliceProfile;
import com.cmcc.simulator.module.VnfInstance;
import com.cmcc.simulator.service.SimulatorService;
import com.cmcc.simulator.util.StringUtil;

@RestController
@RequestMapping("/api/rest/provMns/v1")
public class SliceController {

	private static final Logger logger = LoggerFactory.getLogger(SliceController.class);

	@Autowired
	private SimulatorService service;

	@GetMapping("/NSS/nssi/{id}")
	public ResponseEntity<NssiInfo> getNSSIbyId(@PathVariable String id) {
		if (!service.getNssiIds().contains(id)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		NssiInfo nssiInfo = new NssiInfo();
		Nssi nssi = new Nssi();
		nssi.setNssiId("NSSI-C-001-HDBNJ-NSSMF-01-A-ZX");
		nssi.setNssiName("test_CN");
		nssi.setNsstId("NSST-C-001-HDBNJ-NSSMF-01-A-ZX");
		nssi.setFlavorId("ab9af40f13f721b5f ");
		nssi.setNssiState("enabled");

		NetworkSliceSubnet networkSliceSubnet = new NetworkSliceSubnet();

		String[] mfIdList = { "1301ZTHX2SMFA12ZA1", "1301ZTHX2UPF023A4D", "1301ZTHX2SMF723ADF" };
		NsInstanceInfo nsInfo = new NsInstanceInfo();
		List<SliceProfile> sliceProfileList = new ArrayList<>();

		nsInfo.setNsInstanceId("fe9af40f13f721b5f13539d87488899");
		nsInfo.setNsInstanceName("test_NS");
		nsInfo.setNsdId("7356240f13f721b5f13539d87ad2341");
		nsInfo.setNsState("nsState");

		List<VnfInstance> vnfInstanceList = new ArrayList<>();
		List<PnfInfo> pnfInfoList = new ArrayList<>();
		List<NestedNsInstance> nestedNsInstanceList = new ArrayList<>();

		VnfInstance vnfInstance = new VnfInstance("2345640f13f721b5f13539d8748ade4", "smf",
				"a345640f13f721b5f13539d8748adef", "active");
		vnfInstanceList.add(vnfInstance);

		PnfInfo pnfInfo = new PnfInfo("8aed640f13f721b5f13539d874812a8", "upf", "ffff640f13f721b5f13539d87482222");
		pnfInfoList.add(pnfInfo);

		NestedNsInstance nestedNsInstance = new NestedNsInstance();
		String[] nestedNsInstanceId = { "bbbcf40f13f721b5f13539d8748aedd" };
		nestedNsInstance.setNsInstanceId("1233f40f13f721b5f13539d87488333");
		nestedNsInstance.setNsInstanceName("nested_ns");
		nestedNsInstance.setNsdId("abc6240f13f721b5f13539d87ad2abc");
		nestedNsInstance.setNestedNsInstanceId(nestedNsInstanceId);
		nestedNsInstance.setNsState("active");

		NestedVnfInstance nestedVnfInstance = new NestedVnfInstance();
		nestedVnfInstance.setVnfInstanceId("amf");
		nestedVnfInstance.setVnfInstanceName("amf");
		nestedVnfInstance.setVnfdId("8885640f13f721b5f13539d8748adef");
		nestedVnfInstance.setInstantiationState("active");

		List<NestedVnfInstance> nestedVnfInstanceList = new ArrayList<>();
		nestedVnfInstanceList.add(nestedVnfInstance);
		nestedNsInstance.setNestedVnfInstanceList(nestedVnfInstanceList);

		nestedNsInstanceList.add(nestedNsInstance);

		nsInfo.setPnfInfo(pnfInfoList);
		nsInfo.setVnfInstance(vnfInstanceList);
		nsInfo.setNestedNsInstance(nestedNsInstanceList);

		SliceProfile sliceProfile = new SliceProfile();
		sliceProfile.setSliceProfileId("ab9af40f13f721b5f13539d87484098");

		int size = service.getSnssaiIds().size();
		String[] snssaiList = (String[]) service.getSnssaiIds().toArray(new String[size]);
		sliceProfile.setSnssaiList(snssaiList);

		String[] plmnIdList = { "460-00" };
		sliceProfile.setPlmnIdList(plmnIdList);

		PerfReq perfReq = new PerfReq();
		List<PerfReqEmbb> perfReqEmbbList = new ArrayList<>();
		PerfReqEmbb perfReqEmbb = new PerfReqEmbb();
		perfReqEmbb.setActivityFactor(50);
		perfReqEmbbList.add(perfReqEmbb);
		perfReq.setPerfReqEmbbList(perfReqEmbbList);

		sliceProfile.setPerfReq(perfReq);
		sliceProfile.setMaxNumberofUEs(200);
		sliceProfileList.add(sliceProfile);
		String[] coverageAreaTAList = { "1", "2", "3", "4" };
		sliceProfile.setCoverageAreaTAList(coverageAreaTAList);
		sliceProfile.setLatency(2);
		sliceProfile.setResourceSharingLevel("non-shared");

		networkSliceSubnet.setMfIdList(mfIdList);
		networkSliceSubnet.setNsInfo(nsInfo);
		networkSliceSubnet.setSliceProfileList(sliceProfileList);

		nssi.setNetworkSliceSubnet(networkSliceSubnet);

		nssiInfo.setNssiInfo(nssi);

		return new ResponseEntity<>(nssiInfo, HttpStatus.OK);
	}

	@GetMapping("/NSS/SliceProfiles/{id}")
	public ResponseEntity<NssiInfo> getNSSI(@PathVariable String id) {
		if (!service.getSliceProfileIds().contains(id)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		NssiInfo nssiInfo = new NssiInfo();
		Nssi nssi = new Nssi();
		nssi.setNssiId("NSSI-C-001-HDBNJ-NSSMF-01-A-ZX");
		nssi.setNssiName("test_CN");
		nssi.setNsstId("NSST-C-001-HDBNJ-NSSMF-01-A-ZX");
		nssi.setFlavorId("ab9af40f13f721b5f ");
		nssi.setNssiState("enabled");

		NetworkSliceSubnet networkSliceSubnet = new NetworkSliceSubnet();

		String[] mfIdList = { "1301ZTHX2SMFA12ZA1", "1301ZTHX2UPF023A4D", "1301ZTHX2SMF723ADF" };
		NsInstanceInfo nsInfo = new NsInstanceInfo();
		List<SliceProfile> sliceProfileList = new ArrayList<>();

		nsInfo.setNsInstanceId("fe9af40f13f721b5f13539d87488899");
		nsInfo.setNsInstanceName("test_NS");
		nsInfo.setNsdId("7356240f13f721b5f13539d87ad2341");
		nsInfo.setNsState("nsState");

		List<VnfInstance> vnfInstanceList = new ArrayList<>();
		List<PnfInfo> pnfInfoList = new ArrayList<>();
		List<NestedNsInstance> nestedNsInstanceList = new ArrayList<>();

		VnfInstance vnfInstance = new VnfInstance("2345640f13f721b5f13539d8748ade4", "smf",
				"a345640f13f721b5f13539d8748adef", "active");
		vnfInstanceList.add(vnfInstance);

		PnfInfo pnfInfo = new PnfInfo("8aed640f13f721b5f13539d874812a8", "upf", "ffff640f13f721b5f13539d87482222");
		pnfInfoList.add(pnfInfo);

		NestedNsInstance nestedNsInstance = new NestedNsInstance();
		String[] nestedNsInstanceId = { "bbbcf40f13f721b5f13539d8748aedd" };
		nestedNsInstance.setNsInstanceId("1233f40f13f721b5f13539d87488333");
		nestedNsInstance.setNsInstanceName("nested_ns");
		nestedNsInstance.setNsdId("abc6240f13f721b5f13539d87ad2abc");
		nestedNsInstance.setNestedNsInstanceId(nestedNsInstanceId);
		nestedNsInstance.setNsState("active");

		NestedVnfInstance nestedVnfInstance = new NestedVnfInstance();
		nestedVnfInstance.setVnfInstanceId("amf");
		nestedVnfInstance.setVnfInstanceName("amf");
		nestedVnfInstance.setVnfdId("8885640f13f721b5f13539d8748adef");
		nestedVnfInstance.setInstantiationState("active");

		List<NestedVnfInstance> nestedVnfInstanceList = new ArrayList<>();
		nestedVnfInstanceList.add(nestedVnfInstance);
		nestedNsInstance.setNestedVnfInstanceList(nestedVnfInstanceList);

		nestedNsInstanceList.add(nestedNsInstance);

		nsInfo.setPnfInfo(pnfInfoList);
		nsInfo.setVnfInstance(vnfInstanceList);
		nsInfo.setNestedNsInstance(nestedNsInstanceList);

		SliceProfile sliceProfile = new SliceProfile();
		sliceProfile.setSliceProfileId("ab9af40f13f721b5f13539d87484098");

		int size = service.getSnssaiIds().size();
		String[] snssaiList = (String[]) service.getSnssaiIds().toArray(new String[size]);
		sliceProfile.setSnssaiList(snssaiList);

		String[] plmnIdList = { "460-00" };
		sliceProfile.setPlmnIdList(plmnIdList);

		PerfReq perfReq = new PerfReq();
		List<PerfReqEmbb> perfReqEmbbList = new ArrayList<>();
		PerfReqEmbb perfReqEmbb = new PerfReqEmbb();
		perfReqEmbb.setActivityFactor(50);
		perfReqEmbbList.add(perfReqEmbb);
		perfReq.setPerfReqEmbbList(perfReqEmbbList);

		sliceProfile.setPerfReq(perfReq);
		sliceProfile.setMaxNumberofUEs(200);

		String[] coverageAreaTAList = { "1", "2", "3", "4" };
		sliceProfile.setCoverageAreaTAList(coverageAreaTAList);
		sliceProfile.setLatency(2);
		sliceProfile.setResourceSharingLevel("non-shared");
		sliceProfileList.add(sliceProfile);
		networkSliceSubnet.setMfIdList(mfIdList);
		networkSliceSubnet.setNsInfo(nsInfo);
		networkSliceSubnet.setSliceProfileList(sliceProfileList);

		nssi.setNetworkSliceSubnet(networkSliceSubnet);
//    	List<SliceProfile> sliceProfileList2 = new ArrayList<>();
//    	sliceProfileList.add(sliceProfile);
//    	nssi.setSliceProfileList(sliceProfileList2);
		nssiInfo.setNssiInfo(nssi);
		return new ResponseEntity<>(nssiInfo, HttpStatus.OK);
	}

	@DeleteMapping("/NSS/nssi/{nssiId}")
	public ResponseEntity<JobResponse> terminateNSSI(@PathVariable String nssiId, @RequestBody Nssi nssi) {

		logger.info("terminateNSSI: nssiid: {}, NSSI: {}", nssiId, JSONObject.toJSON(nssi).toString());
		if (service.getNssiIds().contains(nssiId)) {
			JobResponse res = new JobResponse();
			String jobId = UUID.randomUUID().toString().replaceAll("-", "");
			res.setJobId(jobId);
			service.removeNssiIds(nssiId);
			service.addJobIds(jobId);
			return new ResponseEntity<>(res, HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/NSS/SliceProfiles/{sliceProfileId}")
	public ResponseEntity<JobResponse> deallocateNSSI(@PathVariable String sliceProfileId,
			@RequestBody SliceProfile sliceProfile) {

		logger.info("deallocateNSSI: sliceProfileId: {}, sliceProfile: {}", sliceProfileId,
				JSONObject.toJSON(sliceProfile).toString());
		if (!service.getSliceProfileIds().contains(sliceProfileId)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		String nssiId = sliceProfile.getNssiId();
		if (service.getNssiIds().contains(nssiId)) {
			JobResponse res = new JobResponse();
			String jobId = UUID.randomUUID().toString().replaceAll("-", "");
			res.setJobId(jobId);
			service.removeNssiIds(nssiId);
			service.removeSliceProfileIds(sliceProfileId);
			service.addJobIds(jobId);
			String[] snssaiList = sliceProfile.getSnssaiList();
			Arrays.asList(snssaiList).stream().forEach(snssai -> {
				service.removeSnssaiIds(snssai);
				service.removeActivatedSlices(snssai);;
			});
			logger.info("deallocateNSSI response: {}", JSONObject.toJSON(res).toString());

			return new ResponseEntity<>(res, HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/NSS/SliceProfiles")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public NssiResponse allocateNSSI(@RequestBody Nssi nssi) {

		logger.info("allocateNSSI: Nssi: {}", JSONObject.toJSON(nssi).toString());

		String[] snssaiList = nssi.getSliceProfile().getSnssaiList();
		Arrays.asList(snssaiList).stream().forEach(snssai -> {
			service.addSnssaiIds(snssai);
		});

//		String nssiId = "NSSI-C-001-HDBNJ-NSSMF-01-A-ZX";
		String nssiId = nssi.getNssiId();
		if (nssiId == null) {
		     nssiId = "NSSI-C-" + StringUtil.randomStr(3) + "-HDBNJ-NSSMF-01-A-ZX";
		}
		String jobId = UUID.randomUUID().toString().replaceAll("-", "");
		NssiResponse res = new NssiResponse();
		res.setNssiId(nssiId);
		res.setJobId(jobId);

		service.addNssiIds(nssiId);
		service.addJobIds(jobId);
		service.addSliceProfileIds(nssi.getSliceProfile().getSliceProfileId());
		service.addNsstIds(nssi.getNsstId());

		logger.info("allocateNSSI response: {}", JSONObject.toJSON(res).toString());

		return res;
	}

	@PostMapping("/NSS/nssi/notification")
	@ResponseStatus(HttpStatus.CREATED)
	public Extension nSSIChangeNotify(@RequestBody NSSIChangeNotify nSSIChangeNotify) {
		logger.info("nSSIChangeNotify: {}", nSSIChangeNotify);
		return new Extension();
	}

	@PutMapping("/NSS/SliceProfiles/{sliceProfileId}")
	public ResponseEntity<JobResponse> modifyNSSI(@PathVariable String sliceProfileId, @RequestBody Nssi nssi) {

		logger.info("modifyNSSI: sliceProfileId: {}, Nssi {}", sliceProfileId, JSONObject.toJSON(nssi).toString());

		if (!service.getSliceProfileIds().contains(sliceProfileId)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		if (!service.getNssiIds().contains(nssi.getNssiId())) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		if (!service.getNsstIds().contains(nssi.getNsstId())) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		String jobId;
		JobResponse res = new JobResponse();
		if (nssi.getJobId() != null) {
			jobId = nssi.getJobId();
			res.setJobId(jobId);
		} else {
			jobId = UUID.randomUUID().toString().replaceAll("-", "");
			res.setJobId(jobId);
		}
		service.addJobIds(jobId);

		return new ResponseEntity<>(res, HttpStatus.ACCEPTED);
	}

	@PutMapping("/NSS/nssi/{nssiId}")
	public ResponseEntity<JobResponse> modifyNSSIbyId(@PathVariable String nssiId, @RequestBody Nssi nssi) {

		logger.info("modifyNSSIbyId: nssiId: {}, Nssi {}", nssiId, JSONObject.toJSON(nssi).toString());

		if (!service.getNssiIds().contains(nssiId)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		if (!service.getNsstIds().contains(nssi.getNsstId())) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		String jobId;
		JobResponse res = new JobResponse();
		if (nssi.getJobId() != null) {
			jobId = nssi.getJobId();
			res.setJobId(jobId);
		} else {
			jobId = UUID.randomUUID().toString().replaceAll("-", "");
			res.setJobId(jobId);
		}
		service.addJobIds(jobId);
		return new ResponseEntity<>(res, HttpStatus.ACCEPTED);
	}

	@PutMapping("/NSS/{snssai}/activation")
	public ResponseEntity<JobResponse> activateNSSI(@PathVariable String snssai, @RequestBody Nssi nssi) {
		logger.info("activateNSSI: snssai: {}, Nssi {}", snssai, JSONObject.toJSON(nssi).toString());

		if (!service.getSnssaiIds().contains(snssai)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		if (!service.getNssiIds().contains(nssi.getNssiId())) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		String jobId;
		JobResponse res = new JobResponse();
		if (nssi.getJobId() != null) {
			jobId = nssi.getJobId();
			res.setJobId(jobId);
		} else {
			jobId = UUID.randomUUID().toString().replaceAll("-", "");
			res.setJobId(jobId);
		}
		service.addJobIds(jobId);
		service.addActivatedSlices(snssai);
		logger.info("activateNSSI response: {}", JSONObject.toJSON(res).toString());

		return new ResponseEntity<>(res, HttpStatus.ACCEPTED);
	}

	@PutMapping("/NSS/{snssai}/deactivation")
	public ResponseEntity<JobResponse> deactivateNSSI(@PathVariable String snssai, @RequestBody Nssi nssi) {

		logger.info("deactivateNSSI: snssai: {}, Nssi {}", snssai, JSONObject.toJSON(nssi).toString());
		if (!service.getSnssaiIds().contains(snssai)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		if (!service.getNssiIds().contains(nssi.getNssiId())) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		String jobId;
		JobResponse res = new JobResponse();
		if (nssi.getJobId() != null) {
			jobId = nssi.getJobId();
			res.setJobId(jobId);
		} else {
			jobId = UUID.randomUUID().toString().replaceAll("-", "");
			res.setJobId(jobId);
		}
		service.addJobIds(jobId);
		service.removeActivatedSlices(snssai);
		logger.info("deactivateNSSI response: {}", JSONObject.toJSON(res).toString());

		return new ResponseEntity<>(res, HttpStatus.ACCEPTED);
	}

	@GetMapping("/NSS/jobs/{jobId}")
//    public ResponseEntity<JobInfo> getJobStatus(@PathVariable String jobId, @RequestParam("responseId") String responseId) {
	public ResponseEntity<JobInfo> getJobStatus(@PathVariable String jobId) {

//    	logger.info("get job status: jobid:{}, responseid:{}", jobId, responseId);
		logger.info("get job status: jobid:{}", jobId);

		if (!service.getJobIds().contains(jobId)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		ResponseDescriptor responseDescriptor = new ResponseDescriptor();
		Map<String, Integer> jobCheckCountMap = service.getJobCheckCount();
		if (jobCheckCountMap.get(jobId) == null) {
			service.updateJobCheckCount(jobId, 1);
			responseDescriptor.setProgress(20);
			responseDescriptor.setStatus("processing");
			responseDescriptor.setStatusDescription("Initiating VNF Instance");
			responseDescriptor.setResponseId("1");

		} else {
			List<ResponseHistory> responseHistoryList = new ArrayList<>();
			if (jobCheckCountMap.get(jobId) == 1) {
				service.updateJobCheckCount(jobId, 2);
				responseDescriptor.setProgress(40);
				responseDescriptor.setStatus("processing");
				responseDescriptor.setStatusDescription("Preparing for Instantiating NSSI");
				responseDescriptor.setResponseId("2");

				ResponseHistory responseHistory1 = new ResponseHistory();
				responseHistory1.setProgress(20);
				responseHistory1.setStatus("processing");
				responseHistory1.setStatusDescription("Initiating VNF Instance");
				responseHistory1.setResponseId("1");

				responseHistoryList.add(responseHistory1);
			}

			else if (jobCheckCountMap.get(jobId) == 2) {
				service.updateJobCheckCount(jobId, 3);
				responseDescriptor.setProgress(75);
				responseDescriptor.setStatus("processing");
				responseDescriptor.setStatusDescription("Check Requirements of NSSI");
				responseDescriptor.setResponseId("3");

				ResponseHistory responseHistory1 = new ResponseHistory();
				responseHistory1.setProgress(20);
				responseHistory1.setStatus("processing");
				responseHistory1.setStatusDescription("Initiating VNF Instance");
				responseHistory1.setResponseId("1");

				ResponseHistory responseHistory2 = new ResponseHistory();
				responseHistory2.setProgress(40);
				responseHistory2.setStatus("processing");
				responseHistory2.setStatusDescription("Preparing for Instantiating NSSI");
				responseHistory2.setResponseId("2");

				responseHistoryList.add(responseHistory1);
				responseHistoryList.add(responseHistory2);
			}

			else if (jobCheckCountMap.get(jobId) == 3) {
				service.updateJobCheckCount(jobId, 4);
				responseDescriptor.setProgress(100);
				responseDescriptor.setStatus("finished");
				responseDescriptor.setStatusDescription("Complete Successfully");
				responseDescriptor.setResponseId("4");

				ResponseHistory responseHistory1 = new ResponseHistory();
				responseHistory1.setProgress(20);
				responseHistory1.setStatus("processing");
				responseHistory1.setStatusDescription("Initiating VNF Instance");
				responseHistory1.setResponseId("1");

				ResponseHistory responseHistory2 = new ResponseHistory();
				responseHistory2.setProgress(40);
				responseHistory2.setStatus("processing");
				responseHistory2.setStatusDescription("Preparing for Instantiating NSSI");
				responseHistory2.setResponseId("2");

				ResponseHistory responseHistory3 = new ResponseHistory();
				responseHistory2.setProgress(75);
				responseHistory2.setStatus("processing");
				responseHistory2.setStatusDescription("Check Requirements of NSSI");
				responseHistory2.setResponseId("3");

				responseHistoryList.add(responseHistory1);
				responseHistoryList.add(responseHistory2);
				responseHistoryList.add(responseHistory3);
			}
			responseDescriptor.setResponseHistoryList(responseHistoryList);
		}

		JobInfo jobInfo = new JobInfo();
		jobInfo.setResponseDescriptor(responseDescriptor);
		return new ResponseEntity<>(jobInfo, HttpStatus.OK);

	}

	@GetMapping("/jobs")
	public List<String> getJobStatus() {
		return service.getJobIds();
	}

	@GetMapping("/snssaiIds")
	public List<String> getSnssaiIds() {
		return service.getSnssaiIds();
	}

	@GetMapping("/nssiIds")
	public List<String> getNssiIds() {
		return service.getNssiIds();
	}

	@GetMapping("/sliceProfileIds")
	public List<String> getSliceProfileIds() {
		return service.getSliceProfileIds();
	}

	@GetMapping("/nsstIds")
	public List<String> getNsstIds() {
		return service.getNsstIds();
	}

	@GetMapping("/activatedSlices")
	public List<String> getActivatedSlices() {
		return service.getActivatedSlices();
	}

	@GetMapping("/createPM")
	public void createPM() throws Exception {
		List<String> nsstIds = new ArrayList<>();
		nsstIds.add("01-12345678");
		nsstIds.add("01-23456789");
		service.createAMF(nsstIds);
		service.createUPF(nsstIds);
		service.gzipFiles();
	}
	
}