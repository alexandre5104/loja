package com.faxb.helpers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;

import jakarta.servlet.http.Part;

public class FileSaver {
	
	public String writeFile(Part part){
		
		String name = part.getSubmittedFileName();
		
		if (name == null) {
			System.out.println("Arquvio em branco");
		}
		// Pasta temporária da JVM
		File tmpDir = new File("C:/temp");
		if (!tmpDir.exists()) {
			tmpDir.mkdir();
		}
		// Cria o aqrquivo
		File file = new File(tmpDir, name);
		// Abre a OutputStream para escrever no arquivo
		FileOutputStream out = null;
		try {
			out = new FileOutputStream(file);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		// Escreve os dados no arquivo
		try {
			IOUtils.copy(part.getInputStream(), out);
		} catch (IOException e) {
			e.printStackTrace();
		}
		IOUtils.closeQuietly(out);
		
		return file.getAbsolutePath();
	}

}
