package com.souche.doc.model;

import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class DocContent implements Serializable {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(notes="字段名称")
	private String fieldName;
	
	@ApiModelProperty(notes="字段类型")
	private String fieldType;
	
	@ApiModelProperty(notes="说明")
	private String Description;
	
	@ApiModelProperty(notes="是否必传或备注")
	private String isRequireOrRemark;
	
	public DocContent() {
		super();
	}
	
	public DocContent(String fieldName, String fieldType, String description, String isRequireOrRemark) {
		super();
		this.fieldName = fieldName;
		this.fieldType = fieldType;
		Description = description;
		this.isRequireOrRemark = isRequireOrRemark;
	}
	
}
