package v.strathmore.com.lab3;

import android.provider.BaseColumns;

/**
 * Created by wainj on 23/10/2017.
 */

public class Contract {

    public static abstract class TUser implements BaseColumns {
        public static final String TABLE_USERS = "Users";

        //column names
        public static final String KEY_ID = "id";
        public static final String KEY_NAME = "name";
        public static final String KEY_AGE = "age";

        //create table
        public static String CREATE_USERS_TABLE = "CREATE TABLE " + TABLE_USERS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_AGE + " INTEGER" + ")";

        public static String DROP_USERS_TABLE = "DROP TABLE IF EXISTS " + TABLE_USERS;

    }

    public static abstract class TVehicles implements BaseColumns {
        public static final String TABLE_VEHICLES = "Vehicles";

        //column names
        public static final String KEY_ID = "id";
        public static final String KEY_MK = "make";
        public static final String KEY_YR = "year";

        //create table
        public static String CREATE_VEHICLES_TABLE = "CREATE TABLE " + TABLE_VEHICLES + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_MK + " TEXT,"
                + KEY_YR + " TEXT" + ")";

        public static String DROP_VEHICLES_TABLE = "DROP TABLE IF EXISTS " + TABLE_VEHICLES;
    }

    public static abstract class TColors implements BaseColumns {
        public static final String TABLE_COLORS = "Colors";

        //column names
        public static final String KEY_ID = "id";
        public static final String KEY_COLOR1 = "color1";
        public static final String KEY_COLOR2 = "color2";

        //create tables
        public static String CREATE_COLORS_TABLE = "CREATE TABLE " + TABLE_COLORS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_COLOR1 + " TEXT,"
                + KEY_COLOR2 + " TEXT" + ")";

        public static String DROP_COLORS_TABLE = "DROP TABLE IF EXISTS " + TABLE_COLORS;
    }
}
