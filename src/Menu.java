import java.util.Scanner;

public class Menu {
    public static void showmenu(){
        System.out.println("1.Вызвать меню");
        System.out.println("2.Добавить игроков");
        System.out.println("3.Выбрать игрока");
        System.out.println("4.Расчитать пулю");
        System.out.println("5.Выбрать количество игроков");
        System.out.println("6.Начать новую игру");
        System.out.println("0.Выключит");
    }
    public static int chose_num_players(){
        System.out.println("Выберете количество игроков 3 или 4");
        Scanner n = new Scanner(System.in);
        int nn = n.nextInt();
        if (nn == 3){
            nn = 3;
        }
        else if (nn == 4){
            nn = 4;
        }
        else{
            nn = Menu.chose_num_players();
        }
        return nn;
    }

    public static int chose_player(){

        System.out.print("Выберете номер игрока : ");
        Scanner pl_num = new Scanner(System.in);

        int pl_NUM = pl_num.nextInt();

        if (pl_NUM >0 && pl_NUM<5){
            return pl_NUM;
        }
        else{
            pl_NUM = Menu.chose_player();
        }
        return pl_NUM;
    }

    public static void SW_PLAYERS(Player [] ct ,int NUM){


        for (int i = 1; i<= NUM;i++) {

            ct[i].ShowPlayer();

        }

    }

    public static void Add_Players(Player [] ct,int NUM){

        for (int i = 1; i<=NUM; i++){
            System.out.println("Имя : ");
            Scanner scanner = new Scanner(System.in);
            ct[i].Name = scanner.nextLine();


        }

    }

    public static void pula_menu(){
        System.out.println("1.Изменить Пулю");
        System.out.println("2.Изменить Горку");
        System.out.println("3.Изменить Висти");
        System.out.println("0.Выйти");
    }

    public static void chosen_player_menu(){
        System.out.println("1.Изменить Имя");
        System.out.println("2.Отобразить пулю");
        System.out.println("3.Изменить пулю");
        System.out.println("0.Выйти из меню игрока");

    }


    public static void Amnist(Player [] ct , int num, int min_g){

        for (int i = 1; i<=num; i++){
            ct[i].Gora-=min_g;
        }

    }

    public static void Final(Player [] ct, int num){

        System.out.println("Итог : ");

        int id [] = new int[5];
        //Передача масиву результатов

        for (int c = 1; c <= num; c++){
            id[c] = ct[c].Score;
        }
        //Сортировка результатов

        for (int i = 1; i <=num; i++) {
            int max = id[i];
            int max_i = i;

            for (int j = i+1; j <=num; j++) {

                if (id[j] > max) {
                    max = id[j];
                    max_i = j;
                }
            }
            if (i != max_i) {
                int tmp = id[i];
                id[i] = id[max_i];
                id[max_i] = tmp;
            }
        }
        //Вывод результатов

        for (int r = 1; r <= num; r++){

            for (int rr = 1 ;rr <= num; rr++){
                if (id[r] == ct[rr].Score){
                    System.out.println(ct[rr].SW_Player() +" счёт : "+ ct[rr].Score);
                }
            }
        }
    }

    public static void Vist_Players(Player [] ct, int num){
        //4.Вищитиваем висти на каждого игрока

        //Висти между 1 и 2
        if (ct[1].Vist[2]<ct[2].Vist[1]){

            // ct[2].Vist[1]-=ct[1].Vist[2];

            ct[2].Vist_1 = ct[2].Vist[1]-ct[1].Vist[2];
            ct[1].Vist_2 -= ct[2].Vist[1]-ct[1].Vist[2];
        }
        else {

            //ct[1].Vist[2]-=ct[2].Vist[1];

            ct[2].Vist_1 -= ct[1].Vist[2]-ct[2].Vist[1];
            ct[1].Vist_2 =  ct[1].Vist[2]-ct[2].Vist[1];

        }

        //Висти между 1 и 3
        if (ct[1].Vist[3]<ct[3].Vist[1]){

            // ct[3].Vist[1]-=ct[1].Vist[3];

            ct[3].Vist_1 = ct[3].Vist[1]-ct[1].Vist[3];
            ct[1].Vist_3 -= ct[3].Vist[1]-ct[1].Vist[3];

        }
        else{

            // ct[1].Vist[3]-ct[3].Vist[1];

            ct[3].Vist_1 -= ct[1].Vist[3]-ct[3].Vist[1];
            ct[1].Vist_3 = ct[1].Vist[3]-ct[3].Vist[1];
        }

        //Висти между 1 и 4 (4)

        if (ct[1].Vist[4] < ct[4].Vist[1]){

            //ct[4].Vist[1]-=ct[1].Vist[4];

            ct[4].Vist_1 = ct[4].Vist[1]-ct[1].Vist[4];
            ct[1].Vist_4 -= ct[4].Vist[1]-ct[1].Vist[4];

        }
        else {

            // ct[1].Vist[4]-ct[4].Vist[1];

            ct[4].Vist_1 -= ct[1].Vist[4]-ct[4].Vist[1];
            ct[1].Vist_4 = ct[1].Vist[4]-ct[4].Vist[1];

        }

        //Висти между 2 и 3
        if(ct[2].Vist[3]<ct[3].Vist[2]){
            //ct[3].Vist[2]-ct[2].Vist[3];

            ct[2].Vist_3 -= ct[3].Vist[2]-ct[2].Vist[3];
            ct[3].Vist_2 = ct[3].Vist[2]-ct[2].Vist[3];


        }
        else{
            //ct[2].Vist[3]-ct[3].Vist[2];

            ct[2].Vist_3 = ct[2].Vist[3]-ct[3].Vist[2];
            ct[3].Vist_2 -= ct[2].Vist[3]-ct[3].Vist[2];

        }

        //Висти между 2 и 4 (4)
        if(ct[2].Vist[4]<ct[4].Vist[2]){

            //ct[4].Vist[2]-ct[2].Vist[4];

            ct[2].Vist_4 -= ct[4].Vist[2]-ct[2].Vist[4];
            ct[4].Vist_2 = ct[4].Vist[2]-ct[2].Vist[4];


        }
        else{
            //ct[2].Vist[4]-ct[4].Vist[2];

            ct[2].Vist_4 = ct[2].Vist[4]-ct[4].Vist[2];
            ct[4].Vist_2 -= ct[2].Vist[4]-ct[4].Vist[2];

        }

        //Висти между 4 и 3 (4)

        if (ct[4].Vist[3]<ct[3].Vist[4]){

            // ct[3].Vist[4]-=ct[4].Vist[3];

            ct[3].Vist_4 = ct[3].Vist[4]-ct[4].Vist[3];
            ct[4].Vist_3 -= ct[3].Vist[4]-ct[4].Vist[3];

        }
        else{

            // ct[4].Vist[3]-ct[3].Vist[4];

            ct[3].Vist_4 -= ct[4].Vist[3]-ct[3].Vist[4];
            ct[4].Vist_3 = ct[4].Vist[3]-ct[3].Vist[4];
        }





    }



    public static void Start(Player [] ct,int num){

        int min_gora;
        int min_gora_id;
        //0.Виводим статистику всех игроков
        for (int i =1; i<= num;i++){
            Player.Show_Stat(ct,i,num);
            System.out.println("");
        }



        //1.Висчитивае мнимальную гору

        // На 3
        if(num == 3) {


            //Минимальная гора у 1
            if (ct[1].Gora < ct[2].Gora && ct[1].Gora < ct[3].Gora) {
                min_gora = ct[1].Gora;
                min_gora_id = 1;

                //2.Амнистируем у всех мин гору
                Menu.Amnist(ct, num, min_gora);


                //3.Вищитиваем висти по горе

                //Пишем висти на игроека 2
                ct[2].Gora *= 10;
                ct[2].Gora /= 3;

                ct[1].Vist[2] += ct[2].Gora;
                ct[3].Vist[2] += ct[2].Gora;

                //Пишем висти на игроека 3
                ct[3].Gora *= 10;
                ct[3].Gora /= 3;

                ct[1].Vist[3] += ct[3].Gora;
                ct[2].Vist[3] += ct[3].Gora;

                //4.Вищитиваем висти на каждого игрока

                Menu.Vist_Players(ct, num);

                //5.Щитаем игру

                for (int i = 1; i <= num; i++) {
                    ct[i].Score = ct[i].Vist_1 + ct[i].Vist_2 + ct[i].Vist_3;
                }

                //6.Виводим победителя
                Menu.Final(ct, num);


            }
            //Минимальная гора у 2
            else if (ct[2].Gora < ct[1].Gora && ct[2].Gora < ct[3].Gora) {
                min_gora = ct[2].Gora;
                min_gora_id = 2;

                //2.Амнистируем у всех мин гору
                Menu.Amnist(ct, num, min_gora);

                //3.Вищитиваем висти по горе

                //Пишем висти на игроека 1
                ct[1].Gora *= 10;
                ct[1].Gora /= 3;

                ct[2].Vist[1] += ct[1].Gora;
                ct[3].Vist[1] += ct[1].Gora;

                //Пишем висти на игроека 3
                ct[3].Gora *= 10;
                ct[3].Gora /= 3;

                ct[1].Vist[3] += ct[3].Gora;
                ct[2].Vist[3] += ct[3].Gora;

                //4.Вищитиваем висти на каждого игрока

                Menu.Vist_Players(ct, num);

                //5.Щитаем игру

                for (int i = 1; i <= num; i++) {
                    ct[i].Score = ct[i].Vist_1 + ct[i].Vist_2 + ct[i].Vist_3;
                }

                //6.Виводим победителя
                Menu.Final(ct, num);
            }
            //Минимальная гора у 3
            else {

                min_gora = ct[3].Gora;
                min_gora_id = 3;

                //2.Амнистируем у всех мин гору
                Menu.Amnist(ct, num, min_gora);

                //3.Вищитиваем висти по горе

                //Пишем висти на игроека 1
                ct[1].Gora *= 10;
                ct[1].Gora /= 3;

                ct[2].Vist[1] += ct[1].Gora;
                ct[3].Vist[1] += ct[1].Gora;

                //Пишем висти на игроека 2
                ct[2].Gora *= 10;
                ct[2].Gora /= 3;

                ct[1].Vist[2] += ct[2].Gora;
                ct[3].Vist[2] += ct[2].Gora;

                //4.Вищитиваем висти на каждого игрока

                Menu.Vist_Players(ct, num);

                //5.Щитаем игру

                for (int i = 1; i <= num; i++) {
                    ct[i].Score = ct[i].Vist_1 + ct[i].Vist_2 + ct[i].Vist_3;
                }

                //6.Виводим победителя
                Menu.Final(ct, num);
            }
        }

        //На 4
        else if ( num == 4){

            //Минимальная гора у 1
            if (ct[1].Gora < ct[2].Gora && ct[1].Gora < ct[3].Gora && ct[1].Gora < ct[4].Gora) {
                min_gora = ct[1].Gora;
                min_gora_id = 1;

                //2.Амнистируем у всех мин гору
                Menu.Amnist(ct, num, min_gora);

                //3.Вищитиваем висти по горе

                //Пишем висти на игроека 2
                ct[2].Gora *= 10;
                ct[2].Gora /= 4;

                ct[1].Vist[2] += ct[2].Gora;
                ct[3].Vist[2] += ct[2].Gora;
                ct[4].Vist[2] += ct[2].Gora;

                //Пишем висти на игроека 3
                ct[3].Gora *= 10;
                ct[3].Gora /= 4;

                ct[1].Vist[3] += ct[3].Gora;
                ct[2].Vist[3] += ct[3].Gora;
                ct[4].Vist[3] += ct[3].Gora;

                //Пишем висти на 4
                ct[4].Gora *= 10;
                ct[4].Gora /= 4;

                ct[1].Vist[4] += ct[4].Gora;
                ct[2].Vist[4] += ct[4].Gora;
                ct[3].Vist[4] += ct[4].Gora;

                //4.Вищитиваем висти на каждого игрока

                Menu.Vist_Players(ct, num);

                //5.Щитаем игру

                for (int i = 1; i <= num; i++) {
                    ct[i].Score = ct[i].Vist_1 + ct[i].Vist_2 + ct[i].Vist_3 + ct[i].Vist_4;
                }

                //6.Виводим победителя
                Menu.Final(ct, num);


            }
            //Минимальная гора у 2
            else if (ct[2].Gora < ct[1].Gora && ct[2].Gora < ct[3].Gora && ct[2].Gora < ct[4].Gora) {

                min_gora = ct[2].Gora;
                min_gora_id = 2;

                //2.Амнистируем у всех мин гору
                Menu.Amnist(ct, num, min_gora);

                //3.Вищитиваем висти по горе

                //Пишем висти на игроека 1
                ct[1].Gora *= 10;
                ct[1].Gora /= 4;

                ct[2].Vist[1] += ct[1].Gora;
                ct[3].Vist[1] += ct[1].Gora;
                ct[4].Vist[1] += ct[1].Gora;

                //Пишем висти на игроека 3
                ct[3].Gora *= 10;
                ct[3].Gora /= 4;

                ct[1].Vist[3] += ct[3].Gora;
                ct[2].Vist[3] += ct[3].Gora;
                ct[4].Vist[3] += ct[3].Gora;

                //Пишем висти на игрока 4
                ct[4].Gora *= 10;
                ct[4].Gora /= 4;

                ct[1].Vist[4] += ct[4].Gora;
                ct[2].Vist[4] += ct[4].Gora;
                ct[3].Vist[4] += ct[4].Gora;

                //4.Вищитиваем висти на каждого игрока

                Menu.Vist_Players(ct, num);

                //5.Щитаем игру

                for (int i = 1; i <= num; i++) {
                    ct[i].Score = ct[i].Vist_1 + ct[i].Vist_2 + ct[i].Vist_3 + ct[i].Vist_4;
                }

                //6.Виводим победителя
                Menu.Final(ct, num);
            }

            //Минимальная гора у 3
            else if (ct[3].Gora < ct[1].Gora && ct[3].Gora < ct[2].Gora && ct[3].Gora < ct[4].Gora) {

                min_gora = ct[3].Gora;
                min_gora_id = 3;

                //2.Амнистируем у всех мин гору
                Menu.Amnist(ct, num, min_gora);

                //3.Вищитиваем висти по горе

                //Пишем висти на игроека 1
                ct[1].Gora *= 10;
                ct[1].Gora /= 4;

                ct[2].Vist[1] += ct[1].Gora;
                ct[3].Vist[1] += ct[1].Gora;
                ct[4].Vist[1] += ct[1].Gora;

                //Пишем висти на игроека 2
                ct[2].Gora *= 10;
                ct[2].Gora /= 4;

                ct[1].Vist[2] += ct[2].Gora;
                ct[3].Vist[2] += ct[2].Gora;
                ct[4].Vist[2] += ct[2].Gora;

                //Пишем висти на игрока 4

                ct[4].Gora *= 10;
                ct[4].Gora /= 4;

                ct[1].Vist[4] += ct[4].Gora;
                ct[2].Vist[4] += ct[4].Gora;
                ct[3].Vist[4] += ct[4].Gora;

                //4.Вищитиваем висти на каждого игрока

                Menu.Vist_Players(ct, num);

                //5.Щитаем игру

                for (int i = 1; i <= num; i++) {
                    ct[i].Score = ct[i].Vist_1 + ct[i].Vist_2 + ct[i].Vist_3;
                }

                //6.Виводим победителя
                Menu.Final(ct, num);
            }

            //Минимальная гора у 4

            else{

                min_gora = ct[4].Gora;
                min_gora_id = 4;

                //2.Амнистируем у всех мин гору
                Menu.Amnist(ct, num, min_gora);

                //3.Вищитиваем висти по горе

                //Пишем висти на игроека 1
                ct[1].Gora *= 10;
                ct[1].Gora /= 4;

                ct[2].Vist[1] += ct[1].Gora;
                ct[3].Vist[1] += ct[1].Gora;
                ct[4].Vist[1] += ct[1].Gora;

                //Пишем висти на игроека 2
                ct[2].Gora *= 10;
                ct[2].Gora /= 4;

                ct[1].Vist[2] += ct[2].Gora;
                ct[3].Vist[2] += ct[2].Gora;
                ct[4].Vist[2] += ct[2].Gora;

                //Пишем висти на игроека 3
                ct[3].Gora *= 10;
                ct[3].Gora /= 4;

                ct[1].Vist[3] += ct[3].Gora;
                ct[2].Vist[3] += ct[3].Gora;
                ct[4].Vist[3] += ct[3].Gora;

                //4.Вищитиваем висти на каждого игрока

                Menu.Vist_Players(ct, num);

                //5.Щитаем игру

                for (int i = 1; i <= num; i++) {
                    ct[i].Score = ct[i].Vist_1 + ct[i].Vist_2 + ct[i].Vist_3;
                }

                //6.Виводим победителя
                Menu.Final(ct, num);
            }
        }

    }
}
