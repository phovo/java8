package ch.java8.practice.bo;

import java.util.List;
import java.util.Optional;

public class OptionalCatalog {
	
	private int id;
	
	private CatalogType catalogType;
	
	private Optional<List<OptionalBook>> books;
	
	public OptionalCatalog() {
		super();
	}

	public OptionalCatalog(int id, CatalogType catalogType,
			Optional<List<OptionalBook>> books) {
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
	
	public CatalogType getCatalogType() {
		return catalogType;
	}

	public void setCatalogType(CatalogType catalogType) {
		this.catalogType = catalogType;
	}

	public Optional<List<OptionalBook>> getBooks() {
		return books;
	}

	public void setBooks(Optional<List<OptionalBook>> books) {
		this.books = books;
	}
}
