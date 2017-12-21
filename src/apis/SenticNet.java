package apis;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Singleton Pattern for SenticNet class
 */
public class SenticNet {
    private static SenticNet Instance=null;
    private Scanner scanner;
    private HashMap<String, Double> data;

    private SenticNet() {

        String file = "..\\Chatbot\\src\\apis\\senticnet4-v2.txt";
        try {
            scanner = new Scanner(new File(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        data = new HashMap<>();

        //put values from text to hashmap
        while (scanner.hasNextLine()) {
            String currentLine = scanner.nextLine();
            if (!currentLine.contains("_")) {
                String parts[] = currentLine.split(" ");
                double val = Double.parseDouble(parts[1]);
                data.put(parts[0], val);
            }
        }
        scanner.close();
    }

    /**
     * Calculates review point of given string from SenticNet
     * @param tweetText text
     * @return calculated point
     */
    public double calculateReviewPoint(String tweetText) {
        Double sum = 0.0;
        //replaces all special characters (like # ! ? ...)
        tweetText = tweetText.replaceAll("[^a-zA-Z ]+","");

        String[] words = tweetText.split(" ");
        for (String word : words) {
            word=word.toLowerCase();
            Double polarity = data.get(word);
            if (polarity != null) {
                sum += polarity;
               // System.out.println(word + " : " + polarity);
            }
        }
        return sum;
    }

    public double getSenticNetValue(String str){
        return data.get(str);
    }

    public static SenticNet getInstance(){
        if (Instance == null)
            Instance = new SenticNet();

        return Instance;
    }
}