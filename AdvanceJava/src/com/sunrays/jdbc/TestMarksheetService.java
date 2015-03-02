package com.sunrays.jdbc;

import com.sunrays.dto.MarksheetDTO;

/*
 * copyright (c) sunRays Technologies Indore
 * @author: sunRays Developer
 * @url : www.sunrays.co.in
 *
 */

public class TestMarksheetService {

	public static void main(String[] args)throws Exception {
		
		
		MarksheetDTO dto = new MarksheetDTO();
		dto.setRollNo("ABC123");
		dto.setName("Salman Khan");
		dto.setMaths(99);
		dto.setChemistry(99);
		dto.setPhysics(99);
		
		MarksheetService service = new MarksheetService();
		service.addMarkSheet(dto);
		

	}

}
