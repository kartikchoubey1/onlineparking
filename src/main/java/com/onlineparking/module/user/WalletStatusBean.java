package com.onlineparking.module.user;

public class WalletStatusBean {
private int ownerId;
private double amount;
private boolean isSuccess;
public WalletStatusBean(int ownerId, double amount, boolean isSuccess) {
	this.ownerId = ownerId;
	this.amount = amount;
	this.isSuccess = isSuccess;
}
public WalletStatusBean() {
}
public int getOwnerId() {
	return ownerId;
}
public void setOwnerId(int ownerId) {
	this.ownerId = ownerId;
}
public double getAmount() {
	return amount;
}
public void setAmount(double amount) {
	this.amount = amount;
}
public boolean isSuccess() {
	return isSuccess;
}
public void setSuccess(boolean isSuccess) {
	this.isSuccess = isSuccess;
}
@Override
public String toString() {
	return "WalletStatusBean [ownerId=" + ownerId + ", amount=" + amount + ", isSuccess=" + isSuccess + "]";
}


}
