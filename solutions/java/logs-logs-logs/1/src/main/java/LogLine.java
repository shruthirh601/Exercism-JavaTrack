public class LogLine {
    String logLine;
    
    public LogLine(String logLine) {
        this.logLine = logLine;
    }

    public LogLevel getLogLevel() {
        String levelCode = logLine.split("]:\\s*", 2)[0].substring(1);
        switch(levelCode){
            case "TRC": return LogLevel.TRACE;
            case "DBG": return LogLevel.DEBUG;
            case "INF": return LogLevel.INFO;
            case "WRN": return LogLevel.WARNING;
            case "ERR": return LogLevel.ERROR;
            case "FTL": return LogLevel.FATAL;
            default: return LogLevel.UNKNOWN;
            
        }
    }

    public String getOutputForShortLog() {
        String message = logLine.split("]:\\s*", 2)[1].trim();
        LogLevel logLvlType = this.getLogLevel();
        return logLvlType.getTypeLog()+":"+message;
    }
}
