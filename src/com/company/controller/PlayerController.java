package com.company.controller;

import com.company.model.Player;
import com.company.conf.Configs;
import com.company.model.Team;

public class PlayerController {

    public void play(Player p, Team team) {
        ScoreController scoreController = new ScoreController();
        int score = scoreController.generateScore();
        System.out.print(team.getOverCount() + 1 + "-" + (team.getBallCount() + 1) + " ");

        System.out.println(team.getTeamName() + " " + team.getScore()
                + " - " + p.getPlayerName() + " " + p.getScore());

        if (score < 0) {
            String outMode = scoreController.outModesGenerator();
            p.setStatus(outMode);
            if (team.getCurrentPlayerIndex() < Configs.PLAYERS_PER_TEAM - 1) {
                team.setCurrentPlayerIndex(team.getCurrentPlayerIndex() + 1);
            } else {
                team.setStatus(Configs.TEAM_FINISHED);
                System.out.println("team finished");
            }
            System.out.println(outMode);
        } else {

            p.addScore(score);
            p.setStatus(Configs.TEAM_PLAYING);
            System.out.println(score);

        }

        System.out.println("new score :" + team.getScore());


    }

    public void getSummary(Player p){
        System.out.println(p.getPlayerName()+"\t\t" + p.getScore() + "\t" + p.getStatus());
    }


}
