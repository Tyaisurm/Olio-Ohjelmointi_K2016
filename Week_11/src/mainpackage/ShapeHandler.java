/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpackage;

import java.util.ArrayList;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

/**
 *
 * @author m7942
 */
public class ShapeHandler {

    private static ShapeHandler instance = null;

    private ArrayList<Point> points = new ArrayList();
    private ArrayList<LineC> lines = new ArrayList();

    private Circle circleS = null;
    private Circle circleE = null;

    private ShapeHandler() {
        //
    }

    public static ShapeHandler getInstance() {
        if (instance == null) {
            instance = new ShapeHandler();
        }
        return instance;
    }

    public void addPoint(Point point) {
        points.add(point);
    }

    public void addLine(LineC line) {
        lines.add(line);
    }

    /*public void pointClicked(Circle c) {
     if (circleS == null) {
     circleS = c;
     }
     else if(circleE==null){
     circleE = c;
     } else{
     circleS = null;
     circleE = null;
     }
     }*/
    public void pointClicked(Circle c) {
        if (circleE != null) {
            circleS = circleE;
            circleE = c;
        } else {
            circleE = c;
        }
        if (circleS == null) {
            circleS = c;
        }
    }

    public ArrayList getPointList() {
        return points;
    }

    public ArrayList getLineList() {
        return lines;
    }

    public Circle getCircleS() {
        return circleS;
    }

    public Circle getCircleE() {
        return circleE;
    }

    public void reset() {
        circleS = null;
        circleE = null;
    }
}
