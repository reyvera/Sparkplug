/*
 * Licensed Materials - Property of Cirrus Link Solutions
 * Copyright (c) 2016 Cirrus Link Solutions LLC - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package com.cirruslink.sparkplug.message.model;

import java.util.Arrays;

import com.cirruslink.sparkplug.json.FileSerializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonIgnoreProperties(value = { "fileName" })
@JsonSerialize(using = FileSerializer.class)
public class File {
	
	private String fileName;
	private byte[] bytes;
	
	public File() {
		super();
	}
	
	public File(String fileName, byte[] bytes) {
		super();
		this.fileName = fileName == null 
				? null 
				: fileName.replace("/", System.getProperty("file.separator"))
						.replace("\\", System.getProperty("file.separator"));
		this.bytes = Arrays.copyOf(bytes, bytes.length);
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public byte[] getBytes() {
		return bytes;
	}

	public void setBytes(byte[] bytes) {
		this.bytes = bytes;
	}
	
	@Override
	public String toString() {
		return "File [fileName=" + fileName + ", bytes length=" + bytes.length + "]";
	}
}
