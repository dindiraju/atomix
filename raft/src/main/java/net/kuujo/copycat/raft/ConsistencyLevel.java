/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.kuujo.copycat.raft;

/**
 * Query consistency level.
 *
 * @author <a href="http://github.com/kuujo">Jordan Halterman</a>
 */
public enum ConsistencyLevel {

  /**
   * Provides serializable consistency.
   */
  SERIALIZABLE {
    @Override
    public boolean isLeaderRequired() {
      return false;
    }
  },

  /**
   * Provides sequential consistency.
   */
  SEQUENTIAL {
    @Override
    public boolean isLeaderRequired() {
      return false;
    }
  },

  /**
   * Provides linearizable consistency based on a leader lease.
   */
  LINEARIZABLE_LEASE {
    @Override
    public boolean isLeaderRequired() {
      return true;
    }
  },

  /**
   * Provides strict linearizable consistency.
   */
  LINEARIZABLE_STRICT {
    @Override
    public boolean isLeaderRequired() {
      return true;
    }
  };

  /**
   * Returns a boolean value indicating whether a leader is required for the consistency level.
   *
   * @return Indicates whether a leader is required for the consistency level.
   */
  public abstract boolean isLeaderRequired();

}
