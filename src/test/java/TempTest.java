import com.petukhovsky.jvaluer.util.Local;
import com.petukhovsky.jvaluer.util.fs.TempStorage;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Arthur Petukhovsky on 7/7/2016.
 */
public class TempTest {
    @Test
    public void testUnzip() throws IOException {
        Path dir = Paths.get("/tmp/ziptest/");
        Path zip = Files.createTempFile("", ".zip");
        Local.loadResource("/test.zip", zip);
        TempStorage storage = new TempStorage(dir);
        try (TempDirectory temp = storage.unzip(Files.newInputStream(zip))) {
        }
    }
}
