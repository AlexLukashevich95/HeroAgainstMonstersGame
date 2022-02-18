import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String levels ;
        int heroLevel=1;
        Scanner input = new Scanner(System.in);
        levels = input.nextLine();
        String[] numbersStrings = levels.split("\\s");
        List<Integer> list = new ArrayList<>();
        if(numbersStrings.length<Math.pow(10, 5)*2){
            for (String num : numbersStrings) {
                int level = Integer.parseInt(num);
                if(level<Math.pow(10, 6)) {
                    list.add(level);
                }
                else {
                    System.out.println("Too big values, it should be not bigger than 10^6");
                    System.out.println("Please, restart the game");
                }
            }
            Collections.sort(list);
            int heroWounds=0;
            for (Integer integer : list) {
                if (heroLevel >= integer) {
                    if (heroLevel >= integer * 2) {
                        heroLevel++;
                    } else {
                        if (heroWounds < 3) {
                            heroLevel++;
                            heroWounds++;
                        }
                        else if(heroWounds == 3){
                            heroWounds = 0;
                            heroLevel--;
                        }

                    }
                    System.out.print(heroLevel+" ");
                }
                else {
                    System.out.println("Impossible");
                    break;
                }
            }
            if (heroLevel >= list.size()) {
                System.out.print("Possible");
            }
        }
        else{
            System.out.println("Too big value, it should be not bigger than 10^6");
            System.out.println("Please, restart the game");
        }

    }
}

