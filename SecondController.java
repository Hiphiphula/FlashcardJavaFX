package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SecondController {
//	@FXML
//	private Circle circle1;
	@FXML
	private StackPane lbl1;
	
	@FXML
	private StackPane lbl2;
	
	@FXML
	private Pane pn1;
	
	@FXML
	private Button bnext;
	
	@FXML
	private Button bprev;
	
	@FXML
	private AnchorPane anch;
	
	@FXML
	private Text question1;
	
	@FXML
	private Text answer1;
	
	
//	private double x;
//	private double y;
	
	
	
	  private ArrayList<String> arr = new ArrayList<>();
	  private ArrayList<String> arr2 = new ArrayList<>();
	  private int al = 0;
	  private int count = 0;
	  
	  @FXML
	    private Button Hback;
	    
	    @FXML
	    void HomeBack() throws IOException{
	    	Stage primarystage = (Stage) Hback.getScene().getWindow();
	    	
	    	Parent root = FXMLLoader.load(getClass().getResource("mainmenu.fxml"));
	    	Scene sc2 = new Scene(root);
	    	
	    	primarystage.setTitle("Flashdeck");
	    	primarystage.setScene(sc2);
	    	primarystage.show();
	    	
	    }
//	  
	  void read_ffile(ArrayList<String> var1List,  ArrayList<String> var2List, String file_name) {
//	        String fileName = "C:\\Users\\Dante\\eclipse-workspace\\ptest\\src\\ptest\\test.txt"; // Replace with the path to your input file
	        try (BufferedReader br = new BufferedReader(new FileReader(file_name))) {
	            String line;
	            while ((line = br.readLine()) != null) {
	                String[] parts = line.split("\\s*\\|\\s*");
	                if (parts.length == 2) {
	                	arr.add(parts[0].trim());
	                	arr2.add(parts[1].trim());
	                } else {
	                    System.out.println("Invalid line format: " + line);
	                }
	            }
	        } catch (IOException e) {
	            System.out.println("Error reading file: " + e.getMessage());
	        }
	    }
	  
//	  @FXML
	    // this functino should be called when the panel is opened
	    public void initialize(){
	    	String file_name = GlobalVariable.filee();	    	
	        read_ffile(arr, arr2, file_name);
	        Random random = new Random();
	        for (int i = arr.size() - 1; i > 0; i--) {
	            int j = random.nextInt(i + 1);
	            String temp = arr.get(i);
	            String temp2 = arr2.get(i);
	            arr.set(i,arr.get(j));
	            arr.set(j,temp);
	            arr2.set(i,arr2.get(j));
	            arr2.set(j,temp2);     
	        }
	        
//	     // Set initial max width and height based on the frame dimensions
//	        lbl1.setMaxWidth(anch.getWidth() * 0.7);
//	        lbl1.setMaxHeight(anch.getHeight() * 0.3);
//
//	    lbl2.setMaxWidth(anch.getWidth() * 0.7);
//	        lbl2.setMaxHeight(anch.getHeight() * 0.3);
//
//	        // Bind max width and height to the frame's dimensions
//	        lbl1.maxWidthProperty().bind(anch.widthProperty().multiply(0.7));
//	        lbl1.maxHeightProperty().bind(anch.heightProperty().multiply(0.3));
//
//	    lbl2.maxWidthProperty().bind(anch.widthProperty().multiply(0.7));
//	        lbl2.maxHeightProperty().bind(anch.heightProperty().multiply(0.3));
//
//	        // Update max width and height when the frame dimensions change
//	        anch.widthProperty().addListener((obs, oldWidth, newWidth) ->
//	               lbl1.setMaxWidth(newWidth.doubleValue() * 0.7));
//	        anch.heightProperty().addListener((obs, oldHeight, newHeight) ->
//	                lbl1.setMaxHeight(newHeight.doubleValue() * 0.3));
//
//	    anch.widthProperty().addListener((obs, oldWidth, newWidth) ->
//	               lbl2.setMaxWidth(newWidth.doubleValue() * 0.7));
//	        anch.heightProperty().addListener((obs, oldHeight, newHeight) ->
//	                lbl2.setMaxHeight(newHeight.doubleValue() * 0.3));
//	        
	        
	        
	        count = 0;
	        al = arr.size();
	        question1.setText(arr.get(count));
	        answer1.setText(arr2.get(count));
	        if(count >= al) bnext.setVisible(false);
			else bnext.setVisible(true);
			if(count <= 0) bprev.setVisible(false);
			else bprev.setVisible(true);
//			System.out.println(count);
	    }	
	  
	@FXML
	private void next() throws IOException{
		Stage primarystage = (Stage) bnext.getScene().getWindow();
		
//		lbl1.setWrapText(true);
//		lbl2.setWrapText(true);
		count+=1;
		if(count >= al-1) bnext.setVisible(false);
		else bnext.setVisible(true);
		if(count <= 0) bprev.setVisible(false);
		else bprev.setVisible(true);
		question1.setText(arr.get(count));
		answer1.setText(arr2.get(count));
		System.out.println(count);
		
		primarystage.show();
	}
	
	@FXML
	private void prev() throws IOException{
		
//		lbl1.setWrapText(true);
//		lbl2.setWrapText(true);
		Stage primarystage = (Stage) bnext.getScene().getWindow();
		count-=1;
		if(count <= 0) bprev.setVisible(false);
		else bprev.setVisible(true);
		if(count >= al) bnext.setVisible(false);
		else bnext.setVisible(true);
		question1.setText(arr.get(count));
		answer1.setText(arr2.get(count));
		System.out.println(count);
		
		primarystage.show();
	}
	
	@FXML
	private void penter() throws IOException{
//		Stage primarystage = (Stage) bnext.getScene().getWindow();
		FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.3), lbl1);
        fadeTransition.setToValue(0);
//        fadeTransition.
        fadeTransition.play();
        
        
        FadeTransition fadeTransition2 = new FadeTransition(Duration.seconds(0.3), lbl2);
        fadeTransition2.setToValue(1);
        fadeTransition2.play();
        
//        primarystage.show();
	}
	
	@FXML
	private void pexit() throws IOException{
		Stage primarystage = (Stage) bnext.getScene().getWindow();
		FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.3), lbl2);
        fadeTransition.setToValue(0); 
        fadeTransition.play();
        
        FadeTransition fadeTransition2 = new FadeTransition(Duration.seconds(0.3), lbl1);
        fadeTransition2.setToValue(1);      
        fadeTransition2.play();
//		System.out.println("pexit");
        primarystage.show();
	}
}
