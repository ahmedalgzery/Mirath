import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;

public class SecondDataApp implements Initializable {


    File audioFile = new File("src\\sounds\\alaya.m4a");
    Media audio = new Media(audioFile.toURI().toString());
    MediaPlayer audioPlayer = new MediaPlayer(audio);
    
    @FXML
    private ComboBox com1;

    @FXML
    private ComboBox com2;

    @FXML
    private ComboBox com3;

    @FXML
    private ComboBox com4;

    @FXML
    private ComboBox com5;

    @FXML
    private ComboBox com6;

    @FXML
    private ComboBox com7;
    
    @FXML
    private RadioButton r2;

    @FXML
    private Label errorTxt;
    
    @FXML
    private Text t1;

    @FXML
    private Text t2;

    @FXML
    private Text t3;

    @FXML
    private Text t4;

    @FXML
    private Text t5;

    @FXML
    private Text t6;

    @FXML
    private Text t7;

    @FXML
    private Text t8;

    @FXML
    private Text t9;

    @FXML
    private TextField tf1;

    @FXML
    private Button toFirstPgBtn;

    @FXML
    private Button toSecPg;

    @FXML
    void toFirstPgBtnPressed(ActionEvent event) throws IOException {
        SceneController back = new SceneController();
        back.switchToFirstPage(event);
    }

    @FXML
    void toLastPgPressed(ActionEvent event) throws IOException {
        if ("".equals(tf1.getText())) {
            errorTxt.setText("برجاء ادخال البيانات");
        }
        else {
            calcMirath ob=calcMirath.GetInstance();
            ob.setAmount(Double.parseDouble(tf1.getText()));
            ob.setDaughters(Double.parseDouble((String) com4.getValue()));
            ob.setSons(Double.parseDouble((String) com5.getValue()));
            ob.setGender(r2.isSelected());
            ob.setFather(Double.parseDouble((String) "1.0"));
            ob.setMother(Double.parseDouble((String) "1.0"));
            ob.setWife(Double.parseDouble((String) "1.0"));
            SceneController next = new SceneController();
            next.switchToLastPage(event);
        }

    }
 

    @Override
     
    public void initialize(URL location, ResourceBundle resources) {
               com1.setItems(FXCollections.observableArrayList("نعم","لا"));
               com2.setItems(FXCollections.observableArrayList("نعم","لا"));
               com3.setItems(FXCollections.observableArrayList("نعم","لا"));
               com4.setItems(FXCollections.observableArrayList( "1","2","3","4","5","6","7","8","9","10"));
               com5.setItems(FXCollections.observableArrayList( "1","2","3","4","5","6","7","8","9","10"));
               com6.setItems(FXCollections.observableArrayList( "نعم","لا"));
               com7.setItems(FXCollections.observableArrayList( "نعم","لا"));
              
    }

}
