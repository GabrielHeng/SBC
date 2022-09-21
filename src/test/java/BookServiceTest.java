import com.sbc.entity.Book;
import com.sbc.entity.Genre;
import com.sbc.service.BookService;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class BookServiceTest {
    BookService bs = new BookService();
    private void mockData(){
        bs.mapGenres = new ArrayList<>();
        bs.mapBooks = new ArrayList<>();;

        Genre genre1 = new Genre("1", "genre1");
        Genre genre2 = new Genre("2", "genre2");
        Genre genre3 = new Genre("3", "genre3");
        Genre genre4 = new Genre("3", "genre3");
        bs.mapGenres.add(genre1);
        bs.mapGenres.add(genre2);
        bs.mapGenres.add(genre3);
        bs.mapGenres.add(genre4);

        Book book1 = new Book("1", "book1", genre1);
        Book book2 = new Book("2", "book2", genre1);
        Book book3 = new Book("3", "book3", genre3);
        bs.mapBooks.add(book1);
        bs.mapBooks.add(book2);
        bs.mapBooks.add(book3);
    }

    @Test
    public void test_getAllGenres_Remove_Duplicate(){
        mockData();
        List<Genre> temp = bs.getAllGenres();
        assertEquals(3, temp.size());
        assertNotEquals(4, temp.size());
    }

    @Test
    public void test_getBooksByGenre_With_Input_Genre1(){
        mockData();
        Map<String, String> temp =  bs.getBooksByGenre("genre1");
        assertEquals(2, temp.size());
    }

}
