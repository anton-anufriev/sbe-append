package org.dev4fx.sbe;

import org.agrona.concurrent.UnsafeBuffer;
import org.junit.Before;
import org.junit.Test;

import java.nio.ByteBuffer;

import static org.junit.Assert.assertTrue;

public class TestMessageEncodingTest {
    private static final byte[] MESSAGE = "This is a test message payload".getBytes();

    private TestMessageEncoder encoder = new TestMessageEncoder();
    private ByteBuffer allocatedBuffer = ByteBuffer.allocate(512);
    private UnsafeBuffer encodingBuffer = new UnsafeBuffer(allocatedBuffer);

    @Before
    public void setUp() throws Exception {
        encoder.wrap(encodingBuffer, 0 )
                .messageId(123)
                    .entriesCount(3)
                    .next()
                        .entryId(456)
                        .putEntryPayload(MESSAGE, 0, MESSAGE.length)
                    .next()
                        .entryId(789)
                        .putEntryPayload(MESSAGE, 0, MESSAGE.length);
    }

    @Test
    public void decoder_will_NOT_print_second_entryId_when_there_is_a_bug() throws Exception {
        //given
        final TestMessageDecoder decoder = new TestMessageDecoder();

        decoder.wrap(encodingBuffer, 0 , TestMessageDecoder.BLOCK_LENGTH, TestMessageDecoder.SCHEMA_VERSION);
        final StringBuilder stringBuilder = new StringBuilder();

        //when
        decoder.appendTo(stringBuilder);

        //then
        System.out.println(stringBuilder);

        assertTrue(stringBuilder.indexOf("entryId=456") > 0);
        assertTrue(stringBuilder.indexOf("entryId=789") < 0);
    }

    @Test
    public void decoder_should_print_second_entryId_when_bug_is_fixed() throws Exception {
        //given
        final org.dev4fx.sbe.fix.TestMessageDecoder decoder = new org.dev4fx.sbe.fix.TestMessageDecoder();

        decoder.wrap(encodingBuffer, 0 , TestMessageDecoder.BLOCK_LENGTH, TestMessageDecoder.SCHEMA_VERSION);
        final StringBuilder stringBuilder = new StringBuilder();

        //when
        decoder.appendTo(stringBuilder);

        //then
        System.out.println(stringBuilder);

        assertTrue(stringBuilder.indexOf("entryId=456") > 0);
        assertTrue(stringBuilder.indexOf("entryId=789") > 0);
    }

}
