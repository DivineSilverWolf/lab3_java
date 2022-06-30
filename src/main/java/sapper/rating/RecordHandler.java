package sapper.rating;

import sapper.contexts.ContextGame;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class RecordHandler {
    private final static String FILE_NAME = "..\\lab3Java\\Ratings\\";
    private final static String CUSTOM = "Кастомный";
    private final static boolean WIN = true;
    private final static boolean NOT_FOUND = false;
    private final static int START = 0;
    private final static int HOURS = 2;
    private final static int MINUTES = 1;
    private final static int SECONDS = 0;
    private final static int BIAS = 1;
    private final static String COLON_TIMER = ":";
    private final static char COLON_TIMER_ = ':';
    private final static char GO_NAME = ' ';

    public static void goRecord(ContextGame contextGame) {
        String levelID = contextGame.getLevelID();
        String name = contextGame.getNameUser().trim();
        if (levelID.equals(CUSTOM) || name.equals("") || contextGame.getLoser().get()) {
            contextGame.getMenu().setStyle("-fx-background-color: #ff0000; -fx-border-color: #000000;");
            contextGame.getRestart().setStyle("-fx-background-color: #ff0000; -fx-border-color: #000000;");
            return;
        }
        if (!contextGame.getWinner().get())
            contextGame.getWinner().set(WIN);
        else
            return;
        AtomicInteger[] time = contextGame.getTime();

        AtomicInteger flag = new AtomicInteger(START);
        AtomicBoolean found = new AtomicBoolean(NOT_FOUND);


        String[] recordText = read(found, flag, levelID, time, name).toString().trim().split("\n");
        write(contextGame, recordText, found, flag, levelID, time, name);

    }

    private static StringBuilder read(AtomicBoolean found, AtomicInteger flag, String levelID, AtomicInteger[] time, String name) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME + levelID))) {
            StringBuilder recordText = new StringBuilder("");
            int count = START;
            String string = reader.readLine();
            boolean thisIsMyName;
            while (string != null) {
                thisIsMyName = string.substring(string.indexOf(GO_NAME) + BIAS).equals(name);
                if (!found.get() && !string.equals("")) {
                    String time_s = string.substring(START, string.indexOf(GO_NAME) + BIAS);
                    String hours = time_s.substring(START, time_s.indexOf(COLON_TIMER_));
                    time_s = time_s.substring(time_s.indexOf(COLON_TIMER_) + BIAS);
                    String minutes = time_s.substring(START, time_s.indexOf(COLON_TIMER_));
                    time_s = time_s.substring(time_s.indexOf(COLON_TIMER_) + BIAS);
                    String seconds = time_s.substring(START, time_s.indexOf(GO_NAME));
                    if (Integer.parseInt(hours) > time[HOURS].get()) {
                        flag.set(count);
                        found.set(true);
                    } else if (Integer.parseInt(hours) == time[HOURS].get() && Integer.parseInt(minutes) > time[MINUTES].get()) {
                        flag.set(count);
                        found.set(true);
                    } else if (Integer.parseInt(hours) == time[HOURS].get() && Integer.parseInt(minutes) == time[MINUTES].get() && Integer.parseInt(seconds) > time[SECONDS].get()) {
                        flag.set(count);
                        found.set(true);
                    } else if (thisIsMyName) {
                        time[HOURS].set(Integer.parseInt(hours));
                        time[MINUTES].set(Integer.parseInt(minutes));
                        time[SECONDS].set(Integer.parseInt(seconds));
                        flag.set(count);
                        found.set(true);
                    }
                }
                if (!thisIsMyName) {
                    recordText.append(string).append("\n");
                }
                string = reader.readLine();
                count++;
            }
            return recordText;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new StringBuilder("");
    }

    private static void write(ContextGame contextGame, String[] recordText, AtomicBoolean found, AtomicInteger flag, String levelID, AtomicInteger[] time, String name) {
        contextGame.getMenu().setStyle("-fx-background-color: #423189; -fx-border-color: #000000;");
        contextGame.getRestart().setStyle("-fx-background-color: #423189; -fx-border-color: #000000;");

        try (java.io.OutputStreamWriter push = new java.io.OutputStreamWriter(new FileOutputStream(FILE_NAME + levelID))) {
            for (int i = START; i < recordText.length; i++) {
                if (i == flag.get() && found.get()) {
                    push.write(time[HOURS] + COLON_TIMER + time[MINUTES] + COLON_TIMER + time[SECONDS] + " " + name + "\n");
                }
                push.write(recordText[i] + "\n");
            }
            if (!found.get()) {
                push.write(time[HOURS] + COLON_TIMER + time[MINUTES] + COLON_TIMER + time[SECONDS] + " " + name + "\n");
            }
        } catch (IOException e) {
            contextGame.getMenu().setStyle("-fx-background-color: #ff0000; -fx-border-color: #000000;");
            contextGame.getRestart().setStyle("-fx-background-color: #ff0000; -fx-border-color: #000000;");
            e.printStackTrace();
        }

    }
}
