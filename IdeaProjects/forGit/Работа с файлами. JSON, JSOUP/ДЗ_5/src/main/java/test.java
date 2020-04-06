import Core.Line;
import Core.Station;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {

    public static TreeMap<String, String> getAllConect(ArrayList<String> list) throws IOException {


        Document doc = Jsoup.connect("https://ru.wikipedia.org/wiki/%D0%A1%D0%BF%D0%B8%D1%81%D0%BE%D0%BA_%D1%81%D1%82%D0%B0%D0%BD%D1%86%D0%B8%D0%B9_%D0%9C%D0%BE%D1%81%D0%BA%D0%BE%D0%B2%D1%81%D0%BA%D0%BE%D0%B3%D0%BE_%D0%BC%D0%B5%D1%82%D1%80%D0%BE%D0%BF%D0%BE%D0%BB%D0%B8%D1%82%D0%B5%D0%BD%D0%B0").maxBodySize(0).get();
        Elements els = doc.select(".standard.sortable tr");
        HashMap<String, String> conneccct = new HashMap<>();
        ArrayList<String> arrConneccct3 = new ArrayList<>();
        ArrayList<String> arrConneccct2 = new ArrayList<>();
        ArrayList<String> arrConneccct1 = new ArrayList<>();
        TreeMap<String, String> conneccct3 = new TreeMap<>();

        /** Достаем название станций с коннектами*/
        ArrayList<String> conArr = new ArrayList<>();
        for (int i = 0; i < els.size(); i++) {
            Elements es = els.get(i).select("td a");
            for (int w = 0; w < es.size(); w++) {
                conArr.add(es.get(w).attr("title").toString());
            }
        }


        /** Создаем список ключ значение с коннектами*/
        for (int i = 0; i < conArr.size(); i++) {
            if (conArr.get(i).endsWith("линия") && conArr.get(i + 4).startsWith("Переход")) {

                if (conArr.get(i + 1).indexOf('(') > 0) {
                    String st1 = conArr.get(i + 1).substring(0, conArr.get(i + 1).lastIndexOf('(') - 1);
                    String st2 = conArr.get(i + 4).substring(19);
                    arrConneccct1.add(st1);
                    arrConneccct2.add(st2);
                    conneccct.put(st1, st2);
                } else {
                    String st2 = conArr.get(i + 4).substring(19);
                    arrConneccct1.add(conArr.get(i + 1));
                    arrConneccct2.add(st2);
                    conneccct.put(conArr.get(i + 1), st2);
                }

            } else if (conArr.get(i).startsWith("линия") && conArr.get(i + 5).startsWith("Переход")) {
                String st2 = conArr.get(i + 5).substring(19);
                arrConneccct1.add(conArr.get(i + 1));
                arrConneccct2.add(st2);
                conneccct.put(conArr.get(i + 1), st2);
            }
        }

        for (int i = 0; i < arrConneccct2.size(); i++){
            for(int z = 0; z < list.size(); z++) {
               if(arrConneccct2.get(i).contains(list.get(z))) {
                   arrConneccct3.add(list.get(z));
               }
            }
        }


        System.out.println(arrConneccct1.size() + " " + arrConneccct3.size());
        for (String str : conArr) {
            System.out.println(str);
        }
    /*    for (Map.Entry<String, String> entry : conneccct3.entrySet()) {
            System.out.println("Key:" + entry.getKey() + " Value: " + entry.getValue());
        }

            System.out.println(arrConneccct1.size() + " " + arrConneccct2.size());
        for (int i = 0; i < arrConneccct1.size(); i++)
        {
            System.out.println(arrConneccct1.get(i));
        }
        System.out.println("====================");
        for (int i = 0; i < arrConneccct2.size(); i++)
        {
            System.out.println(arrConneccct2.get(i));
        }*/
    return conneccct3;
    }

}









        /**
        for (Map.Entry<String, String> entry1 : conneccct.entrySet()) {
            for (Map.Entry<String, String> entry2 : conneccct.entrySet()) {
                if (entry1.getValue().contains(entry2.getKey())) {
                    arrConneccct2.add(entry2.getKey());
                }
            }
        }



        for (Map.Entry<String, String> entry : conneccct.entrySet()) {
        arrConneccct1.add(entry.getKey());
        }


       for(int i = 0; i < arrConneccct1.size(); i++)
       {
           conneccct3.put(arrConneccct1.get(i), arrConneccct2.get(i));
       }


        System.out.println(arrConneccct1.size() + " " + arrConneccct2.size());
        for (Map.Entry<String, String> entry : conneccct3.entrySet()) {
            System.out.println("Key:" + entry.getKey() + " Value: " + entry.getValue());

        }
    }
}**/


