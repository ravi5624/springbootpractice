package com.helloworldgroup.helloworld.errorhandle;

import java.time.LocalDateTime;
import java.util.Date;

public class ErrorDetails {
    public String errorCode;
    public String errorMessage;
    public LocalDateTime timeStamp;

    public ErrorDetails(String errorCode, String errorMessage, LocalDateTime timeStamp) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.timeStamp = timeStamp;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }
}
