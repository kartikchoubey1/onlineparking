package com.onlineparking.module.user;

public class WalletBookBean {
private Integer userId;
private Integer areaId;
private double wTotal;
private double wBill;
private String bookedSlot;
private String timeTaken;

public WalletBookBean() {
}

public WalletBookBean(Integer userId, Integer areaId, double wTotal, double wBill, String bookedSlot,
		String timeTaken) {
	this.userId = userId;
	this.areaId = areaId;
	this.wTotal = wTotal;
	this.wBill = wBill;
	this.bookedSlot = bookedSlot;
	this.timeTaken = timeTaken;
}

public Integer getUserId() {
	return userId;
}

public void setUserId(Integer userId) {
	this.userId = userId;
}

public Integer getAreaId() {
	return areaId;
}

public void setAreaId(Integer areaId) {
	this.areaId = areaId;
}

public double getwTotal() {
	return wTotal;
}

public void setwTotal(double wTotal) {
	this.wTotal = wTotal;
}

public double getwBill() {
	return wBill;
}

public void setwBill(double wBill) {
	this.wBill = wBill;
}

public String getBookedSlot() {
	return bookedSlot;
}

public void setBookedSlot(String bookedSlot) {
	this.bookedSlot = bookedSlot;
}

public String getTimeTaken() {
	return timeTaken;
}

public void setTimeTaken(String timeTaken) {
	this.timeTaken = timeTaken;
}

@Override
public String toString() {
	return "WalletBookBean [userId=" + userId + ", areaId=" + areaId + ", wTotal=" + wTotal + ", wBill=" + wBill
			+ ", bookedSlot=" + bookedSlot + ", timeTaken=" + timeTaken + "]";
}





}
