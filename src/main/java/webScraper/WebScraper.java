package webScraper;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class WebScraper {
    public static Map<String, LinkedHashSet<String>> map;
    public static ArrayList<Pair> ranking;

    static class Pair implements Comparable<Pair> {
        int first;
        String second;

        @Override
        public int compareTo(Pair o) {
            return o.first - first;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "first=" + first +
                    ", second='" + second + '\'' +
                    '}';
        }
    }

    public static void run(String url) {

        Connection connect = Jsoup.connect(url).userAgent("Mozilla/5.0");
        Document document = null;
        try {
            document = connect.get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (document != null) {
            map = new LinkedHashMap<>();
            getAllText(document, map);
            getAllLink(document, map);
            getAllEmail(document, map);
        }

        for (String str : map.keySet()) {

        }
        LinkedHashSet link = map.get("Link");
        if (link != null) {
            ranking = new ArrayList<>();
            for (Object s : link) {
                String str = (String) s;
                Pair pair = new Pair();
                pair.second = str;
                int min = Math.min(str.length(), url.length());
                for (int i = 0; i < min; i++) {
                    if (str.charAt(i) == url.charAt(i)) pair.first++;
                    else break;
                }
                ranking.add(pair);
            }
            Collections.sort(ranking);
        }
    }

    static void getAllText(Document document, Map map) {
        HashSet<String> p = new LinkedHashSet<>();
        Elements elements = document.getElementsByTag("p");
        for (Element e : elements) {
            p.add(e.text());
        }
        if (p.size() > 0) {
            map.put("Text", p);
        }
    }

    static void getAllLink(Document document, Map map) {
        HashSet<String> a = new LinkedHashSet<>();
        Elements elements = document.select("a[href]");
        for (Element e : elements) {
            a.add(e.attr("abs:href"));
        }
        if (a.size() > 0) {
            map.put("Link", a);
        }
    }

    static void getAllEmail(Document document, Map map) {
        Pattern p = Pattern.compile("[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+");
        Matcher matcher = p.matcher(document.text());
        HashSet<String> e = new LinkedHashSet<>();
        while (matcher.find()) {
            e.add(matcher.group());
        }
        if (e.size() > 0) {
            map.put("Email", e);
        }
    }


}
