package unidad3;

import java.io.*;
//import java.util.ArrayList;
import java.util.List;

class Book {
    private String title;
    private String author; 
    private double price;

    public Book(String title, String author, double price){
        this.title= title;
        this.author=author;
        this.price=price;
    }

    public String getTitle(){
        return title;
    }

    public String getAuthor(){
        return author;
    }

    public double getPrice(){
        return price;
    }
    @Override
    public String toString(){
        return String.format("Title: | Author: | Price: |", title, author, price);
    }
}

    class BookFileHandler {
        private static final String FILE_NAME="books.txt";

        public void saveBooks(List<Book> books){
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))){
                for (Book book : books){
                    writer.write(book.getTitle()+ "|"+ book.getAuthor()+ "|" +book.getPrice());
                    writer.newLine();
                }
                System.out.println("Books saved successfully to" + FILE_NAME);
            } catch (IOException e) {
               System.out.println("Error saving books:" + e.getMessage());
            } 
        }
    }