package org.pluralsight.demos.sessions;

public enum AvailableBooks {
	
	HFJ("Head First Java"),
	EJ("Effective Java"),
	TJ("Thinking in Java");
	
	private String bookName;
	
	AvailableBooks(String bookName) {
		this.bookName = bookName;
	}
	
	public String bookName() {
		return bookName;
	}

}
