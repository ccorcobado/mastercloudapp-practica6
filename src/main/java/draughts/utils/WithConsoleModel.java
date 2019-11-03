package draughts.utils;

public abstract class WithConsoleModel {
    protected final Console console;

    protected WithConsoleModel() {
        this.console = new Console();
    }
}