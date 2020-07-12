import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Ignore;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.Random;

public class GenerateTestData {
    private static final int MAX_RECORDS = 100;
    @Test
    @Ignore
    public void generateData() {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://ec2-52-71-55-81.compute-1.amazonaws.com:5432/da9gmofktofv45",
                            "xmlfxoxlztxbyd", "8279c289d49d2457aa827f9e9eab6d01f711c33e1395f46f81b14412ec0fe366");

            System.out.println("Connection established.");

            stmt = c.createStatement();
            String sql = "drop table if exists bill";
            stmt.executeUpdate(sql);
            sql = "drop table if exists transactions";
            stmt.executeUpdate(sql);

            sql = "create table bill (" +
                    "ref_id VARCHAR (256) primary key," +
                    "name varchar(256)," +
                    "mobile_number varchar(256)," +
                    "due_date Date," +
                    "due_amount int4" +
                    ")";
            stmt.executeUpdate(sql);
            sql = "create table transactions (" +
                    "ref_id VARCHAR (256)," +
                    "transaction_id VARCHAR(256)," +
                    "ack_id VARCHAR(256)," +
                    "transaction_date Date," +
                    "PRIMARY KEY (ref_id, transaction_id)" +
                    ")";
            stmt.executeUpdate(sql);

            Faker faker = new Faker();
            for (int i = 0; i < MAX_RECORDS; i++) {
                sql = "insert into bill(ref_id, name, mobile_number, due_date, due_amount) " +
                        "values ('" + RandomStringUtils.randomAlphanumeric(8) + "', '" + faker.name().firstName() + "', " + randomMobileNumber() + ", '2020-07-10', " + new Random().nextInt(1000) + " )";

                stmt.executeUpdate(sql);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Records created successfully");
    }

    private static String randomMobileNumber() {
        Random rand = new Random();
        int num1 = (rand.nextInt(7) + 1) * 100 + (rand.nextInt(8) * 10) + rand.nextInt(8);
        int num2 = rand.nextInt(743);
        int num3 = rand.nextInt(10000);

        DecimalFormat df3 = new DecimalFormat("000"); // 3 zeros
        DecimalFormat df4 = new DecimalFormat("0000"); // 4 zeros

        String mobileNumber = df3.format(num1) + df3.format(num2) + df4.format(num3);
        System.out.println(mobileNumber);
        return mobileNumber;
    }
}
