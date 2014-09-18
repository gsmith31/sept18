package headfirst.decorator.io;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringBufferInputStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LowerCaseInputStreamTest {
	
	private LowerCaseInputStream stream; 
	private ByteArrayOutputStream outStream;


	
	@Before
	public void runBeforeTests(){
		stream = new LowerCaseInputStream(new StringBufferInputStream("CHANGE TO LOWERCASE"));
	}
	
	@Test //(expected=IOException.class) 
	public void testRead() throws IOException{
		int c;
		String actual = "";
		while((c = stream.read()) >= 0){
			actual += (char) c;
		}
		
		assertEquals("change to lowercase",actual);
	}
	
	@After
	public void runAfterTests(){
		stream = null;
	}

	

}
