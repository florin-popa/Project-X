package implementations

import entities.Environmental

/**
 * Created by POF4CLJ on 17.08.2016.
 */
class EnviromentalRepositoryTest extends groovy.util.GroovyTestCase {

    private EnviromentalRepository env;

    void testStoreEntity() {
        Environmental environmental = new Environmental();
        Date date = new Date();
        date.setTime(1445676343L);
        environmental.setL(23);
        environmental.setN(24);
        environmental.setP(76);
        environmental.setRhw(72);
        environmental.setT(27);
        environmental.setBaseId(21312313);
        environmental.setGw_id("ab453534ac");
        environmental.setTime(date);
        environmental.setType("Environmental");
        environmental.setId("ac55646546546");
        env.storeEntity(environmental);

    }

    void testRetrieveEntity() {

    }

    void testUpdateEntity() {

    }

    void testRemoveEntity() {

    }

    void testGetData() {

    }

    void testTimeDifference() {

    }

    void testNormalizeList() {

    }
}
