package code.model;

public class Book {
    private int id;
    private String name;
    private String genre;
    private int year;
    private Author author;

    public Book(int id, String name, String genre, int year, Author author) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.year = year;
        this.author = author;
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

    public String getGenre() {
        return genre;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setGenre(String description) {
        this.genre = description;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return (id + 1) +
                " title: '" + name +
                "', year: " + year +
                ", author: " + author +
                ";";
    }
}
