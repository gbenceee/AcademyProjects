package hu.ak_akademia.fájlmásolásistatisztika;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCreator {
	private FileOutputStream outputChannel;
	private File fileToCreate;

	public FileCreator(FileOutputStream stream, File fileToCreate) {
		this.outputChannel = stream;
		this.fileToCreate = fileToCreate;
	}

	public void createFileWithSpecifiedSize(byte[] bufferSize, int sizeOfFileInByte) throws IOException {
		while (fileToCreate.length() < sizeOfFileInByte) {
			outputChannel.write(bufferSize);
		}
	}
}
