package ru.rumter.samples.io.fileprocessor;

import java.io.*;
import java.util.*;

public class FileDataProcessor {

	static final String RESOURCES_PATH = "../resources/";
	static final String FILE_PATH = RESOURCES_PATH + "fileData.txt";

	static void check(boolean condition) {
		if (!condition) {
			throw new RuntimeException("check condition error");
		}
	}

	public static void main(String args[]) throws IOException {

		boolean a = true;
		byte b = (byte)1;
		char c = 'A';
		int d = 12345678;
		long e = 123456789123l;
		short f = (short)12345;
		float g = 12.123f;
		double h = 123.12345;
		String i = "ABCDEFGHI";

		try (
			DataOutputStream out = new DataOutputStream(new FileOutputStream(FILE_PATH));
		) {
			out.writeBoolean(a);
			out.writeByte(b);
			out.writeChar(c);
			out.writeInt(d);
			out.writeLong(e);
			out.writeShort(f);
			out.writeFloat(g);
			out.writeDouble(h);
			out.writeUTF(i);
		}
		
		try (
			DataInputStream in = new DataInputStream(new FileInputStream(FILE_PATH));
		) {
			check(a == in.readBoolean());
			check(b == in.readByte());
			check(c == in.readChar());
			check(d == in.readInt());
			check(e == in.readLong());
			check(f == in.readShort());
			check(g == in.readFloat());
			check(h == in.readDouble());
			check(i.equals(in.readUTF()));
		}

	}

}