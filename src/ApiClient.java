import com.google.gson.Gson;
import java.net.URI;
import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiClient {
    private static HttpClient client =  HttpClient.newHttpClient();//Chi manda la richiesta

    public String fetchQuestions(int ammount, String type, String difficulty){
    //https://opentdb.com/api.php?amount=5&difficulty=easy&type=multiple
        String url = "https://opentdb.com/api.php?amount="+ammount+"&type="+type+"&difficulty="+difficulty;

        HttpRequest request = HttpRequest.newBuilder()//Chi fa la richiesta
                .header("Content-Type","application/json")
                .uri(URI.create(url))
                .GET()
                .build();
        HttpResponse<String> response;//Oggetto 'mandato'
        try{
            response = client.send(request,HttpResponse.BodyHandlers.ofString());
        } catch(IOException | InterruptedException e){
            return "error,Lol";
        }



        if (response == null){
            throw new RuntimeException("No risposta ricevuta da api");
        }
        //Il postino che manda il pacco

        Gson gson = new Gson();
        ApiResponse apiResponse = gson.fromJson(response.body(),ApiResponse.class);
        for(ApiQuestions q : apiResponse.results ){
            System.out.print(q.question);
            System.out.println("  Risposta corretta : "+ q.correct_answer);
        }
       return response.body();

    }

}
