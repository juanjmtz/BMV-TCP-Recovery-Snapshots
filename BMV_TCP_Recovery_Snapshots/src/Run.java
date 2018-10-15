/*
 * Copyright (C) 2018 Juan J. Martínez
 * 
 * All rights reserved. This complete software or any portion thereof
 * can be used as reference but may not be reproduced in any manner 
 * whatsoever without the express written permission of the owner.
 * 
 * The purpose of this is to be consulted and used as a referece of 
 * functionallyty.
 * 
 * Developed in Mexico City
 * First version, 2018
 *
 */

/**
 *
 * @author Juan J. Martínez
 * @email juanjmtzs@gmail.com
 * @phone +52-1-55-1247-8044
 * @linkedin https://www.linkedin.com/in/juanjmtzs/
 *
 */
import java.io.File;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

public class Run {

    public static void main(String args[]) {

        if (args.length != 7) {
            System.out.println("Arguments:FolderName(RecoveryXXXXFeedA/RecoveryXXXXFeedB) UserRecovery PasswordRecovery IPRecovery PortRecovery GroupRecovery SnapshotType");
            System.exit(0);
        }

        String myargs[] = new String[8];
        myargs[0] = "BMV Recovery Snapshots";
        myargs[1] = args[0];//FOLDER
        myargs[2] = args[1];//USER
        myargs[3] = args[2];//PASSWORD
        myargs[4] = args[3];//IPRECOVERY
        myargs[5] = args[4];//PORTRECOVERY
        myargs[6] = args[5];//GROUPRECOVERY
        myargs[7] = args[6];//SnapshotType
        String argsRecoverySnapshot[] = new String[10];
        argsRecoverySnapshot[0] = myargs[4];
        argsRecoverySnapshot[1] = myargs[5];
        argsRecoverySnapshot[2] = "";
        argsRecoverySnapshot[3] = myargs[2];
        argsRecoverySnapshot[4] = myargs[3];
        argsRecoverySnapshot[5] = myargs[6];
        argsRecoverySnapshot[6] = "";
        argsRecoverySnapshot[7] = "0";
        argsRecoverySnapshot[8] = myargs[7];
        argsRecoverySnapshot[9] = "";
        try {
            DateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
            Date date = new Date();
            System.setOut(new PrintStream(new File(myargs[1], Instant.now().toEpochMilli() + "_BMVRecoverySnapshots_" + dateFormat.format(date) + ".log")));
        } catch (Exception e) {
            System.out.println("Error " + e);

        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    UnicastBMVNoBytes.StartHandling(argsRecoverySnapshot);

                } catch (Exception ex) {
                }
            }

        }).start();
    }

}
