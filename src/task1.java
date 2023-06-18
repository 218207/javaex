//import java.sql.*;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.util.Scanner;
//
//import static java.lang.Math.abs;
//import static java.lang.Math.pow;
//
//public class task1
//{
//    public static void exportExcel(String tablename, String filename) {
//        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Exam", "root", "1172093Nik")) {
//            System.out.println("Успешное подключение к базе данных.");
//
//            String query = "SELECT * FROM " + tablename;
//            PreparedStatement stmt = connection.prepareStatement(query);
//            ResultSet rs = stmt.executeQuery();
//
//            System.out.println("Вывод текущего состояния таблицы " + tablename);
//            while (rs.next()) {
//                int id1_new = rs.getInt("ID1");
//                int id2_new = rs.getInt("ID2");
//                double res_new = rs.getDouble("RES");
//                System.out.printf("%d %d %.2f%n", id1_new, id2_new, res_new);
//            }
//
//            System.out.println("Имя файла для сохранения: " + filename);
//            String query1 = "SELECT 'ID1', 'ID2', 'RES' UNION ALL SELECT * FROM "
//                    + tablename + " INTO OUTFILE '/usr/local/mysql-8.0.31-macos12-arm64/Excel/"
//                    + filename + "'";
//            PreparedStatement stmt2 = connection.prepareStatement(query1);
//            stmt2.executeQuery();
//
//            System.out.println("Данные успешно занесены в Excel файл.");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//    public static void createQuery(String tablename) throws SQLException {
//        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/Exam", "root", "1172093Nik")) {
//            System.out.println("Connection done");
//
//            String createQuery = "CREATE TABLE IF NOT EXISTS " + tablename + " (ID1 INT, ID2 INT, RES DOUBLE)";
//            Statement statement = connection.createStatement();
//            statement.executeUpdate(createQuery);
//            System.out.println("Таблица успешно создана!");
//        }catch (SQLException e){
//            e.printStackTrace();
//        }
//    }
//
//    public static void insertSQL(String tablename, int ID1, int ID2, double Result) {
//        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/Exam", "root", "1172093Nik")) {
//            System.out.println("Connection done");
//
//            String createQuery = "CREATE TABLE IF NOT EXISTS " + tablename + " (ID1 INT, ID2 INT, RES DOUBLE)";
//            Statement statement = connection.createStatement();
//            statement.executeUpdate(createQuery);
//            System.out.println("Таблица успешно создана!");
//
//            String insertQuery = "INSERT INTO " + tablename + " (ID1, ID2, RES) VALUES (?, ?, ?)";
//            PreparedStatement stmt = connection.prepareStatement(insertQuery);
//            stmt.setInt(1, ID1);
//            stmt.setInt(2, ID2);
//            stmt.setDouble(3, Result);
//            stmt.executeUpdate();
//
//            System.out.println("Данные успешно добавлены в таблицу " + tablename);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//    public static void showData(String tablename) {
//        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/Exam", "root", "1172093Nik")) {
//            System.out.println("Connection done");
//
//            String showQuery = "SELECT * FROM " + tablename;
//            PreparedStatement statement = connection.prepareStatement(showQuery);
//            ResultSet result = statement.executeQuery();
//
//            System.out.println("Данные находящиеся в таблице " + tablename + ":");
//            while (result.next()) {
//                System.out.print(result.getInt("ID1") + " ");
//                System.out.print(result.getInt("ID2") + " ");
//                System.out.print(result.getDouble("RES") + " ");
//                System.out.println();
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void slozhenie(String tablename, int A, int B)
//    {
//        double res = A + B;
//        insertSQL(tablename, A, B, res);
//        showData(tablename);
//    }
//    public static void vichetanie(String tablename, int A, int B)
//    {
//        double res = A - B;
//        insertSQL(tablename, A, B, res);
//        showData(tablename);
//    }
//    public static void umnozhenie(String tablename, int A, int B)
//    {
//        double res = A * B;
//        insertSQL(tablename, A, B, res);
//        showData(tablename);
//    }
//    public static void delenie(String tablename, int A, int B)
//    {
//        double res = (double) A / B;
//        insertSQL(tablename, A, B, res);
//        showData(tablename);
//    }
//    public static void ostatok(String tablename, int A, int B)
//    {
//        double res = A % B;
//        insertSQL(tablename, A, B, res);
//        showData(tablename);
//    }
//    public static void modul(String tablename, int A)
//    {
//        double res = abs(A);
//        insertSQL(tablename, A, 0, res);
//        showData(tablename);
//    }
//    public static void stepen(String tablename, int A, int B)
//    {
//        long res = (long) pow(A, B);
//        insertSQL(tablename, A, B, res);
//        showData(tablename);
//    }
//
//    public static void main(String[] args) throws SQLException {
//        System.out.println("""
//                 Выберите дейтсвие:\s
//                1. Вывести все таблицы из MySQL.
//                2. Создать таблицу в MySQL.
//                3. Сложение чисел, результат сохранить в MySQL с последующим выводом в консоль.
//                4. Вычитание чисел, результат сохранить в MySQL с последующим выводом в консоль.
//                5. Умножение чисел, результат сохранить в MySQL с последующим выводом в консоль.
//                6. Деление чисел, результат сохранить в MySQL с последующим выводом в консоль.
//                7. Деление чисел по модулю (остаток), результат сохранить в MySQL с последующим
//                выводом в консоль.
//                8. Возведение числа в модуль, результат сохранить в MySQL с последующим выводом в
//                консоль.
//                9. Возведение числа в степень, результат сохранить в MySQL с последующим выводом в
//                консоль.
//                10. Сохранить все данные (вышеполученные результаты) из MySQL в Excel и вывести на экран""");
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Введите имя таблицы с которой хотели бы работать");
//        String tablename = scanner.nextLine();
//        boolean exitRequested = false;
//
//        while (!exitRequested) {
//
//            System.out.println("Выберите действие (введите число от 1 до 11) (11 выход из программы):");
//            while (!scanner.hasNextInt()) {
//                System.out.println("Ошибка ввода! Пожалуйста, введите число от 1 до 11 (11 выход из программы):");
//                scanner.next();
//            }
//            int choice = scanner.nextInt();
//            switch (choice) {
//                case 1:
//                    DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
//                    String mySQLurl = "jdbc:mysql://localhost:3306/Exam";
//                    Connection con = DriverManager.getConnection(mySQLurl, "root", "1172093Nik");
//                    System.out.println("Успешное подключение к базе данных. ");
//                    Statement stmt = con.createStatement();
//                    ResultSet rs = stmt.executeQuery("Show Tables");
//                    System.out.println("Таблицы из текущей базы данных. ");
//                    while (rs.next()) {
//                        System.out.print(rs.getString(1)); // print нужен чтобы выводились не через строку,
//                        // так как ей присуща \n
//                        System.out.println();
//                    }
//                    break;
//                case 2:
//                    System.out.println("Введите имя таблицы, которую хотите создать: ");
//                    createQuery(tablename);
//                    break;
//                case 3:
//                    int A = scanner.nextInt();
//                    int B = scanner.nextInt();
//                    slozhenie(tablename, A, B);
//                    break;
//                case 4:
//                    A = scanner.nextInt();
//                    B = scanner.nextInt();
//                    vichetanie(tablename, A, B);
//                    break;
//                case 5:
//                    A = scanner.nextInt();
//                    B = scanner.nextInt();
//                    umnozhenie(tablename, A, B);
//                    break;
//                case 6:
//                    A = scanner.nextInt();
//                    B = scanner.nextInt();
//                    delenie(tablename, A, B);
//                    break;
//                case 7:
//                    A = scanner.nextInt();
//                    B = scanner.nextInt();
//                    ostatok(tablename, A, B);
//                    break;
//                case 8:
//                    A = scanner.nextInt();
//                    modul(tablename, A);
//                    break;
//                case 9:
//                    A = scanner.nextInt();
//                    B = scanner.nextInt();
//                    stepen(tablename, A, B);
//                    break;
//                case 10:
//                    System.out.println("Введите имя файла: ");
//                    String filename = scanner.next();
//                    exportExcel(tablename, filename);
//                case 11:
//                    exitRequested = true;
//                    continue;
//                default:
//                    System.out.println("Неверный выбор. Пожалуйста, выберите число от 1 до 11. Чтобы выйти введите 11");
//                    break;
//            }
//        }
//    }
//}
//
////import java.sql.*;
////import java.util.Arrays;
////import java.util.Scanner;
////
////public class task1 {
////    public static void info(){
////        System.out.println("1. Вывести все таблицы из текущей базы данных");
////        System.out.println("2. Создать таблицу в базе данных");
////        System.out.println("3. Работа с целыми числами");
////        System.out.println("4. Работа с байтовыми числами");
////        System.out.println("5. Работа с вещественными числами");
////        System.out.println("6. Сохранить в excel");
////        System.out.println("7. Выход из программы");
////    }
////    static Scanner scan = new Scanner(System.in);
////    static int ID = 1;
////    static int ID1 = 2;
////    static int ID2 = 3;
////    static int ID3 = 4;
////    static int ID4 = 5;
////    static int ID5 = 6;
////    static int ID6 = 7;
////    static int ID7 = 8;
////    static int ID8 = 9;
////    static int ID9 = 10;
////    static int ID10 = 11;
////    static String name = "Первое_число";
////    static String name1 = "Второе_число";
////    static String name2 = "Сложение";
////    static String name3 = "Вычитание";
////    static String name4 = "Умножение";
////    static String name5 = "Деление";
////    static String name6 = "Деление_по_модулю";
////    static String name7 = "Модуль_первого_числа";
////    static String name8 = "Модуль_второго_числа";
////    static String name9 = "Возведение_в_степень_первого_числа";
////    static String name10 = "Возведение_в_степень_второго_числа";
////    public static void math_int() throws SQLException{
////        System.out.println("Введите первое число: ");
////        int int1 = scan.nextInt();
////        System.out.println("Введите второе число: ");
////        int int2 = scan.nextInt();
////        System.out.println("Введите степень, в которую будут возведены числа");
////        int int_pow = scan.nextInt();
////        int int_sum = int1 + int2;
////        int int_diff = int1 - int2;
////        int int_mul = int1 * int2;
////        int int_div = int1 / int2;
////        int int_mod = int1 % int2;
////        int int_abs1 = Math.abs(int1);
////        int int_abs2 = Math.abs(int2);
////        int int_pow1 = (int)Math.pow(int1, int_pow);
////        int int_pow2 = (int)Math.pow(int2, int_pow);
////        String query5 = "INSERT INTO " + table_name + " (ID, name, result) VALUES (?, ?, ?), (?, ?, ?), (?, ?, ?), " +
////                "(?, ?, ?), (?, ?, ?), (?, ?, ?), (?, ?, ?), (?, ?, ?), (?, ?, ?), (?, ?, ?), (?, ?, ?)";
////        PreparedStatement stmt5 = con.prepareStatement(query5);
////        stmt5.setInt(1, ID);
////        stmt5.setString(2, name);
////        stmt5.setInt(3, int1);
////        stmt5.setInt(4, ID1);
////        stmt5.setString(5, name1);
////        stmt5.setInt(6, int2);
////        stmt5.setInt(7, ID2);
////        stmt5.setString(8, name2);
////        stmt5.setInt(9, int_sum);
////        stmt5.setInt(10, ID3);
////        stmt5.setString(11, name3);
////        stmt5.setInt(12, int_diff);
////        stmt5.setInt(13, ID4);
////        stmt5.setString(14, name4);
////        stmt5.setInt(15, int_mul);
////        stmt5.setInt(16, ID5);
////        stmt5.setString(17, name5);
////        stmt5.setInt(18, int_div);
////        stmt5.setInt(19, ID6);
////        stmt5.setString(20, name6);
////        stmt5.setInt(21, int_mod);
////        stmt5.setInt(22, ID7);
////        stmt5.setString(23, name7);
////        stmt5.setInt(24, int_abs1);
////        stmt5.setInt(25, ID8);
////        stmt5.setString(26, name8);
////        stmt5.setInt(27, int_abs2);
////        stmt5.setInt(28, ID9);
////        stmt5.setString(29, name9);
////        stmt5.setInt(30, int_pow1);
////        stmt5.setInt(31, ID10);
////        stmt5.setString(32, name10);
////        stmt5.setInt(33, int_pow2);
////        stmt5.executeUpdate();
////        System.out.println("Данные в MySQL успешно внесены");
////        ResultSet rs5 = stmt5.executeQuery("SELECT * from " + table_name + "");
////        System.out.println("Введенные данные: ");
////        while (rs5.next()) {
////            System.out.print(Arrays.toString(rs5.getString((1)).split(" ")));
////            System.out.print(Arrays.toString(rs5.getString((2)).split(" ")));
////            System.out.print(Arrays.toString(rs5.getString((3)).split(" ")));
////            System.out.println();
////        }
////    }
////
////    public static void math_byte() throws SQLException{
////        System.out.println("Введите первое число: ");
////        byte byte1 = scan.nextByte();
////        System.out.println("Введите второе число: ");
////        byte byte2 = scan.nextByte();
////        System.out.println("Введите степень, в которую будут возведен числа");
////        byte byte_pow = scan.nextByte();
////        byte byte_sum = (byte) (byte1 + byte2);
////        byte byte_diff = (byte) (byte1 - byte2);
////        byte byte_mul = (byte) (byte1 * byte2);
////        byte byte_div = (byte) (byte1 / byte2);
////        byte byte_mod = (byte) (byte1 % byte2);
////        byte byte_abs1 = (byte) (Math.abs(byte1));
////        byte byte_abs2 = (byte) (Math.abs(byte2));
////        byte byte_pow1 = (byte) (Math.pow(byte1, byte_pow));
////        byte byte_pow2 = (byte) (Math.pow(byte2, byte_pow));
////        String query6 = "INSERT INTO " + table_name + " (ID, name, result) VALUES (?, ?, ?), (?, ?, ?), (?, ?, ?), (?, ?, ?), (?, ?, ?), (?, ?, ?), (?, ?, ?), (?, ?, ?), (?, ?, ?), (?, ?, ?), (?, ?, ?)";
////        PreparedStatement stmt6 = con.prepareStatement(query6);
////        stmt6.setInt(1, ID);
////        stmt6.setString(2, name);
////        stmt6.setInt(3, byte1);
////        stmt6.setInt(4, ID1);
////        stmt6.setString(5, name1);
////        stmt6.setInt(6, byte2);
////        stmt6.setInt(7, ID2);
////        stmt6.setString(8, name2);
////        stmt6.setInt(9, byte_sum);
////        stmt6.setInt(10, ID3);
////        stmt6.setString(11, name3);
////        stmt6.setInt(12, byte_diff);
////        stmt6.setInt(13, ID4);
////        stmt6.setString(14, name4);
////        stmt6.setInt(15, byte_mul);
////        stmt6.setInt(16, ID5);
////        stmt6.setString(17, name5);
////        stmt6.setInt(18, byte_div);
////        stmt6.setInt(19, ID6);
////        stmt6.setString(20, name6);
////        stmt6.setInt(21, byte_mod);
////        stmt6.setInt(22, ID7);
////        stmt6.setString(23, name7);
////        stmt6.setInt(24, byte_abs1);
////        stmt6.setInt(25, ID8);
////        stmt6.setString(26, name8);
////        stmt6.setInt(27, byte_abs2);
////        stmt6.setInt(28, ID9);
////        stmt6.setString(29, name9);
////        stmt6.setInt(30, byte_pow1);
////        stmt6.setInt(31, ID10);
////        stmt6.setString(32, name10);
////        stmt6.setInt(33, byte_pow2);
////        stmt6.executeUpdate();
////        System.out.println("Данные в MySQL успешно внесены");
////        ResultSet rs6 = stmt6.executeQuery("SELECT * from " + table_name + "");
////        System.out.println("Введенные данные: ");
////        while (rs6.next()) {
////            System.out.print(Arrays.toString(rs6.getString((1)).split(" ")));
////            System.out.print(Arrays.toString(rs6.getString((2)).split(" ")));
////            System.out.print(Arrays.toString(rs6.getString((3)).split(" ")));
////            System.out.println();
////        }
////    }
////
////    public static void math_float() throws SQLException{
////        System.out.println("Введите первое число: ");
////        float float1 = scan.nextFloat();
////        System.out.println("Введите второе число: ");
////        float float2 = scan.nextFloat();
////        System.out.println("Введите степень, в которую будут возведены числа");
////        float float_pow = scan.nextFloat();
////        float float_sum = float1 + float2;
////        float float_diff = float1 - float2;
////        float float_mul = float1 * float2;
////        float float_div = float1 / float2;
////        float float_mod = float1 % float2;
////        float float_abs1 = Math.abs(float1);
////        float float_abs2 = Math.abs(float2);
////        float float_pow1 = (float) Math.pow(float1, float_pow);
////        float float_pow2 = (float) Math.pow(float2, float_pow);
////        String query7 = "INSERT INTO " + table_name + " (ID, name, result) VALUES (?, ?, ?), (?, ?, ?), " +
////                "(?, ?, ?), (?, ?, ?), (?, ?, ?), (?, ?, ?), (?, ?, ?), (?, ?, ?), (?, ?, ?), (?, ?, ?), (?, ?, ?)";
////        PreparedStatement stmt7 = con.prepareStatement(query7);
////        stmt7.setInt(1, ID);
////        stmt7.setString(2, name);
////        stmt7.setFloat(3, float1);
////        stmt7.setInt(4, ID1);
////        stmt7.setString(5, name1);
////        stmt7.setFloat(6, float2);
////        stmt7.setInt(7, ID2);
////        stmt7.setString(8, name2);
////        stmt7.setFloat(9, float_sum);
////        stmt7.setInt(10, ID3);
////        stmt7.setString(11, name3);
////        stmt7.setFloat(12, float_diff);
////        stmt7.setInt(13, ID4);
////        stmt7.setString(14, name4);
////        stmt7.setFloat(15, float_mul);
////        stmt7.setInt(16, ID5);
////        stmt7.setString(17, name5);
////        stmt7.setFloat(18, float_div);
////        stmt7.setInt(19, ID6);
////        stmt7.setString(20, name6);
////        stmt7.setFloat(21, float_mod);
////        stmt7.setInt(22, ID7);
////        stmt7.setString(23, name7);
////        stmt7.setFloat(24, float_abs1);
////        stmt7.setInt(25, ID8);
////        stmt7.setString(26, name8);
////        stmt7.setFloat(27, float_abs2);
////        stmt7.setInt(28, ID9);
////        stmt7.setString(29, name9);
////        stmt7.setFloat(30, float_pow1);
////        stmt7.setInt(31, ID10);
////        stmt7.setString(32, name10);
////        stmt7.setFloat(33, float_pow2);
////        stmt7.executeUpdate();
////        System.out.println("Данные в MySQL успешно внесены");
////        ResultSet rs7 = stmt7.executeQuery("SELECT * from " + table_name + "");
////        System.out.println("Введенные данные: ");
////        while (rs7.next()) {
////            System.out.print(Arrays.toString(rs7.getString((1)).split(" ")));
////            System.out.print(Arrays.toString(rs7.getString((2)).split(" ")));
////            System.out.print(Arrays.toString(rs7.getString((3)).split(" ")));
////            System.out.println();
////        }
////
////    }
////
////    public static void all_tables() throws SQLException {
////        Statement stmt1 = con.createStatement();
////        ResultSet rs1 = stmt1.executeQuery("Show tables");
////        System.out.println("current database's tables: ");
////        while (rs1.next()) {
////            System.out.print(rs1.getString(1));
////            System.out.println();
////        }
////    }
////    protected static String mysqlUrl = "jdbc:mysql:///task";
////    protected static Connection con;
////    static String table_name;
////    public static void setTablename() {
////        System.out.println("enter the table name: ");
////        table_name = scan.nextLine();
////    }
////    public static void add_table() throws SQLException{
////        scan.nextLine();
////        setTablename();
////        Statement stmt2 = con.createStatement();
////        String query = "CREATE TABLE IF NOT EXISTS " + table_name + " (ID int, name varchar(255), result numeric(8, 2))";
////        stmt2.executeUpdate(query);
////        System.out.println("done");
////        all_tables();
////    }
////    public static void save_to_xl() throws SQLException{
////        scan.nextLine();
////        setTablename();
////        System.out.print("enter the file's name with an extension: ");
////        String file = scan.nextLine();
////        String query3 = "SELECT * FROM " + table_name + " INTO OUTFILE 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/" + file + "' CHARACTER SET cp1251";
////        PreparedStatement stmt3 = con.prepareStatement(query3);
////        stmt3.executeQuery();
////        System.out.println("done");
////    }
////    public static void calc() throws SQLException {
////
////        try {
////            DriverManager.registerDriver(new Driver());
////            con = DriverManager.getConnection(mysqlUrl, "root", "root");
////        } catch (SQLException e) {
////            throw new RuntimeException(e);
////        }
////
////        int x = 0;
////        String s = "";
////        info();
////        while (!"7".equals(s)) {
////            s = scan.next();
////            try {
////                x = Integer.parseInt(s);
////            } catch (NumberFormatException e) {
////                System.out.println("попробуйте еще раз");
////            }
////            switch (x) {
////                case 1 -> all_tables();
////                case 2 -> add_table();
////                case 3 -> math_int();
////                case 4 -> math_byte();
////                case 5 -> math_float();
////                case 6 -> save_to_xl();
////            }
////        }
////        System.out.println("Пока");
////
////    }
////    public static void main(String[] args) throws SQLException{
////        calc();
////    }
////
////    private static class Driver implements java.sql.Driver {
////    }
////}