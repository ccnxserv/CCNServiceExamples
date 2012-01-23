package edu.columbia.irt.ccn.services.linenum;

import edu.columbia.irt.netserv.core.backbone.CCNService;
import edu.columbia.irt.netserv.core.backbone.ServiceException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LineNumber implements CCNService {

    private static final Logger log = Logger.getLogger(LineNumber.class.getName());
    public static final String SERVICE_NAME = "linenumber";

    @Override
    public Object execute(Object o) throws ServiceException {
        String filePath = (String) o;
        log.log(Level.INFO,
                "LineNumber service called with {0} parameter", filePath);

        String outFilePath = filePath + "%2B" + SERVICE_NAME;
        File file = new File(filePath);
        File outFile = new File(outFilePath);
        BufferedReader inBuf = null;
        BufferedWriter outBuf = null;
        try {
            inBuf = new BufferedReader(new FileReader(file));
            outBuf = new BufferedWriter(new FileWriter(outFile));
            Integer c = 1;
            String line;
            while ((line = inBuf.readLine()) != null) {
                outBuf.write(c.toString());
                outBuf.write('.');
                outBuf.write(' ');
                outBuf.write(line);
                outBuf.write('\n');
                c++;
            }
            outBuf.write("\n\n Line Number Service \n\n Signed by \n Columbia University");
            outBuf.close();
            inBuf.close();
        } catch (FileNotFoundException ex) {
            log.log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            log.log(Level.SEVERE, null, ex);
        }
        log.log(Level.INFO, "[LineNumber]returning outFilePath = {0}", outFilePath);
        return outFilePath;
    }
}
