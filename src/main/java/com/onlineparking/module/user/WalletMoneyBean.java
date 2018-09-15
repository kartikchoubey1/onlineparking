package com.onlineparking.module.user;

public class WalletMoneyBean {
private int walletId;
private double totalAmount;

public WalletMoneyBean() {
}

public WalletMoneyBean(int walletId, double totalAmount) {
	this.walletId = walletId;
	this.totalAmount = totalAmount;
}

public int getWalletId() {
	return walletId;
}

public void setWalletId(int walletId) {
	this.walletId = walletId;
}

public double getTotalAmount() {
	return totalAmount;
}

public void setTotalAmount(double totalAmount) {
	this.totalAmount = totalAmount;
}

@Override
public String toString() {
	return "WalletMoneyBean [walletId=" + walletId + ", totalAmount=" + totalAmount + "]";
}


}
