package com.revu.data;

import java.io.File;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import commons.GlobalConstants_KR;

public class DynamicData {
	public static DynamicData getData() {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			return mapper.readValue(new File(GlobalConstants_KR.PROJECT_PATH + "/testdata/com/revu/data/DynamicData.json"), DynamicData.class);
			
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	@JsonProperty("email")
	String email;
}
