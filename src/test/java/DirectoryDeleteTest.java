import com.petukhovsky.jvaluer.commons.local.OS;
import com.petukhovsky.jvaluer.util.FilesUtils;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertTrue;

/**
 * Created by petuh on 22.11.2016.
 */
public class DirectoryDeleteTest {
    @Test
    public void testWindows() throws IOException, InterruptedException {
        if (OS.isUnix()) return;
        Path dir = Paths.get("/tmp/dirdel/");
        FilesUtils.assureEmptyDir(dir);

        Path file1 = dir.resolve("input.txt");
        FileUtils.write(file1.toFile(), "12 23", "UTF-8");
        FilesUtils.chmod(file1, 444);

        Path exe = dir.resolve("solution.exe");
        Files.createFile(exe);
        FilesUtils.chmod(exe, 111);

        Path file2 = dir.resolve("output.txt");
        Files.createFile(file2);
        FilesUtils.chmod(file2, 666);

        assertTrue(FilesUtils.removeRecursiveForce(dir));
    }
}
