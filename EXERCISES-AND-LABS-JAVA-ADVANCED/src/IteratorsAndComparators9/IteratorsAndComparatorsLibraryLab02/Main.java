package IteratorsAndComparators9.IteratorsAndComparatorsLibraryLab02;

public class Main {
    public static void main(String[] args) {

        Book bookOne = new Book("Animal Farm", 2003, "George Orwell");
        Book bookTwo = new Book("The Documents in the Case", 1930, "Dorothy Sayers", "Robert Eustace");
        Book bookThree = new Book("The Documents in the Case", 2002);

        Library library = new Library();

        library.add(bookOne);
        library.add(bookTwo);
        library.add(bookThree);
//
//        Iterable <Book> iterable = new ArrayList<>();
//        Iterable <Book> iterableLibrary = new Library();
//
//        for (int i = 0; i < library.booksCount(); i++) {
//            System.out.println(library.get(i).getTitle());
//        }
        for (Book book : library) {
            System.out.println(book.getTitle());
        }
    }
}
