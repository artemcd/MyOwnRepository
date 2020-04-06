import Core.Line;
import Core.Station;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {
        StationIndex stationIndex = new StationIndex();
        List<Line> linesArr = new ArrayList<>();
        ArrayList <String> nameOfLineList = new ArrayList<>();
        ArrayList<String> nameOfStations = new ArrayList<>();

        Document doc = Jsoup.connect("https://ru.wikipedia.org/wiki/%D0%A1%D0%BF%D0%B8%D1%81%D0%BE%D0%BA_%D1%81%D1%82%D0%B0%D0%BD%D1%86%D0%B8%D0%B9_%D0%9C%D0%BE%D1%81%D0%BA%D0%BE%D0%B2%D1%81%D0%BA%D0%BE%D0%B3%D0%BE_%D0%BC%D0%B5%D1%82%D1%80%D0%BE%D0%BF%D0%BE%D0%BB%D0%B8%D1%82%D0%B5%D0%BD%D0%B0").maxBodySize(0).get();
        Elements els = doc.select(".standard.sortable tr");

        int number = 1;
        for(int i = 0; i < els.size(); i++)  {

            String es = els.get(i).select("td a").text();
/** Создал три регулярки, которые чистят названия станций от всякого мусора */
            Pattern pattern = Pattern.compile("[А-Я][а-яё]+(\\s?(\\-)?[А-Яа-яё]+)?(\\s?(\\-)?[А-Яа-яё]+)?");
            Matcher matcher = pattern.matcher(es);
            Pattern pattern2 = Pattern.compile("[А-Я]{4}");
            Matcher matcher2 = pattern2.matcher(es);
            Pattern pattern3 = Pattern.compile("[А-Я][а-яё]+\\s{1}[0-9]{4}\\s[а-яё]{4}");
            Matcher matcher3 = pattern3.matcher(es);
/**КОНЕЦ РЕГУЛЯРОК  */

            String nameOfLine = els.get(i).select("span.sortkey +span").attr("title");   // Цепляем станциосодержащие слова

            if(!nameOfLineList.contains(nameOfLine) && !nameOfLine.isEmpty()) { //Создаём линию, ставим номер станции по порядку и прибавляем 1
                nameOfLineList.add(nameOfLine);
                linesArr.add(new Line(number, nameOfLine));
                number++; }


/** А здесь у нас станциоочистительная фабрика, на выходе создаём новую станцию */
            if(matcher3.find()) {
                int start = matcher3.start();
                int end = matcher3.end();
                linesArr.get(linesArr.size() - 1).addStation( new Station(es.substring(start, end), linesArr.get(linesArr.size() - 1)));
                nameOfStations.add(es.substring(start, end));
            } else if (matcher.find()) {
                int start = matcher.start();
                int end = matcher.end();
                linesArr.get(linesArr.size() - 1).addStation( new Station(es.substring(start, end), linesArr.get(linesArr.size() - 1)));
                nameOfStations.add(es.substring(start, end));
            } else if (matcher2.find()) {
                int start = matcher2.start();
                int end = matcher2.end();
                linesArr.get(linesArr.size() - 1).addStation( new Station(es.substring(start, end), linesArr.get(linesArr.size() - 1)));
                nameOfStations.add(es.substring(start, end));
            }
        }
/**КОНЕЦ Фабрики и всего поиска станций и линий           */

test.getAllConect(nameOfStations);

/**============== ДОБАВЛЯЕМ ВСЕ ЛИНИИ И СТАНЦИИ В StationIndex ================*/
        for (int i = 0; i < linesArr.size(); i++) {
            stationIndex.addLine(linesArr.get(i));
            for (int z = 0; z < stationIndex.getLine(i + 1).getStations().size(); z++) {
                stationIndex.addStation(stationIndex.getLine(i + 1).getStations().get(z));
            }
        }
/**КОНЕЦ ДОБАВЛЕНИЮ ВСЕХ СТАНЦИЙ И ЛИНИЙ */

/** Сериализация в ОБЪЕКТА в JSON*/

        try(FileWriter writer = new FileWriter("C:\\Users\\User\\IdeaProjects\\МОДУЛИ\\Модуль 9\\ДЗ_5\\src\\main\\resources\\map.json", false))
        {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(stationIndex);
            writer.write(json);
            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

        for (int i = 0; i < nameOfStations.size(); i++) {
            System.out.println(i + " " + nameOfStations.get(i));
        }
    }
}
