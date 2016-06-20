/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpackage;

import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 *
 * @author m7942
 */
public class Point {

    private Color color = Color.RED;
    private Double radius = 10.0;
    ShapeHandler sh = ShapeHandler.getInstance();
    private Circle circleC;

    protected Circle createNewCircle(String name, Double X, Double Y) {
        final Circle circle = new Circle();
        circle.setRadius(radius);
        circle.setCenterX(X);
        circle.setCenterY(Y);
        circle.setId(name);
        circle.setFill(color);
        circle.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                circle.setFill(Color.CYAN);
            }
        });
        circle.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                circle.setFill(Color.RED);
            }
        });
        circle.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                if (e.getButton() == MouseButton.SECONDARY) {
                    System.out.println("Hei, nimeni on " + circle.getId() + "!");
                } else if (e.getButton() == MouseButton.PRIMARY) {
                    sh.pointClicked(circle);
                }
            }
        });
        circleC = circle;

        return circle;
    }

    protected Circle getCircle() {
        return circleC;
    }
}
