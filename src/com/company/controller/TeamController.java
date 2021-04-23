package com.company.controller;

import com.company.model.Game;
import com.company.model.Player;
import com.company.model.Team;
import com.company.conf.Configs;

public class TeamController {

    public void play(Team team, Game game) {

        PlayerController playerController = new PlayerController();

        if (team.getStatus().equals(Team.Status.TEAM_PLAYING)) {
            playerController.play(team.getPlayers().get(team.getCurrentPlayerIndex()), team);

        } else if (game.getToss().equals(team)) {
            if (team.equals(game.getTeam1())) {
                game.getTeam2().setStatus(Team.Status.TEAM_PLAYING);
                game.setCurrentTeam(game.getTeam2());

            } else {
                game.getTeam1().setStatus(Team.Status.TEAM_PLAYING);
                game.setCurrentTeam(game.getTeam1());

            }
            playerController.play(game.getCurrentTeam().getPlayers().get(game.getCurrentTeam().getCurrentPlayerIndex()),game.getCurrentTeam());

        } else {
            System.out.println(Game.Status.FINISHED);
            game.setGameStatus(Game.Status.FINISHED);
        }
        updateBallsCount(game.getCurrentTeam());
    }

    private void updateBallsCount(Team team){
        if (team.getBallCount() == Configs.BALLS_PER_OVER - 1) {
            team.setBallCount(0);
            if (team.getOverCount() == Configs.OVERS_PER_GAME - 1) {
                team.setStatus(Team.Status.TEAM_FINISHED);
                System.out.println(Team.Status.TEAM_FINISHED);
            } else {
                team.setOverCount(team.getOverCount() + 1);
            }
        } else {
            team.setBallCount(team.getBallCount() + 1);
        }
    }

    public void getSummary(Team team){
        System.out.println("=========================================");
        System.out.println(team.getTeamName());
        System.out.println("Score: " + team.getScore());
        System.out.println("=========================================");

        PlayerController playerController = new PlayerController();

        for (Player p:
             team.getPlayers()) {
            playerController.getSummary(p);
        }
    }
}
