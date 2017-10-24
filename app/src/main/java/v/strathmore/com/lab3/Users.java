package v.strathmore.com.lab3;

/**
 * Created by wainj on 23/10/2017.
 */

public class Users {

    //ptivate variables
    int _id;
    String _name;
    String _age;

    //constructors
    public Users (){

    }

    //read operation
    public Users (int id, String name, String age) {
        this._id = id;
        this._name = name;
        this._age = age;
    }

    //write operation
    public Users (String name, String age){
        this._name = name;
        this._age = age;
    }

    //get id
    public int getID() {
        return this._id;
    }

    //set id
    public void setID(int id) {
        this._id = id;
    }

    //get name

    public String getName() {
        return this._name;
    }

    public void setName(String name) {
        this._name = name;
    }

    public String getAge() {
        return this._age;
    }

    public void setAge(String age) {
        this._age = age;
    }
}
