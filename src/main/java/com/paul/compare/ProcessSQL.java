package com.paul.compare;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class ProcessSQL {

    public static void processSql(String userIdName, String sqlName) {
        if (userIdName == null || sqlName == null) {
            return;
        }
        BufferedReader reader = null;
        BufferedWriter writer = null;
        try {
            reader = new BufferedReader(new FileReader(userIdName));
            File sqlFile = new File(sqlName);
            if (!sqlFile.exists()) {
                if (sqlFile.isDirectory()) {
                    System.out.println("sqlFile can not be a directory!");
                    System.exit(0);
                }
                sqlFile.createNewFile();
            }
            writer = new BufferedWriter(new FileWriter(sqlFile));

            String line = null;
            StringBuffer sqlBuffer = null;
            Integer index = 0;

            while (true) {
                while (index++ != 500 && (line = reader.readLine()) != null) {
                    try {
                        line = line.trim();
                        Long.parseLong(line);
                    } catch (Exception e) {
                        System.out.println(line + "is not a long number");
                        System.exit(0);
                    }

                    sqlBuffer = new StringBuffer("");
                    sqlBuffer.append("update contact set default_flag = 1 where id = (select id from (select id from contact where user_id = ").append(line)
                            .append(" order by default_flag desc, update_time desc, use_num desc limit 1) temp);\n");
                    writer.write(sqlBuffer.toString());
                }
                writer.write("commit;\n");
                if (index != 501 && line == null) {
                    break;
                } else {
                    index = 0;
                }
            }
        } catch (Exception e) {
            System.out.println("Something wrong here, check it!");
            System.exit(0);
        } finally {
            try {
                reader.close();
                writer.close();
            } catch (Exception e) {
                System.out.println("close error!");
                System.exit(0);
            }
        }
    }

    public static void main(String[] args) {
        String userIdFile = args[0];
        String sqlFile = args[1];
        processSql(userIdFile, sqlFile);
    }

}
