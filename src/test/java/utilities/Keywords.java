package utilities;

import java.sql.Timestamp;

public class Keywords {
	public static void wait(int second) throws InterruptedException {
		Thread.sleep(second * 1000);
	}

	public static String gitTimeStamp() {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		return timestamp.getTime() + "";
	}


}
