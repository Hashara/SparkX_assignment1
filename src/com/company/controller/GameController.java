package com.company.controller;

import com.company.conf.Configs;
import com.company.model.Game;
import com.company.model.Team;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    public Game createGame(String team1, String team2) throws IllegalArgumentException {
        return new Game(team1, team2);

    }

    public List<Team> selectRandomTeam(Game game)  {
        ScoreController scoreController = new ScoreController();
        return scoreController.selectRandomTeam(game);
    }

    public void play(Game game) {

        TeamController teamController = new TeamController();
        teamController.play(game.getCurrentTeam(), game);
        updateGameStatus(game);
    }

    public void getSummary(Game game){
        System.out.println("Toss won by: " + game.getToss().getTeamName() );

        List<Team> teamList = getWinner(game);

        TeamController teamController = new TeamController();

        for (Team t:
             teamList) {
            teamController.getSummary(t);
        }

    }

    private List<Team> getWinner(Game game){
        List<Team> teams = new ArrayList<>();
        if (game.getTeam1().getScore() > game.getTeam2().getScore()){
            System.out.println("Game won by: " + game.getTeam1().getTeamName() );
            teams.add(game.getTeam1());
            teams.add(game.getTeam2());
        }
        else if (game.getTeam1().getScore() == game.getTeam2().getScore()){
            System.out.println("Draw");
            teams.add(game.getTeam1());
            teams.add(game.getTeam2());
        }
        else {
            System.out.println("Game won by: " + game.getTeam2().getTeamName() );
            teams.add(game.getTeam2());
            teams.add(game.getTeam1());
        }
        return teams;
    }

    private void updateGameStatus(Game game){
        if (!game.getToss().equals(game.getCurrentTeam()) &&
                game.getCurrentTeam().getScore() > game.getToss().getScore()){
            System.out.println(Configs.GAME_FINISHED);
            game.setGameStatus(Configs.GAME_FINISHED);
        }
    }
}
