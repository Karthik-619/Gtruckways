package com.cogzy.gtruckways.valueObjects;

import java.util.List;

import com.cogzy.gtruckways.businessObjects.TruckInfo;

public class GenericResponse {
	
	private String status_code, status_message;
	private Object response;
	
	
	private List<TruckInfo> list;
	
	public String getStatus_code() {
		return status_code;
	}
	public void setStatus_code(String status_code) {
		this.status_code = status_code;
	}
	public String getStatus_message() {
		return status_message;
	}
	public void setStatus_message(String status_message) {
		this.status_message = status_message;
	}
	public Object getResponse() {
		return response;
	}
	public void setResponse(Object response) {
		this.response = response;
	}
	public List<TruckInfo> getList() {
		return list;
	}
	public void setList(List<TruckInfo> list) {
		this.list = list;
	}
	
	
	

}
