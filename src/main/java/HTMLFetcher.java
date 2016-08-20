import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * Created by Adrian on 8/20/2016.
 */
public class HTMLFetcher {
    public static Document fetch (String url) throws IOException {
        return Jsoup.connect(url).get();
    }
}
