package com.woori.myhome.common;

import java.io.File;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtil {
	 
	static String filePath= CommonConst.FilePath;
	
	
	public static String getFilePath() {
		return filePath;
	}

	public static void setFilePath(String filePath) {
		FileUploadUtil.filePath = filePath;
	}


	public static void upload(String contextPath, 
			List<MultipartFile> fileList,  //upload파일들
			List<String> fileNameList) //바뀐파일명들을 
	{
	
		String filePath = contextPath + "/"+ CommonConst.FilePath;
		System.out.println("경로 : " + filePath);
		//java.io.File
		File file = new File(filePath);
		if( !file.exists())
		{
			file.mkdir();
		}
		
		//System.out.println("filesize : " + fileList.size());
		if( fileList!=null && fileList.size()>0)
		{
			 for(MultipartFile multipartFile : fileList)
			 {		
				 if( multipartFile.getOriginalFilename().length()==0)
					   break;
				
				 
				 String orifilename = multipartFile.getOriginalFilename(); // 
				 
				 
				 int pos = orifilename.lastIndexOf(".");       // 뒤쪽부터 . 위치를 찾아서 
				 String ext = orifilename.substring(pos+1);    //확장자와
				 String oriFile = orifilename.substring(0, pos); //파일명을 분리한다  
							 
				 String filename = multipartFile.getOriginalFilename(); //파일명 
				
				 File newFile = new File(filePath+"/" +filename); //파일이 존재하면 
				 int i=1;
				 while(newFile.exists()) 
				 {
					 filename = oriFile + "("+i+")." + ext;  //a.jpg, a(1).jpg a(2).jpg
					 i++;
					 newFile = new File(filePath+"/" +filename); 
				 }
				 
				 System.out.println("filename : " + filename);
				 fileNameList.add(filename); //바뀐파일명을 저장해서 외부로 내보낸다. 
				
				//파일 업로드한거 저장하기 
				 String newFileName   = filePath + "/" + filename;
				 try
				 {
					 System.out.println(newFileName);
					 multipartFile.transferTo( new File(newFileName));
					 
				 }
				 catch(Exception e)
				 { 
					 e.printStackTrace();
				 } 
			 }
		}
		
		
	}
}
