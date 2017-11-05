
import apis.TwitterAPI;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import twitter4j.TwitterException;

import products.*;
import apis.*;


public class Controller {

    @FXML
    public Label messageLabel;
    public Rectangle messageBox;

    @FXML //Product fields
    public Button closeBtn;
    public TextField brandTF;
    public TextField modelTF;
    public TextField priceTF;
    public TextField widthTF;
    public TextField heightTF;
    public TextField depthTF;
    public TextField weightTF;

    @FXML //Consumer Electronics fields
    public TextField screenTF;
    public TextField storageTF;
    public TextField osTF;


    @FXML //Mobile Phone fields
    public TextField cameraTF;
    public TextField ramTF;

    @FXML //Laptop fields
    public TextField cpuTF;

    private static final String infoColor = "#3c9ae1";
    private static final String errorColor = "#dd3b3b";
    private static final String successColor = "#3ce07e";

    /**
     * This function is called by close button at the top right
     */
    @FXML
    public void close() {
        Stage stage = (Stage) closeBtn.getScene().getWindow();
        stage.close();
    }

    /**
     * this function is called by save button of AddPhone form
     */
    @FXML
    public void savePhone(Event event) {

        if (!isSet(brandTF) || !isSet(modelTF) || !isSet(priceTF) || !isSet(osTF)
                || !isSet(heightTF) || !isSet(widthTF) || !isSet(depthTF) || !isSet(weightTF)
                || !isSet(screenTF) || !isSet(storageTF) || !isSet(cameraTF) || !isSet(ramTF)){
            messageLabel.setText("You must fill the form.");
            messageBox.setFill(Color.web(errorColor));
            return;
        } else {
            messageBox.setFill(Color.web(infoColor));
        }

        MobilePhone newMobilePhone;
        try {
            newMobilePhone = new MobilePhone(
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
        } catch (Exception e) {
            messageLabel.setText("One of values is not acceptable");
            messageBox.setFill(Color.web(errorColor));
            return;
        }

        newMobilePhone.setReviewPoint(getPointFromLatestTweets());

        ProductDB mongoDB = new ProductDB();
        mongoDB.insert(newMobilePhone);
        mongoDB.close(); //close db connection

        this.close();
    }

    /**
     * this function is called by save button of AddLaptop form
     */
    @FXML
    public void saveLaptop(Event event) {

        if (!isSet(brandTF) || !isSet(modelTF) || !isSet(priceTF) || !isSet(osTF)
                || !isSet(heightTF) || !isSet(widthTF) || !isSet(depthTF) || !isSet(weightTF)
                || !isSet(screenTF) || !isSet(storageTF) ||  !isSet(ramTF) || !isSet(cpuTF)){
            messageLabel.setText("You must fill the form.");
            messageBox.setFill(Color.web(errorColor));
            return;
        } else {
            messageBox.setFill(Color.web(infoColor));
        }

        Laptop newLaptop;
        try {
            newLaptop = new Laptop(
                    brandTF.getText(),
                    modelTF.getText(),
                    Double.parseDouble(priceTF.getText()),
                    Double.parseDouble(heightTF.getText()),
                    Double.parseDouble(widthTF.getText()),
                    Double.parseDouble(depthTF.getText()),
                    Integer.parseInt(weightTF.getText()),
                    Double.parseDouble(screenTF.getText()),
                    Integer.parseInt(storageTF.getText()),
                    Integer.parseInt(ramTF.getText()),
                    osTF.getText(),
                    osTF.getText());
        } catch (Exception e) {
            messageLabel.setText("One of values is not acceptable");
            messageBox.setFill(Color.web(errorColor));
            return;
        }

        newLaptop.setReviewPoint(getPointFromLatestTweets());

        ProductDB mongoDB = new ProductDB();
        mongoDB.insert(newLaptop);
        mongoDB.close(); //close db connection

        this.close();
    }

    private Double getPointFromLatestTweets(){
        try {
            TwitterAPI twitterAPI = new TwitterAPI();
            double reviewPoint = twitterAPI.getReviewPoint(modelTF.getText());
            System.out.println("Mean of review points of ten tweets: " + reviewPoint);
            return reviewPoint;
        } catch (TwitterException e) {
            System.out.println("An error ocurred while getting tweets.");
            return 0.0;
        }
    }

    private boolean isSet(TextField tf) {
        if (tf.getText().isEmpty() || tf.getText().equals("") || !tf.getText().matches(".*[a-zA-Z0-9]+.*"))
            return false;
        else
            return true;
    }
}
