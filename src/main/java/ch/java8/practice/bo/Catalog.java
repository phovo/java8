package ch.java8.practice.bo;

import java.util.List;

public class Catalog {
	
	private int id;
	
	private CatalogType catalogType;
	
	private List<Book> books;
	
	public Catalog() {
		super();
	}

	public Catalog(int id, CatalogType catalogType, List<Book> books) {
		super();
		this.id = id;
		this.catalogType = catalogType;
		this.books = books;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	public CatalogType getCatalogType() {
		return catalogType;
	}

	public void setCatalogType(CatalogType catalogType) {
		this.catalogType = catalogType;
	}
}
