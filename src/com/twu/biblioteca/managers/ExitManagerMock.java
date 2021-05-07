package com.twu.biblioteca.managers;

public class ExitManagerMock implements ExitManager {
    public boolean exitWasCalled;
    public int exitCode;

    @Override
    public void exit(int exitCode) {
        exitWasCalled = true;
        this.exitCode = exitCode;
    }
}
