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

package com.rf3studios.anatomygradecalculator.providers;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;

import com.rf3studios.anatomygradecalculator.gradeobjects.LectureGrades;

public class LectureGradeProvider
{
    private final SQLiteDatabase mDb;

    public static final String LECTURE_TABLE_NAME    = "lecture_grades";
    public static final String LECTURE_ROW_ID        = "_id";
    public static final String LECTURE_EXAM_1        = "exam_1";
    public static final String LECTURE_EXAM_2        = "exam_2";
    public static final String LECTURE_EXAM_3        = "exam_3";
    public static final String LECTURE_EXAM_4        = "exam_4";
    public static final String LECTURE_EXAM_FINAL    = "exam_final";
    public static final String LECTURE_QUIZ_1        = "quiz_1";
    public static final String LECTURE_QUIZ_2        = "quiz_2";
    public static final String LECTURE_QUIZ_3        = "quiz_3";
    public static final String LECTURE_QUIZ_4        = "quiz_4";
    public static final String LECTURE_QUIZ_5        = "quiz_5";
    public static final String LECTURE_QUIZ_6        = "quiz_6";
    public static final String LECTURE_QUIZ_7        = "quiz_7";
    public static final String LECTURE_QUIZ_8        = "quiz_8";
    public static final String LECTURE_QUIZ_9        = "quiz_9";
    public static final String LECTURE_QUIZ_10       = "quiz_10";
    public static final String LECTURE_QUIZ_11       = "quiz_11";
    public static final String LECTURE_ATTENDANCE    = "attendance";
    public static final String LECTURE_OVERALL_GRADE = "overall_grade";

    public LectureGradeProvider(final SQLiteDatabase db)
    {
        this.mDb = db;
    }

    public LectureGrades getAllGrades(final long rowId)
    {
        LectureGrades _grades = new LectureGrades();

        try {
            Cursor _cursor = this.mDb
                    .query(LECTURE_TABLE_NAME, null, LECTURE_ROW_ID + "=" + rowId, null, null, null,
                           null);

            if ( _cursor != null ) {
                if ( _cursor.moveToFirst() ) {
                    // Build lecture object
                    _grades = this.buildLectureObject(_cursor);
                }
            }
        }
        catch ( final CursorIndexOutOfBoundsException e ) {
            Log.wtf("LectureProvider", "Cursor is out of bounds! Error: " + e.toString());
        }

        return _grades;
    }

    public final long insertGrades(final LectureGrades lecGrades)
    {
        long _rowId = -1;

        try {
            _rowId = this.mDb.insert(LECTURE_TABLE_NAME, null, this.setGradeVals(lecGrades));
        }
        catch ( final SQLiteException e ) {
            Log.wtf("LECTURE GRADES", "Database insert error: " + e.toString());
        }

        return _rowId;
    }

    public final int updateGrades(final LectureGrades grades)
    {
        int _affectedRows = 0;

        try {
            _affectedRows = this.mDb.update(LECTURE_TABLE_NAME, this.setGradeVals(grades),
                                            LECTURE_ROW_ID + "=" + grades.id, null);
        }
        catch ( final SQLiteException e ) {
            Log.wtf("LectureProvider",
                    "There was an error updating the database! Error: " + e.toString());
        }

        return _affectedRows;
    }

    private LectureGrades buildLectureObject(final Cursor lectureGrades)
    {
        final LectureGrades _grades = new LectureGrades();

        _grades.id = lectureGrades.getInt(lectureGrades.getColumnIndex(LECTURE_ROW_ID));
        _grades.exam1 = lectureGrades.getDouble(lectureGrades.getColumnIndex(LECTURE_EXAM_1));
        _grades.exam2 = lectureGrades.getDouble(lectureGrades.getColumnIndex(LECTURE_EXAM_2));
        _grades.exam3 = lectureGrades.getDouble(lectureGrades.getColumnIndex(LECTURE_EXAM_3));
        _grades.exam4 = lectureGrades.getDouble(lectureGrades.getColumnIndex(LECTURE_EXAM_4));

        _grades.finalExam = lectureGrades
                .getDouble(lectureGrades.getColumnIndex(LECTURE_EXAM_FINAL));

        _grades.quiz1 = lectureGrades.getInt(lectureGrades.getColumnIndex(LECTURE_QUIZ_1));
        _grades.quiz2 = lectureGrades.getInt(lectureGrades.getColumnIndex(LECTURE_QUIZ_2));
        _grades.quiz3 = lectureGrades.getInt(lectureGrades.getColumnIndex(LECTURE_QUIZ_3));
        _grades.quiz4 = lectureGrades.getInt(lectureGrades.getColumnIndex(LECTURE_QUIZ_4));
        _grades.quiz5 = lectureGrades.getInt(lectureGrades.getColumnIndex(LECTURE_QUIZ_5));
        _grades.quiz6 = lectureGrades.getInt(lectureGrades.getColumnIndex(LECTURE_QUIZ_6));
        _grades.quiz7 = lectureGrades.getInt(lectureGrades.getColumnIndex(LECTURE_QUIZ_7));
        _grades.quiz8 = lectureGrades.getInt(lectureGrades.getColumnIndex(LECTURE_QUIZ_8));
        _grades.quiz9 = lectureGrades.getInt(lectureGrades.getColumnIndex(LECTURE_QUIZ_9));
        _grades.quiz10 = lectureGrades.getInt(lectureGrades.getColumnIndex(LECTURE_QUIZ_10));
        _grades.quiz11 = lectureGrades.getInt(lectureGrades.getColumnIndex(LECTURE_QUIZ_11));

        _grades.attendance = lectureGrades.getInt(lectureGrades.getColumnIndex(LECTURE_ATTENDANCE));

        _grades.overallGrade = lectureGrades
                .getDouble(lectureGrades.getColumnIndex(LECTURE_OVERALL_GRADE));

        return _grades;
    }

    private ContentValues setGradeVals(final LectureGrades lecGrades)
    {
        final ContentValues _lecGrades = new ContentValues();

        _lecGrades.put(LECTURE_EXAM_1, lecGrades.exam1);
        _lecGrades.put(LECTURE_EXAM_2, lecGrades.exam2);
        _lecGrades.put(LECTURE_EXAM_3, lecGrades.exam3);
        _lecGrades.put(LECTURE_EXAM_4, lecGrades.exam4);

        _lecGrades.put(LECTURE_EXAM_FINAL, lecGrades.finalExam);

        _lecGrades.put(LECTURE_QUIZ_1, lecGrades.quiz1);
        _lecGrades.put(LECTURE_QUIZ_2, lecGrades.quiz2);
        _lecGrades.put(LECTURE_QUIZ_3, lecGrades.quiz3);
        _lecGrades.put(LECTURE_QUIZ_4, lecGrades.quiz4);
        _lecGrades.put(LECTURE_QUIZ_5, lecGrades.quiz5);
        _lecGrades.put(LECTURE_QUIZ_6, lecGrades.quiz6);
        _lecGrades.put(LECTURE_QUIZ_7, lecGrades.quiz7);
        _lecGrades.put(LECTURE_QUIZ_8, lecGrades.quiz8);
        _lecGrades.put(LECTURE_QUIZ_9, lecGrades.quiz9);
        _lecGrades.put(LECTURE_QUIZ_10, lecGrades.quiz10);
        _lecGrades.put(LECTURE_QUIZ_11, lecGrades.quiz11);

        _lecGrades.put(LECTURE_ATTENDANCE, lecGrades.attendance);

        _lecGrades.put(LECTURE_OVERALL_GRADE, lecGrades.overallGrade);

        return _lecGrades;
    }
}
