package aero.sprouts.largestring.model;

import com.canoo.dolphin.mapping.DolphinBean;
import com.canoo.dolphin.mapping.Property;

/**
 * Defines the model of the MVC that is defined in this example. When using Dolphin Platform a view-controller-pair will
 * share one model that is automatially synchronized between the view on the client and teh controller on the server.
 * The model will automatically instanziated and managed by the platform and its lifecylce is bound to lifecylce of the view.
 * <p>
 * This basic model only contains one value. When defining models with Dolphin Platform all attributes must be
 * defined as observable properties. To do so Dolphin Platform provides the {@link Property} interface. A property
 * can contain a primitive datatype like String or int. In addition a property can contain another Dolphin Platform
 * model. By doing so a hierarchy can be defined. In addition Dolphin Platform contains extensions for the Java
 * collections API like an observable list. This types can be used in model classes, too.
 */
@DolphinBean
public class MyModel {

    private Property<String> largeStringProperty;

    public void setLargeString(String string) {
        this.largeStringProperty.set(string);
    }

    public String getLargeString() {
        return this.largeStringProperty.get();
    }


    private Property<String> value;

    public Property<String> valueProperty() {
        return this.value;
    }

    public String getValue() {
        return valueProperty().get();
    }

    public void setValue(String value) {
        valueProperty().set(value);
    }
}
