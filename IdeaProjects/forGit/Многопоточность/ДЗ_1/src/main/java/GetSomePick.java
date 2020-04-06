import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.*;
import java.net.URL;

public class GetSomePick {
    private static final String folderPath = "C:\\Users\\User\\Desktop\\все картинки";

    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect("https://lenta.ru/").maxBodySize(0).get();
        Elements img = doc.getElementsByTag("img");

        for (Element el : img) {
            String src = el.absUrl("src");
            getImages(src);
        }
    }



    private static void getImages(String src) throws IOException {
try {


    int indexName = src.lastIndexOf("/");
    String name = src.substring(indexName, src.length());

    URL url = new URL(src);
    InputStream in = url.openStream();
    OutputStream out = new BufferedOutputStream(new FileOutputStream(folderPath + name));
    for (int b; (b = in.read()) != -1; ) {
        out.write(b);
    }
    out.close();
    in.close();
}catch (Exception ex) {
    ex.getStackTrace();
}
    }
}