package org.zerock.domain;

import lombok.Data;

@Data
public class AttachFileDTO {
	private String fileName; //파일명
	private String uploadPath; //업로드폴더 경로
	private String uuid; //uuid
	private boolean image; //이미지파일 유무
}
