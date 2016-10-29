import com.petukhovsky.jvaluer.util.FilesUtils;
import org.junit.Test;

import java.nio.file.Paths;

/**
 * Created by arthur on 29.10.16.
 */
public class ChmodTest {
    @Test
    public void test() {
        FilesUtils.chmod(Paths.get("/tmp/abcd"), 777);
    }
}
