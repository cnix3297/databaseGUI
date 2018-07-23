/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasegui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.Pane;
import java.sql.*;
import java.util.regex.Pattern;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author charles
 */
public class GuiController implements Initializable {
    String[] preset = new String[17];
    ConnectionToDatabase connectDatabase = new ConnectionToDatabase();
    int kidStartSize,kidEndSize,adultStartSize,adultEndSize,eLStartSize,eLEndSize;
    double kidWidth1,kidWidth2,kidWidth3,adultWidth1,adultWidth2,adultWidth3,
            priceOfAdultWidth1, priceOfAdultWidth2, priceOfAdultWidth3, 
            priceOfKidWidth1, priceOfKidWidth2,priceOfKidWidth3;
    @FXML
    private Button registerButton;
    @FXML
    private Button invLookupButton;
    @FXML
    private Button InventoryEditButton;
    @FXML
    private Button settingButton;
    @FXML
    private Button cashOutButton;
    @FXML
    private Pane addDesignPane;
    @FXML
    private Pane presetPane;
    @FXML
    private Pane settingPane;
    @FXML
    private Button presetsButton;
    @FXML
    private Button presetSaveUpdate;
    @FXML
    private Button addDesignButton;
    @FXML
    private TextField presetKidSize;
    @FXML
    private ToggleButton presetUpdateCashRegister;
    @FXML
    private TextField presetAdultSize;
    @FXML
    private TextField presetAdultWidthPrice;
    @FXML
    private TextField presetKidWidthPrice;
    @FXML
    private TextField presetELSize;
    @FXML
    private TextField presetAdultWidth;
    @FXML
    private TextField presetPlainKidPrice;
    @FXML
    private TextField presetDesignedKidPrice;
    @FXML
    private TextField presetPaintedKidPrice;
    @FXML
    private TextField presetPlainAdultPrice;
    @FXML
    private TextField presetDesignAdultPrice;
    @FXML
    private TextField presetPaintedAdultPrice;
    @FXML
    private TextField presetPlainELPrice;
    @FXML
    private TextField presetDesignedELPrice;
    @FXML
    private TextField presetPaintedELPrice;
    @FXML
    private Pane paneRun;
    @FXML
    private Button startRunButton;
    @FXML
    private TextField presetKidWidth;
    @FXML
    private Button addDesignSend;
    @FXML
    private TextField addADesignDesign;
    @FXML
    private CheckBox addADesignLengthKid;
    @FXML
    private CheckBox addADesignLengthAdult;
    @FXML
    private CheckBox addADesignLengthEL;
    @FXML
    private TextField addADesignLengthKidEC;
    @FXML
    private TextField addADesignLengthAdultEC;
    @FXML
    private TextField addADesignLengthELEC;
    @FXML
    private CheckBox addADesignColorBlack;
    @FXML
    private CheckBox addADesignColorBrown;
    @FXML
    private TextField addADesignColorBlackEC;
    @FXML
    private TextField addADesignColorBrownEC;
    @FXML
    private ChoiceBox<?> addDesignComboBox2;
    private void open(Pane window){
        settingPane.setVisible(false);
        presetPane.setVisible(false);
        addDesignPane.setVisible(false);
        window.setVisible(true);
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void DisplayRegister(ActionEvent event) {
    
    }

    @FXML
    private void DisplayInventoryLookUp(ActionEvent event) {
    }

    @FXML
    private void DisplayInventoryEdit(ActionEvent event) {
    }

    @FXML
    private void DisplaySettings(ActionEvent event) {
    open(settingPane);
    
    }

    @FXML
    private void DisplayCashOut(ActionEvent event) {
    }

    @FXML
    private void DisplayPresets(ActionEvent event) {
       
    open(presetPane);
    }
    
    @FXML
    private void DisplayAddDesign(ActionEvent event) {
    open(addDesignPane);
    }

    @FXML
    private void presetSaveUpdate(ActionEvent event) {
        if (presetKidSize.getText().length() != 5 || 
                presetKidSize.getText().matches(".*[a-z].*")||
                presetKidSize.getText().charAt(2) != '-') 
            presetKidSize.setText("");
        
        if (presetELSize.getText().length() != 5 || 
                presetELSize.getText().matches(".*[a-z].*")||
                presetELSize.getText().charAt(2) != '-') 
            presetELSize.setText("");
        
        if(presetAdultSize.getText().length() != 5 || 
                presetAdultSize.getText().matches(".*[a-z].*")||
                presetAdultSize.getText().charAt(2) != '-')
            presetAdultSize.setText("");
        
        if(presetKidWidth.getText().matches(".*[a-z].*") ||
                presetKidWidth.getText().length() != 16  ||
                presetKidWidth.getText().charAt(1) != '.'||
                presetKidWidth.getText().charAt(7) != '.'||
                presetKidWidth.getText().charAt(13) != '.'||
                presetKidWidth.getText().charAt(5) != ' '||
                presetKidWidth.getText().charAt(11) != ' ')
            presetKidWidth.setText("");
        
        if(presetAdultWidth.getText().matches(".*[a-z].*") ||
                presetAdultWidth.getText().length() != 16  ||
                presetAdultWidth.getText().charAt(1) != '.'||
                presetAdultWidth.getText().charAt(7) != '.'||
                presetAdultWidth.getText().charAt(13) != '.'||
                presetAdultWidth.getText().charAt(5) != ' '||
                presetAdultWidth.getText().charAt(11) != ' ')
            presetAdultWidth.setText("");
        
        if(presetKidWidthPrice.getText().length() != 19 ||
                presetKidWidthPrice.getText().charAt(2) != '.' ||
                 presetKidWidthPrice.getText().charAt(9) != '.' ||
                 presetKidWidthPrice.getText().charAt(16) != '.' ||
                 presetKidWidthPrice.getText().charAt(6) != ' ' ||
                 presetKidWidthPrice.getText().charAt(13) != ' ' 
                )
            presetKidWidthPrice.setText("");
        
        if(presetAdultWidthPrice.getText().length() != 19 ||
                presetAdultWidthPrice.getText().charAt(2) != '.' ||
                 presetAdultWidthPrice.getText().charAt(9) != '.' ||
                 presetAdultWidthPrice.getText().charAt(16) != '.' ||
                 presetAdultWidthPrice.getText().charAt(6) != ' ' ||
                 presetAdultWidthPrice.getText().charAt(13) != ' ' 
                )
            presetAdultWidthPrice.setText("");
       
        presetPlainKidPrice.setText( testPrice(presetPlainKidPrice.getText()));
        presetPlainAdultPrice.setText(testPrice(presetPlainAdultPrice.getText()));
        presetPlainELPrice.setText(testPrice(presetPlainELPrice.getText()));
        presetDesignedKidPrice.setText(testPrice(presetDesignedKidPrice.getText()));
        presetDesignAdultPrice.setText(testPrice(presetDesignAdultPrice.getText()));
        presetDesignedELPrice.setText(testPrice(presetDesignedELPrice.getText()));
        presetPaintedKidPrice.setText(testPrice(presetPaintedKidPrice.getText()));
        presetPaintedAdultPrice.setText(testPrice(presetPaintedAdultPrice.getText()));
        presetPaintedELPrice.setText(testPrice(presetPaintedELPrice.getText()));
        
        
        String fileName = "C:\\LeathersDatabaseProject\\LeatherPresets.txt";
        int count = 0;
        String temp;
        BufferedWriter output = null;
        try {
            File file = new File(fileName);
            output = new BufferedWriter(new FileWriter(file));
   
    if (presetUpdateCashRegister.isSelected()){
     temp = "1";
    }
    else {
     temp = "0";
    }
    output.write( 
    presetKidSize.getText() + "\n"
     + temp + "\n"        
     + presetAdultSize.getText() + "\n"
     + presetELSize.getText() + "\n"
     + presetKidWidth.getText() + "\n"
     + presetKidWidthPrice.getText() + "\n"
     + presetAdultWidth.getText() + "\n"
     + presetAdultWidthPrice.getText() + "\n"
     + presetPlainKidPrice.getText() + "\n"
     + presetPlainAdultPrice.getText() + "\n"
     + presetPlainELPrice.getText() + "\n"
     + presetDesignedKidPrice.getText() + "\n"
     + presetDesignAdultPrice.getText() + "\n"
     + presetDesignedELPrice.getText() + "\n"
     + presetPaintedKidPrice.getText() + "\n"
     + presetPaintedAdultPrice.getText() + "\n"
     + presetPaintedELPrice.getText() + "\n"
            );
    output.close();
    }   catch (IOException ex) {
            Logger.getLogger(GuiController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        preset = GuiController.readFromPreset();
    loadPreset();
    setPreset();
        
    }
    
    public void loadPreset(){
        
    presetKidSize.setText(preset[0]);
    if ("1".equals(preset[1])){
    presetUpdateCashRegister.setSelected(true);
    }
    else {
    presetUpdateCashRegister.setSelected(false);
    }
    
    presetAdultSize.setText(preset[2]);
    presetELSize.setText(preset[3]);
    presetKidWidth.setText(preset[4]);
    presetKidWidthPrice.setText(preset[5]);
    presetAdultWidth.setText(preset[6]);
    presetAdultWidthPrice.setText(preset[7]);
    presetPlainKidPrice.setText(preset[8]);
    presetPlainAdultPrice.setText(preset[9]);
    presetPlainELPrice.setText(preset[10]);
    presetDesignedKidPrice.setText(preset[11]);
    presetDesignAdultPrice.setText(preset[12]);
    presetDesignedELPrice.setText(preset[13]);
    presetPaintedKidPrice.setText(preset[14]);
    presetPaintedAdultPrice.setText(preset[15]);
    presetPaintedELPrice.setText(preset[16]);
    }
     private static String[] readFromPreset(){
        String[] s = new String[17];
        
        
        
        String line;
        String fileName = "C:\\LeathersDatabaseProject\\LeatherPresets.txt";
        int count = 0;
        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(fileName);
            
            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

             while( (line = bufferedReader.readLine()) != null) {
              
                 s[count] = line;
       count++;
       
    }
        }
             catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }
   
     
return s;
     }
     private void setPreset(){
         String s[];
         Pattern pattern = Pattern.compile("");
         if (!"".equals(preset[0])){
          pattern = Pattern.compile("\\p{Punct}");
        s =  pattern.split(preset[0]);
       kidEndSize = Integer.parseInt(s[0]);
       kidStartSize = Integer.parseInt(s[1]);
       
       
         }
         if (!"".equals(preset[2])){
          pattern = Pattern.compile("\\p{Punct}");
        s =  pattern.split(preset[2]);
        adultStartSize = Integer.parseInt(s[0]);
        adultEndSize = Integer.parseInt(s[1]);
        
         }
         if (!"".equals(preset[3])){
          pattern = Pattern.compile("\\p{Punct}");
        s =  pattern.split(preset[3]);
        eLStartSize = Integer.parseInt(s[0]);
        eLEndSize = Integer.parseInt(s[1]);
         }
        
         if (!"".equals(preset[4])){
          pattern = Pattern.compile("\\S\\s");
        s =  pattern.split(preset[4]);
        kidWidth1 = Double.parseDouble(s[0]);
        kidWidth2 = Double.parseDouble(s[1]);
        kidWidth2 = Double.parseDouble(s[2]);
        
         }
         if (!"".equals(preset[5])){
          pattern = Pattern.compile("\\S\\s");
        s =  pattern.split(preset[5]);
        priceOfKidWidth1 = Double.parseDouble(s[0]);
        priceOfKidWidth2 = Double.parseDouble(s[1]);
        priceOfKidWidth3 = Double.parseDouble(s[2]);
        }
        if (!"".equals(preset[6])){
          pattern = Pattern.compile("\\S\\s");
        s =  pattern.split(preset[6]);
        adultWidth1 = Double.parseDouble(s[0]);
        adultWidth2 = Double.parseDouble(s[1]);
        adultWidth3 = Double.parseDouble(s[2]);
        } 
        if (!"".equals(preset[7])){
          pattern = Pattern.compile("\\S\\s");
        s =  pattern.split(preset[7]);
        priceOfAdultWidth1 = Double.parseDouble(s[0]);
        priceOfAdultWidth2 = Double.parseDouble(s[1]);
        priceOfAdultWidth3 = Double.parseDouble(s[2]);
        }
     }

    @FXML
    private void run(ActionEvent event) {
    preset = GuiController.readFromPreset();
    loadPreset();
    connectDatabase.connection = ConnectionToDatabase.ConnectDB();
    setPreset();
    paneRun.setVisible(false);
    }

    @FXML
    private void addDesignSendToDatabase(ActionEvent event) {
        
        Boolean size[] = new Boolean[3];
        Boolean color[] = new Boolean[2];
        //look into an enum
        try {
           
            Statement statement = connectDatabase.connection.createStatement();
            for (int i = 0; i < 3; i++) {                   //counter for size boolean
                for (int j = 0; j < 2; j++) {               // counter for color boolean
                    if(size[i] || color[j]){                // if statement for when both are true
                        if (i == 0) {                       // will be used to determine price for kids
                            for (int k = kidStartSize; k <= kidEndSize; k = k + 2) {
                                if(j == 0){     //determine if xtra price is added for black
                                statement.executeUpdate("insert into BELT values (null, '"+ addADesignDesign.getText() +"', 10," +  kidWidth1 + ", 'Black', 'Designed')");
                                statement.executeUpdate("insert into BELT values (null, '"+ addADesignDesign.getText() +"', 10, " +  kidWidth1 + ", 'Black', 'Designed')");
                                statement.executeUpdate("insert into BELT values (null, '"+ addADesignDesign.getText() +"', 10," +  kidWidth1 + ", 'Black', 'Designed')");
                                }
                            statement.executeUpdate("insert into BELT values (null, '"+ addADesignDesign.getText() +"', 10," +  kidWidth1 + ", 'Brown', 'Designed')");
                            statement.executeUpdate("insert into BELT values (null, '"+ addADesignDesign.getText() +"', 10," +  kidWidth1 + ", 'Brown', 'Designed')");
                            statement.executeUpdate("insert into BELT values (null, '"+ addADesignDesign.getText() +"', 10," +  kidWidth1 + ", 'Brown', 'Designed')");
                            }
 
                        }else if(i == 1){                   //be used to determine price for adult
                            for (int k = adultStartSize; k <= adultEndSize; k = k + 2) {
                                if(j == 0){     //determine if xtra price is added for black
                                statement.executeUpdate("insert into BELT values (null, '"+ addADesignDesign.getText() +"', 10," +  kidWidth1 + ", 'Black', 'Designed')");
                                statement.executeUpdate("insert into BELT values (null, '"+ addADesignDesign.getText() +"', 10," +  kidWidth1 + ", 'Black', 'Designed')");
                                statement.executeUpdate("insert into BELT values (null, '"+ addADesignDesign.getText() +"', 10," +  kidWidth1 + ", 'Black', 'Designed')");
                                }
                            statement.executeUpdate("insert into BELT values (null, '"+ addADesignDesign.getText() +"', 10," +  kidWidth1 + ", 'Brown', 'Designed')");
                            statement.executeUpdate("insert into BELT values (null, '"+ addADesignDesign.getText() +"', 10," +  kidWidth1 + ", 'Brown', 'Designed')");
                            statement.executeUpdate("insert into BELT values (null, '"+ addADesignDesign.getText() +"', 10," +  kidWidth1 + ", 'Brown', 'Designed')");
                            }
        
                        }else {                             
                            for (int k = eLStartSize; k < eLEndSize; k = k + 2) {  // be used to determine price for Extra Long
                                if(j == 0){     //determine if xtra price is added for black
                                    statement.executeUpdate("insert into BELT values (null, '"+ addADesignDesign.getText() +"', 10," +  kidWidth1 + ", 'Black', 'Designed')");
                                    statement.executeUpdate("insert into BELT values (null, '"+ addADesignDesign.getText() +"', 10," +  kidWidth1 + ", 'Black', 'Designed')");
                                    statement.executeUpdate("insert into BELT values (null, '"+ addADesignDesign.getText() +"', 10," +  kidWidth1 + ", 'Black', 'Designed')");
                                }
                                statement.executeUpdate("insert into BELT values (null, '"+ addADesignDesign.getText() +"', 10," +  kidWidth1 + ", 'Brown', 'Designed')");
                                statement.executeUpdate("insert into BELT values (null, '"+ addADesignDesign.getText() +"', 10," +  kidWidth1 + ", 'Brown', 'Designed')");
                                statement.executeUpdate("insert into BELT values (null, '"+ addADesignDesign.getText() +"', 10," +  kidWidth1 + ", 'Brown', 'Designed')");
                            }
                        }
                        }
                    }
                    
                }
                
            
            statement.executeUpdate("insert into BELT values (null, '"+ addADesignDesign.getText() +"', 10, 1.50, 'Black', 'Designed')");
            }
         catch (SQLException ex) {
            Logger.getLogger(GuiController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   
    private String testPrice(String s){
        if(s.matches(".*[a-z].*") ||
                s.charAt(2) != '.'||
                s.length() != 5){
        return "";
        }else
        return s;
    }
    
    @FXML
    void setDesignaddADesignNewDesign(MouseEvent event) {

    }
   
     }


