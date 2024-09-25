package org.example;

import java.util.Date;

public class Buch {
    private final String titel;
    private final ISBN10 isbn;
    private final String verlag;
    private final Date datum;

    public Buch(String titel, String verlag, ISBN10 isbn, Date datum) {
        this.titel = titel;
        this.isbn = isbn;
        this.datum = datum;
        this.verlag = verlag;
    }

    public String getTitel() {
        return titel;
    }

    public ISBN10 getIsbn() {
        return isbn;
    }

    public String getVerlag() {
        return verlag;
    }

    public Date getDatum() {
        return datum;
    }

    public String csv() {
        return titel + "\t" + isbn + "\t" + verlag + "\t" + datum;
    }
}
