package com.twu.biblioteca.managers;

public class ExitManagerImpl implements ExitManager {
    @Override
    public void exit(int exitCode) {
        System.exit(exitCode);
    }
}
