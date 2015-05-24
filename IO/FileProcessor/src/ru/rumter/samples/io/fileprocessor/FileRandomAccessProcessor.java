package ru.rumter.samples.io.fileprocessor;

import java.io.*;
import java.util.*;

public class FileRandomAccessProcessor {

	static final String RESOURCES_PATH = "../resources/";
	static final String FILE_PATH = RESOURCES_PATH + "fileRandomAccess.txt";

	static void check(boolean condition, String message) {
		if (!condition) {
			throw new RuntimeException(message);
		}
	}

	public static void main(String args[]) throws IOException {

		// clear file
		try (
			PrintWriter pw = new PrintWriter(FILE_PATH);
		) {
			pw.print("");
		}

		try (
			RandomAccessFile file = new RandomAccessFile(FILE_PATH, "rw");
		) {
			// write
			// 123456789
			for (int i = 0; i <= 9; ++ i) {
				file.writeInt(i);
			}

			// check write
			for (int i = 9; i >= 0; -- i) {
				file.seek(i * 4);
				int a = file.readInt();
				check(a == i, "check number");
			}
		}

	}

}