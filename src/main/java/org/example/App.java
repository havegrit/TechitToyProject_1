package org.example;

import org.example.quote.controller.QuotesController;
import org.example.quote.entity.Quotes;
import org.example.system.controller.SystemController;
import java.util.List;

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
            } else if (input.startsWith("삭제?id=")) {
                quotesController.delete(input);
            } else if (input.startsWith("수정?id=")) {
                quotesController.edit(input);
            }
        }
    }

    public void saveData(List<Quotes> quotesList) {

    }
}
