package ch.java8.practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import ch.java8.practice.bo.Appendix;
import ch.java8.practice.bo.Book;
import ch.java8.practice.bo.Catalog;
import ch.java8.practice.bo.CatalogType;
import ch.java8.practice.bo.OptionalBook;
import ch.java8.practice.bo.OptionalCatalog;

public class PracticeAdvancedOptional {
	
	static List<OptionalCatalog> catalogues = Arrays.asList(new OptionalCatalog(1, CatalogType.COMPUTER, Optional.ofNullable(Arrays.asList(new OptionalBook(1, "Java Reference", "John",  Optional.ofNullable(new Appendix("1.0", "EN")))))),
													new OptionalCatalog(2, CatalogType.ART, Optional.ofNullable(Arrays.asList(new OptionalBook(1, "Painting for Beginner", "Philip", Optional.ofNullable(new Appendix("2.0", "FR")))))),
													new OptionalCatalog(3, CatalogType.MATHEMATICS, Optional.ofNullable(Arrays.asList(new OptionalBook(1, "Math science", "Ken", Optional.ofNullable(new Appendix(null, "DE")))))),
													null);
	
	static List<Catalog> catalogs = Arrays.asList(
			new Catalog(1, CatalogType.ART, Arrays.asList(new Book(1, "Java Reference", "John",  new Appendix("1.0", "EN")))),
			new Catalog(2, CatalogType.ART, Arrays.asList(new Book(1, "Painting for Beginner", "Philip", new Appendix("2.0", "FR")))),
			new Catalog(3, CatalogType.ART, Arrays.asList(new Book(1, "Math science", "Ken", new Appendix(null, "DE")))),
			new Catalog(3, CatalogType.ART, Arrays.asList(new Book(1, "CSharp Reference", "John", new Appendix(null, "DE")),
																  null,
																  new Book(1, "Math science", "Ken", new Appendix(null, "DE")))),
			new Catalog(3, CatalogType.ART, null),
			null);
	
	public static void main(String[] args) {
		cataloguesOptional1();
		cataloguesOptional2();
		cataloguesOptional3();
	}
	
	public static void cataloguesOptional1() {
		System.out.println("---------Catalogues Optional----------");
		
			catalogues
			.stream()
			.map(catalogue -> Optional.ofNullable(catalogue)
									.flatMap(OptionalCatalog::getBooks)
									.map(books -> books.stream()
												.map(OptionalBook::getAppendix)
												.map(appendix -> appendix.map(Appendix::getEdition).orElse("N/A")))
									.map(edit -> edit.collect(Collectors.toList()))
									.orElse(Collections.emptyList())
			)
			.flatMap(List::stream)
			.collect(Collectors.toList())
			.forEach(System.out::println);
	}
	
	public static void cataloguesOptional2() {
		System.out.println("---------Catalogues Optional----------");
		Optional<List<Catalog>> catalogsOptionals = Optional.ofNullable(catalogs);
		 List<String> str = catalogsOptionals
			.orElse(Collections.emptyList())
			.stream()
			.map(Optional::ofNullable).filter(Optional::isPresent).map(Optional::get)
			.map(Catalog::getBooks)
			.map(Optional::ofNullable).filter(Optional::isPresent).map(Optional::get)
			.flatMap(books -> books.stream())
			.map(Optional::ofNullable).filter(Optional::isPresent).map(Optional::get)
			.map(Book::getAppendix)
			.map(Appendix::getEdition)
			.map(Optional::ofNullable)
			.map(edition -> edition.orElse("N/A"))
			.distinct()
			.collect(Collectors.toList());
		System.out.println(str);
	}
	
	public static void cataloguesOptional3() {
		System.out.println("---------Catalogues Optional----------");
		catalogs
			.stream()
			.map(Optional::ofNullable).filter(Optional::isPresent)
			.map(Optional::get)
			.map(Catalog::getBooks)
			.map(Optional::ofNullable).filter(Optional::isPresent).map(Optional::get)
			.flatMap(books -> books.stream())
			.map(Optional::ofNullable).filter(Optional::isPresent).map(Optional::get)
			.map(Book::getAppendix)
			.map(Appendix::getEdition)
			.map(Optional::ofNullable)
			.map(edition -> edition.orElse("N/A"))
			.distinct()
			.collect(Collectors.toList());
	}
}
