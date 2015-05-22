package controller;

import customException.DeleteDiaryException;
import customException.InsertDiaryException;
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
                    try {
                        db.insert(optionMenu.getArgs().get(0));
                    } catch (InsertDiaryException e) {
                        IOMenu.printException(e);
                    }
                    break;
                case DELETE:
                    try {
                        db.delete(optionMenu.getArgs().get(0));
                    } catch (DeleteDiaryException e) {
                        IOMenu.printException(e);
                    }
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
