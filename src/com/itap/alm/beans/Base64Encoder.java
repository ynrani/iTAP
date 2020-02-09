package com.itap.alm.beans;

public class Base64Encoder {

	/** The Constant ALPHABET. */
	private final static char[] ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/"
			.toCharArray();

	/** The to int. */
	private static int[] toInt = new int[128];

	static {
		for (int i = 0; i < ALPHABET.length; i++) {
			toInt[ALPHABET[i]] = i;
		}
	}

	/**
	 * Translates the specified byte array into Base64 string.
	 *
	 * @param buf
	 *            the byte array (not null)
	 * @return the translated Base64 string (not null)
	 */
	public static String encode(final byte[] buf) {
		final int size = buf.length;
		final char[] ar = new char[(size + 2) / 3 * 4];
		int a = 0;
		int i = 0;
		while (i < size) {
			final byte b0 = buf[i++];
			final byte b1 = i < size ? buf[i++] : 0;
			final byte b2 = i < size ? buf[i++] : 0;

			final int mask = 0x3F;
			ar[a++] = ALPHABET[b0 >> 2 & mask];
			ar[a++] = ALPHABET[(b0 << 4 | (b1 & 0xFF) >> 4) & mask];
			ar[a++] = ALPHABET[(b1 << 2 | (b2 & 0xFF) >> 6) & mask];
			ar[a++] = ALPHABET[b2 & mask];
		}
		switch (size % 3) {
		case 1:
			ar[--a] = '=';
		case 2:
			ar[--a] = '=';
		}
		return new String(ar);
	}

}
