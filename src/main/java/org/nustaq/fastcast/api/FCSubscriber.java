package org.nustaq.fastcast.api;

import org.nustaq.offheap.bytez.Bytez;

/**
 * Created by ruedi on 29.11.2014.
 */
public interface FCSubscriber {

    public void messageReceived(String sender, long sequence, Bytez b, long off, int len);

    /**
     * called in case the receiver was too slow in processing messages
     * and therefore got dropped (unrecoverable message loss).
     * return true in order to let fast-cast automatically reconnect and resync
     */
    public boolean dropped();

    /**
     * a sender stopped sending or terminated
     * @param senderNodeId
     */
    public void senderTerminated( String senderNodeId );

    /**
     * called upon the first message regulary received from a sender
     * @param receivesFrom
     * @param seqNo
     */
    public void senderBootstrapped(String receivesFrom, long seqNo);

//    public void resync(); FIXME
}
