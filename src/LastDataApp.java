import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class LastDataApp implements Initializable {
    
    File audioFile = new File("src\\sounds\\alaya.m4a");
    Media audio = new Media(audioFile.toURI().toString());
    MediaPlayer audioPlayer = new MediaPlayer(audio);
    
    
    @FXML
    private PieChart pieChart;
    @FXML
    private MediaView mV;
    @FXML
    private Button to1stPg;

    @FXML
    private Button toSecPg;

    @FXML
    void to1stPgPressed(ActionEvent event) throws IOException {
        SceneController next = new SceneController();
        next.switchToFirstPage(event);
        audioPlayer.pause();
    }


    @FXML
    void toSecPgPressed(ActionEvent event) throws IOException {
        SceneController back = new SceneController();
        back.switchToSecondPage(event);
        audioPlayer.pause();
    }

    private ObservableList<PieChart.Data> pieChartData;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        calcMirath ob=calcMirath.GetInstance();
            if (ob.isSound()) {
                audioPlayer.play();
            } else {
                audioPlayer.stop();
            }
        pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("الأم "+Math.floor(ob.getMother()) , 16),
                new PieChart.Data("الأب "+Math.floor(ob.getFather()), 16),
                new PieChart.Data("الزوجه "+Math.floor(ob.getWife()), ob.isGender()?25:12),
                new PieChart.Data("الابناء "+Math.floor(ob.getSons()), ob.isGender()?27:36),
                new PieChart.Data("البنات "+Math.floor(ob.getDaughters()), ob.isGender()?13:18)
        );
        pieChart.setData(pieChartData);
        
    }
 
}
