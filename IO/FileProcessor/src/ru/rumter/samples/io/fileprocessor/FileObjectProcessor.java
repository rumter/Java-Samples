package ru.rumter.samples.io.fileprocessor;

import java.io.*;
import java.util.*;

public class FileObjectProcessor {

	static final String RESOURCES_PATH = "../resources/";
	static final String FILE_PATH = RESOURCES_PATH + "fileObject.txt";

	static class SomeObject implements Serializable {
		Long a = 123456789l;
		String b = "abcdef\r\ngh";
		Double c[] = new Double[] { 1.123, 12.3, 0.123 };

		@Override
		public boolean equals(Object o) {
			if (o == null || !(o instanceof SomeObject)) {
				return false;
			}
			SomeObject obj = (SomeObject) o;
			return a.equals(obj.a) && b.equals(obj.b) && obj.c.length == 3
				&& c[0].equals(obj.c[0]) && c[1].equals(obj.c[1]) && c[2].equals(obj.c[2]);
		}
	}

	public static Object readObject(String filename) throws IOException, ClassNotFoundException {
		try (
			FileInputStream in = new FileInputStream(filename);
			ObjectInputStream oin = new ObjectInputStream(in);
		) {
			return oin.readObject();
		}
	}

	public static void writeObject(String filename, Object obj) throws IOException {
		try (
			FileOutputStream out = new FileOutputStream(filename);
			ObjectOutputStream oout = new ObjectOutputStream(out);
		) {
			oout.writeObject(obj);
		}
	}

	public static void main(String args[]) throws IOException, ClassNotFoundException {

		SomeObject obj = new SomeObject();
		obj.a = 987654321l;

		writeObject(FILE_PATH, obj);

		SomeObject obj2 = (SomeObject) readObject(FILE_PATH);

		if (!obj.equals(obj2)) {
			throw new RuntimeException("objects not equals");
		}

	}

}