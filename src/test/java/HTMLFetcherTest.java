import org.jsoup.nodes.Document;
import org.junit.Test;
import utils.HTMLFetcher;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by Adrian on 8/20/2016.
 */
public class HTMLFetcherTest {

    @Test
    public void retrieveGoogleHTML(){
            Document google = HTMLFetcher.fetch("https://www.google.com");
            assertEquals("Google", google.title());
    }
}
