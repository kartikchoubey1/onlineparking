package com.onlineparking.module.user;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Autowired
	private UserService service;
	
	@RequestMapping(value="mvc/slotbookingusingwallet",method=RequestMethod.POST)
	public @ResponseBody boolean slotBookingUsingWallet(@RequestBody WalletBookBean bookBean) throws SQLException{
		System.out.println("vo  "+bookBean);
		return service.slotBookingUsingWallet(bookBean);
	}
	@RequestMapping(value="mvc/walletMoney", method=RequestMethod.GET)
	public @ResponseBody WalletMoneyBean walletMoney(@RequestParam ("userID") int userId){
		return service.walletMoney(userId);
	}
	@RequestMapping(value="mvc/getAreaSlot", method=RequestMethod.GET)
	public @ResponseBody List<UserSlotBean> getAreaSlot(@RequestParam("areaId") Integer areaId) {
		return service.getAreaSlot(areaId);
	}
}
