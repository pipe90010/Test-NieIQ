package com.arias.nielseniq.test.home_test.problem2;

public class Particle {

    private Direction direction;
    private int startPosition;
    private int speed;

    private int currentPosition;

    public Particle(char dir, int startPos, int spd) throws ParticleException{
        try {
            checkDirection(dir);
            this.startPosition = startPos;
            this.speed = spd;
        } catch (DirectionException ex) {
            System.err.println("Exception occured: " + ex);
            throw new ParticleException("Unable to instantiate particle! - Direction error: " + dir + " is not a valid Direction!");
        }
    }

    void checkDirection( char dir) throws DirectionException{
        if(dir == 'R')
            this.direction = Direction.Right;
        else if(dir == 'L')
            this.direction = Direction.Left;
        else
            throw new DirectionException("An error in direction has occurred.");
    }

    public Direction getDirection() {
        return direction;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public int getStartPosition() {
        return startPosition;
    }

    public int getSpeed() {
        return speed;
    }

    enum Direction{
        Right,
        Left
    }
}
