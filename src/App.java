import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class App {


    public static Map<String, String> addPasswordElement(Map<String, String> mapachka) {
        boolean hasKey = mapachka.containsKey("pass");
        if (hasKey) {
            mapachka.put("password", mapachka.get("pass"));
            return mapachka;
        } else {
            return mapachka;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String strInputURL = scanner.nextLine();

        int indexStrInput1 = strInputURL.indexOf("?");
        String strInputFormURL = strInputURL.substring(indexStrInput1 + 1);

        String[] arrForAllElementUrl = strInputFormURL.split("&");
        Map<String, String> mapElementUrl = new LinkedHashMap<>();

        for (int i = 0; i < arrForAllElementUrl.length; i++) {
            String[] arrForOnceElementUrl = arrForAllElementUrl[i].split("=");
            if (arrForOnceElementUrl.length < 2) {
                for (int j = 0; j < arrForOnceElementUrl.length; j++) {
                    mapElementUrl.put(arrForOnceElementUrl[0], "not found");
                }
            } else {
                for (int k = 0; k < arrForOnceElementUrl.length; k++) {
                    mapElementUrl.put(arrForOnceElementUrl[0], arrForOnceElementUrl[1]);
                }
            }
        }

        for (Map.Entry<String, String> map : addPasswordElement(mapElementUrl).entrySet()) {

            System.out.println(map.getKey() + " : " + map.getValue());
        }
    }
}
