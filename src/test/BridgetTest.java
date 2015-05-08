package test;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by leonardo on 03/05/2015.
 */
public class BridgetTest {

    /*@Test public void testIOMenuGetSelectedOptionAdd () {
        IOMenu iom = new IOMenu();
        Assert.assertTrue(iom.getSelectedOption() == 1);
    }

    @Test public void testIOMenuGetSelectedOptionDelete () {
        IOMenu iom = new IOMenu();
        Assert.assertTrue(iom.getSelectedOption() == 2);
    }

    @Test public void testIOMenuGetSelectedOptionEntries () {
        IOMenu iom = new IOMenu();
        Assert.assertTrue(iom.getSelectedOption() == 3);
    }*/

    @Test public void testEquilatero() {
        int result = tipoTriangulo(10, 10, 10);
        Assert.assertTrue(result == 1);
    }

    @Test public void testIsoceles1() {
        int result = tipoTriangulo(10, 10, 5);
        Assert.assertTrue(result == 2);
    }

    @Test public void testIsoceles2() {
        int result = tipoTriangulo(10, 5, 10);
        Assert.assertTrue(result == 2);
    }

    @Test public void testIsoceles3(){
        int result = tipoTriangulo(5, 10, 10);
        Assert.assertTrue(result == 2);
    }

    @Test public void testEscaleno1() {
        int result = tipoTriangulo(5, 10, 15);
        Assert.assertTrue(result == 3);
    }

    @Test public void testEscaleno2() {
        int result = tipoTriangulo(15, 10, 5);
        Assert.assertTrue(result == 3);
    }

    @Test public void testEscaleno3() {
        int result = tipoTriangulo(5, 15, 10);
        Assert.assertTrue(result == 3);
    }

    @Test public void testEscaleno4() {
        int result = tipoTriangulo(15, 5, 10);
        Assert.assertTrue(result == 3);
    }

    public int tipoTriangulo(int a, int b, int c) {
        // equilatero = 1
        // isoceles  = 2
        // escaleno = 3
        if (a == b) {
            if (b == c) {
                System.out.println("Equilatero");
                return 1;
            } else {
                System.out.println("Isoceles");
                return 2;
            }
        } else {
            if (b == c || a == c) {
                System.out.println("Isoceles");
                return 2;
            } else {
                System.out.println("Escaleno");
                return 3;
            }
        }


    }
}
