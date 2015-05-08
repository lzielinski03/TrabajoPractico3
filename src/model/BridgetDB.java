package model;

import view.IOMenu;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by leonardo on 03/05/2015.
 */
public class BridgetDB {

    private static BridgetDB instance;

    private String path;
    private File bridget = null;

    private BufferedReader br;
    private BufferedWriter bw;

    private List<BridgetLine> diary;

    private BridgetDB() {
        diary = new ArrayList<BridgetLine>();
        path = "bridget.txt";
        loadDiary();
    }

    public static BridgetDB getInstance() {
        if (instance == null)
            instance =  new BridgetDB();
        return instance;
    }

    private void openConnection() {
        if (bridget == null) {
            bridget = new File(path);
        }
        if (!bridget.exists() && !bridget.isDirectory()) {
            try {
                bridget.createNewFile();
            } catch (IOException e) {
                IOMenu.printException(e);
            }
        }
        try {
            br = new BufferedReader(new FileReader(bridget.getAbsoluteFile()));
            bw = new BufferedWriter(new FileWriter(bridget.getAbsoluteFile(), true));
        } catch (IOException e) {
            IOMenu.printException(e);
        }
    }

    private void closeConnection() {
        try {
            br.close();
            bw.close();
        } catch (IOException e) {
            IOMenu.printException(e);
        }
    }

    public void persistDiary() throws IOException{
        openConnection();

        File tmp = File.createTempFile("tmp", "");
        BufferedWriter tmpBw = new BufferedWriter(new FileWriter(tmp.getAbsoluteFile()));

        int i = 0;
        for (BridgetLine l : diary) {
            tmpBw.write(new BridgetLine(i++, l.line).getFormatedLine());
            tmpBw.newLine();
        }

        tmpBw.flush();
        tmpBw.close();
        closeConnection();

        if (bridget.delete()) {
            tmp.renameTo(bridget);
        }
        loadDiary();
    }

    private void loadDiary() {
        openConnection();
        try {
            String line = br.readLine();
            diary.clear();
            while (line != null) {
                diary.add(new BridgetLine(line));
                line = br.readLine();
            }
        } catch (IOException e) {
            IOMenu.printException(e);
        } finally {
            closeConnection();
        }
    }

    // throw bridgetInsertException
    public boolean insert(String data) {
        openConnection();
        try {
            bw.write(new BridgetLine(diary.size(), data).getFormatedLine());
            bw.newLine();
            bw.flush();
        } catch (IOException e) {
            IOMenu.printException(e);
            return false;
        } finally {
            closeConnection();
        }
        loadDiary();
        return true;
    }

    // throw bridgetDeleteException
    public boolean delete(String id) {
        int idItem = Integer.parseInt(id);

        if(idItem > diary.size()) {
            return false;
        }
        diary.remove(idItem);
        try {
            persistDiary();
        } catch (IOException e) {
            IOMenu.printException(e);
        }

        return true;
    }

    public List<String> getDiaryLine() {
        List<String> lines = new ArrayList<String>();
        for (BridgetLine x : diary) {
            lines.add(x.getFormatedLine());
        }
        return lines;
    }

    public class BridgetLine extends FormatDiary{

        private int id;
        private String line;

        // throw BridgetLineException (id < 0)
        public BridgetLine(int id, String line) {
            this.id = id;
            this.line = line;
        }

        // test violate
        public BridgetLine(String line) {
            this.id = Integer.parseInt(line.substring(1, line.indexOf(" ")));
            this.line = line.substring(line.indexOf("|") + 2, line.length());
        }

        public String getFormatedLine() {
            return setLineFormat(this.id, this.line);
        }
    }
}
