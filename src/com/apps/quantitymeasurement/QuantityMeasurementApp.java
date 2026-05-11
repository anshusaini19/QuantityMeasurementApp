package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    // ENUM FOR LENGTH UNITS
    public enum LengthUnit {

        FEET(12.0),
        INCHES(1.0),
        YARDS(36.0),
        CENTIMETERS(0.393701);

        private final double conversionFactor;

        LengthUnit(double conversionFactor) {
            this.conversionFactor = conversionFactor;
        }

        public double getConversionFactor() {
            return conversionFactor;
        }
    }

    // GENERIC LENGTH CLASS
    public static class Length {

        private final double value;
        private final LengthUnit unit;

        public Length(double value, LengthUnit unit) {

            if (unit == null) {
                throw new IllegalArgumentException("Unit cannot be null");
            }

            this.value = value;
            this.unit = unit;
        }

        // CONVERT TO BASE UNIT (INCHES)
        private double toBaseUnit() {
            return value * unit.getConversionFactor();
        }

        @Override
public boolean equals(Object obj) {

    if (this == obj) {
        return true;
    }

    if (obj == null) {
        return false;
    }

    if (getClass() != obj.getClass()) {
        return false;
    }

    Length other = (Length) obj;

    return Math.abs(
            this.toBaseUnit() - other.toBaseUnit()
    ) < 0.0001;
}
    }

    // MAIN METHOD
    public static void main(String[] args) {

        Length feet = new Length(3.0, LengthUnit.FEET);
        Length yard = new Length(1.0, LengthUnit.YARDS);

        System.out.println(feet.equals(yard)); // true

        Length cm = new Length(2.54, LengthUnit.CENTIMETERS);
        Length inch = new Length(1.0, LengthUnit.INCHES);

        System.out.println(cm.equals(inch)); // true
    }
}