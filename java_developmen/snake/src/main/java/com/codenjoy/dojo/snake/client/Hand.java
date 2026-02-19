package com.codenjoy.dojo.snake.client;

import com.codenjoy.dojo.services.Direction;
import com.codenjoy.dojo.services.Point;

import java.util.List;
import java.util.Scanner;

public class Hand {
    public Direction nextMove(Board board) {
        Scanner scanner=new Scanner(System.in);
        while (true){
            String a=scanner.next();
            if(a=="w"){
                return Direction.UP;
            }
            if(a=="s"){
                return Direction.DOWN;
            }
            if(a=="a") {
                return Direction.LEFT;
            }else return Direction.RIGHT;
        }

    }
}
