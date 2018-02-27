/* Generated SBE (Simple Binary Encoding) message codec */
package org.dev4fx.sbe.fix;

import org.agrona.DirectBuffer;
import org.agrona.MutableDirectBuffer;
import org.dev4fx.sbe.GroupSizeEncodingDecoder;
import org.dev4fx.sbe.MetaAttribute;

/**
 * Test Message
 */
@javax.annotation.Generated(value = { "uk.co.real_logic.sbe.generation.java.JavaGenerator" })
@SuppressWarnings("all")
public class TestMessageDecoder
{
    public static final int BLOCK_LENGTH = 8;
    public static final int TEMPLATE_ID = 1;
    public static final int SCHEMA_ID = 1;
    public static final int SCHEMA_VERSION = 0;
    public static final java.nio.ByteOrder BYTE_ORDER = java.nio.ByteOrder.LITTLE_ENDIAN;

    private final TestMessageDecoder parentMessage = this;
    private DirectBuffer buffer;
    protected int offset;
    protected int limit;
    protected int actingBlockLength;
    protected int actingVersion;

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

    public DirectBuffer buffer()
    {
        return buffer;
    }

    public int offset()
    {
        return offset;
    }

    public TestMessageDecoder wrap(
        final DirectBuffer buffer, final int offset, final int actingBlockLength, final int actingVersion)
    {
        this.buffer = buffer;
        this.offset = offset;
        this.actingBlockLength = actingBlockLength;
        this.actingVersion = actingVersion;
        limit(offset + actingBlockLength);

        return this;
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

    public static int messageIdId()
    {
        return 1;
    }

    public static int messageIdSinceVersion()
    {
        return 0;
    }

    public static int messageIdEncodingOffset()
    {
        return 0;
    }

    public static int messageIdEncodingLength()
    {
        return 8;
    }

    public static String messageIdMetaAttribute(final MetaAttribute metaAttribute)
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

    public long messageId()
    {
        return buffer.getLong(offset + 0, java.nio.ByteOrder.LITTLE_ENDIAN);
    }


    private final EntriesDecoder entries = new EntriesDecoder();

    public static long entriesDecoderId()
    {
        return 2;
    }

    public static int entriesDecoderSinceVersion()
    {
        return 0;
    }

    public EntriesDecoder entries()
    {
        entries.wrap(parentMessage, buffer);
        return entries;
    }

    public static class EntriesDecoder
        implements Iterable<EntriesDecoder>, java.util.Iterator<EntriesDecoder>
    {
        private static final int HEADER_SIZE = 4;
        private final GroupSizeEncodingDecoder dimensions = new GroupSizeEncodingDecoder();
        private TestMessageDecoder parentMessage;
        private DirectBuffer buffer;
        private int count;
        private int index;
        private int offset;
        private int blockLength;

        public void wrap(
                final TestMessageDecoder parentMessage, final DirectBuffer buffer)
        {
            this.parentMessage = parentMessage;
            this.buffer = buffer;
            dimensions.wrap(buffer, parentMessage.limit());
            blockLength = dimensions.blockLength();
            count = dimensions.numInGroup();
            index = -1;
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

        public int actingBlockLength()
        {
            return blockLength;
        }

        public int count()
        {
            return count;
        }

        public java.util.Iterator<EntriesDecoder> iterator()
        {
            return this;
        }

        public void remove()
        {
            throw new UnsupportedOperationException();
        }

        public boolean hasNext()
        {
            return (index + 1) < count;
        }

        public EntriesDecoder next()
        {
            if (index + 1 >= count)
            {
                throw new java.util.NoSuchElementException();
            }

            offset = parentMessage.limit();
            parentMessage.limit(offset + blockLength);
            ++index;

            return this;
        }

        public static int entryIdId()
        {
            return 3;
        }

        public static int entryIdSinceVersion()
        {
            return 0;
        }

        public static int entryIdEncodingOffset()
        {
            return 0;
        }

        public static int entryIdEncodingLength()
        {
            return 8;
        }

        public static String entryIdMetaAttribute(final MetaAttribute metaAttribute)
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

        public long entryId()
        {
            return buffer.getLong(offset + 0, java.nio.ByteOrder.LITTLE_ENDIAN);
        }


        public static int entryPayloadId()
        {
            return 4;
        }

        public static int entryPayloadSinceVersion()
        {
            return 0;
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

        public int entryPayloadLength()
        {
            final int limit = parentMessage.limit();
            return (int)(buffer.getInt(limit, java.nio.ByteOrder.LITTLE_ENDIAN) & 0xFFFF_FFFFL);
        }

        public int getEntryPayload(final MutableDirectBuffer dst, final int dstOffset, final int length)
        {
            final int headerLength = 4;
            final int limit = parentMessage.limit();
            final int dataLength = (int)(buffer.getInt(limit, java.nio.ByteOrder.LITTLE_ENDIAN) & 0xFFFF_FFFFL);
            final int bytesCopied = Math.min(length, dataLength);
            parentMessage.limit(limit + headerLength + dataLength);
            buffer.getBytes(limit + headerLength, dst, dstOffset, bytesCopied);

            return bytesCopied;
        }

        public int getEntryPayload(final byte[] dst, final int dstOffset, final int length)
        {
            final int headerLength = 4;
            final int limit = parentMessage.limit();
            final int dataLength = (int)(buffer.getInt(limit, java.nio.ByteOrder.LITTLE_ENDIAN) & 0xFFFF_FFFFL);
            final int bytesCopied = Math.min(length, dataLength);
            parentMessage.limit(limit + headerLength + dataLength);
            buffer.getBytes(limit + headerLength, dst, dstOffset, bytesCopied);

            return bytesCopied;
        }


        public String toString()
        {
            return appendTo(new StringBuilder(100)).toString();
        }

        public StringBuilder appendTo(final StringBuilder builder)
        {
            builder.append('(');
            //Token{signal=BEGIN_FIELD, name='entryId', referencedName='null', description='null', id=3, version=0, deprecated=0, encodedLength=0, offset=0, componentTokenCount=3, encoding=Encoding{presence=REQUIRED, primitiveType=null, byteOrder=LITTLE_ENDIAN, minValue=null, maxValue=null, nullValue=null, constValue=null, characterEncoding='null', epoch='unix', timeUnit=nanosecond, semanticType='null'}}
            //Token{signal=ENCODING, name='Sequence', referencedName='null', description='null', id=-1, version=0, deprecated=0, encodedLength=8, offset=0, componentTokenCount=1, encoding=Encoding{presence=REQUIRED, primitiveType=INT64, byteOrder=LITTLE_ENDIAN, minValue=0, maxValue=null, nullValue=null, constValue=null, characterEncoding='null', epoch='unix', timeUnit=nanosecond, semanticType='null'}}
            builder.append("entryId=");
            builder.append(entryId());
            builder.append('|');
            //Token{signal=BEGIN_VAR_DATA, name='entryPayload', referencedName='null', description='null', id=4, version=0, deprecated=0, encodedLength=0, offset=8, componentTokenCount=6, encoding=Encoding{presence=REQUIRED, primitiveType=null, byteOrder=LITTLE_ENDIAN, minValue=null, maxValue=null, nullValue=null, constValue=null, characterEncoding='null', epoch='unix', timeUnit=nanosecond, semanticType='null'}}
            builder.append("entryPayload=");
            builder.append(entryPayloadLength() + " raw bytes");

            //FIXME add this line to generated decoder
            parentMessage.limit(parentMessage.limit() + entryPayloadHeaderLength() + entryPayloadLength());
            builder.append(')');
            return builder;
        }
    }


    public String toString()
    {
        return appendTo(new StringBuilder(100)).toString();
    }

    public StringBuilder appendTo(final StringBuilder builder)
    {
        final int originalLimit = limit();
        limit(offset + actingBlockLength);
        builder.append("[TestMessage](sbeTemplateId=");
        builder.append(TEMPLATE_ID);
        builder.append("|sbeSchemaId=");
        builder.append(SCHEMA_ID);
        builder.append("|sbeSchemaVersion=");
        if (parentMessage.actingVersion != SCHEMA_VERSION)
        {
            builder.append(parentMessage.actingVersion);
            builder.append('/');
        }
        builder.append(SCHEMA_VERSION);
        builder.append("|sbeBlockLength=");
        if (actingBlockLength != BLOCK_LENGTH)
        {
            builder.append(actingBlockLength);
            builder.append('/');
        }
        builder.append(BLOCK_LENGTH);
        builder.append("):");
        //Token{signal=BEGIN_FIELD, name='messageId', referencedName='null', description='null', id=1, version=0, deprecated=0, encodedLength=0, offset=0, componentTokenCount=3, encoding=Encoding{presence=REQUIRED, primitiveType=null, byteOrder=LITTLE_ENDIAN, minValue=null, maxValue=null, nullValue=null, constValue=null, characterEncoding='null', epoch='unix', timeUnit=nanosecond, semanticType='null'}}
        //Token{signal=ENCODING, name='Sequence', referencedName='null', description='null', id=-1, version=0, deprecated=0, encodedLength=8, offset=0, componentTokenCount=1, encoding=Encoding{presence=REQUIRED, primitiveType=INT64, byteOrder=LITTLE_ENDIAN, minValue=0, maxValue=null, nullValue=null, constValue=null, characterEncoding='null', epoch='unix', timeUnit=nanosecond, semanticType='null'}}
        builder.append("messageId=");
        builder.append(messageId());
        builder.append('|');
        //Token{signal=BEGIN_GROUP, name='entries', referencedName='null', description='null', id=2, version=0, deprecated=0, encodedLength=8, offset=8, componentTokenCount=15, encoding=Encoding{presence=REQUIRED, primitiveType=null, byteOrder=LITTLE_ENDIAN, minValue=null, maxValue=null, nullValue=null, constValue=null, characterEncoding='null', epoch='null', timeUnit=null, semanticType='null'}}
        builder.append("entries=[");
        EntriesDecoder entries = entries();
        if (entries.count() > 0)
        {
            while (entries.hasNext())
            {
                entries.next().appendTo(builder);
                builder.append(',');
            }
            builder.setLength(builder.length() - 1);
        }
        builder.append(']');

        limit(originalLimit);

        return builder;
    }
}
