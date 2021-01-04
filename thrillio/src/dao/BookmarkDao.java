package dao;

import entities.Bookmark;
import entities.userBookmark;
import thrillio.DataStore;

public class BookmarkDao {
	public Bookmark[][] getBookmarks() {
		return DataStore.getBookmarks();
	}

	public void saveUserBookmark(userBookmark userBookmark) {
		DataStore.add(userBookmark);
		
	}
}
