package com.souche.doc.target.rsp;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import com.wordnik.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class QueryWorkOrderMstrDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes="主键ID")
    private String id;
	
	@ApiModelProperty(notes="工单号")
    private String woNo;
	
	@ApiModelProperty(notes="制单人ID")
    private String woCreatorEmpId;
	
	@ApiModelProperty(notes="制单人姓名")
    private String woCreatorEmpName;
	
    @ApiModelProperty(notes="工单创建时间")
    private Date woCreateDate;
    
    @ApiModelProperty(notes="工单状态ID")
    private String woStatusId;

    @ApiModelProperty(notes="工单状态编码")
    private String woStatusCode;

    @ApiModelProperty(notes="工单状态名称")
    private String woStatusName;

    @ApiModelProperty(notes="客户ID")
    private String cusId;

    @ApiModelProperty(notes="客户姓名")
    private String cusName;

    @ApiModelProperty(notes="客户联系电话（手机号或座机号）")
    private String cusContactPhone;

    @ApiModelProperty(notes="会员ID")
    private String memberId;

    @ApiModelProperty(notes="会员编码")
    private String memberNo;

    @ApiModelProperty(notes="车辆ID")
    private String carId;

    @ApiModelProperty(notes="车架号")
    private String vin;
    
    @ApiModelProperty(notes="车牌号")
    private String carPlateNo;
    
    @ApiModelProperty("品牌ID")
 	private String carBrandId;

 	@ApiModelProperty("品牌名称")
 	private String carBrandName;
 	
    @ApiModelProperty("车系ID")
 	private String carSeriesId;

 	@ApiModelProperty("车系名称")
 	private String carSeriesName;
 	
    @ApiModelProperty("车型ID")
	private String carModelId;

	@ApiModelProperty("车型名称")
	private String carModelName;
	
	@ApiModelProperty("发动机号")
	private String carEngineeNo;
	
	@ApiModelProperty("车身色名称")
	private String carColorName;

	@ApiModelProperty("车辆动力类型名称")
	private String carPowerTypeName;
    
    @ApiModelProperty(notes="油表信息ID")
    private String fuelMeterScaleId;

    @ApiModelProperty(notes="油表信息编码")
    private String fuelMeterScaleCode;

    @ApiModelProperty(notes="油表信息名称")
    private String fuelMeterScaleName;
    
    @ApiModelProperty(notes="预计交车时间")
    private Date estimatedCarDeliveryDate;

    @ApiModelProperty(notes="送修人姓名")
    private String carSenderName;

    @ApiModelProperty(notes="送修人电话")
    private String carSenderPhone;
    
    @ApiModelProperty(notes="进店里程")
    private Integer inStoreMileage;
    
    @ApiModelProperty(notes="服务接待员工ID")
    private String scEmpId;

    @ApiModelProperty(notes="服务接待员工姓名")
    private String scEmpName;
    
    @ApiModelProperty(notes="业务类型ID")
    private String bizTypeId;

    @ApiModelProperty(notes="业务类型编码")
    private String bizTypeCode;

    @ApiModelProperty(notes="业务类型名称")
    private String bizTypeName;
    
    @ApiModelProperty(notes="厂商单号")
    private String oemOrderNo;

    @ApiModelProperty(notes="工时单价")
    private BigDecimal workHourlyPrice;
    
    @ApiModelProperty(notes="金额")
    private BigDecimal amount;
    
    @ApiModelProperty(notes="优惠金额")
    private BigDecimal reduceAmount;

    @ApiModelProperty(notes="应收金额")
    private BigDecimal receivableAmount;

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
    
    @ApiModelProperty(notes="创建日期")
    private Date createDate;

    @ApiModelProperty(notes="创建人用户ID")
    private String createUserId;

    @ApiModelProperty(notes="创建人用户名")
    private String createUserName;

}
