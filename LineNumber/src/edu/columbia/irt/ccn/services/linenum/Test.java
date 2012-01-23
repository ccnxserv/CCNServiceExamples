/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.columbia.irt.ccn.services.linenum;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author amanus
 */
public class Test {

    private static final Logger log = Logger.getLogger(Test.class.getName());
    public static final String SERVICE_NAME = "linenumber";

    public static Object execute(Object o) {
        String filePath = (String) o;
        String fileName = null;
        String filePrefix = null;
        int last = filePath.lastIndexOf("/");
        if (last != -1) {
            fileName = filePath.substring(last + 1);
            filePrefix = filePath.substring(0, last);
        }
        String outFilePath = filePrefix + "/" + fileName + "%2B" + SERVICE_NAME;
        String out = fileName + "%2B" + SERVICE_NAME;

        File file = new File(filePath);
        File outFile = new File(outFilePath);
        BufferedOutputStream outBuf = null;
        BufferedInputStream buf = null;
        try {
            buf = new BufferedInputStream(new FileInputStream(file));
            outBuf = new BufferedOutputStream(new FileOutputStream(outFile));
            int c;
            Integer counter = 1;
            while ((c = buf.read()) != -1) {
                outBuf.write(counter.toString().getBytes());
                outBuf.write('.');
                outBuf.write(' ');
                outBuf.write(c);
                while ((c = buf.read()) != '\n') {
                    outBuf.write(c);
                }
                outBuf.write('\n');
                counter++;
            }
            outBuf.close();
            buf.close();
        } catch (FileNotFoundException ex) {
            log.log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            log.log(Level.SEVERE, null, ex);
        }

        return null;

    }

    public static void main(String[] args) {
        //Test.execute("/home/amanus/workspace/hello.html");
        
        String s = "/linenumber/hello";
        
        System.out.println(s.substring(0,s.indexOf("/", 1)));
    }
}
