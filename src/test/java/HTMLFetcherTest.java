import org.jsoup.nodes.Document;
import org.junit.Test;
import java.io.IOException;
import static junit.framework.TestCase.assertEquals;

/**
 * Created by Adrian on 8/20/2016.
 */
public class HTMLFetcherTest {

    @Test
    public void retrieveGoogleHTML(){
        try {
            Document google = HTMLFetcher.fetch("https://www.google.com");
            assertEquals("Google", google.title());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
