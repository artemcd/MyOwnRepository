import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.name.Rename;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ChangePicksSize extends Thread {
private File[] files;
private int newWidth;
private String dst;
private long start;


    public ChangePicksSize(File[] files, int newWidth, String dst, long start) {
        this.files = files;
        this.newWidth = newWidth;
        this.dst = dst;
        this.start = start;
    }


    @Override
    public void run() {
        for(File file : files) {
            try {
              Thumbnails.of(file).size(300, 300).toFiles(Rename.PREFIX_DOT_THUMBNAIL);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(System.currentTimeMillis() - start);
    }
    }

