package com.example.louis.pgv3;

import java.nio.ByteBuffer;

public class TestPacketTcp {
    private static ByteBuffer packet;

    private static ByteBuffer constructPacket() {
        ByteBuffer b = ByteBuffer.allocate(52);

        b.put((byte) Integer.parseInt("45", 16));
        b.put((byte) Integer.parseInt("00", 16));
        b.put((byte) Integer.parseInt("00", 16));
        b.put((byte) Integer.parseInt("34", 16));
        b.put((byte) Integer.parseInt("00000000", 2));
        b.put((byte) Integer.parseInt("00000000", 2));
        b.put((byte) Integer.parseInt("00000000", 2));
        b.put((byte) Integer.parseInt("00000000", 2));
        b.put((byte) Integer.parseInt("01000000", 2));
        b.put((byte) Integer.parseInt("00000110", 2));
        b.put((byte) 51);
        b.put((byte) 43);
        b.put((byte) Integer.parseInt("11000000", 2));
        b.put((byte) Integer.parseInt("10101000", 2));
        b.put((byte) Integer.parseInt("10110010", 2));
        b.put((byte) Integer.parseInt("00010111", 2));
        b.put((byte) Integer.parseInt("10101101", 2));
        b.put((byte) Integer.parseInt("11000010", 2));
        b.put((byte) Integer.parseInt("00100111", 2));
        b.put((byte) Integer.parseInt("00010111", 2));

        b.put((byte) Integer.parseInt("11011011", 2));
        b.put((byte) Integer.parseInt("10110011", 2));
        b.put((byte) Integer.parseInt("00000000", 2));
        b.put((byte) Integer.parseInt("01010000", 2));
        b.put((byte) Integer.parseInt("00001110", 2));
        b.put((byte) Integer.parseInt("01010000", 2));
        b.put((byte) Integer.parseInt("00011110", 2));
        b.put((byte) Integer.parseInt("11001001", 2));
        b.put((byte) Integer.parseInt("00000000", 2));
        b.put((byte) Integer.parseInt("00000000", 2));
        b.put((byte) Integer.parseInt("00000000", 2));
        b.put((byte) Integer.parseInt("00000000", 2));
        b.put((byte) Integer.parseInt("01010000", 2));
        b.put((byte) Integer.parseInt("00001000", 2));              // im Builder ist PUSH FLAG gesetzt
        b.put((byte) Integer.parseInt("00100000", 2));
        b.put((byte) Integer.parseInt("00000000", 2));
        b.put((byte) Integer.parseInt("00101110", 2));              // da paketinformationen geändert
        b.put((byte) Integer.parseInt("01010100", 2));              // wird hier die checksum angepasst
        b.put((byte) Integer.parseInt("00000000", 2));
        b.put((byte) Integer.parseInt("00000000", 2));

        b.put((byte) Integer.parseInt("00000010", 2));
        b.put((byte) Integer.parseInt("00000100", 2));
        b.put((byte) Integer.parseInt("00000101", 2));
        b.put((byte) Integer.parseInt("10110100", 2));
        b.put((byte) Integer.parseInt("00000001", 2));
        b.put((byte) Integer.parseInt("00000011", 2));
        b.put((byte) Integer.parseInt("00000011", 2));
        b.put((byte) Integer.parseInt("00001000", 2));
        b.put((byte) Integer.parseInt("00000001", 2));
        b.put((byte) Integer.parseInt("00000001", 2));
        b.put((byte) Integer.parseInt("00000100", 2));
        b.put((byte) Integer.parseInt("00000010", 2));

        return b;
    }

    public static ByteBuffer getPacket() {
        if (packet == null) {
            packet = constructPacket();
        }

        return packet;
    }
}
