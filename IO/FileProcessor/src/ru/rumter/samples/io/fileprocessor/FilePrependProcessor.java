package ru.rumter.samples.io.fileprocessor;

import java.io.*;
import java.util.*;

public class FilePrependProcessor {

	static final String RESOURCES_PATH = "../resources/";
	static final String FILE_PATH = RESOURCES_PATH + "filePrepend.txt";

	public static void main(String args[]) throws IOException {

		try (
			RandomAccessFile file = new RandomAccessFile(FILE_PATH, "rws");
		) {
			byte content[] = new byte[(int) file.length()];
			file.readFully(content);

			file.seek(0);
			file.writeBytes("prepend data\r\n");
			file.write(content);
		}

	}

}