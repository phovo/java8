package ch.java8.practice.bo;

public class OptionalAppendix {
	
	private String edition;
	
	private String language;

	public OptionalAppendix() {
		super();
	}

	public OptionalAppendix(String edition, String language) {
		super();
		this.edition = edition;
		this.language = language;
	}
	
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}
}
