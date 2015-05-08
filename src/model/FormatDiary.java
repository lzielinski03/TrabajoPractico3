package model;

/**
 * Created by leonardo on 07/05/2015.
 */
public abstract class FormatDiary {

    public String setLineFormat(int id, String line) {
        return "#" + id + " | " + line;
    }
}