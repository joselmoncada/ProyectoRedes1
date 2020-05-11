package com.game;

public abstract class Game {
    protected boolean exit;

    public abstract void init();

    public abstract void update();

    public abstract void render();

    public abstract void dispose();

    public void gameLoop() {
        while (!exit) {
            update();
            render();
        }
        dispose();
    }
}
