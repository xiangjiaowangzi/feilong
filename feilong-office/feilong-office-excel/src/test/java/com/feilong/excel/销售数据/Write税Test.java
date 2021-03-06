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
package com.feilong.excel.销售数据;

import static com.feilong.core.bean.ConvertUtil.toMap;
import static com.feilong.lib.springframework.util.ResourceUtils.CLASSPATH_URL_PREFIX;

import java.util.Map;

@SuppressWarnings("squid:S2699") //Tests should include assertions //https://stackoverflow.com/questions/10971968/turning-sonar-off-for-certain-code
public class Write税Test extends AbstractSalesDataWriteTest{

    @Override
    protected String buildTemplateLocation(){
        return CLASSPATH_URL_PREFIX + "销售数据/税/export-template-sales-税.xlsx";
    }

    @Override
    protected String buildSheetDefinitionLocation(){
        return CLASSPATH_URL_PREFIX + "销售数据/税/sheets-definition.xml";
    }

    //---------------------------------------------------------------

    @Override
    protected Map<String, Object> buildData(){
        return toMap(//
                        "salesDataList",
                        buildList(),

                        "sheetName",
                        "测试111");
    }

}
