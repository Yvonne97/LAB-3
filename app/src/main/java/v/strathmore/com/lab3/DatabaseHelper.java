package v.strathmore.com.lab3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wainj on 23/10/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    //DATBASE VERSION
    private static final int DATABASE_VERSION = 1;

    //DATABASE NAME
    private static final String DATABASE_NAME = "preferenceManager";

    public DatabaseHelper (Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //VEHICLES TABLE CREATE
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(Contract.TVehicles.CREATE_VEHICLES_TABLE);

        db.execSQL(Contract.TUser.CREATE_USERS_TABLE);

        db.execSQL(Contract.TColors.CREATE_COLORS_TABLE);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Contract.TVehicles.TABLE_VEHICLES);
        onCreate(db);

        db.execSQL("DROP TABLE IF EXISTS " + Contract.TUser.TABLE_USERS);
        onCreate(db);

        db.execSQL("DROP TABLE IF EXISTS " + Contract.TColors.TABLE_COLORS);
        onCreate(db);
    }

    /*
    *
    CRUD FUNCTIONS FOR USER TABLE
     *
     */
    //adding new user
    public void addUser(Users users) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Contract.TUser.KEY_NAME, users.getName());
        values.put(Contract.TUser.KEY_AGE, users.getAge());

        //inserting row
        db.insert(Contract.TUser.TABLE_USERS, null, values);
        db.close(); //closing db connection
    }

    //getting single user
    public Users getUsers (int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(Contract.TUser.TABLE_USERS, new String[] {Contract.TUser.KEY_ID,
                        Contract.TUser.KEY_NAME, Contract.TUser.KEY_AGE }, Contract.TUser.KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Users users = new Users(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2));

        return users;
    }

    //getting all users
    public List<Users> getAllUsers (){
        List <Users> userList = new ArrayList<Users>();
        //select all query
        String selectQuery = "SELECT * FROM " + Contract.TUser.TABLE_USERS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Users users = new Users();
                users.setID(Integer.parseInt(cursor.getString(0)));
                users.setName(cursor.getString(1));
                users.setAge(cursor.getString(2));

                userList.add(users);
            } while (cursor.moveToNext());
        }

        return  userList;
    }

    //getting users count
    public int getUsersCount () {
        String countQuery = "SELECT * FROM " + Contract.TUser.TABLE_USERS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        return cursor.getCount();
    }

    //updating a single user
    public int updateUsers (Users users) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Contract.TUser.KEY_NAME, users.getName());
        values.put(Contract.TUser.KEY_AGE, users.getAge());

        //updating row
        return db.update(Contract.TUser.TABLE_USERS, values, Contract.TUser.KEY_ID + " = ? ",
                new String[] { String.valueOf(users.getID()) });
    }

    //deleting single user
    public void deleteUsers (Users users) {
        SQLiteDatabase db =  this.getWritableDatabase();
        db.delete(Contract.TUser.TABLE_USERS, Contract.TUser.KEY_ID + " = ?",
                new String[] {String.valueOf(users.getID()) });
        db.close();
    }

    /*
    *
    CRUD FUNCTIONS FOR VEHICLES TABLE
     *
     */

    //adding new vehicle
    public void addVehicle(Vehicles vehicles) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Contract.TVehicles.KEY_MK, vehicles.getMake());
        values.put(Contract.TVehicles.KEY_YR, vehicles.getYear());

        //inserting row
        db.insert(Contract.TVehicles.TABLE_VEHICLES, null, values);
        db.close(); //closing db connection
    }

    //getting single vehicle
    public Vehicles getVehicle (int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(Contract.TVehicles.TABLE_VEHICLES, new String[] {Contract.TVehicles.KEY_ID,
                        Contract.TVehicles.KEY_MK, Contract.TVehicles.KEY_YR }, Contract.TVehicles.KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Vehicles vehicles = new Vehicles(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2));

        return vehicles;
    }

    //getting all vehicles
    public List<Vehicles> getAllVehicles (){
        List <Vehicles> vehicleList = new ArrayList<Vehicles>();
        //select all query
        String selectQuery = "SELECT * FROM " + Contract.TVehicles.TABLE_VEHICLES;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Vehicles vehicles = new Vehicles();
                vehicles.setID(Integer.parseInt(cursor.getString(0)));
                vehicles.setMake(cursor.getString(1));
                vehicles.setYear(cursor.getString(2));

                vehicleList.add(vehicles);
            } while (cursor.moveToNext());
        }

        return  vehicleList;
    }

    //getting vehicles count
    public int getVehiclesCount () {
        String countQuery = "SELECT * FROM " + Contract.TVehicles.TABLE_VEHICLES;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        return cursor.getCount();
    }

    //updating a single vehicle
    public int updateVehicles (Vehicles vehicles) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Contract.TVehicles.KEY_MK, vehicles.getMake());
        values.put(Contract.TVehicles.KEY_YR, vehicles.getYear());

        //updating row
        return db.update(Contract.TVehicles.TABLE_VEHICLES, values, Contract.TVehicles.KEY_ID + " = ? ",
                new String[] { String.valueOf(vehicles.getID()) });
    }

    //deleting single vehicle
    public void deleteVehicle (Vehicles vehicles) {
        SQLiteDatabase db =  this.getWritableDatabase();
        db.delete(Contract.TVehicles.TABLE_VEHICLES, Contract.TVehicles.KEY_ID + " = ?",
                new String[] {String.valueOf(vehicles.getID()) });
        db.close();
    }

    /*
    *
    CRUD FUNCTIONS FOR COLORS TABLE
    *
    */

    //adding new color
    public void addColor(Colors colors) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Contract.TColors.KEY_COLOR1, colors.getColor1());
        values.put(Contract.TColors.KEY_COLOR2, colors.getColor2());

        //inserting row
        db.insert(Contract.TColors.TABLE_COLORS, null, values);
        db.close(); //closing db connection
    }

    //getting single color
    public Colors getColor (int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(Contract.TColors.TABLE_COLORS, new String[] {Contract.TColors.KEY_ID,
                        Contract.TColors.KEY_COLOR1, Contract.TColors.KEY_COLOR2 }, Contract.TColors.KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Colors colors = new Colors(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2));

        return colors;
    }

    //getting all colors
    public List<Colors> getAllColors (){
        List <Colors> colorList = new ArrayList<Colors>();
        //select all query
        String selectQuery = "SELECT * FROM " + Contract.TColors.TABLE_COLORS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Colors colors = new Colors();
                colors.setID(Integer.parseInt(cursor.getString(0)));
                colors.setColor1(cursor.getString(1));
                colors.setColor2(cursor.getString(2));

                colorList.add(colors);
            } while (cursor.moveToNext());
        }

        return  colorList;
    }

    //getting colors count
    public int getColorsCount () {
        String countQuery = "SELECT * FROM " + Contract.TColors.TABLE_COLORS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        return cursor.getCount();
    }

    //updating a single color
    public int updateColors (Colors colors) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Contract.TColors.KEY_COLOR1, colors.getColor1());
        values.put(Contract.TColors.KEY_COLOR2, colors.getColor2());

        //updating row
        return db.update(Contract.TColors.TABLE_COLORS, values, Contract.TColors.KEY_ID + " = ? ",
                new String[] { String.valueOf(colors.getID()) });
    }

    //deleting single color
    public void deleteColor (Colors colors) {
        SQLiteDatabase db =  this.getWritableDatabase();
        db.delete(Contract.TColors.TABLE_COLORS, Contract.TColors.KEY_ID + " = ?",
                new String[] {String.valueOf(colors.getID()) });
        db.close();
    }
}
