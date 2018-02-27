/* Generated SBE (Simple Binary Encoding) message codec */
package org.dev4fx.sbe;

import org.agrona.MutableDirectBuffer;
import org.agrona.DirectBuffer;

/**
 * Test Message
 */
@javax.annotation.Generated(value = { "uk.co.real_logic.sbe.generation.java.JavaGenerator" })
@SuppressWarnings("all")
public class TestMessageEncoder
{
    public static final int BLOCK_LENGTH = 8;
    public static final int TEMPLATE_ID = 1;
    public static final int SCHEMA_ID = 1;
    public static final int SCHEMA_VERSION = 0;
    public static final java.nio.ByteOrder BYTE_ORDER = java.nio.ByteOrder.LITTLE_ENDIAN;

    private final TestMessageEncoder parentMessage = this;
    private MutableDirectBuffer buffer;
    protected int offset;
    protected int limit;

    public int sbeBlockLength()
    {
        return BLOCK_LENGTH;
    }

    public int sbeTemplateId()
    {
        return TEMPLATE_ID;
    }

    public int sbeSchemaId()
    {
        return SCHEMA_ID;
    }

    public int sbeSchemaVersion()
    {
        return SCHEMA_VERSION;
    }

    public String sbeSemanticType()
    {
        return "";
    }

    public MutableDirectBuffer buffer()
    {
        return buffer;
    }

    public int offset()
    {
        return offset;
    }

    public TestMessageEncoder wrap(final MutableDirectBuffer buffer, final int offset)
    {
        this.buffer = buffer;
        this.offset = offset;
        limit(offset + BLOCK_LENGTH);

        return this;
    }

    public TestMessageEncoder wrapAndApplyHeader(
        final MutableDirectBuffer buffer, final int offset, final MessageHeaderEncoder headerEncoder)
    {
        headerEncoder
            .wrap(buffer, offset)
            .blockLength(BLOCK_LENGTH)
            .templateId(TEMPLATE_ID)
            .schemaId(SCHEMA_ID)
            .version(SCHEMA_VERSION);

        return wrap(buffer, offset + MessageHeaderEncoder.ENCODED_LENGTH);
    }

    public int encodedLength()
    {
        return limit - offset;
    }

    public int limit()
    {
        return limit;
    }

    public void limit(final int limit)
    {
        this.limit = limit;
    }

    public static int messageIdEncodingOffset()
    {
        return 0;
    }

    public static int messageIdEncodingLength()
    {
        return 8;
    }

    public static long messageIdNullValue()
    {
        return -9223372036854775808L;
    }

    public static long messageIdMinValue()
    {
        return 0L;
    }

    public static long messageIdMaxValue()
    {
        return 9223372036854775807L;
    }

    public TestMessageEncoder messageId(final long value)
    {
        buffer.putLong(offset + 0, value, java.nio.ByteOrder.LITTLE_ENDIAN);
        return this;
    }


    private final EntriesEncoder entries = new EntriesEncoder();

    public static long entriesId()
    {
        return 2;
    }

    public EntriesEncoder entriesCount(final int count)
    {
        entries.wrap(parentMessage, buffer, count);
        return entries;
    }

    public static class EntriesEncoder
    {
        private static final int HEADER_SIZE = 4;
        private final GroupSizeEncodingEncoder dimensions = new GroupSizeEncodingEncoder();
        private TestMessageEncoder parentMessage;
        private MutableDirectBuffer buffer;
        private int count;
        private int index;
        private int offset;

        public void wrap(
            final TestMessageEncoder parentMessage, final MutableDirectBuffer buffer, final int count)
        {
            if (count < 0 || count > 65534)
            {
                throw new IllegalArgumentException("count outside allowed range: count=" + count);
            }

            this.parentMessage = parentMessage;
            this.buffer = buffer;
            dimensions.wrap(buffer, parentMessage.limit());
            dimensions.blockLength((int)8);
            dimensions.numInGroup((int)count);
            index = -1;
            this.count = count;
            parentMessage.limit(parentMessage.limit() + HEADER_SIZE);
        }

        public static int sbeHeaderSize()
        {
            return HEADER_SIZE;
        }

        public static int sbeBlockLength()
        {
            return 8;
        }

        public EntriesEncoder next()
        {
            if (index + 1 >= count)
            {
                throw new java.util.NoSuchElementException();
            }

            offset = parentMessage.limit();
            parentMessage.limit(offset + sbeBlockLength());
            ++index;

            return this;
        }

        public static int entryIdEncodingOffset()
        {
            return 0;
        }

        public static int entryIdEncodingLength()
        {
            return 8;
        }

        public static long entryIdNullValue()
        {
            return -9223372036854775808L;
        }

        public static long entryIdMinValue()
        {
            return 0L;
        }

        public static long entryIdMaxValue()
        {
            return 9223372036854775807L;
        }

        public EntriesEncoder entryId(final long value)
        {
            buffer.putLong(offset + 0, value, java.nio.ByteOrder.LITTLE_ENDIAN);
            return this;
        }


        public static int entryPayloadId()
        {
            return 4;
        }

        public static String entryPayloadMetaAttribute(final MetaAttribute metaAttribute)
        {
            switch (metaAttribute)
            {
                case EPOCH: return "unix";
                case TIME_UNIT: return "nanosecond";
                case SEMANTIC_TYPE: return "";
                case PRESENCE: return "required";
            }

            return "";
        }

        public static int entryPayloadHeaderLength()
        {
            return 4;
        }

        public EntriesEncoder putEntryPayload(final DirectBuffer src, final int srcOffset, final int length)
        {
            if (length > 1073741824)
            {
                throw new IllegalStateException("length > maxValue for type: " + length);
            }

            final int headerLength = 4;
            final int limit = parentMessage.limit();
            parentMessage.limit(limit + headerLength + length);
            buffer.putInt(limit, (int)length, java.nio.ByteOrder.LITTLE_ENDIAN);
            buffer.putBytes(limit + headerLength, src, srcOffset, length);

            return this;
        }

        public EntriesEncoder putEntryPayload(final byte[] src, final int srcOffset, final int length)
        {
            if (length > 1073741824)
            {
                throw new IllegalStateException("length > maxValue for type: " + length);
            }

            final int headerLength = 4;
            final int limit = parentMessage.limit();
            parentMessage.limit(limit + headerLength + length);
            buffer.putInt(limit, (int)length, java.nio.ByteOrder.LITTLE_ENDIAN);
            buffer.putBytes(limit + headerLength, src, srcOffset, length);

            return this;
        }
    }


    public String toString()
    {
        return appendTo(new StringBuilder(100)).toString();
    }

    public StringBuilder appendTo(final StringBuilder builder)
    {
        TestMessageDecoder writer = new TestMessageDecoder();
        writer.wrap(buffer, offset, BLOCK_LENGTH, SCHEMA_VERSION);

        return writer.appendTo(builder);
    }
}
