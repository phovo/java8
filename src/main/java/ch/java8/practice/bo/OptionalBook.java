package ch.java8.practice.bo;

import java.util.Optional;


public class OptionalBook {
	
	private int id;
	
	private String name;
	
	private String author;
	
	private Optional<Appendix> appendix;
	
	public OptionalBook() {
		super();
	}

	public OptionalBook(int id, String name, String author, Optional<Appendix> appendix) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.appendix = appendix;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Optional<Appendix> getAppendix() {
		return appendix;
	}

	public void setAppendix(Optional<Appendix> appendix) {
		this.appendix = appendix;
	}
}
