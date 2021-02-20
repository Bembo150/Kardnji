package com.kardnji.frontFX;

import java.util.List;

import com.kardnji.constantes.Constantes;
import com.kardnji.entity.Kard;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

	/**
	 * Declaro variables globales
	 * @author fran-lopez
	 */
	public static List<Kard> kards;
	public static BorderPane panel;
	public static HBox topRoot;
	public static VBox leftRoot;
	public static VBox rightRoot;
	public static HBox centerRoot;
	public static ImageView mainImage;
	
    @Override
    public void start(Stage stage) {
    	Methods.setUp();
    	Methods.addToHBox(Methods.buildButtons(kards,Constantes.btn_back,Constantes.btn_next), topRoot);
    	Methods.addToVBox(Methods.buildLabels(kards, "Nombre: ","Descripcion: "),leftRoot);
    	
    	panel.setTop(topRoot);
    	panel.setCenter(centerRoot);
    	panel.setLeft(leftRoot);
    	
    	stage.setScene(new Scene(panel,Constantes.res_height,Constantes.res_width));
    	stage.setTitle(Constantes.title);
    	stage.show();
    }

    /**
     * Metodo main donde se ejecutara el codigo del programa.
     * @param args recibe parametros iniciales para la configuracion.
     * @author fran-lopez
     */
    public static void main(String[] args) {
        launch();
    }
}