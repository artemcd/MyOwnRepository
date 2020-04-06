import java.io.File;
import java.util.ArrayList;

public class Test1File {

public void printSize (File file){
        if(file.exists()){
           long fileSize = getFileSize(file);
            System.out.println(getFileSizeBytes(fileSize));
            System.out.println(getFileSizeKiloBytes(fileSize));
            System.out.println(getFileSizeMegaBytes(fileSize));
            System.out.println(getFileSizeGigaBytes(fileSize));

        }else System.out.println("Файла нет.");
    }

  public   long getFileSize(File dir) {
      long size = 0;
      if (dir.isFile()) {
          size += dir.length();
      } else {
          File[] arrFiles = dir.listFiles();
          for (File files : arrFiles) {
              size += getFileSize(files);
          }
      }return size;
  }


    private static String getFileSizeGigaBytes(long size) {
        return (double) size/(1024*1024*1024)+" Gb";
    }

    private static String getFileSizeMegaBytes(long size) {
        return (double) size/(1024*1024)+" Mb";
    }

    private static String getFileSizeKiloBytes(long size) {
        return (double)size/1024 + " Kb";
    }

    private static String getFileSizeBytes(long size) {
        return size + " bytes";
    }
}
