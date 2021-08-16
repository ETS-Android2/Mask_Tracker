package mtirtapradja.project.huawei.masktracker;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {

    private static final String HISTORY_TABLE = "HISTORY_TABLE";
    private static final String COLUMN_HISTORY_REASON = "REASON";
    private static final String COLUMN_HISTORY_CHANGE_TIME = "CHANGE_TIME";
    private static final String COLUMN_ID = "ID";

    public DataBaseHelper(@Nullable Context context) {
        super(context, "history.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE " + HISTORY_TABLE +
                "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_HISTORY_REASON + " TEXT, "+ COLUMN_HISTORY_CHANGE_TIME + "DATETIME)";

        db.execSQL(createTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
