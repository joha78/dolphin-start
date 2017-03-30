package aero.sprouts.largestring.controller;

import aero.sprouts.largestring.Constants;
import aero.sprouts.largestring.model.MyModel;
import com.canoo.dolphin.server.DolphinAction;
import com.canoo.dolphin.server.DolphinController;
import com.canoo.dolphin.server.DolphinModel;
import org.apache.commons.io.IOUtils;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

/**
 * This class defines the controller. Whenever a matching view is created in a client a controller instance will be
 * created on the server. The controller is completelly managed by the container and therefore features like CDI can
 * be used without any problems in the controller.
 * The {@link DolphinController} annotation defines the unique name of this controller type. In this sample a static
 * constant is used for the name that is shared with the JavaFX client.
 */
@DolphinController(Constants.CONTROLLER_NAME)
public class MyController {

    /**
     * Defines the model of the MVC group. Like the controller this model will automatically be managed by the container
     * and before the init() method (annotated with {@link PostConstruct}) is called the model will be injected in the
     * controller.
     */
    @DolphinModel
    private MyModel model;

    /**
     * Like in any managed bean this method will be called once the initalisation of the instance (injection etc.) is done.
     */
    @PostConstruct
    public void init() {

    }

    @DolphinAction
    public void action1() throws IOException {
        InputStream inputStream = getClass().getResourceAsStream("/IMG_1451.jpg");
        byte[] byteArray = IOUtils.toByteArray(inputStream);
        this.model.setLargeString(Base64.getEncoder().encodeToString(byteArray));
    }

    @DolphinAction
    public void action2() {
        this.model.setLargeString("short");
    }
}
