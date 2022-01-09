import java.io.File;

public class DirUtils {

    public static File createDirectory(String name) throws DirUtilException {
        File file = new File(name);
        boolean wasCreated = file.mkdir();
        if (!wasCreated) {
            throw new DirUtilException("directory alredy wasCreated");
        }
        return file;
    }

    public static boolean exists(String name) throws DirUtilException {
        var file = new File(name);
        return file.exists();
    }

    public static void delete(String name) throws DirUtilException {
        if (!exists(name)) {
            throw new DirUtilException(("directory is not exists"));
        } else {
            File file = new File(name);
            file.delete();
        }
    }
}
