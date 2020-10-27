import Problem3.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class Problem3Test {
    @Test
    public void catchTheBugInBook() {
        // quiz
        String str0 = "test0";
        String str1 = "test1";
        String str2 = "test2";
        String sBug = "bug";

        BookFiction obj0 = new BookFiction(str0, str1, str2);
        BookFiction obj1 = new BookFiction(obj0);

        // obj0 and obj1 only share the same value for their ID
        obj1.setTitle(sBug);

        assertTrue(obj0.equals(obj1));

        BookFiction obj2 = new BookFiction(str1, str1, str2);
        BookFiction obj3 = new BookFiction(obj2);

        obj3.setAuthor(sBug);

        assertTrue(obj2.equals(obj3));

        BookFiction obj4 = new BookFiction(str2, str1, str2);
        BookFiction obj5 = new BookFiction(obj4);

        obj5.setGenres(sBug);

        assertTrue(obj4.equals(obj5));

        BookFiction obj6 = new BookFiction(str0, str2, str2);
        BookFiction obj7 = new BookFiction(obj6);

        obj7.setTitle(sBug);
        obj7.setGenres(sBug);
        obj7.setAuthor(sBug);

        assertTrue(obj6.equals(obj7));

    }

    @Test
    public void catchTheBugInMovie() {
        // quiz
        String str0 = "test0";
        String str1 = "test1";

        String sBug = "bug";

        MovieAction obj0 = new MovieAction(str0, str1);
        MovieAction obj1 = new MovieAction(obj0);

        obj1.setTitle(sBug);

        assertTrue(obj0.equals(obj1));

        MovieAction obj2 = new MovieAction(str1, str1);
        MovieAction obj3 = new MovieAction(obj2);

        obj2.setRating(sBug);

        assertTrue(obj2.equals(obj3));

        MovieAction obj4 = new MovieAction(str0, str1);
        MovieAction obj5 = new MovieAction(obj4);

        obj4.setTitle(sBug);
        obj4.setRating(sBug);

        assertTrue(obj4.equals(obj5));
    }

    // DO NOT REMOVE OR CHANGE ANYTHING BELOW THIS!
    @Test
    public void testMovieActionEquals() {
        MovieAction m = new MovieAction("PG13", "ti1");
        MovieAction mc = new MovieAction(m);
        assertTrue(m.equals(mc));
        mc = new MovieAction("PG13", "ti1");
        assertFalse(m.equals(mc));
    }

    @Test
    public void testMovieComedyEquals() {
        MovieComedy m = new MovieComedy("G", "ti2");
        MovieComedy mc = new MovieComedy(m);
        assertTrue(m.equals(mc));
        mc = new MovieComedy("G", "ti2");
        assertFalse(m.equals(mc));
    }

    @Test
    public void testMovieEquals() {
        Movie m = new MovieAction("PG13", "au2");
        Movie mc = new MovieComedy("r1", "t1");
        assertFalse(m.equals(mc));
    }

    @Test
    public void testBookFictionEquals() {
        BookFiction f = new BookFiction("t1", "au1", "g1");
        BookFiction fc = new BookFiction(f);
        assertTrue(f.equals(fc));
        fc = new BookFiction("t1", "au1", "g2");
        assertFalse(f.equals(fc));
    }

    @Test
    public void testBookRomanceEquals() {
        BookRomance f = new BookRomance("t1", "au1");
        BookRomance fc = new BookRomance(f);
        assertTrue(f.equals(fc));
        fc = new BookRomance("t1", "au1");
        assertFalse(f.equals(fc));
    }

    @Test
    public void testBookEquals() {
        Book f = new BookFiction("t1", "au1", "g1");
        Book br = new BookRomance("t1", "a1");
        assertFalse(f.equals(br));
    }

    @Test
    public void testBookFictionCalcLateFees() {
        Book bookFiction = new BookFiction("t1", "au1", "g1");

        for (int i = -5; i < 5; i++) {
            int fees = bookFiction.calcLateFees(i);
            assertEquals(fees, Math.max(i, 0) * bookFiction.getLateFeeInDollar());
        }
    }

    @Test
    public void testBookRomanceCalcLateFees() {
        Book bookRomance = new BookRomance("t2", "au2");

        for (int i = -5; i < 5; i++) {
            int fees = bookRomance.calcLateFees(i);
            assertEquals(fees, Math.max(i, 0) * bookRomance.getLateFeeInDollar());
        }
    }

    @Test
    public void testMovieActionCalcLateFees() {
        Movie movieAction = new MovieAction("r1", "t1");

        for (int i = -5; i < 5; i++) {
            int fees = movieAction.calcLateFees(i);
            assertEquals(fees, Math.max(i, 0) * movieAction.getLateFeeInDollar());
        }

        for (int i = 5; i <= 10; i++) {
            int fees = movieAction.calcLateFees(i);
            assertEquals(fees, 2 * i * movieAction.getLateFeeInDollar());
        }
    }

    @Test
    public void testMovieComedyCalcLateFees() {
        Movie movieComedy = new MovieComedy("r1", "t1");

        for (int i = -5; i < 10; i++) {
            int fees = movieComedy.calcLateFees(i);
            assertEquals(fees, Math.max(i, 0) * movieComedy.getLateFeeInDollar());
        }
    }

    @Test
    public void testStoreMediaCalcLateFees() {
        StoreMediaOperations[] s = new StoreMediaOperations[4];

        s[0] = new BookFiction("t1", "au1", "g1");
        s[1] = new BookRomance("t2", "au2");
        s[2] = new MovieAction("r1", "t1");
        s[3] = new MovieComedy("r2", "t2");

        int dayMissed = 10;

        int fees = 0;
        for (StoreMediaOperations storeMediaOperations : s) {
            fees += storeMediaOperations.calcLateFees(dayMissed);
        }

        int expect = 0;
        for (StoreMediaOperations storeMediaOperations : s) {
            int factor = (storeMediaOperations instanceof MovieAction) ? 2 : 1;
            expect += storeMediaOperations.getLateFeeInDollar() * dayMissed * factor;
        }
        assertEquals(expect, fees);
    }

}