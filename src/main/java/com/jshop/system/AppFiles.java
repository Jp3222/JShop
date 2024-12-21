/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jshop.system;

import com.jutil.platf.So;
import java.io.File;

/**
 *
 * @author juan-campos
 */
public class AppFiles {

    public static final File FILE_DESKTOP = new File(So.USER_HOME, getDesktop());
    public static final File FILE_DOCUMENTS = new File(So.USER_HOME, getDocuments());
    
    public static final File FILE_APP_HIDEN_ARCHS = new File(FILE_DOCUMENTS.getAbsolutePath(), File.separator.concat(".jshop"));

    private static String getDesktop() {
        StringBuilder sb = new StringBuilder();
        sb.append(File.separator);
        if (So.isLinux()) {
            if (So.USER_LANGUAJE.equals("en")) {
                sb.append("Desktop");
            }
            if (So.USER_LANGUAJE.equals("es")) {
                sb.append("Escritorio");
            }
        }
        if (So.isMac()) {
            sb.append("Desktop");
        }
        if (So.isWindows()) {
            sb.append("Desktop");
        }
        return sb.toString();
    }

    private static String getDocuments() {
        StringBuilder sb = new StringBuilder();
        if (So.isLinux()) {
            if (So.USER_LANGUAJE.equals("en")) {
                sb.append("Documents");
            }
            if (So.USER_LANGUAJE.equals("es")) {
                sb.append("Documentos");
            }
        }
        if (So.isMac()) {
            sb.append("Documents");
        }
        if (So.isWindows()) {
            sb.append("Documents");
        }
        return sb.toString();

    }

}
