import java.io.File;
import java.util.ArrayList;
import edu.duke.*;
public class CharactersInPlay {

    private ArrayList<String> names;
    private ArrayList<Integer> counts;

    public CharactersInPlay(){
        names = new ArrayList<>();
        counts = new ArrayList<>();
    }
    public void update(String person){
        if(names.indexOf(person) == -1){
            names.add(person);
            counts.add(1);
        }else{
            int indexCounts = counts.get(counts.indexOf(person)) + 1;
            counts.set(names.indexOf(person), indexCounts);
        }
    }

    public void findAllCharacters(){
        FileResource fr = new FileResource();
        String firstOccur = "";
        for(String line: fr.lines()){
            if(line.indexOf(".") == -1){
                firstOccur = line.substring(0, line.indexOf("."));
                update(firstOccur);
            }
        }
    }

    public void tester(){
        counts.clear();
        names.clear();
        findAllCharacters();
        for(int i = 0; i < names.size(); i++){
            if(counts.get(i) > 1){
                System.out.print(names.get(i) + "\t" + counts.get(i));
            }
        }
        charactersWithNumParts(10, 15);
    }

    public void charactersWithNumParts(int num1, int num2){
        System.out.println("Characters that have between " + num1 + " and " + num2+ " lines:");
        for(int i = 0; i < names.size(); i++){
            if(counts.get(i) >= num1 && counts.get(i)<= 2){
                System.out.println(names.get(i) + "\t" + counts.get(i));
            }
        }
    }
    public static void main(String[] args) {

    }
}