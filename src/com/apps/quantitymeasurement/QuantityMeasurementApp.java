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

        // EQUALS METHOD
        @Override
        public boolean equals(Object obj) {

            // SAME REFERENCE CHECK
            if (this == obj) {
                return true;
            }

            // NULL CHECK
            if (obj == null) {
                return false;
            }

            // TYPE CHECK
            if (getClass() != obj.getClass()) {
                return false;
            }

            // TYPE CASTING
            Length other = (Length) obj;

            // FLOATING POINT COMPARISON
            return Math.abs(
                    this.toBaseUnit() - other.toBaseUnit()
            ) < 0.0001;
        }
    }

    // MAIN METHOD
    public static void main(String[] args) {

        // FEET AND INCHES COMPARISON
        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(12.0, LengthUnit.INCHES);

        System.out.println("Are lengths equal? " + length1.equals(length2));

        // YARDS AND INCHES COMPARISON
        Length length3 = new Length(1.0, LengthUnit.YARDS);
        Length length4 = new Length(36.0, LengthUnit.INCHES);

        System.out.println("Are lengths equal? " + length3.equals(length4));

        // CENTIMETERS AND INCHES COMPARISON
        Length length5 = new Length(100.0, LengthUnit.CENTIMETERS);
        Length length6 = new Length(39.3701, LengthUnit.INCHES);

        System.out.println("Are lengths equal? " + length5.equals(length6));
    }
}