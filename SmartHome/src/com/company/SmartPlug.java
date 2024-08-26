package com.company;

public class SmartPlug {
    private String[] deviceTypes = {"Lamp", "TV", "Computer", "Phone Recharger", "Heater"};
    private String[] attachedDevices;
    private int[] plugToRoomID;
    private int[] plugID;
    private boolean[] plugState;
    private static int size;
    private int chosenPlug;
    private int plugCounter = 0;
    private int deviceCounter = 0;

    public void setPlugSize() {
        this.plugState = new boolean[size];
        this.plugToRoomID = new int[size];
        this.plugID = new int[size];
        this.attachedDevices = new String[size];
    }

    public void populatePlugToRoomID(int roomID) {
        plugToRoomID[plugCounter] = roomID;
        plugCounter++;
    }

    public void populatePlugID() {
        for(int i = 0; i < size; i++) {
            plugID[i] = i + 1;
        }
    }

    public int getPlugID(int index) {
        return plugID[index];
    }

    public void populateAttachedDevices(int deviceID) {
        attachedDevices[deviceCounter] = deviceTypes[deviceID - 1];
        deviceCounter++;
    }

    public void setSize(int plugSize) {
        size = plugSize;
        setPlugSize();
    }

    public int getSize() {
        return size;
    }

    public void selectPlug(int chosenPlugInput) {
        chosenPlug = chosenPlugInput - 1;
    }

    public int getSelectedPlug() {
        return chosenPlug;
    }

    public String getDeviceType(int index) {
        return deviceTypes[index];
    }

    public void amendPlug(int chosenDevice) {
        attachedDevices[getSelectedPlug()] = deviceTypes[chosenDevice];
    }

    public String getAttachedPlug(int index) {
        return attachedDevices[index];
    }

    public int getPlugToRoomID(int index) {
        return plugToRoomID[index];
    }

    public void setInitialPlugStates() {
        for(int i = 0; i < plugState.length; i++) {
            plugState[i] = false;
        }
    }

    public String getPlugState(int index) {
        if(!plugState[index]) {
            return "off";
        }else {
            return "on";
        }
    }

    public void changeAllPlugsStates(int choice) {
        if(choice == 1) {
            for( int i =0; i < plugState.length; i++) {
                plugState[i] = false;
            }
        }else {
            for( int i =0; i < plugState.length; i++) {
                plugState[i] = true;
            }
        }
    }

    public void changeRoomPlugsStates(int choice, int selectedRoom) {
        if(choice == 1) {
            for(int i = 0; i < size; i++) {
                if(selectedRoom == plugToRoomID[i]) {
                    plugState[i] = false;
                }
            }
        }else if(choice == 2) {
            for(int i = 0; i < size; i++) {
                if(selectedRoom == plugToRoomID[i]) {
                    plugState[i] = true;
                }
            }
        }
    }

    public void changeIndividualPlugState(int choice) {
        if(choice == 1) {
            plugState[chosenPlug] = false;
        }else {
            plugState[chosenPlug] = true;
        }
    }

    public void changePlugToDiffRoom(int chosenRoom) {
        plugToRoomID[getSelectedPlug()] = chosenRoom;
    }
}
