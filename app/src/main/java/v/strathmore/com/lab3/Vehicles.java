package v.strathmore.com.lab3;

/**
 * Created by wainj on 23/10/2017.
 */

public class Vehicles {

    //private variables
    int _id;
    String _make;
    String _year;

    //constructor
    public Vehicles () {
    }

    //read operation
    public Vehicles (int id, String make, String year){
        this._id = id;
        this._make = make;
        this._year = year;
    }

    //write operation
    public Vehicles (String make, String year) {
        this._make = make;
        this._year = year;
    }

    //get ID
    public int getID() {
        return this._id;
    }

    //set ID
    public void setID(int id) {
        this._id = id;
    }

    //get make
    public String getMake() {
        return this._make;
    }

    //set make
    public void setMake(String make) {
        this._make = make;
    }

    //get year

    public String getYear() {
        return this._year;
    }

    //set year

    public void setYear(String year) {
        this._year = year;
    }
}
