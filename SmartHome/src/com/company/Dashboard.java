package com.company;

public class Dashboard {

    public static void main(String[] args) {
        ConsoleHelper helper = new ConsoleHelper();

        helper.printStr("How many rooms are there in this property?\n");
        SmartHome smartHome = new SmartHome(helper.intInput());

        helper.printStr("How many plugs do you want to place in this property?\n");
        smartHome.plugs.setSize(helper.intInput());
        smartHome.plugs.populatePlugID();

        for(int i = 0; i < smartHome.getSize(); i++) {
            helper.printStr("Please provide a name for Room " + (i + 1) + "\n");
            smartHome.populateRooms(i, helper.strInput());
            smartHome.populateID(i);
        }

        helper.printStr("ENTER PLUG INFORMATION BELOW \n");

        for(int i = 0; i < smartHome.plugs.getSize(); i++) {

            helper.printStr("\n");
            helper.printStr("ROOMS AVAILABLE: ");
            for(int j = 0; j < smartHome.getSize(); j++) {
                helper.printStr(smartHome.getID(j) + " - " + smartHome.getRoom(j) + " | ");
            }
            helper.printStr("\n" +
                    "Using the above list, please select the room for this plug (integer only)\n");
            smartHome.selectRoom(helper.intInput());
            smartHome.plugs.populatePlugToRoomID(helper.returnLastIntInput());
            helper.printStr("AVAILABLE DEVICE LIST OPTIONS\n" +
                    "These are standard devices that can be attached to the smart plug:\n");
            for(int j = 0; j < 5; j++) {
                helper.printStr((j + 1) + " - " + smartHome.plugs.getDeviceType(j) + "\n");
            }
            helper.printStr("Using the above list, please select the device to attach to the smart plug (integer only)\n");
            smartHome.plugs.populateAttachedDevices(helper.intInput());


        }
        smartHome.plugs.setInitialPlugStates();

        while(true) {
            helper.printStr("---------------DASHBOARD--------------\n");

            for(int i = 0; i < smartHome.getSize(); i++) {
                helper.printStr("ROOM: " + smartHome.getID(i) + "\n");

                for(int j = 0; j < smartHome.plugs.getSize(); j++) {
                    if (smartHome.plugs.getPlugToRoomID(j) == smartHome.getID(i)) {
                            helper.printStr("SmartPlug |attached to: " + smartHome.plugs.getAttachedPlug(j) + "                |room: " + smartHome.getRoom(i) + "|ID: " + (smartHome.plugs.getPlugID(j)) + "|status: " + smartHome.plugs.getPlugState(j) + "|\n");
                    }
                }
            }

            helper.printStr("-------------MENU OPTIONS-------------\n" +
                    "---------please select option:--------\n" +
                    "1 - house level options\n" +
                    "2 - room level options\n" +
                    "3 - plug level options\n" +
                    "4 - system options\n");

            switch(helper.intInput()) {
                case 1:
                    helper.printStr("\n" +
                            "HOUSE LEVEL OPTIONS\n" +
                            "1 - Switch all plugs off\n" +
                            "2 - Switch all plugs on\n" +
                            "Select an option\n");
                    smartHome.plugs.changeAllPlugsStates(helper.intInput());
                    break;
                case 2:
                    helper.printStr("ROOMS AVAILABLE: ");

                    for(int i = 0; i < smartHome.getSize(); i++) {
                        helper.printStr(smartHome.getID(i) + " - " + smartHome.getRoom(i) + " | ");
                    }

                    helper.printStr("\n" +
                            "\n" +
                            "Please select room (integer only)\n");
                    smartHome.selectRoom(helper.intInput());

                    helper.printStr("\n");

                    for(int i = 0; i < smartHome.plugs.getSize(); i++) {
                        if(smartHome.plugs.getPlugToRoomID(i) == smartHome.getID(smartHome.returnSelectedRoom() - 1)) {
                            helper.printStr("SmartPlug |attached to: " + smartHome.plugs.getAttachedPlug(i) + "                |room: " + smartHome.getRoom(smartHome.returnSelectedRoom() - 1) + "|ID: " + smartHome.plugs.getPlugID(i) + "|status: " + smartHome.plugs.getPlugState(i) + "|\n");
                        }
                    }

                    helper.printStr("\n" +
                            "ROOM LEVEL OPTIONS\n" +
                            "1 - Switch all plugs off in room\n" +
                            "2 - Switch all plugs on in room\n" +
                            "3 - Select a plug in the room and toggle its on/off status\n" +
                            "\n" +
                            "Select an option\n");

                    if(helper.intInput() == 3) {
                        helper.printStr("\n" +
                                "Select a plug (integer only)\n");
                        smartHome.plugs.selectPlug(helper.intInput());

                        helper.printStr("\n" +
                                "1 - Turn plug off\n" +
                                "2 - Turn plug on\n" +
                                "\n" +
                                "Select option (integer only)\n");
                        smartHome.plugs.changeIndividualPlugState(helper.intInput());
                    }else {
                        smartHome.plugs.changeRoomPlugsStates(helper.returnLastIntInput(), smartHome.returnSelectedRoom());
                    }
                    break;
                case 3:
                    for(int i = 0; i < smartHome.getSize(); i++) {
                        for(int j = 0; j < smartHome.plugs.getSize(); j++) {
                            if (smartHome.plugs.getPlugToRoomID(j) == smartHome.getID(i)) {
                                helper.printStr("SmartPlug |attached to: " + smartHome.plugs.getAttachedPlug(j) + "                |room: " + smartHome.getRoom(i) + "|ID: " + (smartHome.plugs.getPlugID(j)) + "|status: " + smartHome.plugs.getPlugState(j) + "|\n");
                            }
                        }
                    }

                    helper.printStr("\n" +
                            "Please select plug (ID integer only)\n");
                    smartHome.plugs.selectPlug(helper.intInput());

                    helper.printStr("PLUG LEVEL OPTIONS\n" +
                            "1 - Switch plug off\n" +
                            "2 - Switch plug on\n" +
                            "3 - Change attached device\n" +
                            "4 - Move plug to different room\n" +
                            "\n" +
                            "Select an option\n");

                    switch (helper.intInput()) {
                        case 1:
                        case 2:
                            smartHome.plugs.changeIndividualPlugState(helper.returnLastIntInput());
                            break;
                        case 3:
                            helper.printStr("\n" +
                                    "AVAILABLE DEVICE LIST OPTIONS\n" +
                                    "These are standard devices attached to the smart plug, unless otherwise stated\n");
                            for(int j = 0; j < 5; j++) {
                                helper.printStr((j + 1) + " - " + smartHome.plugs.getDeviceType(j) + "\n");
                            }

                            helper.printStr("Enter device to attach to smart plug (integer only)\n");
                            smartHome.plugs.amendPlug(helper.intInput() - 1);
                            break;
                        case 4:
                            helper.printStr("ROOMS AVAILABLE: ");

                            for(int i = 0; i < smartHome.getSize(); i++) {
                                helper.printStr(smartHome.getID(i) + " - " + smartHome.getRoom(i) + " | ");
                            }

                            helper.printStr("\n" +
                                    "Please select room for device from list (integer only)\n");
                            smartHome.plugs.changePlugToDiffRoom(helper.intInput());
                            break;
                    }

                    break;
            }
        }
    }
}

