package com.example.louis.pgv3;

import java.nio.ByteBuffer;

public class TestPacketUdp {
    private static ByteBuffer packet;

    private static ByteBuffer constructPacket() {
        ByteBuffer b = ByteBuffer.allocate(40);

        b.put((byte) Integer.parseInt("45", 16));
        b.put((byte) Integer.parseInt("00", 16));
        b.put((byte) Integer.parseInt("00", 16));
        b.put((byte) Integer.parseInt("40", 10));
        b.put((byte) Integer.parseInt("00000000", 2));
        b.put((byte) Integer.parseInt("00000000", 2));
        b.put((byte) Integer.parseInt("00000000", 2));
        b.put((byte) Integer.parseInt("00000000", 2));
        b.put((byte) Integer.parseInt("01000000", 2));
        b.put((byte) Integer.parseInt("00010001", 2));
        b.put((byte) Integer.parseInt("51", 10)); // CS
        b.put((byte) Integer.parseInt("44", 10)); // CS
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
        b.put((byte) Integer.parseInt("00000000", 2));
        b.put((byte) Integer.parseInt("00010100", 2));
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
