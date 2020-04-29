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
package com.feilong.tools.iplookup;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.feilong.json.jsonlib.JsonUtil;
import com.feilong.test.AbstractTest;

public class IpLookupUtilTest extends AbstractTest{

    @Test
    public void test(){
        //{"code":0,"data":{"ip":"210.75.225.254","country":"中国","area":"","region":"北京","city":"北京","county":"XX","isp":"科技网","country_id":"CN","area_id":"","region_id":"110000","city_id":"110100","county_id":"xx","isp_id":"1000114"}}
        String ip = "210.75.225.254";
        IpInfo ipInfo = IpLookupUtil.getIpInfo(ip);
        LOGGER.debug(JsonUtil.format(ipInfo));

        if (null != ipInfo){
            assertThat(
                            ipInfo,
                            allOf(
                                            hasProperty("country", is("中国")),
                                            hasProperty("region", is("北京")),
                                            hasProperty("cityId", is("110100")),
                                            hasProperty("city", is("北京")),
                                            hasProperty("ip", is(ip))));
        }else{
            assertNull(ipInfo);
        }
    }
}
