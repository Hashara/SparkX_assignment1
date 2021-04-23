package com.company.controller;

import com.company.model.Game;
import com.company.model.Team;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameController {

    public void startGame(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Game started..............");
        System.out.print("Enter team 1 name: ");
        String team1 = scanner.next();
        System.out.print("Enter team 2 name: ");
        String team2 = scanner.next();

        Game currentGame = new Game(team1, team2);

        System.out.print("Toss won by : ");
        Util util = new Util();
        List<Team> teams = util.selectRandomTeam(currentGame);

        System.out.println(teams.get(0).getTeamName());

        System.out.println("Enter p to play");

        while (!Game.Status.FINISHED.equals(currentGame.getGameStatus())) {
            String s = scanner.next();

            if (s.equals("p")) {
                this.play(currentGame);

            } else {
                System.out.println("Enter p to play");
            }
        }

        this.getSummary(currentGame);

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
            System.out.println(Game.Status.FINISHED);
            game.setGameStatus(Game.Status.FINISHED);
        }
    }
}
