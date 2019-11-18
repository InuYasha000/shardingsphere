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

package info.avalon566.shardingscaling.core.spi;

import info.avalon566.shardingscaling.core.execute.reader.JdbcReader;
import info.avalon566.shardingscaling.core.execute.reader.LogReader;
import info.avalon566.shardingscaling.core.execute.writer.Writer;
import org.apache.shardingsphere.spi.DatabaseTypeAwareSPI;

/**
 * Scaling entry.
 *
 * @author yangyi
 */
public interface ScalingEntry extends DatabaseTypeAwareSPI {
    
    /**
     * Get JDBC reader type.
     *
     * @return JDBC reader type
     */
    Class<? extends JdbcReader> getJdbcReaderClass();
    
    /**
     * Get log reader type.
     *
     * @return log reader type
     */
    Class<? extends LogReader> getLogReaderClass();
    
    /**
     * Get writer type.
     *
     * @return writer type
     */
    Class<? extends Writer> getWriterClass();
}
