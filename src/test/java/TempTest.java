import com.petukhovsky.jvaluer.commons.local.Local;
import com.petukhovsky.jvaluer.util.temp.TempDirectory;
import com.petukhovsky.jvaluer.util.temp.TempStorage;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * Created by Arthur Petukhovsky on 7/7/2016.
 */
public class TempTest {
    @Test
    public void testTemp() throws IOException {
        Path dir = Files.createTempDirectory("");
        TempStorage storage = new TempStorage(dir);
        try (TempDirectory temp = storage.createTempDirectory()) {
            Path file = temp.resolve("file.txt");
            try(ByteArrayInputStream bais = new ByteArrayInputStream("test test string".getBytes())) {
                Files.copy(bais, file, StandardCopyOption.REPLACE_EXISTING);
            }
        }
    }

    @Test
    public void testUnzip() throws IOException {
        Path dir = Paths.get("/tmp/ziptest/");
        Path zip = Files.createTempFile("", ".zip");
        Local.loadResource(zip, "/test.zip");
        TempStorage storage = new TempStorage(dir);
        try (TempDirectory temp = storage.unzip(Files.newInputStream(zip))) {
        }
    }
}
