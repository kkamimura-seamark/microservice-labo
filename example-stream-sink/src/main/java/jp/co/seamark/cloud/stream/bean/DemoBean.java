package jp.co.seamark.cloud.stream.bean;

import java.math.BigDecimal;
import java.util.Date;

public class DemoBean {
	private String name;
	private String description;
	private Date createdAt;
	private BigDecimal decimalValue;
	public DemoBean(String name, String description, Date createdAt, BigDecimal decimalValue) {
		super();
		this.name = name;
		this.description = description;
		this.createdAt = createdAt;
		this.decimalValue = decimalValue;
	}
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public BigDecimal getDecimalValue() {
		return decimalValue;
	}

}
