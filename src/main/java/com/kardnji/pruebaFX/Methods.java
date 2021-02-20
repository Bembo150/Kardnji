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
	
	/**
	 * Metodo que carga las variables globales de la clase App.java
	 * @author fran-lopez
	 */
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
	
	/**
	 * Metodo que recibe una lista con nodos a colocar en el HBox y los coloca dentro de este.
	 * @param <T> Marca que es un metodo generico
	 * @param lista Lista de nodos a recibir y que va a añadir al HBox.
	 * @param root HBox recibido donde se añadiran los nodos.
	 * @author fran-lopez
	 */
	public static <T> void addToHBox(List<T> lista,HBox root) {
		System.out.println("Añadir " + lista.size() + " botones a el root");
		lista.forEach(e->App.topRoot.getChildren().add((Node) e));
		System.out.println("Añadidos");
	}
	
	/**
	 * Metodo que recibe una serie de parametros para crear de forma dinamica botones con evento.
	 * Los eventos por ahora solo cambian la imagen a la siguiente en la lista
	 * @param kards Lista de obj Kard 
	 * @param str Nombre que se les dara a los botones
	 * @return devuelve una lista con los botones creados
	 * @author fran-lopez
	 */
	public static List<Button> buildButtons(List<Kard> kards,String... str) {
		List<Button> buttons = new ArrayList<Button>();
		for (String buttonName : str) {
			Button button = new Button(buttonName);
			button.setPrefSize(Constantes.btn_width, Constantes.btn_height);
			if (buttonName.equalsIgnoreCase(Constantes.btn_next)) {
				button.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						if (Constantes.next_kard <= kards.size() && Constantes.next_kard >= 0) {
							if (Constantes.next_kard == kards.size()) {
								Constantes.next_kard = 0;
							}
							changeMainImage(kards.get(Constantes.next_kard));
							Constantes.next_kard++;
						}
					}
				});
			} else {
				button.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						System.out.println("karta_antes_if: " + Constantes.next_kard);
						if (Constantes.next_kard <= kards.size() && Constantes.next_kard >= 0) {
							if (Constantes.next_kard == 0) {
								changeMainImage(kards.get(Constantes.next_kard));
								Constantes.next_kard = kards.size()-1;
							} else if (Constantes.next_kard == kards.size()) {
								Constantes.next_kard = kards.size()-2;
								changeMainImage(kards.get(Constantes.next_kard));
							} else {
								changeMainImage(kards.get(Constantes.next_kard));
								Constantes.next_kard--;
							}
						}
					}
				});
			}
			buttons.add(button);
		}
		System.out.println("Botones creados... : " + buttons.size());
		return buttons;
	}
	
	
	/**
	 * Recibe un parametro con el que cambiar la imagen del panel principal del programa.
	 * @param kard Parametro de tipo Kard de donde el metodo saca la imgURL()
	 * @author fran-lopez
	 */
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
	
    /**
     * Metodo generico que le pasas la URL de una imagen y te la convierte a ImageView
     * de forma automatica
     * @param img URL de la imagen que se quiere convertir
     * @return devuelve el ImageView de la imagen.
     * @author fran-lopez
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
	    	iview.setFitHeight(215);
	    	iview.setFitWidth(120);
	    	//iview.setFitHeight(Constantes.res_height);
	    	iview.setPreserveRatio(true);
	    	return iview;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
    }
}
