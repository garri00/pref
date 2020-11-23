//For those who know
import java.util.Scanner;

class Main {

    public static void main(String args[]) {

        //config
        int conf_1 = 1; // Спрашивать при запуске количество игроков


        //
        //
        int m = 0;
        boolean mm = true;
        boolean mpl = true;
        boolean mp = true;
        boolean game = false;

        //
        int number_players = 0;
        int chosen_player = 0;
        int player_menu = 0;
        int pula_menu = 0;
        int pl_vists = 0;
        int pl_ch_vists = 0;

        int min_gora;
        int min_gora_id = 0;

        String N_name;


        Player[] container = new Player[]
                {


                        new Player(0) ,
                        new Player(1) ,
                        new Player(2) ,
                        new Player(3) ,
                        new Player(4)

                };


        container[1].Name = "W";
        container[2].Name = "S";
        container[3].Name = "E";
        container[4].Name = "Petya";

        container[1].Gora = 322;
        container[2].Gora = 82;
        container[3].Gora = 124;
        container[4].Gora = 4;

        container[1].Vist[2] = 124;
        container[1].Vist[3] = 120;
        container[1].Vist[4] = 0;

        container[2].Vist[1] = 28;
        container[2].Vist[3] = 142;
        container[2].Vist[4] = 0;

        container[3].Vist[1] = 240;
        container[3].Vist[2] = 154;
        container[3].Vist[4] = 0;
//
//        container[1].Score = -1484;
//        container[2].Score = 832;
//        container[3].Score = 652;
//        container[4].Score = -100;





        if (conf_1 == 1){
            number_players = Menu.chose_num_players();
            System.out.println("Игроков : " + number_players);
        }



        while (mm) {

            Menu.showmenu();
            Scanner t = new Scanner(System.in);
            m = t.nextInt();

            switch (m) {

                case 0:  //Выключить
                    System.out.println("OFF");
                    mm = false;
                    break;

                case 1:  //Визвать меню
                    System.out.println("МЕНЮ");
                    break;

                case 2:  //Добавить игрока

                    if(number_players == 3){

                        Menu.Add_Players(container,3);
                        Menu.SW_PLAYERS(container, number_players);
                    }
                    else if (number_players == 4){

                        Menu.Add_Players(container,4);
                        Menu.SW_PLAYERS(container, number_players);
                    }
                    else {

                        number_players = Menu.chose_num_players();
                        System.out.println("Игроков : " + number_players);
                        System.out.println("");
                    }
                    break;

                case 3:  //Выбрать игрока

                    if (number_players > 0 && number_players < 5) {
                        Menu.SW_PLAYERS(container, number_players);
                    }
                    else {
                        number_players = Menu.chose_num_players();
                        Menu.SW_PLAYERS(container, number_players);
                    }

                    chosen_player = Menu.chose_player();

                    container[chosen_player].ShowPlayer();

                    while (mpl) {

                        Player.Show_Stat(container,chosen_player,number_players);
                        Menu.chosen_player_menu();
                        Scanner a33 = new Scanner(System.in);
                        player_menu = a33.nextInt();

                        switch (player_menu){
                            case 0 :
                                mpl = false;
                                break;
                            case 1 : //Изменить имя
                                System.out.print("Новое имя : ");
                                Scanner a3_1 = new Scanner(System.in);
                                N_name = a3_1.nextLine();
                                Player.Change_Name(container,chosen_player ,N_name);
                                System.out.println(container[chosen_player].ID +"."+container[chosen_player].Name );
                                break;

                            case 2://Stats
                                Player.Show_Stat(container, chosen_player, number_players);
                                break;

                            case 3://Изменить пулю
                                Player.Show_Stat(container,chosen_player,number_players);
                                Menu.pula_menu();

                                while (mp){
                                    Scanner a333 = new Scanner(System.in);
                                    pula_menu = a333.nextInt();

                                    switch (pula_menu){

                                        case 0:
                                            mp =false;
                                            break;
                                        case 1://Изменить пулю
                                            System.out.println("Пуля : ");
                                            Scanner a333_1 = new Scanner(System.in);
                                            container[chosen_player].Pula = a333_1.nextInt();
                                            Player.Show_Stat(container,chosen_player,number_players);
                                            Menu.pula_menu();
                                            break;
                                        case 2://ИЗменить горку
                                            System.out.println("Гора : ");
                                            Scanner a333_2 = new Scanner(System.in);
                                            container[chosen_player].Gora = a333_2.nextInt();
                                            Player.Show_Stat(container,chosen_player,number_players);
                                            Menu.pula_menu();
                                            break;
                                        case 3://Изменить висти
                                            System.out.print("Виберете игока на которого хотите изменить висти : ");
                                            Scanner a333_3 = new Scanner(System.in);
                                            pl_ch_vists = a333_3.nextInt();


                                            System.out.println("Висты на " + container[pl_ch_vists].SW_Player() + ":");
                                            Scanner a333_33 = new Scanner(System.in);
                                            pl_vists = a333_33.nextInt();

                                            container[chosen_player].Vist[pl_ch_vists]=pl_vists;

                                            Player.Show_Stat(container,chosen_player,number_players);
                                            Menu.pula_menu();
                                            break;
                                    }
                                }
                                mp = true;
                                break;
                        }
                    }
                    mpl = true;

                    break;

                case 4:  //Расчитать пулю

                    Menu.Start(container,number_players);
                    break;

                case 5:  //Выбрать количество игроков
                    number_players = Menu.chose_num_players();
                    System.out.println("Игроков : " + number_players);
                    break;

                case 6:  //Начать новую игру

                    //Вибрать количество игроков
                    number_players = Menu.chose_num_players();
                    System.out.println("Игроков : " + number_players);

                    //Добавляем игроков
                    for (int y = 1; y <= number_players; y++){
                        container[y].AddPlName();
                    }

                    //Записиваем статистику
                    for (int p = 1; p<=number_players; p++){

                        container[p].ShowPlayer();

                        System.out.print("Пуля : ");
                        Scanner a6_1 = new Scanner(System.in);
                        container[p].Pula = a6_1.nextInt();

                        System.out.print("Гора : ");
                        Scanner a6_2 = new Scanner(System.in);
                        container[p].Gora = a6_2.nextInt();

                        // запись вистов
                        if( p == 1){
                            //Висти на ,2,3,4

                            Player.Vist_on_player(container,1,2);
                            Player.Vist_on_player(container,1,3);

                            if (number_players>3){
                                Player.Vist_on_player(container,1,4);
                            }
                        }
                        else if (p == 2){
                            //Висти на игрока 1.3.4
                            Player.Vist_on_player(container,2,1);
                            Player.Vist_on_player(container,2,3);

                            if (number_players>3){
                                Player.Vist_on_player(container,2,4);
                            }

                        }
                        else if (p == 3){
                            //Висти на игрока 1.2.4
                            Player.Vist_on_player(container,3,1);
                            Player.Vist_on_player(container,3,2);


                            if (number_players>3){
                                Player.Vist_on_player(container,3,4);
                            }

                        }
                        else{
                            Player.Vist_on_player(container,4,1);
                            Player.Vist_on_player(container,4,2);
                            Player.Vist_on_player(container,4,3);
                        }

                    }

                    //Считаем пулю
                    Menu.Start(container,number_players);
                    break;

            }
        }
    }
}