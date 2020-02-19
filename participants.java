// Code reference: https://www.youtube.com/watch?v=uh5R7D_vFto

package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class participants {
    private SimpleStringProperty firstName;
    private SimpleStringProperty bodyWeight;
    private SimpleStringProperty weightLifted ;
    private StringProperty gender;
    private StringProperty type;
    private StringProperty goodBad;

    public participants(String firstName,String bodyWeight,String weightLifted,String gender,String type,String goodBad)
    {
        this.firstName = new SimpleStringProperty(firstName);
        this.bodyWeight = new SimpleStringProperty(bodyWeight);
        this.weightLifted = new SimpleStringProperty(weightLifted);
        this.gender = new SimpleStringProperty(gender);
        this.type = new SimpleStringProperty(type);
        this.goodBad = new SimpleStringProperty(goodBad);

    }

    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String firstName) {
        this.firstName=new SimpleStringProperty(firstName);
    }

    public String getGoodBad() {
        return goodBad.get();
    }

    public void setGoodBad(String goodBad) {
        this.goodBad.set(goodBad);
    }

    public String getType() {
        return type.get();
    }

    public void setType(String type) {
        this.type.set(type);
    }

    public String getGender() {
        return gender.get();
    }

    public void setGender(String gender) {
        this.gender.set(gender);
    }

    public StringProperty nameProperty() {
        return gender;
    }

    public String getBodyWeight() {
        return bodyWeight.get();
    }

    public void setBodyWeight(String bodyWeight) {
        this.bodyWeight=new SimpleStringProperty(bodyWeight);
    }

    public String getWeightLifted() {
        return weightLifted.get();
    }

    public void setWeightLifted(String weightLifted) {
        this.weightLifted=new SimpleStringProperty(weightLifted);
    }


}
