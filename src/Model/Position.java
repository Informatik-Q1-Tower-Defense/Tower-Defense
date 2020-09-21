package Model;

public class Position {

    public int x;
    public int y;

    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    public boolean equals(Object obj) {

        Position position = (Position) obj;

        if(position.x == this.x && position.y == this.y) {

            return true;
        }
        else {

            return false;
        }
    }

    public static Position[] sortWay(Position start, Position[] way) {

        if (start == null || way.length == 0) {

            throw new IllegalArgumentException("emty parrameters");
        }

        Position[] result = new Position[way.length + 1];

        result[0] = start;

        boolean condition = true;

        for (int i = 0; i < (result.length - 1); i++) {

            for (Position position: way) {

                if (position == null) {

                    throw new IllegalArgumentException("emty parrameters");
                }

                else if ((position.x == result[i].x && position.y == result[i].y + 1) || (position.x == result[i].x && position.y == result[i].y - 1) || (position.y == result[i].y && position.x == result[i].x + 1) || (position.y == result[i].y && position.x == result[i].x - 1)) {

                    for(Position element: result) {

                        if (element != null) {

                            if (element.x == position.x && element.y == position.y) {

                                condition = false;
                                break;
                            }
                        }
                    }

                    if (condition) {

                        result[i + 1] = position;
                    }
                    condition = true;
                }
            }
        }

        return result;
    }
}
