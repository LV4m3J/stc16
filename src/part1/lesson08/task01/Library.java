package part1.lesson08.task01;

import part1.lesson08.task02.School;

import java.io.Serializable;
import java.util.Arrays;

public class Library extends School implements Serializable {
    private String books;
    private int[] readingRooms;
    private boolean isOpen;

    private static final long serialVersionId = 1L;
    public Library() {
     }

    public Library(String books, int[] readingRooms, boolean isOpen) {
        this.books = books;
        this.readingRooms = readingRooms;
        this.isOpen = isOpen;
    }

    @Override
    public String toString() {
        return "Library{" +
                "books=" + books +
                ", readingRooms=" + Arrays.toString(readingRooms) +
                ", isOpen=" + isOpen +
                '}';
    }

    public String getBooks() {
        return books;
    }

    public void setBooks(String books) {
        this.books = books;
    }

    public int[] getReadingRooms() {
        return readingRooms;
    }

    public void setReadingRooms(int[] readingRooms) {
        this.readingRooms = readingRooms;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }
}
