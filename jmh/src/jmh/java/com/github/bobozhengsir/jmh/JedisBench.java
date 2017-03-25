/*
 * Copyright 2016-2017 the original author or authors.
 *
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
package com.github.bobozhengsir.jmh;

import org.openjdk.jmh.annotations.*;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

@State(Scope.Benchmark)
public class JedisBench {
    private JedisPool jedisPool;
    private Jedis jedis;

    @Setup
    public void init() {
        GenericObjectPoolConfig config = new GenericObjectPoolConfig();
        config.setMaxIdle(512);
        jedisPool = new JedisPool(config, "10.0.0.206", 6396, 2000, null,1);
        jedis = jedisPool.getResource();
    }

    @TearDown
    public void clean() {
        jedis.close();
        jedisPool.destroy();
    }

    @Benchmark
    public double pow() {
        return Math.pow(42, 17);
    }

    @Benchmark
    public void jedisSet() {
        jedis.setnx("jmh-test", "test");
        jedis.expire("jmh-test", 900);
    }
}