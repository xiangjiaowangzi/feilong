/*
 * Copyright (C) 2008 feilong
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.feilong.core.util.maputil;

import static com.feilong.core.util.MapUtil.newHashMap;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Map;

import org.junit.Test;

import com.feilong.core.util.MapUtil;

public class NewHashMapTest{

    /**
     * TestMapUtilTest.
     */
    @Test
    public void testNewHashMap(){
        Map<Object, Object> newHashMap = MapUtil.newHashMap(100);
        assertThat(newHashMap.size(), is(0));
    }

    /**
     * Test new hash map 2.
     */
    @Test
    public void testNewHashMap2(){
        Map<String, String> newHashMap = MapUtil.newHashMap(3);
        newHashMap.put("name", "feilong");
        newHashMap.put("age", "18");
        newHashMap.put("address", "shanghai");

        assertThat(newHashMap.size(), is(3));
    }

    //---------------------------------------------------------------
    @Test
    public void testNewHashMap2333(){
        Map<String, String> newHashMap = newHashMap(3);
        newHashMap.put("name", "feilong");
        newHashMap.put("age", "18");
        newHashMap.put("address", "shanghai");
        assertThat(newHashMap.size(), is(3));

        Map<String, String> newHashMap1 = newHashMap(newHashMap);
        assertThat(newHashMap1.size(), is(3));
    }

    /**
     * TestNewHashMapTest.
     */
    @Test(expected = NullPointerException.class)
    public void testNewHashMapTest(){
        newHashMap(null);
    }

    //---------------------------------------------------------------

    /**
     * Test new hash map 1.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testNewHashMap1(){
        MapUtil.newHashMap(-1);
    }
}
