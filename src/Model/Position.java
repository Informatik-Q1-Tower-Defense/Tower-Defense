package Model;

public class Position {

    public int x;
    public int y;

    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    public static Position[] sortWay(Position start, Position[] way) {

        if (start == null || way.length == 0) {

            throw new IllegalArgumentException("emty parrameters");
        }

        Position[] result = new Position[way.length + 1];

        result[0] = start;

        for (int i = 0; i < result.length; i++) {

            for (Position position: way) {

                if (position == null) {

                    throw new IllegalArgumentException("emty parrameters");
                }

                else if ((position.x == result[i].x & position.y == result[i].y + 1) | (position.x == result[i].x & position.y == result[i].y - 1) | (position.y == result[i].y & position.x == result[i].x + 1) | (position.y == result[i].y & position.x == result[i].x - 1)) {

                    result[i + 1] = position;
                }
            }
        }

        return result;
    }
}
