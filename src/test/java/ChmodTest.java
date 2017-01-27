import com.petukhovsky.jvaluer.util.fs.FilesUtils;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by arthur on 29.10.16.
 */
public class ChmodTest {
    @Test
    public void test() throws IOException {
        Path tmp = Paths.get("/tmp/x.txt");
        Files.createFile(tmp);
        FilesUtils.chmod(tmp, 777);
    }
}
