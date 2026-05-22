/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft;

public enum GameMode {
    NOT_SET("", -1),
    SURVIVAL("Survival Mode", 0),
    CREATIVE("Creative Mode", 1),
    ADVENTURE("Adventure Mode", 2),
    SPECTATOR("Spectator Mode", 3);

    private final String text;
    private final int id;

    private GameMode(String text, int id) {
        this.text = text;
        this.id = id;
    }

    public String text() {
        return this.text;
    }

    public int id() {
        return this.id;
    }

    public static GameMode getById(int id) {
        GameMode gameMode;
        switch (id) {
            case -1: {
                gameMode = NOT_SET;
                break;
            }
            case 1: {
                gameMode = CREATIVE;
                break;
            }
            case 2: {
                gameMode = ADVENTURE;
                break;
            }
            case 3: {
                gameMode = SPECTATOR;
                break;
            }
            default: {
                gameMode = SURVIVAL;
            }
        }
        return gameMode;
    }
}

