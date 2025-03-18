package Test0318;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Test0318 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssnnnnnnnnn");

		try {
			System.out.print("분자 : ");
			int num1 = s.nextInt();
			System.out.print("분모 : ");
			int num2 = s.nextInt();
			System.out.println(num1 / num2);

			s.close();
		} catch (Exception e1) {
			System.out.println(e1.getMessage());
			String numericDateTime = now.format(formatter);
			String result = numericDateTime;

			File outputStreamWriter2 = new File("C:\\log\\" + result + ".txt");
			try (OutputStream os = new FileOutputStream(outputStreamWriter2, false);
					OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");) {

				osw.write("에러 메세지 로그 파일 입니다.\n".toCharArray());
				osw.write(e1.getMessage());
				osw.write('\n');
				osw.flush();

			} catch (IOException e2) {
			}

		}

	}

}
