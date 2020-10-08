package com.company;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AreaTest {

    @Test
    public void testMToString() {
        Area area = new Area(100, Area.Measure.m);
        assertEquals("100.0 кв.м", area.toString());
    }

    @Test
    public void testGaToString() {
        Area area = new Area(100, Area.Measure.ga);
        assertEquals("100.0 га", area.toString());
    }

    @Test
    public void testArToString() {
        Area area = new Area(100, Area.Measure.ar);
        assertEquals("100.0 сотка", area.toString());
    }

    @Test
    public void testDeToString() {
        Area area = new Area(100, Area.Measure.de);
        assertEquals("100.0 десятина", area.toString());
    }

    @Test
    public void testAddNumber() {
        Area area = new Area(100, Area.Measure.m);
        area = area.add(10);
        assertEquals("110.0 кв.м", area.toString());
    }
    @Test
    public void testSubtractNumber() {
        Area area = new Area(100, Area.Measure.m);
        area = area.subtraction(50);
        assertEquals("50.0 кв.м", area.toString());
    }
    @Test
    public void testMultiplyByNumber() {
        Area area = new Area(100, Area.Measure.m);
        area = area.multiply(5);
        assertEquals("500.0 кв.м", area.toString());
    }
    @Test
    public void testConvertMeterToAny() {
        Area area;

        area = new Area(10000, Area.Measure.m);
        assertEquals("1.0 га", area.to(Area.Measure.ga).toString());

        area = new Area(100, Area.Measure.m);
        assertEquals("1.0 сотка", area.to(Area.Measure.ar).toString());

        area = new Area(11111, Area.Measure.m);
        assertEquals("1.0 десятина", area.to(Area.Measure.de).toString());
    }
    @Test
    public void testConvertAnyToMeter() {
        Area area;

        area = new Area(1, Area.Measure.ga);
        assertEquals("10000.0 кв.м", area.to(Area.Measure.m).toString());

        area = new Area(1, Area.Measure.ar);
        assertEquals("100.0 кв.м", area.to(Area.Measure.m).toString());

        area = new Area(1, Area.Measure.de);
        assertEquals("11111.0 кв.м", area.to(Area.Measure.m).toString());
    }

    @Test
    public void testAddTwoArea() {
        Area area1 = new Area(1, Area.Measure.ga);
        Area area2 = new Area(5000, Area.Measure.m);

        assertEquals(area1.add(area2), new Area(1.5, Area.Measure.ga));
        assertEquals(area1.add(area2), new Area(15000, Area.Measure.m));
    }

    @Test
    public void testSubtractTwoArea() {
        Area area1 = new Area(1, Area.Measure.ga);
        Area area2 = new Area(500, Area.Measure.m);

        assertEquals(area1.subtraction(area2), new Area(0.95, Area.Measure.ga));
        assertEquals(area1.subtraction(area2), new Area(9500, Area.Measure.m));
    }
}