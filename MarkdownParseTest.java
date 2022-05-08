import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }
    @Test
    public void testGetLinksFile1() throws IOException{
        Path fileName = Path.of("test-file.md");
        String content = Files.readString(fileName);
        ArrayList<String> expectedList = new ArrayList<String>();
        expectedList.add("https://something.com");
        expectedList.add("some-thing.html");
        assertEquals(expectedList,MarkdownParse.getLinks(content));
    }
    @Test
    public void testGetLinksFile2() throws IOException{
        Path fileName = Path.of("example.md");
        String content = Files.readString(fileName);
        ArrayList<String> expectedList = new ArrayList<String>();
        expectedList.add("https://google.com");
        assertEquals(expectedList,MarkdownParse.getLinks(content));
    }
    @Test
    public void testGetLinksFile3() throws IOException{
        Path fileName = Path.of("fail1.md");
        String content = Files.readString(fileName);
        ArrayList<String> expectedList = new ArrayList<String>();
        if(content.length() == 0){
            assertEquals(null,null);
        }
        assertEquals(null,MarkdownParse.getLinks(content));
    }

    @Test
    public void testGetLinksFile4() throws IOException{
        Path fileName = Path.of("fail2.md");
        String content = Files.readString(fileName);
        ArrayList<String> expectedList = new ArrayList<String>();
        expectedList.add("https://instagram.com"); 
        expectedList.add("https://twitter.com");
        assertEquals(expectedList ,MarkdownParse.getLinks(content));

    }

    @Test
    public void testGetLinksFile5() throws IOException{
        Path fileName = Path.of("fail3.md");
        String content = Files.readString(fileName);
        ArrayList<String> expectedList = new ArrayList<String>();
        expectedList.add("google.com"); 
        
        assertEquals(expectedList ,MarkdownParse.getLinks(content));

    }
}
