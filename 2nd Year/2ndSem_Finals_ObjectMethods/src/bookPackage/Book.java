package bookPackage;

public class Book {
	// Variables for class Author
	private String bookName;
	private String bookEmail;
	private String bookGender;
	
	// Local Variables of class Book
	private String bookTitle;
	private Author author = new Author(bookName, bookEmail, bookGender);
	private double price;
	private int stock = 0;
	
	// Book Constructor
	Book(String bookTitle, Author author,  double price, int stock) {
		this.bookTitle = bookTitle;
		this.author = author;
		this.price = price;
		this.stock = stock;
	}
	
	public void priceCheck(double price) {
		if(price>=0) {
			this.price = price;
		}
		else {
			System.out.println("Note: Price should be positive! Set to 0");
			this.price = 0;
		}
	}
	
	public void stockCheck(int stock) {
		if(stock>=0) {
			this.stock = stock;
		}
		else {
			System.out.println("Book stocks cannot be negative! Set to 0\n");
			this.stock = 0;
		}
	}
	
	// Print method for Book class
	void print() {
		priceCheck(price);
		stockCheck(stock);
		System.out.println("Book Title : " + this.bookTitle);
		author.print();
	}
	
	// Getter for instantiated Author inside Book class
	public Author getAuthor() {
		return author;
	}
	
	public void setAuthor(Author author) {
		this.author = author;
	}
}
