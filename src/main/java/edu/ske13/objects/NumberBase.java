package edu.ske13.objects;

import edu.ske13.constants.Base;

/**
 * @author kamontat
 * @version 1.0
 * @since Sun 05/Nov/2017 - 20:38
 */
public class NumberBase extends Number implements Comparable<NumberBase>, Operable<NumberBase> {
    private String number;
    private Base base;
    
    public NumberBase(String number) {
        this(number, Base.Decimal);
    }
    
    public NumberBase(int number) {
        this(number, Base.Decimal);
    }
    
    public NumberBase(String number, Base base) {
        this.number = number;
        this.base = base;
    }
    
    public NumberBase(int number, Base base) {
        this(String.valueOf(number), base);
    }
    
    public Base getBase() {
        return base;
    }
    
    public NumberBase setBase(Base base) {
        this.number = convert(number, this.base, base);
        this.base = base;
        return this;
    }
    
    public NumberBase createNew(Base base) {
        return new NumberBase(convert(number, this.base, base), base);
    }
    
    @Override
    public int compareTo(NumberBase o) {
        return Integer.compare(intValue(), o.intValue());
    }
    
    /**
     * get decimal number
     *
     * @return decimal number
     */
    @Override
    public int intValue() {
        return Integer.parseUnsignedInt(number, base.getBase());
    }
    
    @Override
    public long longValue() {
        return Long.parseUnsignedLong(number, base.getBase());
    }
    
    @Override
    public float floatValue() {
        return (float) intValue();
    }
    
    @Override
    public double doubleValue() {
        return (double) intValue();
    }
    
    public String binaryValue() {
        return createNew(Base.Binary).number;
    }
    
    /**
     * get number of input base
     *
     * @return number of input base
     */
    public String getValue() {
        return number;
    }
    
    /**
     * log
     *
     * @return string
     */
    @Override
    public String toString() {
        return number + " with " + getBase();
    }
    
    private static String convert(String number1, Base b1, Base b2) {
        int num1 = Integer.parseUnsignedInt(number1, b1.getBase());
        return Integer.toString(num1, b2.getBase());
    }
    
    private static String convertDecimal(int number, Base b1) {
        return convert(String.valueOf(number), Base.Decimal, b1);
    }
    
    @Override
    public NumberBase and(NumberBase numberBase, Base b) {
        return new NumberBase(convertDecimal(intValue() & numberBase.intValue(), b), b);
    }
    
    @Override
    public NumberBase or(NumberBase numberBase, Base b) {
        return new NumberBase(convertDecimal(intValue() | numberBase.intValue(), b), b);
    }
    
    @Override
    public NumberBase xor(NumberBase numberBase, Base b) {
        return new NumberBase(convertDecimal(intValue() ^ numberBase.intValue(), b), b);
    }
    
    @Override
    public NumberBase not(Base b) {
        return new NumberBase(convertDecimal(~intValue(), b), b);
    }
    
    @Override
    public NumberBase leftShift(NumberBase numberBase, Base b) {
        return new NumberBase(convertDecimal(intValue() << numberBase.intValue(), b), b);
    }
    
    @Override
    public NumberBase logicalRightShift(NumberBase numberBase, Base b) {
        return new NumberBase(convertDecimal(intValue() >>> numberBase.intValue(), b), b);
    }
    
    @Override
    public NumberBase arithmeticRightShift(NumberBase numberBase, Base b) {
        return new NumberBase(convertDecimal(intValue() >> numberBase.intValue(), b), b);
    }
    
    @Override
    public NumberBase add(NumberBase numberBase, Base b) {
        return new NumberBase(convertDecimal(intValue() + numberBase.intValue(), b), b);
    }
    
    @Override
    public NumberBase minus(NumberBase numberBase, Base b) {
        return new NumberBase(convertDecimal(intValue() - numberBase.intValue(), b), b);
    }
    
    @Override
    public boolean isBetween(NumberBase numberBase, NumberBase numberBase2, Base b) {
        double max = Math.max(numberBase.doubleValue(), numberBase2.doubleValue());
        double min = Math.min(numberBase.doubleValue(), numberBase2.doubleValue());
        
        return doubleValue() >= min && doubleValue() <= max;
    }
    
    @Override
    public NumberBase and(NumberBase numberBase) {
        return and(numberBase, getBase());
    }
    
    @Override
    public NumberBase or(NumberBase numberBase) {
        return or(numberBase, getBase());
    }
    
    @Override
    public NumberBase xor(NumberBase numberBase) {
        return xor(numberBase, getBase());
    }
    
    @Override
    public NumberBase not() {
        return not(getBase());
    }
    
    @Override
    public NumberBase leftShift(NumberBase numberBase) {
        return leftShift(numberBase, getBase());
    }
    
    @Override
    public NumberBase logicalRightShift(NumberBase numberBase) {
        return logicalRightShift(numberBase, getBase());
    }
    
    @Override
    public NumberBase arithmeticRightShift(NumberBase numberBase) {
        return arithmeticRightShift(numberBase, getBase());
    }
    
    @Override
    public NumberBase add(NumberBase numberBase) {
        return add(numberBase, getBase());
    }
    
    @Override
    public NumberBase minus(NumberBase numberBase) {
        return minus(numberBase, getBase());
    }
    
    @Override
    public boolean isBetween(NumberBase numberBase, NumberBase numberBase2) {
        return isBetween(numberBase, numberBase2, getBase());
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NumberBase)) return false;
        
        NumberBase that = (NumberBase) o;
        return number.equals(that.number);
    }
    
    @Override
    public int hashCode() {
        return number.hashCode();
    }
    
    public static class Utils {
        public static NumberBase toNumberBase(int i) {
            return new NumberBase(i);
        }
    }
}
