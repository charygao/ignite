/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.ignite.cache.eviction.igfs;

import org.apache.ignite.cache.eviction.*;
import org.apache.ignite.internal.processors.igfs.*;

import javax.cache.*;
import java.io.*;

/**
 * IGFS eviction filter which will not evict blocks of particular files.
 */
public class CacheIgfsEvictionFilter implements CacheEvictionFilter, Serializable {
    /** */
    private static final long serialVersionUID = 0L;

    /** {@inheritDoc} */
    @Override public boolean evictAllowed(Cache.Entry entry) {
        Object key = entry.getKey();

        return !(key instanceof IgfsBlockKey && ((IgfsBlockKey)key).evictExclude());
    }
}
