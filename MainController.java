package application;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.util.random.*;


public class MainController {

	String question;
	String answer;
	File directory;
	
	
	
	@FXML
	private Button directoryBtn;
	
	@FXML
	private Button bBtn;
	
	@FXML
	private Label pathLabel;
	
	@FXML
	private TextField Fname;
	
	@FXML
	private Button qBtn;
	
	@FXML
    private Button createButton;
	
    @FXML	
    private TextArea TextQuestion;
    
    @FXML
    private TextArea crAnswer;
    
    @FXML
    private Button addAnotherButton;
    
    @FXML
    private Button FinishButton;
    
    @FXML
    private Button CreateQuestion;
    

    @FXML
    void createFlashcard() throws IOException {
    	Stage primarystage = (Stage) createButton.getScene().getWindow();
    	
    	Parent root2 = FXMLLoader.load(getClass().getResource("fileChooser.fxml"));
    	Scene sc2 = new Scene(root2);
    	
    	primarystage.setTitle("Create Deck");
    	primarystage.setScene(sc2);
    	primarystage.show();
    	
//    	question = crQuestion.getText();
//    	Parent root = FXMLLoader.load(getClass().getResource("answ.fxml"));    	'
    }
    
    @FXML
    void ChooseDir() throws IOException{
    	
    	Stage primarystage = (Stage) qBtn.getScene().getWindow();    	
    	DirectoryChooser jfc = new DirectoryChooser();
    	File directorytemp = jfc.showDialog(primarystage);
    	directory = directorytemp;
    	
    	pathLabel.setText(directorytemp.getPath());
//    	return;
//    	System.out.println(directory);
    }
    
	void setDirectory(File temp)
    {
    	directory = temp;
    	GlobalVariable.setFileDirectory(temp);
//    	System.out.println(directory);
    }
    
    public File getDirectory()
    {
//    	System.out.println(GlobalVariable.getFileDirectory());
    	return GlobalVariable.getFileDirectory();
    }
    
    @FXML
    void Bmainmenu() throws IOException{
    	Stage primarystage = (Stage) bBtn.getScene().getWindow();
    	Parent root = FXMLLoader.load(getClass().getResource("mainmenu.fxml"));
    	Scene sc = new Scene(root);
    	
    	primarystage.setTitle("Flashdeck");
    	primarystage.setScene(sc);
    	primarystage.show();
    	
    	
    }
    
    @FXML
    void toQuest() throws IOException{
    	Stage primarystage = (Stage) qBtn.getScene().getWindow();
    	Parent root2 = FXMLLoader.load(getClass().getResource("question.fxml"));
    	Scene sc2 = new Scene(root2);
    	String fileName = Fname.getText();
    	File fileN = new File(directory + "/" + fileName + ".txt");
//    	System.out.println(fileN);
//    	TextQuestion.setMaxWidth(400);
    	
//    	GlobalVariable.setFileDirectory(fileN);
    	setDirectory(fileN);
//    	primarystage.setTitle("Question");
    	primarystage.setScene(sc2);
    	primarystage.show();
    	
    }
    
    @FXML
    void contAns(ActionEvent event) throws IOException{
    	Stage primarystage = (Stage) CreateQuestion.getScene().getWindow();
//    	System.out.println(getDirectory());
    	
    	question = TextQuestion.getText();
    	Parent root3 = FXMLLoader.load(getClass().getResource("answer.fxml"));
    	Scene sc3 = new Scene(root3);
    	String List = question;
    	root3.translateXProperty().set(sc3.getWidth());
    	textfile(List,0);

    	
    	
//    	primarystage.setTitle("Answer");
    	primarystage.setScene(sc3);
    	primarystage.show();    	
    }
   
    @FXML
    void Finish() throws IOException{
    	Stage primarystage = (Stage) FinishButton.getScene().getWindow();
    	answer = crAnswer.getText();
    	Parent root2 = FXMLLoader.load(getClass().getResource("mainmenu.fxml"));
    	Scene sc3 = new Scene(root2);
    	String List = " | " + answer;
    	textfile(List,1);
    	
    	primarystage.setTitle("FlipFX");
    	primarystage.setScene(sc3);
    	primarystage.show();
    	
    }
    
    @FXML
    void AnotherCont() throws IOException{
    	Stage primarystage = (Stage) FinishButton.getScene().getWindow();
    	answer = crAnswer.getText();
    	Parent root = FXMLLoader.load(getClass().getResource("question.fxml"));
    	Scene sc = new Scene(root);
    	String List = " | " + answer;
    	textfile(List,1);
    	
//    	primarystage.setTitle("");
    	primarystage.setScene(sc);
    	primarystage.show();
    }
    
    public void textfile(String List, int QorA)
    {
    	
    	File file = GlobalVariable.getFileDirectory();
    	FileWriter fw = null;
    	BufferedWriter write = null;
    	
    	try{
    			fw = new FileWriter(file, true);
    			write = new BufferedWriter(fw);
    			write.append(List);
//    			System.out.println(List);
    			if(QorA == 1)
    			{
    				write.newLine();
    			}
    			write.close();  
    
    				
    		} catch (IOException e) {
    			System.out.println("error");
    			e.printStackTrace();
    		}
    	
    }
    
    
    //choose file
    //Choose Display in Main Menu
    @FXML
    private Button DisplayBtn;
    
    // Choose Display
    @FXML
    private Button displayDirectoryBtn;
    
    @FXML
    private Label displayFileLabel;
    
    @FXML
    private Button backHomeBtn;
    
    @FXML
    private Button NextDisplayBtn;
    
    @FXML
    private Button DButton;
    
    @FXML
    void toDisplay() throws IOException{
    	Stage primarystage = (Stage) DButton.getScene().getWindow();
        
        Parent rootDisplay = FXMLLoader.load(getClass().getResource("FileChooserCr.fxml"));
        Scene displayFlash = new Scene(rootDisplay);
        
        primarystage.setTitle("Choose File");
        primarystage.setScene(displayFlash);
        primarystage.show();
    	
    	
    	
    }
    
    
    // Flashcard Display fxml load
    @FXML
    void displayFlashcardMain() throws IOException{
        Stage primarystage = (Stage) DisplayBtn.getScene().getWindow();
        
        Parent rootDisplay = FXMLLoader.load(getClass().getResource("FileChooserCr.fxml"));
        Scene displayFlash = new Scene(rootDisplay);
        
        primarystage.setTitle("Choose File");
        primarystage.setScene(displayFlash);
        primarystage.show();
    }
    
    // Input directory Button
    @FXML
    void displayFlashcardDirBtn() throws IOException{
        Stage primarystage = (Stage) displayDirectoryBtn.getScene().getWindow();        
        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("TXT files", "*.txt");
        FileChooser kfc = new FileChooser();
        kfc.getExtensionFilters().add(filter);
    	File filen = kfc.showOpenDialog(primarystage);
    	setDirectory(filen);
    	
        displayFileLabel.setText(filen.getPath());
    }
    //backHomeBtn
    @FXML
    void backHome() throws IOException{
        Stage primaryStage = (Stage) backHomeBtn.getScene().getWindow();
        Parent home = FXMLLoader.load(getClass().getResource("mainmenu.fxml"));
        Scene backHome = new Scene(home);
        
        primaryStage.setScene(backHome);
        primaryStage.setTitle("FlipFX");
        primaryStage.show();
    }
    
    
    @FXML 
    void Displey() throws IOException{
    	Stage primaryStage = (Stage) NextDisplayBtn.getScene().getWindow();
    	Parent root = FXMLLoader.load(getClass().getResource("display.fxml"));
    	Scene sc = new Scene(root);
    	
    	
    	
    	
    	primaryStage.setScene(sc);
    	primaryStage.setTitle("Your FlipDeck");
    	primaryStage.show();
    	
    	
    	
    }
    
    //fxml display
    

}
	