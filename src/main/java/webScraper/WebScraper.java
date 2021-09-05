package webScraper;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class WebScraper {
    public static void main(String[] args) {
    Connection connect=Jsoup.connect(
            "");
        try {
            Document document= connect.get();
            Elements elements=document.getElementsByTag("a");
            for (Element e :elements) {
                System.out.println(e.attr("href"));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
