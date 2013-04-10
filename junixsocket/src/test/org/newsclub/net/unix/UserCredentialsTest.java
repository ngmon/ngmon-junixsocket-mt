package org.newsclub.net.unix;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.Socket;

import org.junit.Test;

/**
 * Tests retrieving {@link UserCredentials} on the server side.
 * 
 * @see <a href="http://code.google.com/p/junixsocket/issues/detail?id=18">Issue 18</a>
 */
public class UserCredentialsTest extends SocketTestBase {
    public UserCredentialsTest() throws IOException {
        super();
    }

    private class UserCredentialsGatheringServerThread extends ServerThread {
        private UserCredentials userCredentials;

        protected UserCredentialsGatheringServerThread() throws IOException {
            super();
            ((AFUNIXServerSocket) getServerSocket()).setPassUserCredentials(true);
        }

        @Override
        protected boolean handleConnection(Socket sock) throws IOException {
            userCredentials = ((AFUNIXSocket) sock).getUserCredentials();
            return false;
        }
        
    }
    
    @Test
    public void issue18() throws Exception {
        
        UserCredentialsGatheringServerThread thread = new UserCredentialsGatheringServerThread();

        AFUNIXSocket sock;
        sock = connectToServer();
        sock.close();
        
        thread.join();
        
        assertNotNull("UserCredentials should have been retrieved", thread.userCredentials);
    }

}
