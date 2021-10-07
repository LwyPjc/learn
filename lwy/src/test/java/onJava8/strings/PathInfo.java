package onJava8.strings;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathInfo {
    static void show(String id, Object p) {
        System.out.println(id + ": " + p);
    }
    static void info(Path path){
        show("toString ",path);
        show("Exists ", Files.exists(path));
        show("RegularFile",Files.isRegularFile(path));
        show("Directory", Files.isDirectory(path));
        show("Absolute", path.isAbsolute());
        show("FileName", path.getFileName());
        show("Parent",path.getParent());
        show("Root", path.getRoot());
        System.out.println("================");
    }

    public static void main(String[] args) {
        System.out.println(System.getProperty("os.name"));

        info(Paths.get("C:"));
    }
}
