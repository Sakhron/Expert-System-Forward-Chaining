import java.util.*;

public class UI {
    
    private ArrayList<String> questions;
    private int answers[];
    
    public UI()
    {
        this.answers = new int[5];
        this.questions = new ArrayList<String>();
        this.setQuestions();
    }
    
    private void setQuestions()
    {
        //Q1
        questions.add("Apakah daun berwarna kekuningan?");
        //Q2
        questions.add("Apakah daun yang terkena layu?");
        //Q3
        questions.add("Apa tumbuhan pertumbuhannya terhambat?");
        //Q4
        questions.add("Apakah ada bintik elips coklat pada daun?");
        //Q5
        questions.add("Apakah ada warna putih pada daun yang kekuningan?");
    }
    
    public void showQuestion()
    {
        Scanner sc = new Scanner(System.in);
        int i =0;
        for(String q: this.questions)
        {
            System.out.println(q);
            System.out.println("0. Tidak    1.Ya");
            int a = sc.nextInt();
            while(a != 0 && a!=1)
            {
                System.out.println("Jawaban tidak sesuai!");
                a = sc.nextInt();
            }
            answers[i] = a;
            i++;
        }
    }
    
    public Set<String> getFacts()
    {
        Set<String> facts = new HashSet<>();
        if(answers[0] == 1)
            facts.add("a");
        if(answers[1] == 1)
            facts.add("g");
        if(answers[2] == 1)
            facts.add("b");
        if(answers[3] == 1)
            facts.add("j");
        if(answers[4] == 1)
            facts.add("c");
        return facts;
    }
    
    public void showConclussion(boolean fIsTrue, boolean lIsTrue, Set<String> facts, Set<String> inferredFacts) {
        if (fIsTrue && lIsTrue) {
            System.out.println("\nTanaman Terkena Bulai dan Hawar");
        } else if (lIsTrue){
            System.out.println("\nTanaman Terkena Hawar");
        } else if(fIsTrue) {
            System.out.println("\nTanaman Terkena Bulai");
        } else {
            System.out.println("\nTanaman Sehat");
        }
    }

    public void Opening() {
        System.out.println("SELAMAT DATANG");
        System.out.println("TEST BULAI dan HAWAR");
        System.out.println("Forward Chaining oleh: Muhammad Fauzan Hernadi (2201190)\n" +
"Sakhron Isyama Hendra (2202296)\n");
}
    
    
}
