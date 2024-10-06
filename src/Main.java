import java.util.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static List<Rule> getKnowledge() throws FileNotFoundException, IOException
    {
        //ganti dengan lokasi project Anda nanti
        FileReader reader = new FileReader("E:\\SAKHRON\\S5\\Sistem Pakar\\SimpleExpertSystem-main\\Forward Chaining Expert System\\src\\knowledge_base");
        BufferedReader bufferedReader = new BufferedReader(reader);
        List<Rule> rules = new ArrayList<>();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            //mengambil string bagian fact dulu baru conclussion
            rules.add(new Rule(
                    Arrays.asList(line.split("-")[0].split(",")), 
                    line.split("-")[1]));
        }
        
        bufferedReader.close();
        reader.close();
        return rules;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        UI tampilan = new UI();
        tampilan.Opening();
        tampilan.showQuestion();
        //initial facts, jawaban user
        Set<String> facts  = tampilan.getFacts();
        
        //get knowledge base
        List<Rule> rules = getKnowledge();
        
        // Apply forward chaining
        Set<String> inferedFacts = 
                InferenceForwardChaining.doForwardChaining(rules, facts);
        
        boolean fIsTrue = inferedFacts.contains("f");
        boolean lIsTrue = inferedFacts.contains("l");

        // Tampilkan hasil kesimpulan
        tampilan.showConclussion(fIsTrue, lIsTrue, facts, inferedFacts);

    }
    
}
