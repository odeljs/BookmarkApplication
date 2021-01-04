package entities;

import constants.KidFriendlyStatus;

public abstract class Bookmark {
	//Start of fields
	private long id;
	private String title;
	private String profileURL;
	//this field can be changed by editor or chief editor to be unknown, approved, or rejected
	private String kidFriendlyStatus = KidFriendlyStatus.UNKNOWN;
	private User kidFriendlyMarkedBy;
	private User sharedBy;
	//end of fields
	
	//start of getter and setter
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getProfile() {
		return profileURL;
	}
	public void setProfile(String profile) {
		this.profileURL = profile;
	}
	//end of getter and setter

	public abstract boolean isKidFriendlyEligable();
	public String getKidFriendlyStatus() {
		return kidFriendlyStatus;
	}
	public void setKidFriendlyStatus(String kidFriendlyStatus) {
		this.kidFriendlyStatus = kidFriendlyStatus;
	}
	public User getKidFriendlyMarkedBy() {
		return kidFriendlyMarkedBy;
	}
	public void setKidFriendlyMarkedBy(User kidFriendlyMarkedBy) {
		this.kidFriendlyMarkedBy = kidFriendlyMarkedBy;
	}
	public User getSharedBy() {
		return sharedBy;
	}
	public void setSharedBy(User sharedBy) {
		this.sharedBy = sharedBy;
	}
}
