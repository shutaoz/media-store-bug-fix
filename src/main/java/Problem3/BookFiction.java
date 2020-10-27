package Problem3;

public class BookFiction extends Book {

    private int lateFeePerDayInDollar = 2;

    private String genres;

    public BookFiction(String title, String author, String genres) {
        super(title, author);
        this.genres = genres;
    }

    // copy constructor
    public BookFiction(BookFiction anotherBook) {
        super(anotherBook);
        this.genres = anotherBook.genres;
    }

    //setters
    public void setTitle(String uStr){
        super.title = uStr;
    }
    public void setAuthor(String uStr){
        super.author = uStr;
    }
    public void setGenres(String uStr){
        this.genres = uStr;
    }

    @Override
    public int getLateFeeInDollar() {
        return lateFeePerDayInDollar;
    }

    @Override
    public int calcLateFees(int numOfDaysPastDue) {
        if (numOfDaysPastDue <= 0) {
            return 0;
        }
        return lateFeePerDayInDollar * numOfDaysPastDue;
    }
}
