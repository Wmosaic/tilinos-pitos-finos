package bookstore;

public class Book{
 private String title;
 private String author;
 private int pubYear;
 private double price;
 private String editor;
 
 public Book (String t,String a, int d, double p, String e){
 if (t !=null) title= t;
 if (a !=null) author= a;
 if (p > 0) price = p;
  if (e !=null) editor= e;
  pubYear= d;
  }
  
  public String getTitle(){ return title; }
  public String getAuthor() { return author; }
  public int getPubYear () { return pubYear; }
  public double getPrice () { return price; }
  public String getEditor () { return editor; }
  public String toString() {
   return author+", "+title +", "+pubYear+",$"+price+", "+editor;}
  }