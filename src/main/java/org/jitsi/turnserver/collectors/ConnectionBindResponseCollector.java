/*
 * TurnServer, the OpenSource Java Solution for TURN protocol. Maintained by the
 * Jitsi community (http://jitsi.org).
 *
 * Copyright @ 2015 Atlassian Pty Ltd
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

package org.jitsi.turnserver.collectors;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.ice4j.*;
import org.ice4j.attribute.*;
import org.ice4j.message.*;
import org.ice4j.stack.*;

/**
 * The class that would be handling and responding to incoming ConnectionBind
 * response.
 * 
 * @author Aakash Garg
 */
public class ConnectionBindResponseCollector
    implements ResponseCollector
{

    /**
     * The <tt>Logger</tt> used by the <tt>ConnectionBindresponseCollector</tt>
     * class and its instances for logging output.
     */
    private static final Logger logger = Logger
        .getLogger(ConnectionBindResponseCollector.class.getName());

    private final StunStack stunStack;

    /**
     * Creates a new ConnectionBindresponseCollector
     * 
     * @param turnStack
     */
    public ConnectionBindResponseCollector(StunStack stunStack)
    {
        this.stunStack = stunStack;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.ice4j.ResponseCollector#processResponse(org.ice4j.StunResponseEvent)
     */
    @Override
    public void processResponse(StunResponseEvent evt)
    {
        if (logger.isLoggable(Level.FINER))
        {
            logger.finer("Received response " + evt);
        }
        Message message = evt.getMessage();
        if (message.getMessageType() == Message.ALLOCATE_ERROR_RESPONSE)
        {
            ErrorCodeAttribute errorCodeAttribute =
                (ErrorCodeAttribute) message.getAttribute(Attribute.ERROR_CODE);
            switch (errorCodeAttribute.getErrorCode())
            {
            case ErrorCodeAttribute.BAD_REQUEST:
                // code for bad response error
                break;
            }
        }
        else if (message.getMessageType() == Message.ALLOCATE_RESPONSE)
        {
            // code for doing processing of ConnectionBind success response
        }
        else
        {
            return;
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.ice4j.ResponseCollector#processTimeout(org.ice4j.StunTimeoutEvent)
     */
    @Override
    public void processTimeout(StunTimeoutEvent event)
    {
        // TODO Auto-generated method stub

    }

}
