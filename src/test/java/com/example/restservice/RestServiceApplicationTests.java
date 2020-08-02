package com.example.restservice;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;

import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertTrue;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class RestServiceApplicationTests {


	@Test
	void contextLoads() {
	}

//	@Mock
//	SaveFileServices saveFileServices;
	@Spy
	SaveFileServices saveFileServices;

	@Test
	void testCreateFile_DirectoryDoesntExist(){
		//when
		String path = "C:\\Users\\jakub.grodzicki\\Desktop\\test2\\tests.txt";
		File file = new File(path);
		when(saveFileServices.getFileName()).thenReturn(path);
		//then
		saveFileServices.createFile();
		//equals
		assertTrue("File wasn't created",file.exists());
	}

	@Test
	void testCreateFile_DirectoryExist(){
		//when
		String path = "C:\\Users\\jakub.grodzicki\\Desktop\\test\\tests.txt";
		when(saveFileServices.getFileName()).thenReturn(path);
		//then
		saveFileServices.createFile();
		File file = new File(path);
		//equals
		assertTrue("File wasn't created",file.exists());
	}






}
