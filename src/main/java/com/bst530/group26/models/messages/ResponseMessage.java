package com.bst530.group26.models.messages;

public class ResponseMessage extends Message {
    private boolean insert;

    public ResponseMessage() { }

    public ResponseMessage(long senderID, long groupID, double latitude, double longitude, boolean insert) {
        super(senderID, groupID, latitude, longitude);
        this.insert = insert;
    }

    public boolean getInsert(){
        return this.insert;
    }

    public void setInsert(boolean insert){
        this.insert = insert;
    }
}
