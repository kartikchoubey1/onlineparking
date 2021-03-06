package com.onlineparking.util;

public class SqlUtil {
	public static final String USER_WALLET_DEDUCTION = "update userwolet set totalamount=? where userId=?";
	public static final String OWNER_WALLET_AMOUNT = "select amount,ownerId from ownerwolet where ownerId=(select id  from ownerinfo where parkingAreaId=?)";
	public static final String CREDIT_OWNER_WOLLET = "update ownerwolet set amount=? where ownerId=?";
	public static final String OWNER_RECORD = "insert into ownercreditrecord (userId,date,amount,ownerId,isCancel) values (?,?,?,?,?)";
	public static final String BOOK_SLOTS = "UPDATE tab_slot_datail SET is_reserved = 1  where fslot_id=(select slot_id from tab_slot where area_id=?) and slot_number=?";
	public static final String USER_BOOK_HISTORY = "insert into userbookhistory (userId,slotnumber,areaId,amount,timetaken,date) values(?,?,?,?,?,?)";
	public static final String USER_WALLET_MONEY = "select id,totalamount from userwolet where userId=?";
	public static final String SELECT_AREASLOT = "select id,slot_number,is_reserved,fslot_id from onlineparking.tab_slot_datail where fslot_id=(select slot_id from tab_slot where area_id=?)";
}
