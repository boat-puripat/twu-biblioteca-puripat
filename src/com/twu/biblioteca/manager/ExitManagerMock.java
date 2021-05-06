package com.twu.biblioteca.manager;

public class ExitManagerMock implements ExitManager {
    public boolean exitWasCalled;
    public int exitCode;

    @Override
    public void exit(int exitCode) {
        exitWasCalled = true;
        this.exitCode = exitCode;
    }
}
