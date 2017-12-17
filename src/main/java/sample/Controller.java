package sample;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.web.WebView;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    @FXML private WebView browserView;
    @FXML private ListView listoflinks;

    private ArrayList<NewsLink> getLinks(String url) throws Exception {
        ArrayList<NewsLink> addresses = new ArrayList<NewsLink>();
        try {
            Document page = Jsoup.connect(url).ignoreHttpErrors(true).timeout(10000).get();
            Elements links = page.select("a[href]");
            String address, title;
            for (Element link : links) {
                address = link.attr("abs:href");
                title = link.text();
                if (!address.contains("article"))
                    addresses.add(new NewsLink(address, title));
            }
        } catch (Exception e) {
            HelperMethods.showErrorDialog(e);
        } finally {
            return addresses;
        }
    }

    public void initialize() {
        try {
            List<NewsLink> allNews = getLinks("https://www.prothom-alo.com/");
            List<String> allURLs = new ArrayList<String>();
            for (NewsLink article : allNews) {
                allURLs.add(article.getTitle());
            }
            ListProperty<String> listProperty = new SimpleListProperty<String>();
            listProperty.set(FXCollections.observableArrayList(allURLs));
            listoflinks.itemsProperty().bind(listProperty);
        } catch (Exception e) {
            HelperMethods.showErrorDialog(e);
        }
    }


}
