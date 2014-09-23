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
	private String s;
	private byte[] b;


	
	@Before
	public void runBeforeTests(){
		s = "CHANGE TO LOWERCASE";
		b = new byte[s.length()];
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
	@Test
	public void testByteread()throws IOException{
		int c;
		String actual = "";
		stream.read(b, 0, b.length);
		for(int i = 0; i<b.length;i++){
			actual +=  (char) b[i];
		}
		assertEquals("change to lowercase",actual);
	}
	
	@After
	public void runAfterTests(){
		stream = null;
	}

	

}
