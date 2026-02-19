package com.codenjoy.dojo.snake.client;


import com.codenjoy.dojo.services.Direction;
import com.codenjoy.dojo.services.Point;
import com.codenjoy.dojo.services.PointImpl;

import java.util.*;

public class Snake {
    public Direction nextMove(Board board) {

        if (board.isGameOver()) {
            return Direction.UP;
        }

        Point head = board.getHead();
        List<Point> apples = board.getApples();

        if (apples.isEmpty()) {
            return safeDirection(board);
        }

        Point target = apples.get(0);

        List<Point> path = findShortRoad(board, head, target);

        if (path.size() < 2) {
            return safeDirection(board);
        }

        Point next = path.get(1);

        return directionBetween(head, next);
    }


    private List<Point> findShortRoad(Board board, Point head, Point apple) {

        Queue<Point> queue = new LinkedList<>();
        Map<Point, Point> parent = new HashMap<>();
        Set<Point> visited = new HashSet<>();

        Set<Point> blocked = new HashSet<>(board.getBarriers());
        blocked.remove(head);

        queue.add(head);
        visited.add(head);

        while (!queue.isEmpty()) {

            Point current = queue.poll();

            if (current.equals(apple)) {
                return buildPath(parent, head, apple);
            }

            for (Point neighbor : neighbors(board, current)) {

                if (visited.contains(neighbor)) continue;
                if (blocked.contains(neighbor)) continue;

                visited.add(neighbor);
                parent.put(neighbor, current);
                queue.add(neighbor);
            }
        }

        return Collections.emptyList();
    }



    private List<Point> buildPath(Map<Point, Point> parent, Point start, Point goal) {

        List<Point> path = new ArrayList<>();
        Point step = goal;

        while (step != null) {
            path.add(step);
            step = parent.get(step);
        }

        Collections.reverse(path);
        return path;
    }



    private List<Point> neighbors(Board board, Point p) {

        List<Point> result = new ArrayList<>();
        int size = board.size();

        int x = p.getX();
        int y = p.getY();

        check(result, x + 1, y, size);
        check(result, x - 1, y, size);
        check(result, x, y + 1, size);
        check(result, x, y - 1, size);

        return result;
    }

    private void check(List<Point> list, int x, int y, int size) {

        if (x < 0 || y < 0 || x >= size || y >= size) return;

        list.add(new PointImpl(x, y));
    }



    private Direction directionBetween(Point from, Point to) {

        if (to.getX() > from.getX()) return Direction.RIGHT;
        if (to.getX() < from.getX()) return Direction.LEFT;
        if (to.getY() > from.getY()) return Direction.UP;
        return Direction.DOWN;
    }



    private Direction safeDirection(Board board) {

        Point head = board.getHead();
        Set<Point> blocked = new HashSet<>(board.getBarriers());

        for (Point neighbor : neighbors(board, head)) {
            if (!blocked.contains(neighbor)) {
                return directionBetween(head, neighbor);
            }
        }

        return board.getSnakeDirection();
    }
}
