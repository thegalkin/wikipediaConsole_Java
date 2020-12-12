package com.wiki;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList languageList = new ArrayList<>(Arrays.asList("en", "es", "de", "ru",  "fr"));
        String language = "dasda";
        Scanner in = new Scanner(System.in);
        while (!languageList.contains(language)) {
            System.out.println("Введите код языка: en, es, de, ru, fr");
            language = in.nextLine();
        }
        Boolean areWeDone = false;
        while (!areWeDone) {
            System.out.println("Введите запрос");
            String specificTopic = in.nextLine();

            String link = Parser.myContent(language, specificTopic);
            try {
                String requestRes = Parser.connectingUrl(link);

                areWeDone = Parser.searchOutput(requestRes);
            }catch (IOException e){
                areWeDone = false;
            }
        }
    }
}
