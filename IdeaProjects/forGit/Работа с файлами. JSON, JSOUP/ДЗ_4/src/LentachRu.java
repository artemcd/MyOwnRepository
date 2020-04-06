import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.*;
import java.net.URL;

public class LentachRu {
    private static final String folderPath = "C:\\Users\\User\\Desktop\\первая";

    public static void main(String[] args) throws IOException {
               Document doc = Jsoup.connect("https://lenta.ru/").get(); // Получаем документ с html файлом через конект
               Elements img = doc.getElementsByTag("img"); //Создаём объект класса Элементы и добавляем туда все img-содержащие элементы

                    for (Element el : img) {
                        String src = el.absUrl("src"); // Через атрибут src мы получаем адрес, который достается методом absUrl
                        System.out.println(src);
                        getImages(src);
                    }
            }



    private static void getImages(String src) throws IOException {

                int indexName = src.lastIndexOf("/");
                String name = src.substring(indexName, src.length());  // Получаем название каждого изображения

                URL url = new URL(src); //Получаем  объект класса URL
                InputStream in = url.openStream(); // Открываем поток
                OutputStream out = new BufferedOutputStream(new FileOutputStream( folderPath+ name));
                for (int b; (b = in.read()) != -1;) {
                    out.write(b);
                }
                out.close();
                in.close();
    }
}

