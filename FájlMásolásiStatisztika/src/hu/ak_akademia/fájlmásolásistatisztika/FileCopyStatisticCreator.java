package hu.ak_akademia.fájlmásolásistatisztika;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

public class FileCopyStatisticCreator {
	private FileInputStream readChannel;
	private FileOutputStream copyChannel;

	public FileCopyStatisticCreator(FileInputStream readChannel, FileOutputStream copyChannel) {
		this.readChannel = readChannel;
		this.copyChannel = copyChannel;
	}

	public void createStatistic(Map<Integer, Long> copyStatistics, byte[] bufferSize) throws IOException {
		while (bufferSize.length < 50_000) {
			long requiredNanosecondsToCopy = measureTimeOfCopy(bufferSize);
			copyStatistics.put(bufferSize.length, requiredNanosecondsToCopy);
			bufferSize = increaseBufferSize(bufferSize);
		}
	}

	private long measureTimeOfCopy(byte[] bufferSize) throws IOException {
		long startTime = System.nanoTime();
		writeBytesToFile(bufferSize);
		long finishTime = System.nanoTime();
		return finishTime - startTime;
	}

	private void writeBytesToFile(byte[] bufferSize) throws IOException {
		int readBytes;
		while ((readBytes = readChannel.read(bufferSize)) != -1) {
			copyChannel.write(bufferSize);
		}
	}

	private byte[] increaseBufferSize(byte[] bufferSize) {
		return new byte[bufferSize.length + 100];
	}

}