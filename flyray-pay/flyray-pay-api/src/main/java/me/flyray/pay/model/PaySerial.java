package me.flyray.pay.model;

import java.math.BigDecimal;

/** 
* @author: bolei
* @date：2017年3月6日 下午10:14:30 
* @description： 支付流水 
*/

public class PaySerial {

	/**
	 * 支付流水号
	 */
	private String serialNo;
	
	/**
	 * 订单号
	 */
	private String payOrderNo;
	
	/**
	 * 支付渠道号
	 */
	private String payChannelNo;
	
	/**
	 * 支付公司编号
	 */
	private String payCompanyNo;
	
	/**
	 * 交易金额
	 */
	private BigDecimal payAmt;
	
	/**
	 * 交易手续费
	 */
	private BigDecimal payFee;
	
	/**
	 * 支付记账状态
	 */
	private String accountStatus;
	
	/**
	 * 支付状态
	 */
	private String payStatus;

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}


	public String getPayOrderNo() {
		return payOrderNo;
	}

	public void setPayOrderNo(String payOrderNo) {
		this.payOrderNo = payOrderNo;
	}

	public String getPayChannelNo() {
		return payChannelNo;
	}

	public void setPayChannelNo(String payChannelNo) {
		this.payChannelNo = payChannelNo;
	}

	public String getPayCompanyNo() {
		return payCompanyNo;
	}

	public void setPayCompanyNo(String payCompanyNo) {
		this.payCompanyNo = payCompanyNo;
	}

	public BigDecimal getPayAmt() {
		return payAmt;
	}

	public void setPayAmt(BigDecimal payAmt) {
		this.payAmt = payAmt;
	}

	public BigDecimal getPayFee() {
		return payFee;
	}

	public void setPayFee(BigDecimal payFee) {
		this.payFee = payFee;
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	public String getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}
	
}
