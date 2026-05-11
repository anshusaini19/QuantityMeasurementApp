package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import com.apps.quantitymeasurement.QuantityMeasurementApp.Length;
import com.apps.quantitymeasurement.QuantityMeasurementApp.LengthUnit;

public class QuantityMeasurementAppTest {

    // FEET EQUALITY
    @Test
    public void testFeetEquality() {

        Length l1 = new Length(1.0, LengthUnit.FEET);
        Length l2 = new Length(1.0, LengthUnit.FEET);

        assertTrue(l1.equals(l2));
    }

    // INCHES EQUALITY
    @Test
    public void testInchesEquality() {

        Length l1 = new Length(12.0, LengthUnit.INCHES);
        Length l2 = new Length(12.0, LengthUnit.INCHES);

        assertTrue(l1.equals(l2));
    }

    // FEET-INCHES COMPARISON
    @Test
    public void testFeetInchesComparison() {

        Length feet = new Length(1.0, LengthUnit.FEET);
        Length inches = new Length(12.0, LengthUnit.INCHES);

        assertTrue(feet.equals(inches));
    }

    // YARD TO FEET
    @Test
    public void testYardFeetComparison() {

        Length yard = new Length(1.0, LengthUnit.YARDS);
        Length feet = new Length(3.0, LengthUnit.FEET);

        assertTrue(yard.equals(feet));
    }

    // YARD TO INCHES
    @Test
    public void testYardInchesComparison() {

        Length yard = new Length(1.0, LengthUnit.YARDS);
        Length inches = new Length(36.0, LengthUnit.INCHES);

        assertTrue(yard.equals(inches));
    }

    // CM TO INCH
    @Test
    public void testCmInchesComparison() {

        Length cm = new Length(2.54, LengthUnit.CENTIMETERS);
        Length inch = new Length(1.0, LengthUnit.INCHES);

        assertTrue(cm.equals(inch));
    }

    // CM TO FEET
    @Test
    public void testCmFeetComparison() {

        Length cm = new Length(30.48, LengthUnit.CENTIMETERS);
        Length feet = new Length(1.0, LengthUnit.FEET);

        assertTrue(cm.equals(feet));
    }

    // SAME REFERENCE
    @Test
    public void testSameReference() {

        Length l1 = new Length(1.0, LengthUnit.FEET);

        assertTrue(l1.equals(l1));
    }

    // NULL CHECK
    @Test
    public void testNullComparison() {

        Length l1 = new Length(1.0, LengthUnit.FEET);

        assertFalse(l1.equals(null));
    }

    // DIFFERENT CLASS
    @Test
    public void testDifferentClass() {

        Length l1 = new Length(1.0, LengthUnit.FEET);

        assertFalse(l1.equals("hello"));
    }
}