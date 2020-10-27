package Problem3;

public class MovieAction extends Movie {

    private int lateFeePerDayInDollar = 5;

    public MovieAction(String rating, String title) {
        super(rating, title);
    }

    public MovieAction(MovieAction anotherMovie) {
        super(anotherMovie);
    }

    public void setTitle(String uStr){
        super.title = uStr;
    }
    public void setRating(String uStr){
        super.rating = uStr;
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
        int fee = lateFeePerDayInDollar * numOfDaysPastDue;
        return (numOfDaysPastDue >= 5) ? 2 * fee : fee;
    }
}
