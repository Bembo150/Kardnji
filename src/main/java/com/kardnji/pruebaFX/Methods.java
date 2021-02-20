package com.kardnji.pruebaFX;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import com.kardnji.constantes.Constantes;
import com.kardnji.entity.Kard;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class Methods {
	
	public static void setUp() {
		System.out.println("Realizando setUp...");
		App.kards = new ArrayList<Kard>();
		App.topRoot = new HBox();
		App.panel = new BorderPane();
		
    	App.kards.add(new Kard(1,Constantes.img_prueba1,"hola","buenas"));
    	App.kards.add(new Kard(2,Constantes.img_prueba2,"hola","buenas"));
    	App.kards.add(new Kard(3,Constantes.img_prueba3,"hola","buenas"));
    	App.mainImage = Methods.setUpImg(Constantes.img_prueba1);
    	
    	App.topRoot.setPadding(new Insets(15,12,15,12));
    	App.topRoot.setSpacing(10);
    	App.topRoot.setStyle("-fx-background-color: #336699");
	}
	
	public static <T> void addToHBox(List<Button> lista,HBox root) {
		System.out.println("Añadir " + lista.size() + " botones a el root");
		lista.forEach(e->App.topRoot.getChildren().add((Node) e));
		System.out.println("Añadidos");
	}
	
	public static List<Button> buildButtons(List<Kard> kards,String... str) {
		List<Button> buttons = new ArrayList<Button>();
		for (String buttonName : str) {
			Button button = new Button(buttonName);
			button.setPrefSize(Constantes.btn_width, Constantes.btn_height);
			button.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					if (Constantes.next_kard < kards.size()) {
						System.out.println("Cambio imagen... img actual: " + Constantes.next_kard);
						changeMainImage(kards.get(Constantes.next_kard));
						Constantes.next_kard++;
					} else Constantes.next_kard = 0;
				}
			});
			buttons.add(button);
		}
		System.out.println("Botones creados... : " + buttons.size());
		return buttons;
	}
	
    public static void changeMainImage(Kard kard) {
		FileInputStream istr;
		try {
			istr = new FileInputStream(kard.getImageUrl());
	    	Image image = new Image(istr);
			App.mainImage.setImage(image);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    }
	
	public static ImageView setUpImg(String img) {
    	FileInputStream istr;
		try {
			istr = new FileInputStream(img);
	    	Image image = new Image(istr);
	    	ImageView iview = new ImageView();
	    	iview.setImage(image);
	    	iview.setX(10);
	    	iview.setY(10);
	    	iview.setFitHeight(400);
	    	iview.setFitWidth(300);
	    	//iview.setFitHeight(Constantes.res_height);
	    	iview.setPreserveRatio(true);
	    	return iview;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
    }
}
