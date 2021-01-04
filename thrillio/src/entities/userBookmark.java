package entities;
//this class will maintain the relationship between the user and their bookmarks
public class userBookmark {
	//start of field
	private User user; //instantiating User class as use object
	private Bookmark bookmark; //instantiating Bookmark class as bookmark object
	//end of field
	
	//start of getter and setter
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Bookmark getBookmark() {
		return bookmark;
	}
	public void setBookmark(Bookmark bookmark) {
		this.bookmark = bookmark;
	}
	//end of getter and setter
}
