import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.name.Rename;

import java.io.File;
import java.io.IOException;

public class Main {
    private static  int newWidth = 300;

    public static void main(String[] args) throws IOException {
        String srcFolder = "C:\\Users\\User\\Desktop\\все картинки";
        String dstFolder = "C:\\Users\\User\\Desktop\\dst";
        long start = System.currentTimeMillis();

        File src = new File(srcFolder);
        File [] files = src.listFiles();
        int quarter = files.length / 4;

        File [] file1 = new File [quarter];
        System.arraycopy(files, 0, file1, 0, file1.length);
        ChangePicksSize picksSize1 = new ChangePicksSize(file1, newWidth, dstFolder, start);
picksSize1.start();
        File [] file2 = new File [quarter];
        System.arraycopy(files, quarter, file2, 0, file2.length);
        ChangePicksSize picksSize2 = new ChangePicksSize(file2, newWidth, dstFolder, start);
picksSize2.start();
        File [] file3 = new File [quarter];
        System.arraycopy(files, quarter*2, file3, 0, file3.length);
        ChangePicksSize picksSize3 = new ChangePicksSize(file3, newWidth, dstFolder, start);
picksSize3.start();
        File [] file4 = new File [files.length - quarter*3];
        System.arraycopy(files, quarter*3, file4, 0, file4.length);
        ChangePicksSize picksSize4 = new ChangePicksSize(file4, newWidth, dstFolder,start);
        picksSize4.start();

    }
}
