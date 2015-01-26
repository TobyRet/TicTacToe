package com.codurance.Game;

import com.codurance.Console.Console;
import com.codurance.Players.BoardMarker;
import com.codurance.Players.HumanPlayer;
import com.codurance.Players.Player;

import java.util.ArrayList;
import java.util.List;

public class Players {

    public static List<Player> create() {
        List<Player> players = new ArrayList();
        players.add(new HumanPlayer(BoardMarker.CROSS, new Console()));
        players.add(new HumanPlayer(BoardMarker.CROSS, new Console()));
        return players;
    }
}
