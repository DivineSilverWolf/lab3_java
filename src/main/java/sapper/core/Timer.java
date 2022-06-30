package sapper.core;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.text.Font;
import javafx.util.Duration;
import sapper.contexts.ContextGame;

import java.util.concurrent.atomic.AtomicInteger;

public class Timer {
    private static int ENDLESS = -1;
    private static String TIMER = "0:0:0";
    private static String COLON_TIMER = ":";
    private static int START = 0;
    private static double FONT = 20;
    private static double OPTIMAL_OFFSET = 1.5;
    private static double MILLISECONDS = 1000;
    private static int HOUR = 2;
    private static int MINUTES = 1;
    private static int SECONDS = 0;
    private static int TIME_SIZE = 60;

    public static Timeline loadTimer(ContextGame contextGame) {
        contextGame.getText().setText(TIMER);
        contextGame.getText().setX(START);
        contextGame.getText().setY(contextGame.getTIME_PAUSE_SIZE() / OPTIMAL_OFFSET);
        contextGame.getText().setFont(Font.font(FONT));
        contextGame.getRoot().getChildren().add(contextGame.getText());

        for (int i = START; i < contextGame.getTime().length; i++) {
            contextGame.getTime()[i] = new AtomicInteger(START);
        }

        Timeline timeline = new Timeline(
                new KeyFrame(
                        Duration.millis(MILLISECONDS), //1000 мс * 60 сек = 1 мин
                        ae -> {
                            contextGame.getTime()[SECONDS].getAndIncrement();
                            if (contextGame.getTime()[SECONDS].get() == TIME_SIZE) {
                                contextGame.getTime()[SECONDS].set(START);
                                contextGame.getTime()[MINUTES].getAndIncrement();
                            }
                            if (contextGame.getTime()[MINUTES].get() == TIME_SIZE) {
                                contextGame.getTime()[MINUTES].set(START);
                                contextGame.getTime()[HOUR].getAndIncrement();
                            }
                            contextGame.getText().setText(contextGame.getTime()[HOUR].get() + COLON_TIMER + contextGame.getTime()[MINUTES].get() + COLON_TIMER + contextGame.getTime()[SECONDS].get());
                        }
                )
        );
        timeline.setCycleCount(ENDLESS); //Ограничим число повторений
        return timeline;
    }
}
