package com.onlineparking.module.user;

public class UserSlotBean {
private int slotId;
private  Integer slotNumber;
private int isReaserved;
private int fSlotId;

public UserSlotBean(int slotId, Integer slotNumber, int isReaserved, int fSlotId) {

	this.slotId = slotId;
	this.slotNumber = slotNumber;
	this.isReaserved = isReaserved;
	this.fSlotId = fSlotId;
}

public UserSlotBean() {
}

public int getSlotId() {
	return slotId;
}

public void setSlotId(int slotId) {
	this.slotId = slotId;
}

public Integer getSlotNumber() {
	return slotNumber;
}

public void setSlotNumber(Integer slotNumber) {
	this.slotNumber = slotNumber;
}

public int getIsReaserved() {
	return isReaserved;
}

public void setIsReaserved(int isReaserved) {
	this.isReaserved = isReaserved;
}

public int getfSlotId() {
	return fSlotId;
}

public void setfSlotId(int fSlotId) {
	this.fSlotId = fSlotId;
}

@Override
public String toString() {
	return "UserSlotBean [slotId=" + slotId + ", slotNumber=" + slotNumber + ", isReaserved=" + isReaserved
			+ ", fSlotId=" + fSlotId + "]";
}



}
