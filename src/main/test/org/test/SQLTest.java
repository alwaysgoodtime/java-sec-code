package org.test;

import com.google.gson.Gson;

public class SQLTest {
    public static void main(String[] args) {
        String sourceCode = "    @RequestMapping(\"/jdbc/vuln\")\n" +
                "    public String jdbc_sqli_vul(@RequestParam(\"username\") String username) {\n" +
                "\n" +
                "        StringBuilder result = new StringBuilder();\n" +
                "\n" +
                "        try {\n" +
                "            Class.forName(driver);\n" +
                "            Connection con = DriverManager.getConnection(url, user, password);\n" +
                "\n" +
                "            if (!con.isClosed())\n" +
                "                System.out.println(\"Connect to database successfully.\");\n" +
                "\n" +
                "            // sqli vuln code\n" +
                "            Statement statement = con.createStatement();\n" +
                "            String sql = \"select * from users where username = '\" + username + \"'\";\n" +
                "            logger.info(sql);\n" +
                "            ResultSet rs = statement.executeQuery(sql);\n" +
                "\n" +
                "            while (rs.next()) {\n" +
                "                String res_name = rs.getString(\"username\");\n" +
                "                String res_pwd = rs.getString(\"password\");\n" +
                "                String info = String.format(\"%s: %s\\n\", res_name, res_pwd);\n" +
                "                result.append(info);\n" +
                "                logger.info(info);\n" +
                "            }\n" +
                "            rs.close();\n" +
                "            con.close();\n" +
                "\n" +
                "\n" +
                "        } catch (ClassNotFoundException e) {\n" +
                "            logger.error(\"Sorry, can't find the Driver!\");\n" +
                "        } catch (SQLException e) {\n" +
                "            logger.error(e.toString());\n" +
                "        }\n" +
                "        return result.toString();\n" +
                "    }";
        Gson gson = new Gson();
        System.out.println(gson.toJson(sourceCode));

    }




}
