package Model;

public class Effect {

    enum Type {

        FREEZED,
        NORMALTOWERRANGE,
        NONE
    }

    public Type type;
    public Tower tower;

    public Effect(Type type, Tower tower) {

        this.type = type;
        this.tower = tower;
    }
}
