package ru.rumter.samples.io.filelineprocessor;

import java.io.*;
import java.util.*;

public class FileLineProcessor {

	static final String RESOURCES_PATH = "../resources/";
	static final String FILE_PATH_IN = RESOURCES_PATH + "fileLine.in.txt";
	static final String FILE_PATH_OUT = RESOURCES_PATH + "fileLine.out.txt";

	public static void main(String args[]) throws IOException {

		List<String> lines = new ArrayList<>();
		
		try (
			BufferedReader in = new BufferedReader(new FileReader(FILE_PATH_IN));
		) {
			String line = null;
			while ((line = in.readLine()) != null) {
				lines.add(line);
			}
		}

		for (int i = 0; i < lines.size(); ++ i) {
			lines.set(i, "processed: " + lines.get(i));
		}

		try (
			BufferedWriter out = new BufferedWriter(new FileWriter(FILE_PATH_OUT));
		) {
			for (String line : lines) {
				out.write(line);
				out.newLine();
			}
		}

	}

}