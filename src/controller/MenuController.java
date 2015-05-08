package controller;

import model.BridgetDB;
import view.IOMenu;

/**
 * Created by leonardo on 03/05/2015.
 */
public class MenuController {

    public MenuController() {
        boolean fin = false;
        IOMenu iom = new IOMenu();

        while(!fin) {
            IOMenu.OptionMenu optionMenu = iom.getOptionMenu();
            BridgetDB db = BridgetDB.getInstance();

            switch(optionMenu) {
                case ADD:
                    db.insert(optionMenu.getArgs().get(0));
                    break;
                case DELETE:
                    db.delete(optionMenu.getArgs().get(0));
                    break;
                case ENTRIES:
                    iom.printDiary(db.getDiaryLine());
                    break;
                case HELP:
                    iom.printHelp();
                    break;
                case EXIT:
                    fin = true;
                    break;
            }
        }
    }


}
