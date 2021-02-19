package com.kardnji.pruebaFX;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import com.kardnji.constantes.Constantes;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

	public static VBox root;
	public static Scene scene;
	
    @Override
    public void start(Stage stage) {
    	setUp(stage);
    	ImageView iview = setUpImg(Constantes.img_prueba);
    	Button button1 = new Button("Atras");
    	Button button2 = new Button("Siguiente");
    	root.getChildren().add(iview);
    	root.getChildren().add(button1);
    	root.getChildren().add(button2);
    	stage.setScene(scene);
    	stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
    
    public static void setUp(Stage stage) {
    	stage.setTitle(Constantes.title);
    	root = new VBox(5.0);
    	root.setPadding(new Insets(10.0));
    	root.setAlignment(Pos.CENTER);
    	scene = new Scene(root,Constantes.res_height,Constantes.res_width);
    }
    
    /**
     * 
     * @param img
     * @return
     */
    public static ImageView setUpImg(String img) {
    	FileInputStream istr;
		try {
			istr = new FileInputStream(img);
	    	Image image = new Image(istr);
	    	ImageView iview = new ImageView();
	    	iview.setImage(image);
	    	iview.setX(10);
	    	iview.setY(10);
	    	//iview.setFitHeight(Constantes.res_height);
	    	iview.setPreserveRatio(true);
	    	return iview;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
    }
}