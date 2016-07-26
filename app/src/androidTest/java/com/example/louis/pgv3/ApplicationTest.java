package com.example.louis.pgv3;

import android.app.Application;
import android.test.ApplicationTestCase;
import android.util.Log;

import java.nio.ByteBuffer;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */

public class ApplicationTest extends ApplicationTestCase<Application> {

    public ApplicationTest() {
        super(Application.class);
    }

    protected static void assertByteBufferEquals(ByteBuffer b1, ByteBuffer b2) {
        for (int i=0; i<b1.capacity() || i<b2.capacity(); i++) {
            Log.i("i", Integer.toString(i));
            assertEquals(b1.array()[i], b2.array()[i]);
        }
    }
}