package com.github.loanptn;

public class Resource1 {
    boolean isCloseMethodCalled = false;
    boolean isCloseMethodCalled() {
	return isCloseMethodCalled;
    }
    public void close() {
	if(isCloseMethodCalled)
	    throw new CloseMethodAlreadyCalledRuntimeException();
	isCloseMethodCalled = true;
    }
    class CloseMethodAlreadyCalledRuntimeException extends RuntimeException {
    }
}
