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

    public static Document document = null;

    public static Document getDocument() {
        return document;
    }

    public static Map<String, LinkedHashSet<String>> run(String url) {
        Map<String, LinkedHashSet<String>> map=new LinkedHashMap<>();
        Connection connect = Jsoup.connect(url).userAgent("Mozilla/5.0");
        document = null;
        try {
            document = connect.get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (document != null) {
            map = new LinkedHashMap<>();
            getAllLink(document, map);
            getAllEmail(document, map);
        }
        return map;
    }


    public static ArrayList<Pair> getLinkRanking(String url, Map<String, LinkedHashSet<String>> map){
        ArrayList<Pair> ranking = null;
        LinkedHashSet<String> link = map.get("Link");
        if (link != null) {
            ranking = new ArrayList<>();
            for (String s : link) {
                Pair pair = new Pair();
                pair.second = s;
                int min = Math.min(s.length(), url.length());
                for (int i = 0; i < min; i++) {
                    if (s.charAt(i) == url.charAt(i)) pair.first++;
                    else break;
                }
                ranking.add(pair);
            }
            Collections.sort(ranking);
        }
        return ranking;
    }

    public static String getAllText(Document document) {
        LinkedHashSet<String> p = new LinkedHashSet<>();
        return document.select("p").text();
    }

    static void getAllLink(Document document, Map<String, LinkedHashSet<String>> map) {
        LinkedHashSet<String> a = new LinkedHashSet<>();
        Elements elements = document.select("a[href]");
        for (Element e : elements) {
            a.add(e.attr("abs:href"));
        }
        if (a.size() > 0) {
            map.put("Link", a);
        }
    }

    static void getAllEmail(Document document, Map<String, LinkedHashSet<String>> map) {
        Pattern p = Pattern.compile("[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+");
        Matcher matcher = p.matcher(document.text());
        LinkedHashSet<String> e = new LinkedHashSet<>();
        while (matcher.find()) {
            e.add(matcher.group());
        }
        if (e.size() > 0) {
            map.put("Email", e);
        }
    }

//    public static void main(String[] args) {
//        WebScraper.run("");
//    }


}
