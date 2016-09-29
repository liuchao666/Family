package com.finance.model;

public class M_InCost {

	private int InID;
	private double Money;
	private String InTime;
	private String InType;
	private String Source;
	private String Depict;
	
	
	/**
	 * 默认构造函数
	 */
	public M_InCost()
	{
	super();
	}
	
	public M_InCost(int inid, double money,String intime,String intype,String source,String depict )
	{
		super();
		this.InID = inid;
		this.Money = money;
		this.InTime = intime;
		this.InType = intype;
		this.Source = source;
		this.Depict = depict;
	}

	public int getInID() {
		return InID;
	}

	public void setInID(int inID) {
		InID = inID;
	}

	public double getMoney() {
		return Money;
	}

	public void setMoney(double money) {
		Money = money;
	}

	public String getInTime() {
		return InTime;
	}

	public void setInTime(String inTime) {
		InTime = inTime;
	}

	public String getInType() {
		return InType;
	}

	public void setInType(String inType) {
		InType = inType;
	}

	public String getSource() {
		return Source;
	}

	public void setSource(String source) {
		Source = source;
	}

	public String getDepict() {
		return Depict;
	}

	public void setDepict(String depict) {
		Depict = depict;
	}

}
