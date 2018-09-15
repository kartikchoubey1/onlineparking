package com.onlineparking.module.user;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserDAO dao;

	public boolean slotBookingUsingWallet(WalletBookBean bookBean) throws SQLException{
		int status=0;
		status=dao.slotBookingUsingWallet(bookBean);
		if(status==1)
		return true;
		else 
			return false;	
	}
	
	public WalletMoneyBean walletMoney(int userId){
		return dao.walletMoney(userId);
	}
	public List<UserSlotBean> getAreaSlot(Integer areaId) {
		return dao.getAreaSlot(areaId);
	}
}
