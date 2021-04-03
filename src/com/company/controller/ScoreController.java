package com.company.controller;

import com.company.conf.Configs;
import com.company.model.Game;
import com.company.model.Team;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ScoreController {

    private Random getRandom(){
        try {
            return SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException e) {
            return new Random();
        }
    }
    public int generateScore() {
        Random random = getRandom();

        List<Integer> scores = Arrays.asList(Configs.RUNS);

        return scores.get(random.nextInt(scores.size()));
    }

    public String outModesGenerator() {
        Random random =  getRandom();
        List<String> outModes = Arrays.asList(Configs.OUT_MODES);

        return outModes.get(random.nextInt(outModes.size()));
    }

    public List<Team> selectRandomTeam(Game game) {
        List<Team> teams = new ArrayList<>();
        Random random =  getRandom();
        if (random.nextBoolean()) {
            game.setToss(game.getTeam1());
            game.setCurrentTeam(game.getTeam1());
            teams.add(game.getTeam1());
            game.getTeam1().setStatus(Configs.TEAM_PLAYING);
            teams.add(game.getTeam2());
        } else {
            game.setToss(game.getTeam2());
            game.setCurrentTeam(game.getTeam2());
            game.getTeam2().setStatus(Configs.TEAM_PLAYING);
            teams.add(game.getTeam2());
            teams.add(game.getTeam1());
        }
        return teams;
    }
}
