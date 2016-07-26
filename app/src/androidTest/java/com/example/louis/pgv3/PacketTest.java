package com.example.louis.pgv3;

import android.app.Application;
import android.test.ApplicationTestCase;
import android.util.Log;

import com.example.louis.pgv3.packetBuilder.BuilderTcp;
import com.example.louis.pgv3.packetBuilder.Packet;
import com.example.louis.pgv3.sessions.SessionTcp;

import java.nio.ByteBuffer;

public class PacketTest extends ApplicationTestCase<Application> {
    private ByteBuffer testPacket = TestPacketTcp.getPacket();
    private Packet constrPacket = new Packet(testPacket);

    private ByteBuffer payload = ByteBuffer.allocate(12);
    private SessionTcp sessionTcp = new SessionTcp(null, null, ipStringToInt("173.194.39.23"), ipStringToInt("192.168.178.23"), (short) 80, (short) 42, (short) 56243);
    private  ByteBuffer builtPacketTcp;


    public PacketTest() {
        super(Application.class);

        payload.put(testPacket.array(), 40, 12);
        sessionTcp.lastAck = 240131785;
        builtPacketTcp = BuilderTcp.getDataPacket(payload, sessionTcp, payload.capacity());
    }

    public void testPacketFromPacketClass() {
        ApplicationTest.assertByteBufferEquals(testPacket, constrPacket.getPacketBuffer());
    }

    public void testPacketFromBuilder() {
        ApplicationTest.assertByteBufferEquals(testPacket, builtPacketTcp);
    }

    public void testIpSource() {
        assertEquals(testPacket.getInt(12), constrPacket.getSourceAddress());
    }

    public void testIpDestination() {
        assertEquals(testPacket.getInt(16), constrPacket.getDestinationAddress());
    }

    public void testIpChecksum() {
        assertEquals(testPacket.getShort(10), constrPacket.getIpChecksum());
    }

    public void testTcpPayload() {
        ApplicationTest.assertByteBufferEquals(payload, constrPacket.getPayload());
    }

    public void testIpStringToInt() {
        assertEquals(2130706433, ipStringToInt("127.0.0.1"));
        assertEquals(-1379784937, ipStringToInt("173.194.39.23"));
    }

    public void testIpIntToStr() {
        assertEquals("127.0.0.1", ipIntToStr(2130706433));
        assertEquals("173.194.39.23", ipIntToStr(-1379784937));
        assertEquals("192.168.178.23", ipIntToStr(-1062686185));
    }

    private int ipStringToInt(String ipString) {
        int ipAddress = 0;
        String[] ipStringParts = ipString.split("\\.");

        for (int i=0; i < 4; i++) {
            ipAddress += (Integer.parseInt(ipStringParts[i]) * (long) Math.pow(256, 3-i));
        }

        return ipAddress;
    }

    private static String ipIntToStr(long ip) {
        String ipString = Integer.toString((int) ip >> 24 & 0xFF) + ".";
        ipString += Integer.toString((int) ip >> 16 & 0xFF) + ".";
        ipString += Integer.toString((int) ip >> 8 & 0xFF) + ".";
        ipString += Integer.toString((int) ip & 0xFF);

        return ipString;
    }

    private void printBuffer(ByteBuffer buffer) {
        Log.i("***BUFFER", "cap: " + buffer.capacity() + " pos: " + buffer.position());

        for (int i=0; i<buffer.position(); i++) {
            Log.i("***BUFFER", "i " + (buffer.get(i) & 0xFF));
        }
    }
}
