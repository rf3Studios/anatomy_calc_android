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

package com.rf3studios.anatomygradecalculator.adapters;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.rf3studios.anatomygradecalculator.gradeobjects.LectureGrades;
import com.rf3studios.anatomygradecalculator.providers.LectureGradeProvider;

public class LectureGradeAdapter
{
    private final LectureGradeProvider mGradeProvider;

    public LectureGradeAdapter(final SQLiteDatabase db)
    {
        this.mGradeProvider = new LectureGradeProvider(db);
    }

    public final boolean saveGrades(final LectureGrades grades)
    {
        if ( grades.id == -1 ) {
            final long _rowId = this.mGradeProvider.insertGrades(grades);

            if ( _rowId != -1 ) {
                return true;
            }
        }
        else {
            if ( this.mGradeProvider.updateGrades(grades) == 1 ) {
                return true;
            }
        }

        return false;
    }

    public final LectureGrades getAllGrades(final long rowId)
    {
        if ( rowId != -1 ) {
            return this.mGradeProvider.getAllGrades(rowId);
        }

        return null;
    }
}
