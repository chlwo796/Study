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
	
	//������ �̵���
	@RequestMapping("/board/write")
	String board_write(Model model)
	{
		BoardDto dto = new BoardDto();
		model.addAttribute("boardDto", dto);
		return "/board/write";
	}
	
	//����
	@RequestMapping("/board/save")
	String board_save(BoardDto dto, MultipartHttpServletRequest multi,
			HttpServletRequest request)
	{
		//1.������ jsp �ݵ�� post������� enctype="multipart/form-data"
		//2.������ ������ ���, ��������ο����� �Ѵ� .-> �������ε� ������ �ϰ�� �ִµ� 
		//������ ��Ʈ������ Ȯ���ϰ� ����  �����δ� �����ҵ� 
		
		
		/*MultipartFile file = multi.getFile("file1");  //Ŭ���̾�Ʈ���� ���� ���Ͽ� ���� ������ Ȯ���Ѵ� 
		
		//multi.getFile("file�±��� �̸�") ���¸� �ָ� MultipartFile  ������ ��ü�� ��ȯ�Ѵ� 
		String path = "C:\\springboot\\spring3\\spring_workspace3\\myhome2\\upload";
		//�� ��ΰ� �����ϴ��� Ȯ���ϱ� 
		File dir = new File(path);  //java.io.file
		if( !dir.exists() )//��ΰ� ������ ��θ� �����Ѵ� 
			dir.mkdirs(); 
		
		//������ �̹� ������ �ӽø޸𸮿� ���ε� �� ���¿��� ���޵ȴ�. 
		//������ ������ ���丮�� �Űܾ߸� �����Ѵ� 
		try {
			//������ �̹� �ӽ� �޸𸮿� ���ε� �Ǿ� �ִ�. ���ε� ������ ���ο� �̸����� upload��ο� ��������
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


