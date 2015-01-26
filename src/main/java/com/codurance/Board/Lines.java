package com.codurance.Board;

import java.util.ArrayList;
import java.util.List;

public class Lines {
    public static List<Line> create() {
        List<Line> lines = new ArrayList<>();

        lines.add(new Line(0,1,2));
        lines.add(new Line(3,4,5));
        lines.add(new Line(6,7,8));
        lines.add(new Line(0,3,6));
        lines.add(new Line(1,4,7));
        lines.add(new Line(2,5,8));
        lines.add(new Line(0,4,8));
        lines.add(new Line(2,4,6));

        return lines;
    }
}
