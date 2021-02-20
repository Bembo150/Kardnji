package com.kardnji.frontFX;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import com.kardnji.constantes.Constantes;
import com.kardnji.entity.Kard;
import com.kardnji.enums.Lesson;
import com.kardnji.jsonRepo.KardRepositoryImpl;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Methods {
	
	/**
	 * Metodo que carga las variables globales de la clase App.java y las inicializa.
	 * Añade una Lista inicial de lecciones.
	 * Inicializar las distintas partes de las que esta compuesto el programa.
	 * 		- topRoot: los botones de arriba para pasar entre kandnji hacia detra y adelante.
	 * 		- centerRoot: donde esta la imagen del kanji/componente.
	 * 		- leftRoot: donde estan los datos KeyWord y el shotStory de la kard.
	 * 		- rightRoot: VBox donde se encuentra el ChoiceBox con el seleccionador de Lecciones.
	 * @author fran-lopez
	 */
	public static void setUp() {
		App.kards = new ArrayList<Kard>();
		KardRepositoryImpl krepo = new KardRepositoryImpl();
		App.kards.addAll(krepo.read(Lesson.LESSON1));
		
		App.topRoot = initializeHBox(Pos.CENTER);
		App.centerRoot = initializeVBox(Pos.CENTER);
		App.leftRoot = initializeVBox(Pos.CENTER);
		App.rightRoot = initializeVBox(Pos.CENTER);
		
		App.panel = new BorderPane();
		App.topRoot.setStyle("-fx-background-color: #346699;");
		// Linea 1: Añado una imagen de primeras a la ImageView
		// Linea 2: Añado esa imagen al VBox central
    	App.mainImage = setUpImg(Constantes.img_not_found);
    	App.centerRoot.getChildren().add(App.mainImage);
	}
	
	/**
	 * Metodo que recibe una lista con nodos a colocar en el HBox y los coloca dentro de este.
	 * @param <T> Marca que es un metodo generico
	 * @param lista Lista de nodos a recibir y que va a añadir al HBox.
	 * @param root HBox recibido donde se añadiran los nodos.
	 * @author fran-lopez
	 */
	public static <T> void addToHBox(List<T> lista,HBox root) {
		lista.forEach(e->App.topRoot.getChildren().add((Node) e));
	}
	
	/**
	 * Metodo que recibe una lista con nods a colocar en el VBox y los coloca dentro de este.
	 * @param <T> Marca que es un metodo generico
	 * @param lista nodos que va a recibir y que va a añadir al VBox.
	 * @param root VBox recibido donde se va a añadir los nodos
	 * @author fran-lopez
	 */
	public static <T> void addToVBox(List<T> lista,VBox root) {
		lista.forEach(e->App.leftRoot.getChildren().add((Node) e));
	}
	
	/**
	 * Inicializa de manera generica los VBox que lo necesiten
	 * @param posicion Posicion con la que colocar el elemento en pantalla
	 * @return devuelve el VBox inicializado.
	 */
	public static VBox initializeVBox(Pos posicion) {
		VBox node = new VBox();
		node.setAlignment(posicion);
		node.setPadding(new Insets(15,12,15,12));
    	node.setSpacing(10);
    	node.setStyle("-fx-background-color: #FFFFFF");
    	return node;
	}
	
	/**
	 * Inicializa de manera generica los HBox que lo necesiten
	 * @param posicion Posicion con la que colocar el elemento en pantalla
	 * @return devuelve el HBox inicializado.
	 */
	public static HBox initializeHBox(Pos posicion) {
		HBox node = new HBox();
		node.setAlignment(posicion);
		node.setPadding(new Insets(15,12,15,12));
    	node.setSpacing(10);
    	node.setStyle("-fx-background-color: #FFFFFF");
    	return node;
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
						nextKard(kards);
						addToVBox(buildLabels(kards),App.leftRoot);
					}
				});
			} else {
				button.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						lastKard(kards);
						addToVBox(buildLabels(kards),App.leftRoot);
					}
				});
			}
			buttons.add(button);
		}
		return buttons;
	}
	
	/**
	 * Crea labels de manera dinamica a partir de los parametros pasados
	 * @param kards lista con las kartas de donde sacar la informacion
	 * @param str parametro donde recibe los String de texto que tendra cada label
	 * @return devuelve la lista con los labels creados
	 * @author fran-lopez
	 */
	public static List<Label> buildLabels(List<Kard> kards) {
		List<Label> labels = new ArrayList<Label>();
		App.keyWord = new Label("Nombre: \n" + kards.get(Constantes.next_kard).getKeyWord());
		App.ShortHistory = new Label("Descripcion: \n" + kards.get(Constantes.next_kard).getShortStory());
		App.keyWord.setFont(Font.font("Symbol", FontWeight.BOLD, 15));
		App.ShortHistory.setFont(Font.font("Symbol", FontWeight.BOLD, 15));
		return labels;
	}

	public static List<ChoiceBox> buildChoiceBox(List<Kard> kards,String... str) {
		List<ChoiceBox> choice = new ArrayList();
		ChoiceBox cb = new ChoiceBox(FXCollections.observableArrayList(str));
		return choice;
	}
	
	/**
	 * Actualiza la Kard que se esta viendo en pantalla en este momento a la siguiente en la lista de kards pasadas por parametro
	 * @param kards lista con las kard de la leccion seleccionada
	 * @author fran-lopez
	 */
	public static void nextKard(List<Kard> kards) {
		if (Constantes.next_kard <= kards.size() && Constantes.next_kard >= 0) {
			if (Constantes.next_kard == kards.size()) {
				Constantes.next_kard = 0;
			}
			changeMainImage(kards.get(Constantes.next_kard));
			Constantes.next_kard++;
		}
	}
	
	/**
	 * Actualiza la kard que se esta viendo en pantalla a la anterior a esta.
	 * @param kards lista con las kard de la leccion seleccionada.
	 * @author fran-lopez
	 */
	public static void lastKard(List<Kard> kards) {
		if (Constantes.next_kard > 0) Constantes.next_kard--;
		if (Constantes.next_kard <= kards.size() && Constantes.next_kard >= 0) {
			if (Constantes.next_kard == 0) {
				changeMainImage(kards.get(Constantes.next_kard));
				Constantes.next_kard = kards.size();
			} else if (Constantes.next_kard == kards.size()-1) {
				Constantes.next_kard = kards.size()-1;
				changeMainImage(kards.get(Constantes.next_kard));
			} else {
				changeMainImage(kards.get(Constantes.next_kard));
			}
		}
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
	    	//iview.setFitHeight(215);
	    	//iview.setFitWidth(120);
	    	iview.setFitHeight(315);
	    	iview.setFitWidth(215);
	    	//iview.setFitHeight(Constantes.res_height);
	    	iview.setPreserveRatio(true);
	    	return iview;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
    }
}
