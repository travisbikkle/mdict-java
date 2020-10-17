/*
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do
 * so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package org.joni;

public final class Option {
    /* options */
    public static final int NONE                 = 0;
    public static final int IGNORECASE           = (1 << 0);
    public static final int EXTEND               = (1 << 1);
    public static final int MULTILINE            = (1 << 2);
    public static final int SINGLELINE           = (1 << 3);
    public static final int FIND_LONGEST         = (1 << 4);
    public static final int FIND_NOT_EMPTY       = (1 << 5);
    public static final int NEGATE_SINGLELINE    = (1 << 6);
    public static final int DONT_CAPTURE_GROUP   = (1 << 7);
    public static final int CAPTURE_GROUP        = (1 << 8);

    /* options (search time) */
    public static final int NOTBOL               = (1 << 9);
    public static final int NOTEOL               = (1 << 10);
    public static final int POSIX_REGION         = (1 << 11);

    /* options (ctype range) */
    public static final int ASCII_RANGE          = (1 << 12);
    public static final int POSIX_BRACKET_ALL_RANGE = (1 << 13);
    public static final int WORD_BOUND_ALL_RANGE = (1 << 14);
    /* options (newline) */
    public static final int NEWLINE_CRLF         = (1 << 15);
    public static final int NOTBOS               = (1 << 16);
    public static final int NOTEOS               = (1 << 17);
    public static final int CR_7_BIT             = (1 << 18);

    public static final int MAXBIT               = (1 << 19); /* limit */

    public static final int DEFAULT              = NONE;

    public static String toString(int option) {
        String options = "";
        if (isIgnoreCase(option)) options += "IGNORECASE";
        if (isExtend(option)) options += "EXTEND";
        if (isMultiline(option)) options += "MULTILINE";
        if (isSingleline(option)) options += "SINGLELINE";
        if (isFindLongest(option)) options += "FIND_LONGEST";
        if (isFindNotEmpty(option)) options += "FIND_NOT_EMPTY";
        if (isNegateSingleline(option)) options += "NEGATE_SINGLELINE";
        if (isDontCaptureGroup(option)) options += "DONT_CAPTURE_GROUP";
        if (isCaptureGroup(option)) options += "CAPTURE_GROUP";
        if (isNotBol(option)) options += "NOTBOL";
        if (isNotEol(option)) options += "NOTEOL";
        if (isPosixRegion(option)) options += "POSIX_REGION";
        if (isCR7Bit(option)) options += "CR_7_BIT";
        return options;
    }

    public static boolean isIgnoreCase(int option) {
        return (option & IGNORECASE) != 0;
    }

    public static boolean isExtend(int option) {
        return (option & EXTEND) != 0;
    }

    public static boolean isSingleline(int option) {
        return (option & SINGLELINE) != 0;
    }

    public static boolean isMultiline(int option) {
        return (option & MULTILINE) != 0;
    }

    public static boolean isFindLongest(int option) {
        return (option & FIND_LONGEST) != 0;
    }

    public static boolean isFindNotEmpty(int option) {
        return (option & FIND_NOT_EMPTY) != 0;
    }

    public static boolean isFindCondition(int option) {
        return (option & (FIND_LONGEST | FIND_NOT_EMPTY)) != 0;
    }

    public static boolean isNegateSingleline(int option) {
        return (option & NEGATE_SINGLELINE) != 0;
    }

    public static boolean isDontCaptureGroup(int option) {
        return (option & DONT_CAPTURE_GROUP) != 0;
    }

    public static boolean isCaptureGroup(int option) {
        return (option & CAPTURE_GROUP) != 0;
    }

    public static boolean isNotBol(int option) {
        return (option & NOTBOL) != 0;
    }

    public static boolean isNotEol(int option) {
        return (option & NOTEOL) != 0;
    }

    public static boolean isPosixRegion(int option) {
        return (option & POSIX_REGION) != 0;
    }

    public static boolean isAsciiRange(int option) {
        return (option & ASCII_RANGE) != 0;
    }

    public static boolean isPosixBracketAllRange(int option) {
        return (option & POSIX_BRACKET_ALL_RANGE) != 0;
    }

    public static boolean isWordBoundAllRange(int option) {
        return (option & WORD_BOUND_ALL_RANGE) != 0;
    }

    public static boolean isNewlineCRLF(int option) {
        return (option & NEWLINE_CRLF) != 0;
    }

    public static boolean isCR7Bit(int option) {
        return (option & CR_7_BIT) != 0;
    }

    public static boolean isDynamic(int option) {
        // ignore-case and multibyte status are included in compiled code
        // return (option & (MULTILINE | IGNORECASE)) != 0;
        return false;
    }
}
