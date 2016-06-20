/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpackage;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

/**
 *
 * @author m7942
 */
public class LineC {

    private Color color = Color.RED;
    private Line lineL;

    protected Line createNewLine(Circle pointS, Circle pointE) {
        Line line = null;
        if (pointE != null) {
            line = new Line();
            line.setStartX(pointS.getCenterX());
            line.setStartY(pointS.getCenterY());
            line.setEndX(pointE.getCenterX());
            line.setEndY(pointE.getCenterY());
            line.setFill(color);
        }
        lineL = line;
        return line;
    }

    public Line getLine() {
        return lineL;
    }
}
