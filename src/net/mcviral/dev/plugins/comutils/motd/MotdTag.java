package net.mcviral.dev.plugins.comutils.motd;

public class MotdTag {
	
	private int tagType = -1;
	private String value = null;
	
	public MotdTag(){
		
	}
	
	public MotdTag(int tagType){
		this.setTagType(tagType);
	}
	
	public MotdTag(int tagType, String value){
		this.setTagType(tagType);
		this.setValue(value);
	}

	public int getTagType() {
		return tagType;
	}

	public void setTagType(int tagType) {
		this.tagType = tagType;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
