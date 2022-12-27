import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class FirstDataApp implements Initializable{

   
    File audioFile = new File("src\\sounds\\besm alaah.mp3");
    Media audio = new Media(audioFile.toURI().toString());
    MediaPlayer audioPlayer = new MediaPlayer(audio);
    
    @FXML
    private Button startBtn;
    @FXML
    private CheckBox soundcheck;
    @FXML
    void soundchecked(ActionEvent event) {
        calcMirath ob=calcMirath.GetInstance();
        ob.setSound(soundcheck.isSelected());
        if (ob.isSound()) {
            audioPlayer.play();
        } else {
            audioPlayer.stop();
        }
    }
    @FXML
    void startBtnPressed(ActionEvent event) throws IOException {
        SceneController next = new SceneController();
        next.switchToSecondPage(event);
        audioPlayer.pause();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        calcMirath ob=calcMirath.GetInstance();
        ob.setSound(false);
    }

}