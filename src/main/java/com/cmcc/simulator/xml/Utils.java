package com.cmcc.simulator.xml;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class Utils {

	public static String beanToXml(Object obj, Class<?> load) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(load);
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.setProperty(Marshaller.JAXB_ENCODING, "utf-8");
		StringWriter writer = new StringWriter();
		marshaller.marshal(obj, writer);
		return writer.toString();
	}

    public static void writeToFile(String outputFilePath, String content) {
        File file = new File(outputFilePath);
        try {
            FileWriter writer = new FileWriter(file);
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	public static String createAmfFile(List<Instance> objects) throws JAXBException {

		FileHeader fileHeader = new FileHeader();
		fileHeader.setElementType("AMF");
		fileHeader.setPmVersion("V0.4.0");
		fileHeader.setTimeZone("UTC+8");
		fileHeader.setVendorName("CMCC");
		fileHeader.setPeriod(15);
		fileHeader.setStartTime(Utils.getTimeShort());
		fileHeader.setTimeStamp(Utils.getTimeShort());

		Measurements measurements = new Measurements();
		PmData pmData = new PmData(objects);
		N n46 = new N("46", "AMF.RegSub._NS");
		List<N> ns = new ArrayList<>();
		ns.add(n46);
		measurements.setN(ns);
		measurements.setObjectType("AmfFunction");
		measurements.setPmData(pmData);

		PmFile pmFile = new PmFile(fileHeader, measurements);
		String str = Utils.beanToXml(pmFile, PmFile.class);

		str = str.replaceAll("<sns>", "");
		str = str.replaceAll("</sns>", "");
		str = str.replaceAll("((\r\n)|\n)[\\s\t ]*(\\1)+", "$1").replaceAll("^((\r\n)|\n)", "");
		return str;

	}

	public static String createUPFFile(List<Instance> objects) throws Exception {
		FileHeader fileHeader = new FileHeader();
		fileHeader.setElementType("UPF");
		fileHeader.setPmVersion("V0.4.0");
		fileHeader.setTimeZone("UTC+8");
		fileHeader.setVendorName("CMCC");
		fileHeader.setPeriod(15);
		fileHeader.setStartTime(Utils.getTimeShort());
		fileHeader.setTimeStamp(Utils.getTimeShort());

		Measurements measurements = new Measurements();
		PmData pmData = new PmData(objects);
		N n9 = new N("9", "UPF.N3IncPkt._Dnn");
		N n11 = new N("11", "UPF.N3OgPkt._Dnn");
		List<N> ns = new ArrayList<>();
		ns.add(n9);
		ns.add(n11);
		measurements.setN(ns);
		measurements.setObjectType("UpfFunction");
		measurements.setPmData(pmData);

		PmFile pmFile = new PmFile(fileHeader, measurements);
		String str = Utils.beanToXml(pmFile, PmFile.class);

		str = str.replaceAll("<sns>", "");
		str = str.replaceAll("</sns>", "");
		str = str.replaceAll("((\r\n)|\n)[\\s\t ]*(\\1)+", "$1").replaceAll("^((\r\n)|\n)", "");
		return str;
		
	}

    public  static boolean delFile(File file) {
        if (!file.exists()) {
            return false;
        }

        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
                delFile(f);
            }
        }
        return file.delete();
    }


    public static String getTimeShort() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date currentTime = new Date();
        String dateString = formatter.format(currentTime);
        return dateString;
     }

    public static String getTimeFormat() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date currentTime = new Date();
        String dateString = formatter.format(currentTime);
        return dateString;
     }

}