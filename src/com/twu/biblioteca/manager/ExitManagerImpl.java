package com.twu.biblioteca.manager;

public class ExitManagerImpl implements ExitManager {
    @Override
    public void exit(int exitCode) {
        System.exit(exitCode);
    }
}
