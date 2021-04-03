package com.company.controller;

import com.company.model.Game;
import com.company.model.Team;
import com.company.conf.Configs;

public class TeamController {

    public void play(Team team, Game game) {
        if (team.getBallCount() == Configs.BALLS_PER_OVER - 1) {
            team.setBallCount(0);
            if (team.getOverCount() == Configs.OVERS_PER_GAME - 1) {
                team.setStatus(Configs.TEAM_FINISHED);
            } else {
                team.setOverCount(team.getOverCount() + 1);
            }
        } else {
            team.setBallCount(team.getBallCount() + 1);
        }
        PlayerController playerController = new PlayerController();

        if (team.getStatus().equals(Configs.TEAM_PLAYING)) {
            playerController.play(team.getPlayers().get(team.getCurrentPlayerIndex()));

        } else if (team.equals(game.getToss())) {
            if (team.equals(game.getTeam1())) {
                game.getTeam2().setStatus(Configs.TEAM_PLAYING);
                game.setCurrentTeam(game.getTeam2());

            } else {
                game.getTeam1().setStatus(Configs.TEAM_PLAYING);
                game.setCurrentTeam(game.getTeam1());

            }
            playerController.play(game.getCurrentTeam().getPlayers().get(game.getCurrentTeam().getCurrentPlayerIndex()));

        } else {
            System.out.println(Configs.GAME_FINISHED);
            game.setGameStatus(Configs.GAME_FINISHED);
        }
    }
}
