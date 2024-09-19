package model;

public class  Player extends  Member{
    private int number;
    private String role;
    private int goals;

    public Player(int number, String role, int goals) {
        this.number = number;
        this.role = role;
        this.goals = goals;
    }
}
