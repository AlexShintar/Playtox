package ru.shintar;

public class Counter {
    private int number;

    public Counter(int number) {
        this.number = number;
    }
    public void increase() {
        number++;
    }
    public int getNumber() {
        return number;
    }
}
