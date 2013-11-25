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

package com.rf3studios.anatomygradecalculator.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.rf3studios.anatomygradecalculator.providers.LectureGradeProvider;

public class DbUtils
{
    private final Context mCtx;

    public DbUtils(final Context context)
    {
        this.mCtx = context;
    }

    public final void createLectureGradesTable(final SQLiteDatabase db)
    {
        Log.i("DbUtil", "Creating Lecture Grades Table...");

        // Create Lecture Grades Table
        final String _lecGradesMakeTable = "CREATE Table IF NOT EXISTS "
                                            + LectureGradeProvider.LECTURE_TABLE_NAME
                                            + " (`"
                                            + LectureGradeProvider.LECTURE_ROW_ID
                                            + "` INTEGER PRIMARY KEY AUTOINCREMENT, `"
                                            + LectureGradeProvider.LECTURE_EXAM_1
                                            + "` REAL DEFAULT 100.0, `"
                                            + LectureGradeProvider.LECTURE_EXAM_2
                                            + "` REAL DEFAULT 100.0, `"
                                            + LectureGradeProvider.LECTURE_EXAM_3
                                            + "` REAL DEFAULT 100.0, `"
                                            + LectureGradeProvider.LECTURE_EXAM_4
                                            + "` REAL DEFAULT 100.0, `"
                                            + LectureGradeProvider.LECTURE_EXAM_FINAL
                                            + "` REAL DEFAULT 10, `"
                                            + LectureGradeProvider.LECTURE_QUIZ_1
                                            + "` INTEGER DEFAULT 10, `"
                                            + LectureGradeProvider.LECTURE_QUIZ_2
                                            + "` INTEGER DEFAULT 10, `"
                                            + LectureGradeProvider.LECTURE_QUIZ_3
                                            + "` INTEGER DEFAULT 10, `"
                                            + LectureGradeProvider.LECTURE_QUIZ_4
                                            + "` INTEGER DEFAULT 10, `"
                                            + LectureGradeProvider.LECTURE_QUIZ_5
                                            + "` INTEGER DEFAULT 10, `"
                                            + LectureGradeProvider.LECTURE_QUIZ_6
                                            + "` INTEGER DEFAULT 10, `"
                                            + LectureGradeProvider.LECTURE_QUIZ_7
                                            + "` INTEGER DEFAULT 10, `"
                                            + LectureGradeProvider.LECTURE_QUIZ_8
                                            + "` INTEGER DEFAULT 10, `"
                                            + LectureGradeProvider.LECTURE_QUIZ_9
                                            + "` INTEGER DEFAULT 10, `"
                                            + LectureGradeProvider.LECTURE_QUIZ_10
                                            + "` INTEGER DEFAULT 10, `"
                                            + LectureGradeProvider.LECTURE_QUIZ_11
                                            + "` INTEGER DEFAULT 10, `"
                                            + LectureGradeProvider.LECTURE_ATTENDANCE
                                            + "` INTEGER DEFAULT 0, `"
                                            + LectureGradeProvider.LECTURE_OVERALL_GRADE
                                            +"` REAL DEFAULT 100.0"
                                            + ");";

        db.execSQL(_lecGradesMakeTable);
    }
}
