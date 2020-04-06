import java.io.*;
import java.nio.file.*;
public class FileTest {


    public void copyDir(String sourceDirName, String targetSourceDir) throws IOException {
        File folder = new File(sourceDirName); //указываем директорию ОТ КУДА копировать

        File[] listOfFiles = folder.listFiles(); //создаём массив данных в буфер

        Path destDir = Paths.get(targetSourceDir); //указываем директорию КУДА копировать
        if (listOfFiles != null)  {
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    Files.copy(file.toPath(), destDir.resolve(file.getName()), StandardCopyOption.REPLACE_EXISTING);
                } else {
                    File dirs = new File(targetSourceDir, file.getName());
                    boolean created = dirs.mkdir();
                    copyDir(file.getAbsolutePath(), dirs.getAbsolutePath());
                }
            }
        }
    }
}
