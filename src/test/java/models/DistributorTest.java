package models;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Guest on 8/10/17.
 */
public class DistributorTest {

    @Test
    public void distributerClassInstantiateCorrectlyAndItemsAreAdded() {
        Distributor distributer = new Distributor();
        assertTrue(distributer instanceof Distributor);
        assertEquals(3, distributer.goodsBank().size());
    }
}