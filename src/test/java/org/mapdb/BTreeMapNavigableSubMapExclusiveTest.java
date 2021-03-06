package org.mapdb;

import java.util.NavigableMap;

public class BTreeMapNavigableSubMapExclusiveTest extends BTreeMapNavigable2Test{

    public static class Outside extends BTreeMapNavigableSubMapExclusiveTest{
        @Override protected NavigableMap<Integer, String> newMap() {
            return DBMaker.memoryDB().make()
                    .treeMap("map", Serializer.INTEGER, Serializer.STRING)
                    //TODO enable once values outside nodes work
                    //.valuesOutsideNodesEnable()
                    .create();
        }

    }

    @Override
	public void setUp() throws Exception {
        super.setUp();
        map.put(-1,"-one");
        map.put(0,"zero");
        map.put(11,"eleven");
        map.put(12,"twelve");
        map = map.subMap(0,false,11,false);
    }


    @Override
	public void testPut(){
        //this test is not run on submaps
    }
}
