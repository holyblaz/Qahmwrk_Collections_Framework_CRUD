package ru.netology.game;

import ru.netology.domain.Player;
import ru.netology.exception.NotRegisteredException;

import java.util.ArrayList;
import java.util.List;

public class Game {
    protected List<Player> players = new ArrayList<>();

    public void register(Player player) {
        players.add(player);
    }

    public int findByName(String name) {
        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
            if (player.getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public int round(String name1, String name2) {
        int player1Num = findByName(name1);
        int player2Num = findByName(name2);

        if (player1Num == -1) {
            throw new NotRegisteredException("Игрок" + name1 + "не зарегестрирован");
        }
        if (player2Num == -1) {
            throw new NotRegisteredException("Игрок" + name2 + "не зарегестрирован");
        }
        int strength1 = players.get(player1Num).getStrength();
        int strength2 = players.get(player2Num).getStrength();

        if (strength1 > strength2) {
            return 1;
        }
        if (strength1 == strength2) {
            return 0;
        }
        return 2;
    }
}
