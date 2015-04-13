package ru.rumter.samples.io.fileprocessor;

import java.io.*;
import java.util.*;

public class FileWholeProcessor {

	static final String RESOURCES_PATH = "../resources/";
	static final String FILE_PATH_IN = RESOURCES_PATH + "fileWhole.in.txt";
	static final String FILE_PATH_OUT = RESOURCES_PATH + "fileWhole.out.txt";

	public static String readAll(String filename) throws IOException {
		final int N = 1024 * 1024;
		char buffer[] = new char[N];
		StringBuilder res = new StringBuilder("");

		try (
			BufferedReader in = new BufferedReader(new FileReader(filename));
		) {
			int len = 0;
			while ((len = in.read(buffer, 0, N)) > 0) {
				res.append(new String(buffer, 0, len));
			}
		}

		return res.toString();
	}

	public static void writeAll(String filename, String content) throws IOException {
		try (
			BufferedWriter out = new BufferedWriter(new FileWriter(filename));
		) {
			out.write(content);
		}
	}

	public static void main(String args[]) throws IOException {

		String content = readAll(FILE_PATH_IN);

		writeAll(FILE_PATH_OUT, "Processed: " + content);

	}

}