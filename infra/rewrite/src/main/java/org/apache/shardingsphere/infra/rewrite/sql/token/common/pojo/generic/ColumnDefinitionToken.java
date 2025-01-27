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

package org.apache.shardingsphere.infra.rewrite.sql.token.common.pojo.generic;

import com.google.common.base.Strings;
import lombok.Getter;
import org.apache.shardingsphere.infra.rewrite.sql.token.common.pojo.SQLToken;

/**
 * Column definition token.
 */
@Getter
public final class ColumnDefinitionToken extends SQLToken {
    
    private final String columnName;
    
    private final String dataType;
    
    public ColumnDefinitionToken(final String columnName, final String dataType, final int startIndex) {
        super(startIndex);
        this.columnName = columnName;
        this.dataType = dataType;
    }
    
    @Override
    public String toString() {
        if (Strings.isNullOrEmpty(dataType)) {
            return columnName;
        }
        if (Strings.isNullOrEmpty(columnName)) {
            return dataType;
        }
        return columnName + " " + dataType;
    }
    
    @Override
    public int getStopIndex() {
        return getStartIndex();
    }
}
