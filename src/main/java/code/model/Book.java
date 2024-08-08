package code.model;

import java.util.ArrayList;

public class Book {
    private int id;
    private String name;
    private String genre;
    private int year;
    private Author author;
    public static final String SPLIT_STRING = " ";
    public static final String BOOK_IN_LINE_WITH_ID_TEMPLATE = "0 null 1000 0 0";

    public Book(int id, String name, int year, Author author, String genre) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.author = author;
        this.genre = genre;
    }

    public static Book convertArrayToBook(ArrayList<String> arr) {
        int id = Integer.parseInt(arr.get(0));
        StringBuilder sb = new StringBuilder();
        int yearIndex = findYearIndex(arr);
        for (int i = 1; i < yearIndex; i++) {
            sb.append(arr.get(i));
            sb.append(" ");
        }
        String name = sb.substring(0, sb.length() - 1);
        int year = Integer.parseInt(arr.get(yearIndex));
        Author author = new Author(arr.get(arr.size() - 2));
        String genre = arr.get(arr.size() - 1);
        return new Book(id, name, year, author, genre);
    }

    private static int findYearIndex(ArrayList<String> arr) {
        int yearIndex;
        for (int i = 2; ; i++) {
            if (arr.get(i).length() == 4) {
                yearIndex = i;
                break;
            }
        }
        return yearIndex;
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
        return id +
                " title: '" + name +
                "', year: " + year +
                ", author: " + author.toString() +
                ", genre: " + genre + ";";
    }
}
