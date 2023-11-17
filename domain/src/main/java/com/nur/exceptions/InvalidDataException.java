package com.nur.exceptions;

public class InvalidDataException  extends RuntimeException{
    private static final long serialVersionUID = 1L;
    String metodo;
    public InvalidDataException(String message) {
        super(message);
        this.fillMethod();
    }
    private void fillMethod() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace.length > 3) {
            StackTraceElement caller = stackTrace[3];
            String className = caller.getFileName();
            String var10000 = caller.getMethodName();
            String methodName = var10000 + ":" + caller.getLineNumber();
            metodo = className + ":" + methodName;
        }
    }
}
