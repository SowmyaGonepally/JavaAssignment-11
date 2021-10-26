
import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    static LinkedHashMap<Character,Integer> frequency=new LinkedHashMap<Character,Integer>();
    public static void main(String[] args) throws IOException {
        File file=new File(args[0]);
        readAndcountCharacters(file);
        writeOutputToFile();
    }
    public static void readAndcountCharacters(File file) throws IOException
    {
        BufferedReader reader=new BufferedReader(new FileReader(file));
        int c=0;
        while ((c = reader.read()) != -1)
        {
            char current=(char)(c);
            frequency.put(current,frequency.getOrDefault(current,0)+1);
        }
        for(Map.Entry<Character,Integer>f:frequency.entrySet())
        {
            System.out.println(f.getKey()+"----"+f.getValue());
        }
        reader.close();
    }
    public static void writeOutputToFile() throws IOException {
        BufferedWriter writer=new BufferedWriter(new FileWriter("/home/sowmyg/Desktop/output.txt"));
        for(Map.Entry<Character,Integer>m:frequency.entrySet())
        {
            writer.write(m.getKey()+"---"+m.getValue());
            writer.newLine();
        }
        writer.close();
    }
}
