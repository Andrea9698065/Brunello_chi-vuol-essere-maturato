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
                .uri(java.net.URI.create(url))
                .GET()
                .build();
        HttpResponse<String> response;//Oggetto 'mandato'
        try{
            response = client.send(request,HttpResponse.BodyHandlers.ofString());
        }catch(IOException | InterruptedException e){
            return "error,Lol";
        }//Il postino che manda il pacco

        return response.body();
    }

}
