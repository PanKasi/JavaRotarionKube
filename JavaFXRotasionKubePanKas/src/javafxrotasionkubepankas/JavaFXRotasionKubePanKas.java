package javafxrotasionkubepankas;

import javafx.application.Application;
import javafx.geometry.Point3D;
import javafx.scene.AmbientLight;
import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.Sphere;
import javafx.stage.Stage;

public class JavaFXRotasionKubePanKas extends Application {
    
    final static int WINDOW_WIDTH = 1024;
    final static int WINDOW_HEIGHT = 720;
    
    @Override
    public void start(Stage primaryStage) {

       PhongMaterial m = new PhongMaterial();
       m.setDiffuseColor(Color.BLUE);
       Box b = new Box(1400, 300, 1400);
       b.setTranslateY(300);
       b.setRotationAxis(new Point3D(0, 1, 0));
       b.setRotate(45);
       Sphere s = new Sphere(5);
       s.setTranslateX(0);
        s.setTranslateY(-150);
        s.setTranslateZ(-700);
       Box r = new Box();
        r.setDepth(100);
        r.setHeight(100);
        r.setWidth(100);
        r.setTranslateX(50);
        r.setTranslateY(60);
        r.setTranslateZ(-700);
        r.setMaterial(m);
        AmbientLight al = new AmbientLight();
        al.setColor(Color.rgb(150,5,100,.1));
        Group g = new Group(b, r, al);
        g.setTranslateX(WINDOW_WIDTH / 2);
        g.setTranslateY(WINDOW_HEIGHT / 2);
        Scene scn = new Scene(g, WINDOW_WIDTH, WINDOW_HEIGHT);
        Camera cam = new PerspectiveCamera();
        scn.setCamera(cam);
        scn.setFill(Color.DARKGRAY);
           primaryStage.addEventHandler(KeyEvent.KEY_PRESSED, event->{
            switch(event.getCode()){
                case A:
                    r.setRotate(r.getRotate()-5);
                    r.translateXProperty().set(r.getTranslateX()-5);  
                    break;
                case D:
                    r.setRotate(r.getRotate()+5);
                    r.translateXProperty().set(r.getTranslateX()+5);
                    break;                    
            }});


        primaryStage.setScene(scn);
        primaryStage.show();
    }
    
}
