package ru.netology.game;

import ru.netology.domain.Player;
import ru.netology.exception.NotRegisteredException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {
    protected Map<String, Player> players = new HashMap<>();

    public void register(Player player) {
        players.put(player.getName(), player);
    }

   /* public int findByName(String name) {
        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
            if (player.getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }*/

    public int round(String name1, String name2) {
        Player player1 = players.get(name1);
        Player player2 = players.get(name2);
        if (player1 == null) {
            throw new NotRegisteredException("Игрок" + name1 + "не зарегестрирован");
        }
        if (player2 == null) {
            throw new NotRegisteredException("Игрок" + name2 + "не зарегестрирован");
        }
        int strength1 = player1.getStrength();
        int strength2 = player2.getStrength();

        if (strength1 > strength2) {
            return 1;
        }
        if (strength1 == strength2) {
            return 0;
        }
        return 2;
    }
}