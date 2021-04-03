package com.company;

import com.company.controller.GameController;
import com.company.model.Game;
import com.company.model.Team;
import com.company.conf.Configs;

import java.util.List;
import java.util.Scanner;

public class RunGame {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Game started..............");
        System.out.print("Enter team 1 name: ");
        String team1 = scanner.next();
        System.out.print("Enter team 2 name: ");
        String team2 = scanner.next();

        GameController gameController = new GameController();

        Game currentGame = gameController.createGame(team1, team2);

        System.out.print("Toss won by : ");
        List<Team> teams = gameController.selectRandomTeam(currentGame);

        System.out.println(teams.get(0).getTeamName());

        System.out.print("Enter p to play");

        while (true) {
            String s = scanner.next();

            if (currentGame.getGameStatus().equals(Configs.GAME_ONGOING)) {
                if (s.equals("p")) {
                    gameController.play(currentGame);
                } else {
                    System.out.println("Enter p to play");
                }
            } else if (currentGame.getGameStatus().equals(Configs.GAME_FINISHED)) {
                break;
            }
        }

        System.out.println("Game finished");
    }
}