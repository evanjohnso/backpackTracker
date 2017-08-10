package models;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Guest on 8/10/17.
 */
public class DistributerTest {

    @Test
    public void distributerClassInstantiateCorrectlyAndItemsAreAdded() {
        Distributer distributer = new Distributer();
        assertTrue(distributer instanceof Distributer);
        assertEquals(3, distributer.goodsBank().size());

    }

}