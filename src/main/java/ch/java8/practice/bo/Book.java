package ch.java8.practice.bo;



public class Book {
	
	private int id;
	
	private String name;
	
	private String author;
	
	private Appendix appendix;
	
	public Book() {
		super();
	}

	public Book(int id, String name, String author, Appendix appendix) {
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

	public Appendix getAppendix() {
		return appendix;
	}

	public void setAppendix(Appendix appendix) {
		this.appendix = appendix;
	}
}
