package amk.scrabble.model;

import java.sql.*;

public class DBManager {

    public static void showleaderboard() {

        try {
            //idk why wasn't working without addditional jdbc loading (mb servlet side error):<
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/leaderboard",
                    "root",
                    "java1234"
            );

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from score");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("username"));
                System.out.println(resultSet.getInt("score"));
            }
        }catch(SQLException exception){
            exception.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void addscoretoleaderboard(String name, int gamescore){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/leaderboard",
                    "root",
                    "java1234"
            );

            String sql = "SELECT * FROM score WHERE username = ?";


            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            String username = name;
            preparedStatement.setString(1, username);

            ResultSet resultSet = preparedStatement.executeQuery();

            String resultUser = null;
            int resultScore = 0;
            while (resultSet.next()) {
                resultUser = resultSet.getString("username");
                resultScore = resultSet.getInt("score");
            }

            if (resultUser != null){
                //dodaj do pobranych
                String sql2 = "UPDATE score SET score = ? WHERE username = ?";
                preparedStatement = connection.prepareStatement(sql2);
                int newScore = Math.max(gamescore, resultScore);

                preparedStatement.setInt(1, newScore);
                preparedStatement.setString(2, resultUser);
                int rowsUpdated = preparedStatement.executeUpdate();
                if (rowsUpdated > 0) {
                    System.out.println("score updated for: " + resultUser);
                }
            }
            else{
                //dodaj nowe :)
                String sql3 = "INSERT INTO score (username, score) VALUES (?, ?)";

                preparedStatement = connection.prepareStatement(sql3);
                String newUser = name;
                int newScore = gamescore;

                preparedStatement.setString(1, newUser);
                preparedStatement.setInt(2, newScore);

                int rowsInserted = preparedStatement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("user added to table: " + newUser);
                }
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    }






