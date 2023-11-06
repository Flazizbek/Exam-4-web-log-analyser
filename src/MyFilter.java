import java.util.logging.Filter;
import java.util.logging.Level;
import java.util.logging.LogRecord;

public class MyFilter implements Filter {
    @Override
    public boolean isLoggable(LogRecord record) {
        if (record.getLevel().equals(Level.SEVERE) || record.getLevel().equals(Level.INFO)){
            return true;
        }
        return false;
    }
}