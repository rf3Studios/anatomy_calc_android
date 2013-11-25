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

import com.rf3studios.anatomygradecalculator.gradeobjects.LectureGrades;

public class LectureUtil
{
    private Double[] mExams;
    private Integer[] mQuizzes;
    private double   mFinalExam;
    private int      mAttendance;

    public LectureUtil(final LectureGrades grades)
    {
        mExams = new Double[4];
        mExams[0] = grades.exam1;
        mExams[1] = grades.exam2;
        mExams[2] = grades.exam3;
        mExams[3] = grades.exam4;

        mFinalExam = grades.finalExam;

        mQuizzes = new Integer[11];
        mQuizzes[0] = grades.quiz1;
        mQuizzes[1] = grades.quiz2;
        mQuizzes[2] = grades.quiz3;
        mQuizzes[3] = grades.quiz4;
        mQuizzes[4] = grades.quiz5;
        mQuizzes[5] = grades.quiz6;
        mQuizzes[6] = grades.quiz7;
        mQuizzes[7] = grades.quiz8;
        mQuizzes[8] = grades.quiz9;
        mQuizzes[9] = grades.quiz10;
        mQuizzes[10] = grades.quiz11;

        mAttendance = grades.attendance;
    }

    /**
     * Returns the overall weighted grade for Lecture
     *
     * @return
     */
    public final double getOverallGrade()
    {
        double _grade = (this.getWeightedExamGrade() + this.getWeightedQuizGrade() + this
                .getWeightedFinalExamGrade()) * 0.75;

        /*
         * Attendance deduction
         *
         * 0 pts per class missed up to 3 classes missed
         * 2 pts per class missed after 3 classes missed
         * 7 missed classes results in automatic failure
         */
        if ( this.mAttendance > 7 ) {
            return 00.00;
        }
        else if ( this.mAttendance > 3 ) {
            return _grade - ((this.mAttendance - 3) * 2);
        }
        else {
            return _grade;
        }
    }

    /**
     * Returns the average of all exam grades
     *
     * @return
     */
    public double getAverageExamGrade()
    {
        double _grade = 0.0;

        // TODO Finish method
        for ( Double exam : mExams )
        {
            _grade += exam;
        }

        _grade = _grade / mExams.length;

        return _grade;
    }

    /**
     * Returns the average of all quiz grades
     *
     * @return
     */
    private double getAverageQuizGrade()
    {
        double _grade = 0.0;

        // TODO Finish method

        return _grade;
    }

    /**
     * Returns the weighted value of the exam grades
     *
     * @return
     */
    private double getWeightedExamGrade()
    {
        return getAverageExamGrade() * 0.7;
    }

    /**
     * Returns the weighted value of the final exam grade
     *
     * @return
     */
    private double getWeightedFinalExamGrade()
    {
        return mFinalExam * 0.2;
    }

    /**
     * Returns the weighted value of all the quiz grades
     *
     * @return
     */
    private double getWeightedQuizGrade()
    {
        return getAverageQuizGrade() * 0.1;
    }
}
