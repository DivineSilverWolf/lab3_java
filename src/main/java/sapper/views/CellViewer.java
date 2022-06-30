package sapper.views;

import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.File;
import java.net.MalformedURLException;

public class CellViewer {
    private static double ORDER = 25;

    public static ImageView cellViewer(AnchorPane root, File png, Color color, final double x, final double y, final double sizeX, final double sizeY) {
        ImageView view = new ImageView();
        if (png != null) {
            try {
                String localUrl = png.toURI().toURL().toString();
                ImageView image = new ImageView(localUrl);
                image.setX(x);
                image.setY(y);
                image.setFitWidth(sizeX);
                image.setFitHeight(sizeY);
                root.getChildren().add(image);
                view = image;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        if (color != null) {
            Rectangle rectangle = new Rectangle();
            rectangle.setX(x);
            rectangle.setY(y);
            rectangle.setWidth(sizeX);
            rectangle.setHeight(sizeY);
            rectangle.setFill(color);
            rectangle.setViewOrder(ORDER);
            root.getChildren().add(rectangle);
        }
        return view;
    }
}
