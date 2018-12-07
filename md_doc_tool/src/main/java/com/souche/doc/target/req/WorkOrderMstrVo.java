package com.souche.doc.target.req;

import java.io.Serializable;

import com.souche.optimus.saas.annotations.Validate;
import com.wordnik.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class WorkOrderMstrVo implements Serializable {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(notes="主键ID")
    private String id;

	@Validate(failMessage = "客户ID不能为空", require = true)
    @ApiModelProperty(notes="客户ID <必传>")
    private String cusId;

	@Validate(failMessage = "客户姓名不能为空", require = true)
    @ApiModelProperty(notes="客户姓名 <必传>")
    private String cusName;

	@Validate(failMessage = "客户联系电话不能为空", require = true)
    @ApiModelProperty(notes="客户联系电话（手机号或座机号 <必传>")
    private String cusContactPhone;

    @ApiModelProperty(notes="会员ID")
    private String memberId;

    @ApiModelProperty(notes="会员编码")
    private String memberNo;

    @Validate(failMessage = "车辆ID不能为空", require = true)
    @ApiModelProperty(notes="车辆ID <必传>")
    private String carId;

    @Validate(failMessage = "车架号不能为空", require = true)
    @ApiModelProperty(notes="车架号 <必传>")
    private String vin;

    @Validate(failMessage = "油表信息ID不能为空", require = true)
    @ApiModelProperty(notes="油表信息ID <必传>")
    private String fuelMeterScaleId;

    @Validate(failMessage = "油表信息编码不能为空", require = true)
    @ApiModelProperty(notes="油表信息编码 <必传>")
    private String fuelMeterScaleCode;

    @Validate(failMessage = "油表信息名称不能为空", require = true)
    @ApiModelProperty(notes="油表信息名称 <必传>")
    private String fuelMeterScaleName;
    
    @Validate(failMessage = "预计交车时间不能为空", require = true)
    @ApiModelProperty(notes="预计交车时间 <必传>")
    private String estimatedCarDeliveryDate;

    @Validate(failMessage = "送修人姓名不能为空", require=true)
    @ApiModelProperty(notes="送修人姓名 <必传>")
    private String carSenderName;

    @Validate(failMessage = "送修人电话不能为空", require=true)
    @ApiModelProperty(notes="送修人电话 <必传>")
    private String carSenderPhone;
    
    @Validate(failMessage = "进店里程不能为空", require = true)
    @ApiModelProperty(notes="进店里程 <必传>")
    private Integer inStoreMileage;
    
    @Validate(failMessage = "服务接待员工ID不能为空", require = true)
    @ApiModelProperty(notes="服务接待员工ID <必传>")
    private String scEmpId;

    @Validate(failMessage = "服务接待员工姓名不能为空", require = true)
    @ApiModelProperty(notes="服务接待员工姓名 <必传>")
    private String scEmpName;
    
    @Validate(failMessage = "业务类型ID不能为空", require = true)
    @ApiModelProperty(notes="业务类型ID <必传>")
    private String bizTypeId;

    @Validate(failMessage = "业务类型编码不能为空", require = true)
    @ApiModelProperty(notes="业务类型编码 <必传>")
    private String bizTypeCode;

    @Validate(failMessage = "业务类型名称不能为空", require = true)
    @ApiModelProperty(notes="业务类型名称 <必传>")
    private String bizTypeName;
    
    @ApiModelProperty(notes="厂商单号")
    private String oemOrderNo;

    @Validate(failMessage = "工时单价不能为空", require = true)
    @ApiModelProperty(notes="工时单价 <必传>")
    private String workHourlyPrice;

    @ApiModelProperty(notes="客户描述")
    private String cusDesc;

    @ApiModelProperty(notes="预检结果")
    private String precheckResult;

    @ApiModelProperty(notes="维修建议")
    private String repairAdvice;

    @ApiModelProperty(notes="客户带走旧件(1-是, 0-否)")
    private Byte cusTakeOldParts;
    
    @ApiModelProperty(notes="车辆洗车(1-是, 0-否)")
    private Byte carWash;
    
    @ApiModelProperty(notes="客户等待(1-是, 0-否)")
    private Byte cusWait;
    
    @ApiModelProperty(notes="客户路试(1-是, 0-否)")
    private Byte cusRoadTestDrive;
    
    @Validate(failMessage = "总金额不能为空", require = true)
	@ApiModelProperty(notes="总金额 <必传>")
    private String totalAmount;
	
    @Validate(failMessage = "商品金额不能为空", require = true)
	@ApiModelProperty(notes="商品金额 <必传>")
    private String goodsAmount;
	
    @Validate(failMessage = "施工金额不能为空", require = true)
	@ApiModelProperty(notes="施工金额 <必传>")
    private String workItemAmount;
	
    @Validate(failMessage = "应收金额不能为空", require = true)
	@ApiModelProperty(notes="应收金额 <必传>")
    private String receivableAmount;
	
    @Validate(failMessage = "付费金额不能为空", require = true)
	@ApiModelProperty(notes="付费金额 <必传>")
    private String payAmount;

}
