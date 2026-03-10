import java.util.*;

public class Quiz {
    public static void main(String[] args) {
        // 1. Store questions and correct answers
        HashMap<String, String> quiz = new LinkedHashMap<>(); // keep insertion order
        quiz.put("What is the capital of France?", "Paris");
        quiz.put("Which language is used for Android development?", "Java");
        quiz.put("Which planet is known as the Red Planet?", "Mars");
        quiz.put("What is 5 + 7?", "12");

        // 2. Predefined options for simplicity
        HashMap<String, List<String>> optionsMap = new HashMap<>();
        optionsMap.put("What is the capital of France?", Arrays.asList("Paris", "London", "Berlin", "Rome"));
        optionsMap.put("Which language is used for Android development?", Arrays.asList("Python", "Java", "C++", "Ruby"));
        optionsMap.put("Which planet is known as the Red Planet?", Arrays.asList("Earth", "Mars", "Jupiter", "Venus"));
        optionsMap.put("What is 5 + 7?", Arrays.asList("10", "11", "12", "13"));

        Scanner sc = new Scanner(System.in);
        int score = 0;

        // 3. Loop through questions
        for (String question : quiz.keySet()) {
            System.out.println(question);
            List<String> options = optionsMap.get(question);

            // Display options
            for (int i = 0; i < options.size(); i++) {
                System.out.println((i + 1) + ". " + options.get(i));
            }

            System.out.print("Enter your option (1-4): ");
            int userChoice = sc.nextInt();

            // Check answer
            String selectedAnswer = options.get(userChoice - 1);
            if (selectedAnswer.equalsIgnoreCase(quiz.get(question))) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Wrong! Correct answer: " + quiz.get(question) + "\n");
            }
        }

        System.out.println("Quiz Completed! Your score: " + score + "/" + quiz.size());
        sc.close();
    }
}