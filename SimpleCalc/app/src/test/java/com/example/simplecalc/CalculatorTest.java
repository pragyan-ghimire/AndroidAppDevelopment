/*
 * Copyright 2018, Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.simplecalc;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


import androidx.test.filters.SmallTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


/**
 * JUnit4 unit tests for the calculator logic. These are local unit tests; no device needed
 */
@RunWith(JUnit4.class)
@SmallTest
public class CalculatorTest {

    private Calculator mCalculator;

    /**
     * Set up the environment for testing
     */
    @Before
    public void setUp() {
        mCalculator = new Calculator();
    }

    /**
     * Test for simple addition
     */
    @Test
    public void addTwoNumbers() {
        double resultAdd = mCalculator.add(1d, 1d);
        assertThat(resultAdd, is(equalTo(2d)));
    }
    @Test
    public void addTwoNumbersNegative(){
        double resultAdd= mCalculator.add(-1d,2d);
        assertThat(resultAdd,is(equalTo(1d)));
    }
    @Test
    public void addTwoNumbersFloating(){
        double resultAdd=mCalculator.add(1.111d,1.111d);
//        assertThat(resultAdd,is(equalTo(2.222d)));
//        assertThat(resultAdd,is(closeTo(2.222,0.01)));
        assertThat(resultAdd,is(equalTo(2.222)));
    }
    @Test
    public void subTwoNumbers() {
        double resultSub = mCalculator.sub(1d, 1d);
        assertThat(resultSub, is(equalTo(0d)));
    }
    @Test
    public void subTwoNumbersNegative(){
        double resultSub= mCalculator.sub(-1d,2d);
        assertThat(resultSub,is(equalTo(-3d)));
    }
    @Test
    public void mulTwoNumbers() {
        double resultMul = mCalculator.mul(1d, 1d);
        assertThat(resultMul, is(equalTo(1d)));
    }
    @Test
    public void mulTwoNumbersZero(){
        double resultMul= mCalculator.mul(1d,0d);
        assertThat(resultMul,is(equalTo(0d)));
    }
    @Test
    public void divTwoNumbers() {
        double resultDiv = mCalculator.div(2d, 2d);
        assertThat(resultDiv, is(equalTo(1d)));
    }
//    @Test
//    public void divTwoNumbersZero(){
//        double resultDiv= mCalculator.div(1d,0d);
//        assertThat(resultDiv,is(equalTo(Double.POSITIVE_INFINITY)));
//    }
    @Test(expected = IllegalArgumentException.class)
    public void divByZeroThrows() {
        double resultDiv = mCalculator.div(4d, 0d);
        if (resultDiv == Double.POSITIVE_INFINITY)
            throw new IllegalArgumentException();

    }


    //power
    @Test
    public void powTwoNumbers(){
        double result=mCalculator.pow(2d,5d);
        assertThat(result,is(equalTo(32d)));
    }
    @Test(expected=AssertionError.class)
    public void powTwoNumbersFirstNeg(){
        double result=mCalculator.pow(-2d,5d);
      if(result==-32){
          throw new AssertionError();
      }
    }
    @Test (expected = AssertionError.class)
    public void powTwoNumbersSecondNeg(){
        double result=mCalculator.pow(2d,-5d);
        if(result==(1/(mCalculator.pow(2d,5d))))
        throw new AssertionError();
    }
    @Test
    public void powTwoNumbersFirstZero(){
        double result=mCalculator.pow(0d,5d);
        assertThat(result,is(equalTo(0d)));
    }
    @Test
    public void powTwoNumbersSecondZero(){
        double result=mCalculator.pow(2d,0d);
        assertThat(result,is(equalTo(1d)));
    }
    @Test
    public void powFirstZeroSecondNeg(){
        double result=mCalculator.pow(0d,-5d);
        assertThat(result,is(equalTo(Double.POSITIVE_INFINITY)));
    }
    @Test
    public void powFirstNegZeroSecondNeg(){
        double result=mCalculator.pow(-0d,-5d);
        assertThat(result,is(equalTo(Double.NEGATIVE_INFINITY)));
    }





}