package arc.core.loggers;

import com.hypixel.hytale.logger.HytaleLogger;

public class Logger {
  
  public static void Info(String message) {
    HytaleLogger.getLogger().atInfo().log(message);
  }

  public static void Error(String message) {
    HytaleLogger.getLogger().atSevere().log(message);
  }

  public static void Warning(String message) {
    HytaleLogger.getLogger().atWarning().log(message);
  }
}
