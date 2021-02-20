package com.kardnji.pruebaFX;

import java.util.ArrayList;
import java.util.List;

import com.kardnji.constantes.Constantes;
import com.kardnji.entity.Kard;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

	public static Scene scene;
	public static List<Kard> kards;
	
    @Override
    public void start(Stage stage) {
    	List<Kard> kartas = new ArrayList<Kard>();
    	kartas.add(new Kard(1,Constantes.img_prueba2,"hola","buenas"));
    	kartas.add(new Kard(2,Constantes.img_prueba1,"hola","buenas"));
    	kartas.add(new Kard(3,Constantes.img_prueba2,"hola","buenas"));
    	
    	BorderPane border = Methods.buildBorder();
    	HBox root = Methods.addHBox();
    	Methods.buildButtons(root,kards,Constantes.btn_back,Constantes.btn_next);
    	ImageView image = Constantes.act_img_url;
    	
    	border.setCenter(image);
    	border.setTop(root);
    	scene = new Scene(border,Constantes.res_height,Constantes.res_width);
    	stage.setTitle(Constantes.title);
    	stage.setScene(scene);
    	stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
    
}