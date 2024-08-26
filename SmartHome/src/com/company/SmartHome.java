package com.company;

public class SmartHome {
    private static int size;
    private String[] rooms;
    private int chosenRoom;
    private int[] roomID;
    SmartPlug plugs = new SmartPlug();

    public SmartHome(int roomSize) {
        this.rooms = new String[roomSize];
        setSize();
        setIDSize();
    }

    public void setIDSize() {
        this.roomID = new int[size];
    }

    public void populateID(int index) {
        roomID[index] = index + 1;
    }

    public void setSize() {
        size = rooms.length;
    }

    public int getSize() {
        return size;
    }

    public String getRoom(int index) {
        return rooms[index];
    }

    public int getID(int index) {
        return roomID[index];
    }

    public void populateRooms(int index, String roomName) {
        rooms[index] = roomName;

    }

    public void selectRoom(int chosenRoomInput) {
        chosenRoom = chosenRoomInput;
    }

    public int returnSelectedRoom() {
        return chosenRoom;
    }

}
