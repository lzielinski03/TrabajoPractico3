package model;

import customException.*;
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
        diary = new ArrayList<>();
        path = "bridget.txt";
        try {
            loadDiary();
        } catch (LoadDiaryException e) {
            IOMenu.printException(e);
        }
    }

    public static BridgetDB getInstance() {
        if (instance == null)
            instance =  new BridgetDB();
        return instance;
    }

    private void openConnection() throws OpenConnectionException{
        try {
            if (bridget == null)
                bridget = new File(path);

            if (!bridget.exists() && !bridget.isDirectory())
                bridget.createNewFile();

            // use to get exceptions.
            //bridget = null;

            br = new BufferedReader(new FileReader(bridget.getAbsoluteFile()));
            bw = new BufferedWriter(new FileWriter(bridget.getAbsoluteFile(), true));

        } catch (IOException | NullPointerException e) {
            throw new OpenConnectionException();
        }
    }

    private void closeConnection() throws CloseDiaryException{
        if (br == null || bw == null)
            throw new CloseDiaryException();

        try {
            br.close();
            bw.close();
        } catch (IOException e) {
            throw new CloseDiaryException();
        }
    }

    public void persistDiary() throws PersistDiaryException{
        try {
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

            if (bridget.delete())
                tmp.renameTo(bridget);

            loadDiary();
        } catch (OpenConnectionException | IOException | CloseDiaryException | LoadDiaryException e) {
            throw new PersistDiaryException();
        }
    }

    private void loadDiary() throws LoadDiaryException{
        try {
            openConnection();

            String line = br.readLine();
            diary.clear();
            while (line != null) {
                diary.add(new BridgetLine(line));
                line = br.readLine();
            }
        } catch (OpenConnectionException | IOException e) {
            throw new LoadDiaryException();
        } finally {
            try {
                closeConnection();
            } catch (CloseDiaryException e) {
                IOMenu.printException(e);
            }
        }
    }

    public boolean insert(String data) throws InsertDiaryException{
        try {
            openConnection();

            bw.write(new BridgetLine(diary.size(), data).getFormatedLine());
            bw.newLine();
            bw.flush();
        } catch (OpenConnectionException | IOException e) {
            throw new InsertDiaryException();
        } finally {
            try {
                closeConnection();
                loadDiary();
            } catch (CloseDiaryException | LoadDiaryException e) {
                IOMenu.printException(e);
            }
        }
        return true;
    }

    public boolean delete(String id) throws DeleteDiaryException{
        if (id.trim().isEmpty())
            throw new DeleteDiaryException();

        try {
            int idItem = Integer.parseInt(id);

            if (idItem > diary.size())
                throw new DeleteDiaryException();

            diary.remove(idItem);
            persistDiary();

        } catch (NumberFormatException | IndexOutOfBoundsException | PersistDiaryException e) {
            throw new DeleteDiaryException();
        }
        return true;
    }

    public List<String> getDiaryLine() {
        try {
            loadDiary();
        } catch (LoadDiaryException e) {
            IOMenu.printException(e);
        }

        List<String> lines = new ArrayList<>();
        for (BridgetLine x : diary) {
            lines.add(x.getFormatedLine());
        }
        return lines;
    }

    public class BridgetLine extends FormatDiary{

        private int id;
        private String line;

        public BridgetLine(int id, String line) {
            this.id = id;
            this.line = line;
        }

        public BridgetLine(String line) {
            this.id = Integer.parseInt(line.substring(1, line.indexOf(" ")));
            this.line = line.substring(line.indexOf("|") + 2, line.length());
        }

        public String getFormatedLine() {
            return setLineFormat(this.id, this.line);
        }
    }
}