package sampple.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogUtil {
static Logger logger = LogManager.getLogger("org.springframework");
	
	private LogUtil() {
		throw new IllegalStateException("Utility class");
	}
	
	public static Logger getLogger() {
		return logger;
	}
}
