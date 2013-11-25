/*
 * Project: Anatomy Grade Calculator
 * Copyright (C)2013 Rich Friedel
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see {http://www.gnu.org/licenses/}.
 */

package com.rf3studios.anatomygradecalculator.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.rf3studios.anatomygradecalculator.utils.DbUtils;

public class DbHelper extends SQLiteOpenHelper
{
    private static final String DB_NAME            = "anatomy_db";
    private static final int    DB_CURRENT_VERSION = 1;

    private final DbUtils mDbUtils;

    public DbHelper(final Context context)
    {
        super(context, DB_NAME, null, DB_CURRENT_VERSION);

        this.mDbUtils = new DbUtils(context);
    }

    /**
     * Called when the database is created for the first time. This is where the
     * creation of tables and the initial population of the tables should happen.
     *
     * @param db
     *         The database.
     */
    @Override
    public void onCreate(final SQLiteDatabase db)
    {
        this.mDbUtils.createLectureGradesTable(db);
    }

    /**
     * Called when the database needs to be upgraded. The implementation
     * should use this method to drop tables, add tables, or do anything else it
     * needs to upgrade to the new schema version.
     * <p/>
     * <p>
     * The SQLite ALTER TABLE documentation can be found
     * <a href="http://sqlite.org/lang_altertable.html">here</a>. If you add new columns
     * you can use ALTER TABLE to insert them into a live table. If you rename or remove columns
     * you can use ALTER TABLE to rename the old table, then create the new table and then
     * populate the new table with the contents of the old table.
     * </p><p>
     * This method executes within a transaction.  If an exception is thrown, all changes
     * will automatically be rolled back.
     * </p>
     *
     * @param db
     *         The database.
     * @param oldVersion
     *         The old database version.
     * @param newVersion
     *         The new database version.
     */
    @Override
    public void onUpgrade(final SQLiteDatabase db, final int oldVersion, final int newVersion)
    {

    }
}
