package com.joe.kosmo_post.file;

import java.io.File;

import org.springframework.beans.factory.annotation.Value;

public class FiledManager {
	
	
	@Value("${file.path}")
	private String Path;
	
	public void fileSave() throws Exception {
		
		String name = String.valueOf(System.currentTimeMillis());

		//1.어디에 저장
		File file = new File(Path, name);
		if(!file.exists()) {
			file.mkdirs();
		}
	
		//2.파일명
		
		//3.저장
		
		
	}

}
