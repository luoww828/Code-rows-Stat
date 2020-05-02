package javaTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JavaTest {

	private static Integer code1 = 0;
	private static Integer codeComments1 = 0;
	private static Integer codeBlank1 = 0;
	
	private static Integer code2 = 0;
	private static Integer codeComments2 = 0;
	private static Integer codeBlank2 = 0;

	public static void main(String[] args) {
//		File file = new File("C:\\Users\\cn006278\\Desktop\\da\\ttt");
		File file = new File("E:\\thprojects\\leaderdesktop");
		factFiles1(file);
		System.out.println(".Java�ļ���������:" + code1);
		System.out.println(".Java�ļ��հ�����:" + codeBlank1);
		System.out.println(".Java�ļ�ע������:" + codeComments1);
		System.out.println("*********************************************************");
		factFiles2(file);
		System.out.println(".Java֮���ļ���������:" + code2);
		System.out.println(".Java֮���ļ��հ�����:" + codeBlank2);
		System.out.println(".Java֮���ļ�ע������:" + codeComments2);
	}

	public static void factFiles1(File file) {
		
		BufferedReader br = null;
		String s = null;

		// ��Դ�ļ���Ŀ¼����ݹ�
		if (file.isDirectory()) {
			File[] files = file.listFiles();
			for (File f : files) {
				factFiles1(f);
			}
		} else {
			try {
				br = new BufferedReader(new FileReader(file));
				boolean comm = false;
				while ((s = br.readLine()) != null) {
					if (file.getName().endsWith(".java")) {
						if (s.startsWith("/*") && s.endsWith("*/")) {
							codeComments1++;
						} else if (s.trim().startsWith("//")) {
							codeComments1++;
						} else if (s.startsWith("/*") && !s.endsWith("*/")) {
							codeComments1++;
							comm = true;
						} else if (!s.startsWith("/*") && s.endsWith("*/")) {
							codeComments1++;
							comm = false;
						} else if (comm) {
							codeComments1++;
						} else if (s.trim().length() < 1) {
							codeBlank1++;
						} else {
							code1++;
						}
					}
				}
				br.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void factFiles2(File file) {
		
		BufferedReader br = null;
		String s = null;

		// ��Դ�ļ���Ŀ¼����ݹ�
		if (file.isDirectory()) {
			File[] files = file.listFiles();
			for (File f : files) {
				factFiles2(f);
			}
		} else {
			try {
				br = new BufferedReader(new FileReader(file));
				boolean comm = false;
				while ((s = br.readLine()) != null) {
					if (!(file.getName().endsWith(".java"))) {
						if (s.startsWith("/*") && s.endsWith("*/")) {
							codeComments2++;
						} else if (s.trim().startsWith("//")) {
							codeComments2++;
						} else if (s.startsWith("/*") && !s.endsWith("*/")) {
							codeComments2++;
							comm = true;
						} else if (!s.startsWith("/*") && s.endsWith("*/")) {
							codeComments2++;
							comm = false;
						} else if (comm) {
							codeComments2++;
						} else if (s.trim().length() < 1) {
							codeBlank2++;
						} else {
							code2++;
						}
					}
				}
				br.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
