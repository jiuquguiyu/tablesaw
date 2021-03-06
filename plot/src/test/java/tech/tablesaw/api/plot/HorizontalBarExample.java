/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package tech.tablesaw.api.plot;

import tech.tablesaw.api.QueryHelper;
import tech.tablesaw.api.Table;

import static tech.tablesaw.aggregate.AggregateFunctions.*;
import static tech.tablesaw.api.plot.HorizontalBar.*;

/**
 *
 */
public class HorizontalBarExample {

    public static void main(String[] args) throws Exception {
        Table table = Table.read().csv("../data/tornadoes_1950-2014.csv");
        Table t2 = table.countBy(table.stringColumn("State"));
        t2 = t2.where(QueryHelper.numberColumn("Count").isGreaterThan(100));
        show("tornadoes by state", t2.stringColumn("Category"), t2.nCol("Count"));
        show("T", table.summarize("fatalities", sum).by("Scale"));
    }
}
