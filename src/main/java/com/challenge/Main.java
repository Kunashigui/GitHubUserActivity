package com.challenge;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
//mvn compile exec:java -Dexec.mainClass=
//mvn exec:java -Dexec.mainClass="com.challenge.Main" -Dexec.args=\"username\"

public class Main {
    static String GIT_URL = "https://api.github.com/users/<username>/events"; // URL de la API de GitHub

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide a username as an argument.");
            return;
        }
        try {
            String urlString = GIT_URL.replace("<username>", args[0]);
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                JSONArray jsonArray = new JSONArray(response.toString());
                if (jsonArray.isEmpty()){
                    System.out.println("No events found for the user: " + args[0]);
                }
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject event = jsonArray.getJSONObject(i);
                    String type = event.getString("type");
                    String repoName = event.getJSONObject("repo").getString("name");
                    switch (type) {
                        case "PushEvent":
                            System.out.println("Push Event to Repository: " + repoName);
                            break;
                        case "CreateEvent":
                            System.out.println("Created Repository: " + repoName);
                            break;
                        case "DeleteEvent":
                            System.out.println("Deleted Repository: " + repoName);
                            break;
                        case "ForkEvent":
                            System.out.println("Forked Repository: " + repoName);
                            break;
                        case "IssuesEvent":
                            System.out.println("Created Issue in Repository: " + repoName);
                            break;
                        case "PullRequestEvent":
                            System.out.println("Opened Pull Request in Repository: " + repoName);
                            break;
                        case "WatchEvent":
                            System.out.println("Starred Repository: " + repoName);
                            break;
                        default:
                            System.out.println("Event Type: " + type + ", Repository: " + repoName);
                            break;
                    }
                }
            } else {
                System.out.println("GET request failed. Response Code: " + responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}