/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.core.parse.filler.sharding.dml.select;

import lombok.Setter;
import org.apache.shardingsphere.core.parse.filler.SQLSegmentFiller;
import org.apache.shardingsphere.core.parse.filler.common.dml.RowNumberPredicateFiller;
import org.apache.shardingsphere.core.parse.sql.segment.dml.predicate.OrPredicateSegment;
import org.apache.shardingsphere.core.parse.sql.segment.dml.predicate.SubqueryPredicateSegment;
import org.apache.shardingsphere.core.parse.sql.statement.SQLStatement;
import org.apache.shardingsphere.core.parse.sql.statement.dml.SelectStatement;

/**
 * Subquery predicate filler for sharding.
 *
 * @author duhongjun
 */
@Setter
public final class ShardingSubqueryPredicateFiller implements SQLSegmentFiller<SubqueryPredicateSegment> {
    
    private final RowNumberPredicateFiller shardingRowNumberPredicateFiller = new RowNumberPredicateFiller();
    
    @Override
    public void fill(final SubqueryPredicateSegment sqlSegment, final SQLStatement sqlStatement) {
        SelectStatement selectStatement = (SelectStatement) sqlStatement;
        for (OrPredicateSegment each : sqlSegment.getOrPredicates()) {
            selectStatement.setContainsSubquery(true);
            shardingRowNumberPredicateFiller.fill(each, sqlStatement);
        }
    }
}
