package thrillio;

import constants.KidFriendlyStatus;
import constants.UserType;
import controllers.BookmarkController;
import entities.Bookmark;
import entities.User;
import partner.Shareable;

//this class is used to mimic the user interface
//it will simulate actions taken by each user
//each method in the class corresponds to one or more actions a single user takes in the web browser
//the launch class will envoke these methods
public class View {
	public static void browse(User user, Bookmark[][] bookmarks) {
		System.out.println("\n" + user.getEmail() + " is browsing items....");
		int bookmarkCount = 0;
		
		//iterate through two dimensional array Bookmark
		for(Bookmark[] bookmarkList : bookmarks) {
			for(Bookmark bookmark : bookmarkList) {
				if(bookmarkCount < DataStore.USER_BOOKMARK_LIMIT) {
					boolean isBookmarked = getBookmarkDecision(bookmark);
					if(isBookmarked) {
						bookmarkCount++;
						
						BookmarkController.getInstance().saveUserBookmark(user, bookmark);
						
						System.out.println("New Item Bookmarked -- " + bookmark);
					}
				}
				
				if(user.getUserType().equals(UserType.EDITOR) || user.getUserType().equals(UserType.CHIEF_EDITOR)) {
					
					
					//Mark as kid-friendly
					if(bookmark.isKidFriendlyEligable() && bookmark.getKidFriendlyStatus().contentEquals(KidFriendlyStatus.UNKNOWN)) {
						String kidFriendlyStatus = getKidFriendlyStatusDecision(bookmark);
						if(!kidFriendlyStatus.contentEquals(KidFriendlyStatus.UNKNOWN)) {
							BookmarkController.getInstance().setKidFriendlyStatus(user, kidFriendlyStatus, bookmark);
							
							}
						}
					//Sharing!!
					if(bookmark.getKidFriendlyStatus().contentEquals(KidFriendlyStatus.APPROVED)
							&& bookmark instanceof Shareable) {
						boolean isShared = getShareDecision();
						if(isShared) {
							BookmarkController.getInstance().share(user, bookmark);
						}
					}
					}
						}
			}
			}
		//TODO: Below methods simulate user input. After IO we will take input via console
		private static boolean getShareDecision() {
			return Math.random() < 0.5 ? true : false;
		
	}

		private static String getKidFriendlyStatusDecision(Bookmark bookmark) {
		return Math.random() < 0.4 ? KidFriendlyStatus.APPROVED : 
			(Math.random() >= 0.4 && Math.random() < 0.8) ? KidFriendlyStatus.REJECTED : KidFriendlyStatus.UNKNOWN;
		
	}
		private static boolean getBookmarkDecision(Bookmark bookmark) {
			return Math.random() < 0.5 ? true : false;
			
		}
		
		
		/*int i = 0; i < DataStore.USER_BOOKMARK_LIMIT; i++) {
			int typeOffset = (int)(Math.random() * DataStore.BOOKMARK_TYPES_COUNT); //random generation of the type of bookmark
			int bookmarkOffset = (int)(Math.random() * DataStore.BOOKMARK_COUNT_PER_TYPE);
		
		Bookmark bookmark = bookmarks[typeOffset][bookmarkOffset];
		
		// In real world the user will randomly select a bookmark and he is going to save it
		//Once he saves it, that information will be passed to the back in server and then eventually to the controller
		//From the controller it will be passed to the service layer and so on
		
		BookmarkController.getInstance().saveUserBookmark(user, bookmark);
		
		System.out.println(bookmark);
		}
	*/
	/*public static void bookmark(User user, Bookmark[][] bookmarks) {
		System.out.println("\n" + user.getEmail() + " is bookmarking");
		for(int i = 0; i < DataStore.USER_BOOKMARK_LIMIT; i++) {
			int typeOffset = (int)(Math.random() * DataStore.BOOKMARK_TYPES_COUNT); //random generation of the type of bookmark
			int bookmarkOffset = (int)(Math.random() * DataStore.BOOKMARK_COUNT_PER_TYPE);
		
		Bookmark bookmark = bookmarks[typeOffset][bookmarkOffset];
		
		// In real world the user will randomly select a bookmark and he is going to save it
		//Once he saves it, that information will be passed to the back in server and then eventually to the controller
		//From the controller it will be passed to the service layer and so on
		
		BookmarkController.getInstance().saveUserBookmark(user, bookmark);
		
		System.out.println(bookmark);
		}
	}*/

	
	
	
	
	
	
}
