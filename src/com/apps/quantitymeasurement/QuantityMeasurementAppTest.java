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

    // FEET INEQUALITY
    @Test
    public void testFeetInequality() {

        Length l1 = new Length(1.0, LengthUnit.FEET);
        Length l2 = new Length(2.0, LengthUnit.FEET);

        assertFalse(l1.equals(l2));
    }

    // INCHES EQUALITY
    @Test
    public void testInchesEquality() {

        Length l1 = new Length(12.0, LengthUnit.INCHES);
        Length l2 = new Length(12.0, LengthUnit.INCHES);

        assertTrue(l1.equals(l2));
    }

    // INCHES INEQUALITY
    @Test
    public void testInchesInequality() {

        Length l1 = new Length(12.0, LengthUnit.INCHES);
        Length l2 = new Length(24.0, LengthUnit.INCHES);

        assertFalse(l1.equals(l2));
    }

    // FEET TO INCHES EQUALITY
    @Test
    public void testFeetInchesComparison() {

        Length feet = new Length(1.0, LengthUnit.FEET);
        Length inches = new Length(12.0, LengthUnit.INCHES);

        assertTrue(feet.equals(inches));
    }

    // YARD TO YARD SAME VALUE
    @Test
    public void testEquality_YardToYard_SameValue() {

        Length yard1 = new Length(1.0, LengthUnit.YARDS);
        Length yard2 = new Length(1.0, LengthUnit.YARDS);

        assertTrue(yard1.equals(yard2));
    }

    // YARD TO YARD DIFFERENT VALUE
    @Test
    public void testEquality_YardToYard_DifferentValue() {

        Length yard1 = new Length(1.0, LengthUnit.YARDS);
        Length yard2 = new Length(2.0, LengthUnit.YARDS);

        assertFalse(yard1.equals(yard2));
    }

    // YARD TO FEET EQUALITY
    @Test
    public void testEquality_YardToFeet_EquivalentValue() {

        Length yard = new Length(1.0, LengthUnit.YARDS);
        Length feet = new Length(3.0, LengthUnit.FEET);

        assertTrue(yard.equals(feet));
    }

    // FEET TO YARD EQUALITY
    @Test
    public void testEquality_FeetToYard_EquivalentValue() {

        Length feet = new Length(3.0, LengthUnit.FEET);
        Length yard = new Length(1.0, LengthUnit.YARDS);

        assertTrue(feet.equals(yard));
    }

    // YARD TO INCHES EQUALITY
    @Test
    public void testEquality_YardToInches_EquivalentValue() {

        Length yard = new Length(1.0, LengthUnit.YARDS);
        Length inches = new Length(36.0, LengthUnit.INCHES);

        assertTrue(yard.equals(inches));
    }

    // INCHES TO YARD EQUALITY
    @Test
    public void testEquality_InchesToYard_EquivalentValue() {

        Length inches = new Length(36.0, LengthUnit.INCHES);
        Length yard = new Length(1.0, LengthUnit.YARDS);

        assertTrue(inches.equals(yard));
    }

    // YARD TO FEET NON-EQUIVALENT
    @Test
    public void testEquality_YardToFeet_NonEquivalentValue() {

        Length yard = new Length(1.0, LengthUnit.YARDS);
        Length feet = new Length(2.0, LengthUnit.FEET);

        assertFalse(yard.equals(feet));
    }

    // CM TO INCH EQUALITY
    @Test
    public void testEquality_CentimetersToInches_EquivalentValue() {

        Length cm = new Length(2.54, LengthUnit.CENTIMETERS);
        Length inch = new Length(1.0, LengthUnit.INCHES);

        assertTrue(cm.equals(inch));
    }

    // CM TO FEET EQUALITY
    @Test
    public void testCmFeetComparison() {

        Length cm = new Length(30.48, LengthUnit.CENTIMETERS);
        Length feet = new Length(1.0, LengthUnit.FEET);

        assertTrue(cm.equals(feet));
    }

    // CM TO FEET NON-EQUIVALENT
    @Test
    public void testEquality_CentimetersToFeet_NonEquivalentValue() {

        Length cm = new Length(1.0, LengthUnit.CENTIMETERS);
        Length feet = new Length(1.0, LengthUnit.FEET);

        assertFalse(cm.equals(feet));
    }

    // TRANSITIVE PROPERTY
    @Test
    public void testEquality_MultiUnit_TransitiveProperty() {

        Length yard = new Length(1.0, LengthUnit.YARDS);
        Length feet = new Length(3.0, LengthUnit.FEET);
        Length inches = new Length(36.0, LengthUnit.INCHES);

        assertTrue(yard.equals(feet));
        assertTrue(feet.equals(inches));
        assertTrue(yard.equals(inches));
    }

    // COMPLEX SCENARIO
    @Test
    public void testEquality_AllUnits_ComplexScenario() {

        Length yard = new Length(2.0, LengthUnit.YARDS);
        Length feet = new Length(6.0, LengthUnit.FEET);
        Length inches = new Length(72.0, LengthUnit.INCHES);

        assertTrue(yard.equals(feet));
        assertTrue(feet.equals(inches));
        assertTrue(yard.equals(inches));
    }

    // YARD NULL UNIT
    @Test
    public void testEquality_YardWithNullUnit() {

        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Length(1.0, null)
        );

        assertEquals("Unit cannot be null", exception.getMessage());
    }

    // CM NULL UNIT
    @Test
    public void testEquality_CentimetersWithNullUnit() {

        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Length(1.0, null)
        );

        assertEquals("Unit cannot be null", exception.getMessage());
    }

    // SAME REFERENCE
    @Test
    public void testEquality_YardSameReference() {

        Length yard = new Length(1.0, LengthUnit.YARDS);

        assertTrue(yard.equals(yard));
    }

    // CM SAME REFERENCE
    @Test
    public void testEquality_CentimetersSameReference() {

        Length cm = new Length(1.0, LengthUnit.CENTIMETERS);

        assertTrue(cm.equals(cm));
    }

    // NULL COMPARISON
    @Test
    public void testEquality_YardNullComparison() {

        Length yard = new Length(1.0, LengthUnit.YARDS);

        assertFalse(yard.equals(null));
    }

    // CM NULL COMPARISON
    @Test
    public void testEquality_CentimetersNullComparison() {

        Length cm = new Length(1.0, LengthUnit.CENTIMETERS);

        assertFalse(cm.equals(null));
    }

    // DIFFERENT CLASS
    @Test
    public void testDifferentClass() {

        Length l1 = new Length(1.0, LengthUnit.FEET);

        assertFalse(l1.equals("hello"));
    }
}