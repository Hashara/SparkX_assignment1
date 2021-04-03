package com.company.controller;

import com.company.model.Game;
import com.company.model.Team;

import java.util.List;

public class GameController {

    public Game createGame(String team1, String team2) throws Exception {
        return new Game(team1, team2);

    }

    public List<Team> selectRandomTeam(Game game)  {
        ScoreController scoreController = new ScoreController();
        return scoreController.selectRandomTeam(game);
    }

    public void play(Game game) {

        TeamController teamController = new TeamController();
        teamController.play(game.getCurrentTeam(), game);

    }
}
