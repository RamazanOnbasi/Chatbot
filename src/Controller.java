
import apis.TwitterAPI;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import products.*;
import twitter4j.TwitterException;

public class Controller {

    @FXML
    public Button closeBtn;
    public TextField brandTF;
    public TextField priceTF;
    public TextField widthTF;
    public TextField weightTF;
    public TextField storageTF;
    public TextField osTF;
    public TextField modelTF;
    public TextField heightTF;
    public TextField depthTF;
    public TextField screenTF;
    public TextField cameraTF;
    public TextField ramTF;
    TwitterAPI twitterAPI;

    /**
     * This function is called by close button at the top right
     */
    @FXML
    public void close() {
        Stage stage = (Stage) closeBtn.getScene().getWindow();
        stage.close();
    }

    /**
     * this function is called by save button
     */
    @FXML
    public void savePhone(Event event) {
        MobilePhone newMobilePhone = new MobilePhone(
                brandTF.getText(),
                modelTF.getText(),
                Double.parseDouble(priceTF.getText()),
                Double.parseDouble(heightTF.getText()),
                Double.parseDouble(widthTF.getText()),
                Double.parseDouble(depthTF.getText()),
                Integer.parseInt(weightTF.getText()),
                Double.parseDouble(screenTF.getText()),
                Integer.parseInt(storageTF.getText()),
                Integer.parseInt(cameraTF.getText()),
                osTF.getText(),
                Integer.parseInt(ramTF.getText()));
        try {
            twitterAPI = new TwitterAPI();
            double reviewPoint = twitterAPI.getReviewPoint(modelTF.getText());
            System.out.println("10 tweetin Hesaplananortalamasi: " + reviewPoint);
            newMobilePhone.setReviewPoint(reviewPoint);
        } catch (TwitterException e) {

        }
        /**
         * ToDo: insert the object to mongoDB
         */
        System.out.println(newMobilePhone);

    }

}
