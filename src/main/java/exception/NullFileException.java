package exception;

public class NullFileException extends Exception{

    /**
     * 空文件异常
     * @param message
     */
    public NullFileException(String message) {
        super(message);
    }
}
