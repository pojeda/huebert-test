package com.tipitap.services.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class LibraryServiceImpl {
	
	public String getBooks(String path) throws Exception{
		String json = readFile(path);
		return json;
	}
	
	public void writeToFile(InputStream uploadedInputStream, String uploadedFileLocation) throws IOException {

		OutputStream out = new FileOutputStream(new File(uploadedFileLocation));
		int read = 0;
		byte[] bytes = new byte[1024];

		out = new FileOutputStream(new File(uploadedFileLocation));
		while ((read = uploadedInputStream.read(bytes)) != -1) {
			out.write(bytes, 0, read);
		}
		out.flush();
		out.close();

	}
	
	public static void writeText(String file, String text){
		 BufferedWriter writer = null;
	        try {
	            File logFile = new File(file);

	            writer = new BufferedWriter(new FileWriter(logFile));
	            writer.write(text);
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                writer.close();
	            } catch (Exception e) {
	            }
	        }
	}
	
	public static String readFile(String file) throws Exception {
		StringBuilder stringBuilder = new StringBuilder();
		BufferedReader reader = null;
		if (file != null) {
			try {
				reader = new BufferedReader(new FileReader(file));
				String line = null;
				String ls = System.getProperty("line.separator");

				while ((line = reader.readLine()) != null) {
					stringBuilder.append(line);
					stringBuilder.append(ls);
				}

			} catch (IOException ioe) {
				throw (ioe);
			} finally {
				if (reader != null) {
					try {
						reader.close();
					} catch (IOException e) {
						throw (e);
					}
				}
			}
		}

		return stringBuilder.toString();
	}
	
}
