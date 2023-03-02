package org.example;

import org.example.quote.controller.QuotesController;
import org.example.system.controller.SystemController;

public class App {
    public void run() {
        System.out.println("== 명언 앱 ==");
        SystemController systemController = new SystemController();
        QuotesController quotesController = new QuotesController();

        while(true){
            System.out.print("명언) ");
            String input = Container.getScanner().nextLine().trim();
            Rq rq = new Rq(input);

            switch (rq.getActionCode()) {
                case "종료" -> {
                    systemController.exit();
                    return;
                }
                case "등록" -> {
                    quotesController.write();
                }
                case "목록" -> {
                    quotesController.list();
                }
                case "삭제" -> {
                    quotesController.delete(rq);
                }
                case "수정" -> {
                    quotesController.edit(rq);
                }
            }
        }
    }
}
