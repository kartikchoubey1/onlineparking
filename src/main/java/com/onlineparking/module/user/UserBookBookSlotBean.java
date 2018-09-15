package com.onlineparking.module.user;

public class UserBookBookSlotBean {
private Integer slotId;
private Integer slotNumber;
private Integer isReserved;
private Integer fSlot;

public UserBookBookSlotBean() {
}

public UserBookBookSlotBean(Integer slotId, Integer slotNumber, Integer isReserved, Integer fSlot) {
	this.slotId = slotId;
	this.slotNumber = slotNumber;
	this.isReserved = isReserved;
	this.fSlot = fSlot;
}

public Integer getSlotId() {
	return slotId;
}

public void setSlotId(Integer slotId) {
	this.slotId = slotId;
}

public Integer getSlotNumber() {
	return slotNumber;
}

public void setSlotNumber(Integer slotNumber) {
	this.slotNumber = slotNumber;
}

public Integer getIsReserved() {
	return isReserved;
}

public void setIsReserved(Integer isReserved) {
	this.isReserved = isReserved;
}

public Integer getfSlot() {
	return fSlot;
}

public void setfSlot(Integer fSlot) {
	this.fSlot = fSlot;
}

@Override
public String toString() {
	return "UserBookBookSlotBean [slotId=" + slotId + ", slotNumber=" + slotNumber + ", isReserved=" + isReserved
			+ ", fSlot=" + fSlot + "]";
}




}
