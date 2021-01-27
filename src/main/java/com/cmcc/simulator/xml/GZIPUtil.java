package com.cmcc.simulator.xml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;
import org.apache.commons.compress.utils.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GZIPUtil {

	private static final Logger logger = LoggerFactory.getLogger(GZIPUtil.class);
	public static File pack(File[] sources, File target) {
		FileOutputStream out = null;
		try {
			out = new FileOutputStream(target);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		TarArchiveOutputStream os = new TarArchiveOutputStream(out);
		for (File file : sources) {
			try {
				TarArchiveEntry tae = new TarArchiveEntry(file);
				 tae.setName(file.getName());
				                os.putArchiveEntry(tae);
//				os.putArchiveEntry(tae);
				IOUtils.copy(new FileInputStream(file), os);
				os.closeArchiveEntry();

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (os != null) {
			try {
				os.flush();
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return target;
	}


	public static File compress(String filePath, File source) {

		File target = new File(filePath + "/" + source.getName() + ".gz");
		FileInputStream in = null;
		GZIPOutputStream out = null;
		try {
			in = new FileInputStream(source);
			out = new GZIPOutputStream(new FileOutputStream(target));
			byte[] array = new byte[1024];
			int number = -1;
			while ((number = in.read(array, 0, array.length)) != -1) {
				out.write(array, 0, number);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
					return null;
				}
			}

			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return target;
	}

	public static void doCompressFileToGz(String inFileName) {
		try {

			logger.debug("Creating the GZIP output stream.");
			String outFileName = inFileName + ".gz";
			GZIPOutputStream out = null;
			try {
				out = new GZIPOutputStream(new FileOutputStream(outFileName));
			} catch (FileNotFoundException e) {
				logger.info("Could not create file: " + outFileName);
				System.exit(1);
			}

			logger.debug("Opening the input file.");
			FileInputStream in = null;
			try {
				in = new FileInputStream(inFileName);
			} catch (FileNotFoundException e) {
				logger.error("File not found. " + inFileName);
				System.exit(1);
			}

			logger.debug("Transfering bytes from input file to GZIP Format.");
			byte[] buf = new byte[1024];
			int len;
			while ((len = in.read(buf)) > 0) {
				out.write(buf, 0, len);
			}
			in.close();

			logger.info("Completing the GZIP file");
			out.finish();
			out.close();

		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
}
