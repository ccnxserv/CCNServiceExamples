package edu.columbia.irt.ccn.services.next;

import edu.columbia.irt.netserv.core.backbone.CCNService;
import edu.columbia.irt.netserv.core.backbone.ServiceException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NextService implements CCNService {

    private static final Logger log = Logger.getLogger(NextService.class.getName());
    public static final String SERVICE_NAME = "nextservice";

    @Override
    public Object execute(Object o) throws ServiceException {
        String filePath = (String) o;
        String outFilePath = filePath + "%2B" + SERVICE_NAME;
        log.log(Level.INFO, "NextService called with {0} parameter", filePath);
        
        try {
            File in = new File(filePath);
            if (!in.exists()) {
                log.log(Level.WARNING, "File does not exit.. {0}", filePath);
                return null;
            }
            BufferedReader buf_in = new BufferedReader(new FileReader(in));
            BufferedWriter out = new BufferedWriter(new FileWriter(outFilePath));
            String line;
            while ((line = buf_in.readLine()) != null) {
                out.write(line);
                out.write('\n');
            }
            out.write("\n\n ADDED BY NEXT SERVICE");
            out.close();
        } catch (IOException e) {
            log.warning("Cannot write to output file for service.." + SERVICE_NAME);
            return null;
        }
        log.log(Level.INFO, "[NextService] returning outFilePath = {0}", outFilePath);
        return outFilePath;
    }
}
