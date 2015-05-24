package ru.rumter.samples.io.fileprocessor;

import java.io.*;
import java.util.*;

public class FileAppendProcessor {

	static final String RESOURCES_PATH = "../resources/";
	static final String FILE_PATH = RESOURCES_PATH + "fileAppend.txt";

	public static void main(String args[]) throws IOException {

		final boolean append = true;

		try (
			PrintWriter pw = new PrintWriter(new FileWriter(FILE_PATH, append));
		) {
			pw.println("data");
		}

	}

}