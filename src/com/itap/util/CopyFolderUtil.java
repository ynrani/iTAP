package com.itap.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.http.ParseException;

import com.itap.constant.ITAPConstants;

public class CopyFolderUtil {

	public static void main(String[] args) throws ParseException, IOException {
		String destination = "HIG" + "\\" + "HIG" + "_" + "HIG" + "\\UFT";

		copyFolder(null, destination, "\\\\in-pnq-coe30\\e$\\iTAP\\");

	}

	public static String copyFolder(String source, String destination, String rootPath) {

		try {
			File sour = new File(ITAPConstants.FT_UFT_MAINSCRIPT_PATH);

			File dest = new File(rootPath + destination);
			FileUtils.copyDirectory(sour, dest);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

}
