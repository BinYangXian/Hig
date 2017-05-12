package com;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the history_order database table.
 * 
 */
@Entity
@Table(name="history_order")
@NamedQuery(name="HistoryOrder.findAll", query="SELECT h FROM HistoryOrder h")
public class HistoryOrder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="order_id")
	private int orderId;

	@Column(name="goods_num")
	private int goodsNum;

	@Column(name="goods_price")
	private int goodsPrice;

	@Column(name="goods_unit")
	private String goodsUnit;

	@Column(name="goods_value")
	private int goodsValue;

	@Column(name="order_addr")
	private String orderAddr;

	@Temporal(TemporalType.DATE)
	@Column(name="order_date")
	private Date orderDate;

	@Column(name="order_doods")
	private String orderDoods;

	@Column(name="order_status")
	private String orderStatus;

	@Column(name="order_total_val")
	private int orderTotalVal;

	private String remark1;

	private String remark2;

	private String remark3;

	//bi-directional many-to-one association to CrmCustomer
	private CrmCustomer crmCustomer;

	public HistoryOrder() {
	}

	public int getOrderId() {
		return this.orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getGoodsNum() {
		return this.goodsNum;
	}

	public void setGoodsNum(int goodsNum) {
		this.goodsNum = goodsNum;
	}

	public int getGoodsPrice() {
		return this.goodsPrice;
	}

	public void setGoodsPrice(int goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public String getGoodsUnit() {
		return this.goodsUnit;
	}

	public void setGoodsUnit(String goodsUnit) {
		this.goodsUnit = goodsUnit;
	}

	public int getGoodsValue() {
		return this.goodsValue;
	}

	public void setGoodsValue(int goodsValue) {
		this.goodsValue = goodsValue;
	}

	public String getOrderAddr() {
		return this.orderAddr;
	}

	public void setOrderAddr(String orderAddr) {
		this.orderAddr = orderAddr;
	}

	public Date getOrderDate() {
		return this.orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderDoods() {
		return this.orderDoods;
	}

	public void setOrderDoods(String orderDoods) {
		this.orderDoods = orderDoods;
	}

	public String getOrderStatus() {
		return this.orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public int getOrderTotalVal() {
		return this.orderTotalVal;
	}

	public void setOrderTotalVal(int orderTotalVal) {
		this.orderTotalVal = orderTotalVal;
	}

	public String getRemark1() {
		return this.remark1;
	}

	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}

	public String getRemark2() {
		return this.remark2;
	}

	public void setRemark2(String remark2) {
		this.remark2 = remark2;
	}

	public String getRemark3() {
		return this.remark3;
	}

	public void setRemark3(String remark3) {
		this.remark3 = remark3;
	}

	public CrmCustomer getCrmCustomer() {
		return this.crmCustomer;
	}

	public void setCrmCustomer(CrmCustomer crmCustomer) {
		this.crmCustomer = crmCustomer;
	}

}