import exception.NullFileException;
import org.junit.Test;

public class testException {

    @Test
    public void testException() {
        try {
            throw new NullFileException("文本为空");
        } catch (NullFileException e) {
            e.printStackTrace();
        }
    }
}
