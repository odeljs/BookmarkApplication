package entities;

import partner.Shareable;

public class WebLink extends Bookmark implements Shareable {
	//start of fields
	private String url;
	private String host;
	//end of fields
	
	//start of getter and setter
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	//end of getter and setter
	@Override
	public String toString() {
		return "WebLink [url=" + url + ", host=" + host + "]";
	}
	@Override
	public boolean isKidFriendlyEligable() {
		if(url.contains("porn") || getTitle().contains("porn") || host.contains("adult")) {
			return false;
		} 
		return true;
	}
	@Override
	public String getItemData() {
		StringBuilder builder = new StringBuilder();
		builder.append("<item>");
		builder.append("<type>Weblink</type>");
		builder.append("<title>").append(getTitle()).append("</title>");
		builder.append("<url>").append(url).append("</url>");
		builder.append("<host>").append(host).append("</host>");
		builder.append("</item>");
		return builder.toString();
	}
}
