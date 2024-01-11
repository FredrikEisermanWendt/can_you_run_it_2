package org.example.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Disk {

	private int total;
	private int used;
	private int free;
	private final static String getFreeSpaceCommand = "wmic logicaldisk get freespace";
	private final static String getTotalSizeCommand = "wmic logicaldisk get size";
	
	
	public Disk(int total, int used, int free) {
		this.total = total;
		this.used = used;
		this.free = free;
	}
	
	
	
	
	
	public int getTotal() {
		return total;
	}



	public void setTotal(int total) {
		this.total = total;
	}



	public int getUsed() {
		return used;
	}



	public void setUsed(int used) {
		this.used = used;
	}



	public int getFree() {
		return free;
	}



	public void setFree(int free) {
		this.free = free;
	}
	
	
	public static Disk getDiskInfo() throws IOException, InterruptedException {
		int total = getDisk(getTotalSizeCommand);
		int free = getDisk(getFreeSpaceCommand);
		int used = total - free;
		return new Disk(total, used, free);
	}


		public static int getDisk(String command) throws IOException, InterruptedException {
			 /*
			  * wmic logicaldisk get deviceid, freespace, size, volumename
			  * */

		        Process process = Runtime.getRuntime().exec(command);
		        process.waitFor(); 

		        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
		        String line;

				long temp = 0;
		        int value = 0;

		        // Skip the header line
		        reader.readLine();

		        while ((line = reader.readLine()) != null) {
					if (line != null && !line.isBlank()) {
						temp = Long.parseLong(line.trim());
					}
		        }

		        reader.close();
				temp = temp/(1024 * 1024 * 1024);
				value = (int) temp;
		        return value;
	}
}
