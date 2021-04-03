package com.company.conf;


public final class Configs {

    private Configs() {
    }

    public static final int PLAYERS_PER_TEAM = 6;
    public static final Integer[] RUNS = {-1, 0, 1, 2, 3, 4, 6};
    public static final String[] PLAYING_MODES = {"ball", "bat"};
    public static final String[] OUT_MODES = {"caught", "bowled"};
    public static final int OVERS_PER_GAME = 5;
    public static final int BALLS_PER_OVER = 3;
    public static final String TEAM_PLAYING = "Playing";
    public static final String TEAM_FINISHED = "finished";
    public static final String GAME_ONGOING = "ongoing";
    public static final String GAME_FINISHED = "finished";


}
