package com.pawan.blog.exceptions;

public class ResourceNotFoundException extends RuntimeException {
	
	String resourceName;
	String fieldName;
	Long fieldValue;
	
	
	public ResourceNotFoundException(String resourceName, String fieldName, Long fieldValue) {
		super(String.format("%s not found with %s : %s", resourceName, fieldName, fieldValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}


	public String getResourceName() {
		return resourceName;
	}


	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}


	public String getFieldName() {
		return fieldName;
	}


	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}


	public Long getFieldValue() {
		return fieldValue;
	}


	public void setFieldValue(Long fieldValue) {
		this.fieldValue = fieldValue;
	}
	
	
	public ResourceNotFoundException()
	{
		
	}


	@Override
	public String toString() {
		return "ResourceNotFoundException [resourceName=" + resourceName + ", fieldName=" + fieldName + ", fieldValue="
				+ fieldValue + "]";
	}
	
}
