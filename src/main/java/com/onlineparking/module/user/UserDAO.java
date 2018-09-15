package com.onlineparking.module.user;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.onlineparking.util.CommonUtil;
import com.onlineparking.util.SqlUtil;



@Repository
public class UserDAO {
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private JdbcTemplate jdbctemplate;

	public int slotBookingUsingWallet(WalletBookBean bookBean) throws SQLException {
		try {
			int status = 0;
			if (this.userWalletDeduction(bookBean)) {
				if (this.recordOwnerWallet(bookBean)) {
					if (this.slotBook(bookBean.getBookedSlot(), bookBean.getAreaId())) {
						status = jdbctemplate.update(SqlUtil.USER_BOOK_HISTORY, bookBean.getUserId(),
								bookBean.getBookedSlot(), bookBean.getAreaId(), bookBean.getwBill(),
								bookBean.getTimeTaken(), new Date() + "");
					}
				}
			}
			return status;
		} catch (Exception e) {
			log.error("error occured while fetching status for wallet,please contact support team", e);
			throw e;
		}
	}

	private boolean slotBook(String bookedSlot, Integer areaId) throws SQLException {
		List<Integer> ids = null;
		boolean flag = true;
		try {
			ids = CommonUtil.cvsIds(bookedSlot);
			for (Integer integer : ids) {
				int ret = jdbctemplate.update(SqlUtil.BOOK_SLOTS, areaId, integer);
				if (ret == 0) {
					flag = false;
				}
			}
		} catch (Exception e) {
			log.error("");
			throw e;
		}
		return false;
	}

	private boolean recordOwnerWallet(WalletBookBean bookBean) {
		WalletStatusBean bean = null;
		boolean statusRecord = false;
		try {
			bean = this.creditOwnerWallet(bookBean);
		} catch (Exception e) {
			log.error("error occured while call creditownerwallet,please contact support Team", e);
			throw e;
		}
		try {
			int ret = jdbctemplate.update(SqlUtil.OWNER_RECORD, bookBean.getUserId(), new Date() + "",
					bookBean.getwBill(), bean.getOwnerId(), 0);
			if (ret == 1)
				statusRecord = true;
		} catch (Exception e) {
			log.error("error occured while user recordownerwallet,please contact support team", e);
			throw e;
		}
		return statusRecord;
	}

	private WalletStatusBean creditOwnerWallet(WalletBookBean bookBean) {
		WalletStatusBean bean = null;
		try {
			bean = this.getownerWalletAmount(bookBean);
			bean.setSuccess(false);
			if (bean.getOwnerId() != 0) {
				int ret = jdbctemplate.update(SqlUtil.CREDIT_OWNER_WOLLET, (bean.getAmount() + bookBean.getwBill()),
						bean.getOwnerId());
				if (ret == 1) {
					bean.setSuccess(true);
				}
			}
		} catch (Exception e) {
			log.error("error occured while creitowner wallet", e);
			throw e;

		}
		return bean;
	}

	private WalletStatusBean getownerWalletAmount(WalletBookBean bookBean) {
		List<WalletStatusBean> list = null;
		try {
			list = jdbctemplate.query(SqlUtil.OWNER_WALLET_AMOUNT, (ResultSet rs) -> {
				List<WalletStatusBean> wlist = new ArrayList<WalletStatusBean>();
				while (rs.next()) {
					WalletStatusBean wsbean = new WalletStatusBean();
					wsbean.setOwnerId(rs.getInt("ownerId"));
					wsbean.setAmount(rs.getDouble("amount"));
					wlist.add(wsbean);
				}
				return wlist;
			}, bookBean.getAreaId());
		} catch (Exception e) {
			log.error("error while getting user wallet amount,please contact support team.", e);
			throw e;
		}
		if (list.size() == 1) {
			return list.get(0);
		} else
			return null;
	}

	private boolean userWalletDeduction(WalletBookBean bookBean) {
		boolean flag = true;
		try {
			int ret = jdbctemplate.update(SqlUtil.USER_WALLET_DEDUCTION, (bookBean.getwTotal() - bookBean.getwBill()),
					bookBean.getUserId());
			if (ret == 0)
				flag = false;
		} catch (Exception e) {
			log.error("error while using wallet deduction,please contact support team", e);
			throw e;
		}
		return flag;
	}

	public WalletMoneyBean walletMoney(int userId) {
		WalletMoneyBean walletMoneyBean = null;
		try {
			walletMoneyBean = jdbctemplate.queryForObject(SqlUtil.USER_WALLET_MONEY, (ResultSet rs, int index) -> {
				WalletMoneyBean walletMoney = new WalletMoneyBean();

				walletMoney.setWalletId(rs.getInt("id"));
				walletMoney.setTotalAmount(rs.getDouble("totalAmount"));
				return walletMoney;
			}, userId);
		} catch (Exception e) {
			log.error("an error while getting walletmoney:please contect support team ");
			throw e;
		}
		return walletMoneyBean;
	}

	public List<UserSlotBean> getAreaSlot(Integer areaId) {
		try {
			List<UserSlotBean> userSlotBean = jdbctemplate.query(SqlUtil.SELECT_AREASLOT, (ResultSet rs) -> {
				List<UserSlotBean> userSlot = new ArrayList<UserSlotBean>();
				while (rs.next()) {
					UserSlotBean bean = new UserSlotBean();
					bean.setSlotId(rs.getInt("id"));
					bean.setSlotNumber(rs.getInt("slot_number"));
					bean.setIsReaserved(rs.getInt("is_reserved"));
					bean.setfSlotId(rs.getInt("fslot_id"));
					userSlot.add(bean);
				} // (while)
				return userSlot;
			},areaId);
			return userSlotBean;
		} catch (Exception e) {
			log.error("en error occured while");
			throw e;
		}
	

	}
}
