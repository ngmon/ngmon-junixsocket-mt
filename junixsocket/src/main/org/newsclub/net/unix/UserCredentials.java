/**
 * junixsocket
 *
 * Copyright (c) 2009 NewsClub, Christian Kohlschütter
 *
 * The author licenses this file to You under the Apache License, Version 2.0
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
package org.newsclub.net.unix;

/**
 * User credentials discovered for the peer socket.
 * <p/>
 * When obtained on the server side, the {@link UserCredentials}
 * will represent the user on the client side.
 */
public class UserCredentials {
    
    private int pid;
    private int uid;
    private int gid;
    
    public int getPid() {
        return pid;
    }
    
    public int getUid() {
        return uid;
    }
    
    public int getGid() {
        return gid;
    }
    
    @Override
    public String toString() {
        return "UserCredentials["
        + "pid=" + pid
        + "; uid=" + uid
        + "; gid=" + gid
        + "]";
    }

}
