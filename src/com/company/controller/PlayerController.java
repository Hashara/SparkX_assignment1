package com.company.controller;

import com.company.model.Player;
import com.company.conf.Configs;

public class PlayerController {

    public void play(Player p) {
        ScoreController scoreController = new ScoreController();
        int score = scoreController.generateScore();
        System.out.print(p.getTeam().getOverCount() + 1 + "-" + (p.getTeam().getBallCount() + 1) + " ");

        System.out.println(p.getTeam().getTeamName() + " " + p.getTeam().getScore()
                + " - " + p.getPlayerName() + " " + p.getScore());

        if (score < 0) {
            String outMode = scoreController.outModesGenerator();
            p.setStatus(outMode);
            if (p.getTeam().getCurrentPlayerIndex() < Configs.PLAYERS_PER_TEAM - 1) {
                p.getTeam().setCurrentPlayerIndex(p.getTeam().getCurrentPlayerIndex() + 1);
            } else {
                p.getTeam().setStatus(Configs.TEAM_FINISHED);
                System.out.println("team finished");
            }
            System.out.println(outMode);
        } else {

            p.addScore(score);
            p.setStatus(Configs.TEAM_PLAYING);
            System.out.println(score);

        }

    }

    public void getSummary(Player p){
        System.out.println(p.getPlayerName()+"\t\t" + p.getScore() + "\t" + p.getStatus());
    }
}
