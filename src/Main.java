//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ApiClient client = new ApiClient();
        String response;
        response = client.fetchQuestions(5,"multiple","easy");
        System.out.println(response);
    }
}