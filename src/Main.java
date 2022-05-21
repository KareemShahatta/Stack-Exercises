import java.util.Scanner;
import java.util.Stack;

public class Main
{
    public static void main(String[] args) {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please Enter a sentence(s) to be reversed.");
        main.reverseString(scanner.nextLine());

        System.out.println("\nPlease Enter an integer number to be reversed.");
        main.reverseNumber(scanner.nextInt());
    }

    void reverseNumber(int num) {
        Stack<Integer> stack = new Stack();
        int digit = 0;

        while (num != 0) {
            digit = num % 10;
            stack.push(digit);
            num = num / 10;
        }

        int rev_num = 0;
        int power = 0;

        while (!stack.isEmpty()) {
            digit = stack.pop();
            rev_num = rev_num + digit * (int) Math.pow(10, power);
            power = power + 1;
        }

        System.out.println("Reversed Number: " + rev_num);
    }

    void reverseString(String input) {
        Stack<String> stack = new Stack<>();
        String[] splitInput = input.split(" ");
        System.out.print("Reversed Sentence(s): ");

        for(String word : splitInput)
        {
            if(word.contains("."))
            {
                word = word.replace(".", "");
                stack.push(word);
                processSentence(stack);
                stack.clear();
            }
            else
            {
                stack.push(word);
            }
        }
    }
    void processSentence(Stack<String> stack)
    {
        StringBuilder reversedSentenceBuilder = new StringBuilder();
        String word = "";

        int stackSize = stack.size();

        for(int i = 0 ; i < stackSize ; i++)
        {
            word = stack.pop().toLowerCase();

            if(i == 0)
            {
                String firstLetter = word.substring(0, 1);
                word =  firstLetter.toUpperCase() + word.substring(1);
                reversedSentenceBuilder.append(word);
            }
            else if(i == (stackSize - 1))
            {
                reversedSentenceBuilder.append(" ").append(word).append(". ");
            }
            else
            {
                reversedSentenceBuilder.append(" " + word);
            }
        }

        System.out.print(reversedSentenceBuilder.toString());
    }
}
