package sql;

import java.util.Random;

public class Main_sql_homework {
    public static void main(String[] args) {
        int num = 100;
        Random rand = new Random();

        // 좋아요 테이블 데이터 생성기
        for (int i = 1; i <= num ; i++) {
            int rand_int1 = rand.nextInt(44); // post 개수
            int rand_int2 = 1+ rand.nextInt(10); // user_id
            int num2 = rand_int1;

            System.out.println(
            "INSERT INTO `20200207_task03`.`like` (`user_id`,`board_id`,`like`) VALUES (" + rand_int2 + ", "+ num2 + ", 1);"
            );

        }
    }
}