package learningtest.java.util.zip;

import org.junit.jupiter.api.Test;

import java.util.zip.CRC32;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link CRC32}.
 *
 * @author Johnny Lim
 */
class CRC32Tests {

    @Test
    void test() {
        CRC32 crc32 = new CRC32();
        crc32.update("Hello".getBytes());
        crc32.update("World".getBytes());
        long value = crc32.getValue();
        assertThat(value).isNotZero();

        crc32.reset();
        assertThat(crc32.getValue()).isZero();

        crc32.update("HelloWorld".getBytes());
        assertThat(crc32.getValue()).isEqualTo(value);

        crc32.reset();
        assertThat(crc32.getValue()).isZero();

        crc32.update("World".getBytes());
        crc32.update("Hello".getBytes());
        assertThat(crc32.getValue()).isNotEqualTo(value);
    }

}
