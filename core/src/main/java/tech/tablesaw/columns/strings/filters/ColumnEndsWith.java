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

package tech.tablesaw.columns.strings.filters;

import tech.tablesaw.api.StringColumn;
import tech.tablesaw.columns.Column;
import tech.tablesaw.columns.strings.StringColumnReference;
import tech.tablesaw.filtering.TwoColumnFilter;
import tech.tablesaw.selection.Selection;

/**
 * A filtering that selects cells whose contents startWith the given text ignoring case
 */
public class ColumnEndsWith extends TwoColumnFilter {

    public ColumnEndsWith(StringColumnReference reference, StringColumn otherStringColumn) {
        super(reference, otherStringColumn);
    }

    public ColumnEndsWith(StringColumn stringColumnToCompareAgainst) {
        super(stringColumnToCompareAgainst);
    }

    public ColumnEndsWith(StringColumnReference reference, StringColumnReference stringColumnToCompareAgainst) {
        super(reference, stringColumnToCompareAgainst);
    }

    /**
     * Returns a selection formed by applying a predicate for case-neutral equality between
     * each value in the given column and the corresponding value of the column passed into the constructor.
     *
     * @param columnBeingFiltered The column whose results will be filtered by the operation
     */
    @Override
    public Selection apply(Column columnBeingFiltered) {
        StringColumn textColumn = (StringColumn) columnBeingFiltered;
        return textColumn.eval(String::endsWith, (StringColumn) otherColumn());
    }
}