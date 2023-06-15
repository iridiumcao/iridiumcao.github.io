public abstract class Bird implements Animal {
    private boolean fly;
    private boolean swim;
    public boolean isFly() {
        return fly;
    }
    public void setFly(boolean fly) {
        this.fly = fly;
    }
    public boolean isSwim() {
        return swim;
    }
    public void setSwim(boolean swim) {
        this.swim = swim;
    }
}
