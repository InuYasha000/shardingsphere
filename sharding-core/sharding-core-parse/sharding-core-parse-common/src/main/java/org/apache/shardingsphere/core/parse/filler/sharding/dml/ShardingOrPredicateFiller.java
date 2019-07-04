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

package org.apache.shardingsphere.core.parse.filler.sharding.dml;

import lombok.Setter;
import org.apache.shardingsphere.core.parse.filler.SQLSegmentFiller;
import org.apache.shardingsphere.core.parse.filler.common.dml.RowNumberPredicateFiller;
import org.apache.shardingsphere.core.parse.sql.segment.dml.predicate.OrPredicateSegment;
import org.apache.shardingsphere.core.parse.sql.statement.SQLStatement;
import org.apache.shardingsphere.core.parse.sql.statement.dml.DMLStatement;
import org.apache.shardingsphere.core.parse.sql.statement.dml.SelectStatement;

/**
 * Or predicate filler for sharding.
 *
 * @author duhongjun
 * @author zhangliang
 * @author panjuan
 */
@Setter
public final class ShardingOrPredicateFiller implements SQLSegmentFiller<OrPredicateSegment> {
    
    private final RowNumberPredicateFiller shardingRowNumberPredicateFiller = new RowNumberPredicateFiller();
    
    @Override
    public void fill(final OrPredicateSegment sqlSegment, final SQLStatement sqlStatement) {
        if (sqlStatement instanceof DMLStatement) {
            if (sqlStatement instanceof SelectStatement) {
                shardingRowNumberPredicateFiller.fill(sqlSegment, sqlStatement);
            }
        }
    }
}
