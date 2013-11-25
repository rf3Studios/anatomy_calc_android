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

package com.rf3studios.anatomygradecalculator.fragments;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.rf3studios.anatomygradecalculator.R;
import com.rf3studios.anatomygradecalculator.adapters.LectureGradeAdapter;
import com.rf3studios.anatomygradecalculator.database.DbHelper;
import com.rf3studios.anatomygradecalculator.gradeobjects.LectureGrades;
import com.rf3studios.anatomygradecalculator.utils.LectureUtil;

public class LectureFragment extends Fragment implements View.OnFocusChangeListener
{
    private EditText mExam1;
    private EditText mExam2;
    private EditText mExam3;
    private EditText mExam4;

    private EditText mFinalExam;

    private EditText mQuiz1;
    private EditText mQuiz2;
    private EditText mQuiz3;
    private EditText mQuiz4;
    private EditText mQuiz5;
    private EditText mQuiz6;
    private EditText mQuiz7;
    private EditText mQuiz8;
    private EditText mQuiz9;
    private EditText mQuiz10;
    private EditText mQuiz11;

    private EditText mAttendance;

    private TextView mTEMPAvgExam;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View _rootView = inflater.inflate(R.layout.fragment_lecture, container, false);

        setHasOptionsMenu(true);

        return _rootView;
    }

    @Override
    public void onResume()
    {
        super.onResume();
        this.buildUiElements();
        this.setAllGrades();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        inflater.inflate(R.menu.grades, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item)
    {
        // Get the item that the user selected
        switch ( item.getItemId() ) {
            // Save Grades Menu Item
            case R.id.save_grades:
                this.saveGrades();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void buildUiElements()
    {
        // Get all the grades from the EditText boxes
        this.mExam1 = (EditText) this.getView().findViewById(R.id.editTextLecExam1);
        this.mExam2 = (EditText) this.getView().findViewById(R.id.editTextLecExam2);
        this.mExam3 = (EditText) this.getView().findViewById(R.id.editTextLecExam3);
        this.mExam4 = (EditText) this.getView().findViewById(R.id.editTextLecExam4);

        this.mFinalExam = (EditText) this.getView().findViewById(R.id.editTextLecFinalExam);

        this.mQuiz1 = (EditText) this.getView().findViewById(R.id.editTextLecQuiz1);
        this.mQuiz2 = (EditText) this.getView().findViewById(R.id.editTextLecQuiz2);
        this.mQuiz3 = (EditText) this.getView().findViewById(R.id.editTextLecQuiz3);
        this.mQuiz4 = (EditText) this.getView().findViewById(R.id.editTextLecQuiz4);
        this.mQuiz5 = (EditText) this.getView().findViewById(R.id.editTextLecQuiz5);
        this.mQuiz6 = (EditText) this.getView().findViewById(R.id.editTextLecQuiz6);
        this.mQuiz7 = (EditText) this.getView().findViewById(R.id.editTextLecQuiz7);
        this.mQuiz8 = (EditText) this.getView().findViewById(R.id.editTextLecQuiz8);
        this.mQuiz9 = (EditText) this.getView().findViewById(R.id.editTextLecQuiz9);
        this.mQuiz10 = (EditText) this.getView().findViewById(R.id.editTextLecQuiz10);
        this.mQuiz11 = (EditText) this.getView().findViewById(R.id.editTextLecQuiz11);

        this.mAttendance = (EditText) this.getView().findViewById(R.id.editTextLecDaysMissed);

        // TODO Temporary
        this.mTEMPAvgExam = (TextView) this.getView().findViewById(R.id.textViewAvgExamGrade);
    }

    private void setAllGrades()
    {
        SQLiteDatabase _db = new DbHelper(this.getActivity()).getWritableDatabase();
        LectureGradeAdapter _adapter = new LectureGradeAdapter(_db);

        LectureGrades _grades = _adapter.getAllGrades(1);

        this.mExam1.setText(String.valueOf(_grades.exam1));
        this.mExam2.setText(String.valueOf(_grades.exam2));
        this.mExam3.setText(String.valueOf(_grades.exam3));
        this.mExam4.setText(String.valueOf(_grades.exam4));

        this.mFinalExam.setText(String.valueOf(_grades.finalExam));

        this.mQuiz1.setText(String.valueOf(_grades.quiz1));
        this.mQuiz2.setText(String.valueOf(_grades.quiz2));
        this.mQuiz3.setText(String.valueOf(_grades.quiz3));
        this.mQuiz4.setText(String.valueOf(_grades.quiz4));
        this.mQuiz5.setText(String.valueOf(_grades.quiz5));
        this.mQuiz6.setText(String.valueOf(_grades.quiz6));
        this.mQuiz7.setText(String.valueOf(_grades.quiz7));
        this.mQuiz8.setText(String.valueOf(_grades.quiz8));
        this.mQuiz9.setText(String.valueOf(_grades.quiz9));
        this.mQuiz10.setText(String.valueOf(_grades.quiz10));
        this.mQuiz11.setText(String.valueOf(_grades.quiz11));

        this.mAttendance.setText(String.valueOf(_grades.attendance));

        LectureUtil _lecUtil = new LectureUtil(_grades);
        this.mTEMPAvgExam.setText(String.valueOf(_lecUtil.getAverageExamGrade()));

        _db.close();
    }

    private LectureGrades getAllGrades()
    {
        // Load the grades into the Lecture grades class
        LectureGrades _grades = new LectureGrades();

        _grades.exam1 = Double.valueOf(this.mExam1.getText().toString());
        _grades.exam2 = Double.valueOf(this.mExam2.getText().toString());
        _grades.exam3 = Double.valueOf(this.mExam3.getText().toString());
        _grades.exam4 = Double.valueOf(this.mExam4.getText().toString());

        _grades.finalExam = Double.valueOf(this.mFinalExam.getText().toString());

        _grades.quiz1 = Integer.valueOf(this.mQuiz1.getText().toString());
        _grades.quiz2 = Integer.valueOf(this.mQuiz2.getText().toString());
        _grades.quiz3 = Integer.valueOf(this.mQuiz3.getText().toString());
        _grades.quiz4 = Integer.valueOf(this.mQuiz4.getText().toString());
        _grades.quiz5 = Integer.valueOf(this.mQuiz5.getText().toString());
        _grades.quiz6 = Integer.valueOf(this.mQuiz6.getText().toString());
        _grades.quiz7 = Integer.valueOf(this.mQuiz7.getText().toString());
        _grades.quiz8 = Integer.valueOf(this.mQuiz8.getText().toString());
        _grades.quiz9 = Integer.valueOf(this.mQuiz9.getText().toString());
        _grades.quiz10 = Integer.valueOf(this.mQuiz10.getText().toString());
        _grades.quiz11 = Integer.valueOf(this.mQuiz11.getText().toString());

        _grades.attendance = Integer.valueOf(this.mAttendance.getText().toString());

        // Create the overall grade from all the other grades
        LectureUtil _lecUtil = new LectureUtil(_grades);
        _grades.overallGrade = _lecUtil.getOverallGrade();

        return _grades;
    }

    /**
     * Saves the grades to the database
     *
     * @return
     */
    private boolean saveGrades()
    {
        SQLiteDatabase _db = new DbHelper(this.getActivity()).getWritableDatabase();
        LectureGradeAdapter _adapter = new LectureGradeAdapter(_db);

        final boolean _saveSuccess = _adapter.saveGrades(this.getAllGrades());

        if ( _saveSuccess ) {
            Toast.makeText(this.getActivity(), "Grades Successfully Saved", Toast.LENGTH_SHORT)
                 .show();
        }
        else {
            Toast.makeText(this.getActivity(), "Save Failed! Grades NOT Saved!", Toast.LENGTH_SHORT)
                 .show();
        }

        _db.close();

        return _saveSuccess;
    }

    /**
     * Called when the focus state of a view has changed.
     *
     * @param v
     *         The view whose state has changed.
     * @param hasFocus
     *         The new focus state of v.
     */
    @Override
    public void onFocusChange(final View v, final boolean hasFocus)
    {
        this.setAllGrades();
    }
}