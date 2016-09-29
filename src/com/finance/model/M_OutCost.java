package com.finance.model;

public class M_OutCost {

	private int OutID;
	private double Money;
	private String OutTime;
	private String OutType;
	private String Address;
	private String Depict;
	
	
	/**
	 *  默认构造函数
	 */
	public M_OutCost()
	{
		super();
	}
	
	/**
	 * 定义有参数的构造函数，初始化支出信息的各个字段
	 * @param outid  编号
	 * @param money  金额
	 * @param outtime 时间
	 * @param outtype 类别
	 * @param address 地点
	 * @param depict 备注
	 */
	public M_OutCost(int outid, double money,String outtime,String outtype,String address,String depict )
	{
		super();
		this.OutID = outid;
		this.Money = money;
		this.OutTime = outtime;
		this.OutType = outtype;
		this.Address = address;
		this.Depict = depict;
	}


	public int getOutID() {
		return OutID;
	}


	public void setOutID(int outID) {
		OutID = outID;
	}


	public double getMoney() {
		return Money;
	}


	public void setMoney(double money) {
		Money = money;
	}


	public String getOutTime() {
		return OutTime;
	}


	public void setOutTime(String outTime) {
		OutTime = outTime;
	}


	public String getOutType() {
		return OutType;
	}


	public void setOutType(String outType) {
		OutType = outType;
	}


	public String getAddress() {
		return Address;
	}


	public void setAddress(String address) {
		Address = address;
	}


	public String getDepict() {
		return Depict;
	}


	public void setDepict(String depict) {
		Depict = depict;
	}
	
	
}
