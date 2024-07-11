import java.util.Scanner;

class Book {
    private String title;
    private String author;
    private String issuedTo;
    private boolean isIssued;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isIssued = false;
        this.issuedTo = null;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIssuedTo() {
        return issuedTo;
    }

    public boolean isIssued() {
        return isIssued;
    }

    public void issue(String issuedTo) {
        this.isIssued = true;
        this.issuedTo = issuedTo;
    }

    public void returnBook() {
        this.isIssued = false;
        this.issuedTo = null;
    }

   
}


class Library  {
    private Book books[];
    private int count;

    public Library(int capacity) {
        books = new Book[capacity];
        count = 0;
    }


    public void addBook(Book book) {
        if (count < books.length) {
            books[count++] = book;
            System.out.println("Book added: " + book.getTitle());
        } else {
            System.out.println("Library is full. Cannot add more books.");
        }
    }

    public void issueBook(String title, String issuedTo) {
        for (int i = 0; i < count; i++) {
            if (books[i].getTitle().equals(title) && !books[i].isIssued()) {
                books[i].issue(issuedTo);
                System.out.println("Book issued: " + title + " to " + issuedTo);
                return;
            }
        }
        System.out.println("Book not available: " + title);
    }

    public void returnBook(String title) {
        for (int i = 0; i < count; i++) {
            if (books[i].getTitle().equals(title) && books[i].isIssued()) {
                books[i].returnBook();
                System.out.println("Book returned: " + title);
                return;
            }
        }
        System.out.println("Book not found: " + title);
    }


    public void displayBooks() {
        for (int i = 0; i < count; i++) {
            System.out.println("Book Author "+books[i].getAuthor()+" , "+" Issed status "+books[i].isIssued());
        }
    }
}


public class LibraryManagementSystem {
  
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library(100); 

    while (true) {
            System.out.println("\nWelcome in Library Managemnt System \n");
            System.out.print("Enter a number to select a option \n");
            System.out.println("1. Add Book");
            System.out.println("2. Issue Book");
            System.out.println("3. Return Book");
            System.out.println("4. Display Books");
            System.out.println("5. Exit");
            

            int choice = scanner.nextInt();
          
            
            if(choice==1){
                System.out.print("Enter book title: ");
                String title = scanner.nextLine();
                System.out.print("Enter book author: ");
                String author = scanner.nextLine();
                library.addBook(new Book(title, author));
            }else if(choice==2){
                System.out.print("Enter book title to issue: ");
                String issueTitle = scanner.nextLine();
                System.out.print("Enter name of person to issue to: ");
                String issuedTo = scanner.nextLine();
                library.issueBook(issueTitle, issuedTo);

            }else if(choice==3){
                System.out.print("Enter book title to return: ");
                String returnTitle = scanner.nextLine();
                library.returnBook(returnTitle);

            }else if(choice==4){
                library.displayBooks();

            }else if(choice==5){
                System.out.println("Exiting system.");
                break;
                
            }else{
                System.out.println("Invalid option. Please try again.");
            }
              
        
                  
                  
            
        }
    }
}
