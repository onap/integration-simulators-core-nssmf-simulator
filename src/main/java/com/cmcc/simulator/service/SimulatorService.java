package com.cmcc.simulator.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.cmcc.simulator.xml.CV;
import com.cmcc.simulator.xml.FileReadyEvent;
import com.cmcc.simulator.xml.GZIPUtil;
import com.cmcc.simulator.xml.Instance;
import com.cmcc.simulator.xml.SN;
import com.cmcc.simulator.xml.Utils;
import com.cmcc.simulator.xml.V;

@Component
public class SimulatorService {

    @Autowired
    RestTemplate restTemplate;

	private List<String> snssaiIds = new ArrayList<>();

	private List<String> nssiIds = new ArrayList<>();

	private List<String> jobIds = new ArrayList<>();

	private List<String> sliceProfileIds = new ArrayList<>();

	private List<String> nsstIds = new ArrayList<>();

	private Map<String, Integer> jobCheckCount = new HashMap<String,Integer>(); 

	private List<String> activatedSlices = new ArrayList<>();
	
	@Value("${filepath}")
	private String filePath;

	@Value("${notifyurl}")
	private String url;

	@Value("${amffilepath}")
	private String amfFilePath;

	@Value("${upffilepath}")
	private String upfFilePath;

	public List<String> getActivatedSlices() {
		return activatedSlices;
	}

	public List<String> getSnssaiIds() {
		return snssaiIds;
	}

	public List<String> getNssiIds() {
		return nssiIds;
	}

	public List<String> getJobIds() {
		return jobIds;
	}

	public List<String> getSliceProfileIds() {
		return sliceProfileIds;
	}

	public List<String> getNsstIds() {
		return nsstIds;
	}

	public synchronized void addActivatedSlices(String snssaiId) {
		if (!activatedSlices.contains(snssaiId))
			activatedSlices.add(snssaiId);
	}

	public synchronized void removeActivatedSlices(String snssaiId) {
		if (activatedSlices.contains(snssaiId))
			activatedSlices.remove(snssaiId);
	}
	
	public synchronized void addNsstIds(String nsstId) {
		if (!nsstIds.contains(nsstId))
			nsstIds.add(nsstId);
	}

	public synchronized void removeNsstIds(String nsstId) {
		if (nsstIds.contains(nsstId))
			nsstIds.remove(nsstId);
	}

	public synchronized void addSliceProfileIds(String sliceProfileId) {
		if (!sliceProfileIds.contains(sliceProfileId))
			sliceProfileIds.add(sliceProfileId);
	}

	public synchronized void removeSliceProfileIds(String sliceProfileId) {
		if (sliceProfileIds.contains(sliceProfileId))
			sliceProfileIds.remove(sliceProfileId);
	}

	public synchronized void addSnssaiIds(String snssaiId) {
		if (!snssaiIds.contains(snssaiId))
		    snssaiIds.add(snssaiId);
	}

	public synchronized void removeSnssaiIds(String snssaiId) {
		if (snssaiIds.contains(snssaiId))
		    snssaiIds.remove(snssaiId);
	}

	public synchronized void addNssiIds(String nssiId) {
		if (!nssiIds.contains(nssiId))
			nssiIds.add(nssiId);
	}

	public synchronized void removeNssiIds(String nssiId) {
		if (nssiIds.contains(nssiId))
			nssiIds.remove(nssiId);
	}

	public synchronized void addJobIds(String jobId) {
		if (!jobIds.contains(jobId))
			jobIds.add(jobId);
	}

	public synchronized void removeJobIds(String jobId) {
		if (jobIds.contains(jobId))
			jobIds.remove(jobId);
	}

	public void createAMF(List<String> nsstIds) throws Exception {
		List<Instance> objects = new ArrayList<>();
		Instance object1 = new Instance();
		Instance object2 = new Instance();
		List<SN> sns1 = new ArrayList<>();
		List<SN> sns2 = new ArrayList<>();
		CV cv1 = new CV();
		CV cv2 = new CV();
		List<CV> cvs1 = new ArrayList<>();
		List<CV> cvs2 = new ArrayList<>();

		V v1 = new V("1", 1);
		V v2 = new V("2", 2);
		V v3 = new V("3", 3);
		List<V> vs = new ArrayList<>();
		vs.add(v1);
		vs.add(v2);
		vs.add(v3);

		nsstIds.forEach(nssiId -> {
			SN sn1 = new SN("AMF.RegSub.460_08_" + nssiId, (int) (Math.random() * (100 - 1) + 1));
			SN sn2 = new SN("AMF.RegSub.460_08_" + nssiId, (int) (Math.random() * (100 - 1) + 1));
			sns1.add(sn1);
			sns2.add(sn2);
			cv1.setI("46");
			cv1.setSns(sns1);
			cv2.setI("46");
			cv2.setSns(sns2);
		});
		cvs1.add(cv1);
		cvs2.add(cv2);
		object1.setCvs(cvs1);
		object2.setCvs(cvs2);
		object2.setVs(vs);
		object1.setVs(vs);
		objects.add(object1);
		objects.add(object2);
		String str = Utils.createAmfFile(objects);
		String xmlPath =  filePath + "/AMF.xml";
		BufferedWriter bfw = new BufferedWriter(new FileWriter(new File(xmlPath)));
		bfw.write(str);
		bfw.close();	
		GZIPUtil.doCompressFileToGz(xmlPath);
	}

	public void createUPF(List<String> nsstIds) throws Exception {
		List<Instance> objects = new ArrayList<>();
		Instance object1 = new Instance();
		Instance object2 = new Instance();

		List<SN> sns1 = new ArrayList<>();
		List<SN> sns2 = new ArrayList<>();
		List<SN> sns3 = new ArrayList<>();
		List<SN> sns4 = new ArrayList<>();

		List<CV> cvs1 = new ArrayList<>();
		List<CV> cvs2 = new ArrayList<>();

		V v1 = new V("1", 1);
		V v2 = new V("2", 2);
		V v3 = new V("3", 3);
		List<V> vs = new ArrayList<>();
		vs.add(v1);
		vs.add(v2);
		vs.add(v3);

		CV cv1 = new CV();
		CV cv2 = new CV();
		CV cv3 = new CV();
		CV cv4 = new CV();

		nsstIds.forEach(nssiId -> {
			SN sn1 = new SN("UPF.N3IncPkt.340_110_" + nssiId, (int) (Math.random() * (100 - 1) + 1));
			sns1.add(sn1);
			cv1.setI("9");
			cv1.setSns(sns1);

			SN sn2 = new SN("UPF.N3OgOct.340_110_" + nssiId, (int) (Math.random() * (100 - 1) + 1));
			sns2.add(sn2);
			cv2.setI("11");
			cv2.setSns(sns2);


			SN sn3 = new SN("UPF.N3IncPkt.340_110_" + nssiId, (int) (Math.random() * (100 - 1) + 1));
			sns3.add(sn3);
			cv3.setI("9");
			cv3.setSns(sns3);

			SN sn4 = new SN("UPF.N3OgOct.340_110_" + nssiId, (int) (Math.random() * (100 - 1) + 1));
			sns4.add(sn4);
			cv4.setI("11");
			cv4.setSns(sns4);

		});
		cvs1.add(cv1);
		cvs1.add(cv2);
		cvs2.add(cv3);
		cvs2.add(cv4);
		object1.setCvs(cvs1);
		object2.setCvs(cvs2);
		object2.setVs(vs);
		object1.setVs(vs);
		objects.add(object1);
		objects.add(object2);
		String str = Utils.createUPFFile(objects);
		String xmlPath = filePath + "/UPF.xml";
		BufferedWriter bfw = new BufferedWriter(new FileWriter(new File(xmlPath)));
		bfw.write(str);
		bfw.close();		
		GZIPUtil.doCompressFileToGz(xmlPath);
	}
	
    public void notify(FileReadyEvent event) throws Exception {
    	SimulatorService.sendHttpPost(url, JSON.toJSONString(event));
    }

    public void gzipFiles() {
		File[] sources = new File[] { new File(amfFilePath),
				  new File(upfFilePath) };
		// Define a the *.tar file ,the file in sources will be tar to the target
		File target = new File(filePath + "/PM.tar");
		// compress the files into *.tar.gz
	    GZIPUtil.compress(filePath, GZIPUtil.pack(sources, target));
    }

    public void delFiles() {
    	Utils.delFile(new File(filePath + "/AMF.xml"));
    	Utils.delFile(new File(filePath + "/UPF.xml"));
    	Utils.delFile(new File(amfFilePath));
    	Utils.delFile(new File(upfFilePath));
    	Utils.delFile(new File(filePath + "/PM.tar"));    	
//    	Utils.delFile(new File(filePath + "/PM.tar.gz"));    	
    }
    public static void sendHttpPost(String url, String JSONBody) throws Exception {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(url);
		httpPost.addHeader("Content-Type", "application/json");
		httpPost.setEntity(new StringEntity(JSONBody));
		CloseableHttpResponse response = httpClient.execute(httpPost);

		response.close();
		httpClient.close();
	}

	public void updateJobCheckCount(String jobId,  Integer count) {
		if (count != 4) {
			jobCheckCount.put(jobId, count);
		} else {
			jobCheckCount.remove(jobId);
		}
	}
  
	public Map<String, Integer> getJobCheckCount() {
		return jobCheckCount;
	}
}
