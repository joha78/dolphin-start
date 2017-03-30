package aero.sprouts.largestring.view;

import aero.sprouts.largestring.Constants;
import aero.sprouts.largestring.model.MyModel;
import com.canoo.dolphin.client.ClientContext;
import com.canoo.dolphin.client.javafx.view.AbstractFXMLViewBinder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;


public class MyView extends AbstractFXMLViewBinder<MyModel> {

    @FXML
    private Button button1;

    @FXML
    private Button button2;

    @FXML
    private ProgressIndicator progress;

    @FXML
    private Label message;

    @FXML
    void onButton1(ActionEvent event) {
        this.message.setText("Please wait...");
        invoke("action1").thenRun(() -> {
            if (getModel().getLargeString().length() > 20000) {
                this.message.setText("Success!");
            } else {
                this.message.setText("Failed!");
            }
        });
    }

    @FXML
    void onButton2(ActionEvent event) {
        this.message.setText("Please wait...");
        invoke("action2").thenRun(() -> {
            if (getModel().getLargeString().equals("short")) {
                this.message.setText("Success!");
            } else {
                this.message.setText("Failed!");
            }
        });
    }

    public MyView(ClientContext clientContext) {
        super(clientContext, Constants.CONTROLLER_NAME, MyView.class.getResource("view.fxml"));
    }

    @Override
    protected void init() {
        this.button1.disableProperty().bind(actionInProcessProperty());
        this.button2.disableProperty().bind(actionInProcessProperty());
        this.progress.visibleProperty().bind(actionInProcessProperty());
    }
}
