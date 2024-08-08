package code.model;

public class Author {
    private String name;
    private String surname;

    public Author(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Author(String fullName) {
        String[] arr = fullName.split(" ");
        if (arr.length > 2) {
            this.name = arr[0] + " " + arr[1];
        } else {
            this.name = arr[0];
        }
        this.surname = arr[arr.length - 1];
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return name + ' ' + surname;
    }
}
