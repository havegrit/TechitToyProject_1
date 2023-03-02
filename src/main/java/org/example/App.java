package org.example;

import org.example.quote.controller.QuotesController;
import org.example.system.controller.SystemController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class App {
    public void run() {
        System.out.println("== 명언 앱 ==");
        SystemController systemController = new SystemController();
        QuotesController quotesController = new QuotesController();

        while(true){
            System.out.print("명언) ");
            String input = Container.getScanner().nextLine().trim();
            if (input.equals("종료")) {
                systemController.exit();
                break;
            } else if (input.equals("등록")) {
                quotesController.write();
            } else if (input.equals("목록")) {
                quotesController.list();
            } else if (input.startsWith("삭제")) {
                String[] inputBits = input.split("\\?", 2);
                String actionCode = inputBits[0];
                Map<String, String> params = new HashMap<>();
                String[] paramBits = inputBits[1].split("&");
                for(String paramStr:paramBits) {
                    String[] paramStrBits = paramStr.split("=", 2);
                    String key = paramStrBits[0];
                    String value = paramStrBits[1];
                    params.put(key, value);
                }

                System.out.printf("actionCode = %s\n",actionCode);
                System.out.printf("params = %s\n", params);

                quotesController.delete(input);
            } else if (input.startsWith("수정")) {
                quotesController.edit(input);
            }
        }
    }
}
