package com.woori.myhome.board;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.woori.myhome.common.FileUploadUtil;

@Controller
public class BoardController {
	
	@Autowired 
	BoardService boardService;
	
	@RequestMapping(value="/board/list")
	String board_list(BoardDto dto, Model model)
	{
		model.addAttribute("boardList", boardService.getList(dto));
		model.addAttribute("totalCnt", boardService.getTotal(dto));
		
		return "/board/list";
	}
	
	//페이지 이동용
	@RequestMapping("/board/write")
	String board_write(Model model)
	{
		BoardDto dto = new BoardDto();
		model.addAttribute("boardDto", dto);
		return "/board/write";
	}
	
	//저장
	@RequestMapping("/board/save")
	String board_save(BoardDto dto, MultipartHttpServletRequest multi,
			HttpServletRequest request)
	{
		//1.파일은 jsp 반드시 post방식으로 enctype="multipart/form-data"
		//2.파일의 물리적 경로, 절대적경로여야함 한다 .-> 상대적경로도 지원은 하고는 있는데 
		//스프링 부트에서는 확실하게 가능  앞으로는 가능할듯 
		
		
		/*MultipartFile file = multi.getFile("file1");  //클라이언트에서 보낸 파일에 대한 정보를 확인한다 
		
		//multi.getFile("file태그의 이름") 형태를 주면 MultipartFile  형태의 객체를 반환한다 
		String path = "C:\\springboot\\spring3\\spring_workspace3\\myhome2\\upload";
		//이 경로가 존재하는지 확인하기 
		File dir = new File(path);  //java.io.file
		if( !dir.exists() )//경로가 없으면 경로를 생성한다 
			dir.mkdirs(); 
		
		//파일은 이미 서버의 임시메모리에 업로드 된 상태에서 전달된다. 
		//파일을 지정된 디렉토리로 옮겨야만 존재한다 
		try {
			//파일이 이미 임시 메모리에 업로드 되어 있다. 업로된 파일을 새로운 이름으로 upload경로에 저장하자
			file.transferTo( new File(path + "/" + file.getOriginalFilename()));
			
		} catch (IllegalStateException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		*/
		
		List<MultipartFile> multiList = new ArrayList<MultipartFile>();
		multiList.add(multi.getFile("file1"));
		multiList.add(multi.getFile("file2"));
		multiList.add(multi.getFile("file3"));
		
		List<String> fileNameList = new ArrayList<String>();
		String path = "C:\\springboot\\spring3\\spring_workspace3\\myhome2";
		FileUploadUtil.upload(path,  multiList, fileNameList);
		
		dto.setFilename1(fileNameList.get(0));
		dto.setFilename2(fileNameList.get(1));
		dto.setFilename3(fileNameList.get(2));
		
		if(dto.getSeq().contentEquals(""))
			boardService.insert(dto);
		else
			boardService.update(dto);
//		
		
		
		return "redirect:/board/list";
	}
	
	@RequestMapping("/board/view")
	String board_view(int seq, Model model)
	{
		model.addAttribute("boardDto", boardService.getView(seq));
		
		return "/board/view";
	}
	
	@RequestMapping("/board/modify")
	String board_modify(int seq, Model model)
	{
		BoardDto dto = boardService.getView(seq);
		model.addAttribute("boardDto", dto);
		
		return "/board/write";
	}
	
	@RequestMapping("/board/delete")
	String board_delete(int seq)
	{
		boardService.delete(seq);
		
		return "redirect:/board/list";
	}
}


