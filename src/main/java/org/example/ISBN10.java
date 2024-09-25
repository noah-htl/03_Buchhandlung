package org.example;

public class ISBN10 {
    private final int isbn;

    private ISBN10(int isbn) {
        this.isbn = isbn;
    }

    public int getIsbn() {
        return this.isbn;
    }

    public static ISBN10 of(int isbn) {
        if(String.valueOf(isbn).length() != 10) {
            throw new IllegalArgumentException("ISBN must be 10 digits");
        }
        return new ISBN10(isbn);
    }

    public static ISBN10 of(String isbn) {
        int _isbn;

        try {
            _isbn = Integer.parseInt(isbn);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("ISBN must be 10 digits");
        }

        return ISBN10.of(_isbn);
    }

    @Override
    public String toString() {
        return String.valueOf(this.isbn);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof ISBN10 other) {
            return this.isbn == other.isbn;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.isbn;
    }
}
