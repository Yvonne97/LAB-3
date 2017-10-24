package v.strathmore.com.lab3;

/**
 * Created by wainj on 23/10/2017.
 */

public class Colors {

    //private variables
    int _id;
    String _color1;
    String _color2;

    //constructor

    public Colors () {

    }

    //read operation
    public Colors (int id, String color1, String color2) {
        this._id = id;
        this._color1 = color1;
        this._color2 = color2;
    }

    //write operation
    public Colors (String color1, String color2) {
        this._color1 = color1;
        this._color2 = color2;
    }

    //getting ID
    public int getID() {
        return this._id;
    }

    //setting ID
    public void setID(int id) {
        this._id = id;
    }

    //getting color
    public String getColor1() {
        return this._color1;
    }

    //setting color
    public void setColor1(String color1) {
        this._color1 = color1;
    }

    public String getColor2() {
        return this._color2 ;
    }

    public void setColor2 (String color2) {
        this._color2 = color2;
    }
}
