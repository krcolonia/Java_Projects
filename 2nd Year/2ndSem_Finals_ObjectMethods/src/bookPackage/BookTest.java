package bookPackage;

public class BookTest {
	public static void main(String[] args) {
		Author author1 = new Author("Marcus Laurence", "milaurence@neu.edu.ph", "SheMale");
		author1.print();
		
		Book bk1 = new Book("Java Book", author1, -1499, -10);
		bk1.print();
		
		author1.setEmail("cuscusgmail.com");
		
		author1.print();
		bk1.print();
		
		bk1.getAuthor().setEmail("Laurence.marcusgmail.com");
		bk1.print();
		
	}
}
