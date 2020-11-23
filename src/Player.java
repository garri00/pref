import java.util.Scanner;

public class Player {
    //Inditification
    int ID;
    public String Name;
    //Game
    public int Gora;
    public int Pula;
    public int Score;

    public int[] Vist = new int[5];

    public int Vist_1 = Vist[1];
    public int Vist_2 = Vist[2];
    public int Vist_3 = Vist[3];
    public int Vist_4 = Vist[4];

    public int getGora() {
        return Gora;
    }

    public void setGora(int gora) {
        Gora = gora;
    }

    public int getPula() {
        return Pula;
    }

    public void setPula(int pula) {
        Pula = pula;
    }

    Player(int id){
        this.ID = id;
    }


    public void AddPlayer(int id){

        System.out.println("Новий игрок");

        Scanner scanner = new Scanner(System.in);
        Name = scanner.nextLine();

        System.out.println( "Имя игрока : " + ID + "." + Name);
    }

    public void AddPlName (){

        System.out.println("Введите имя игрока ");

        Scanner scanner = new Scanner(System.in);
        Name = scanner.nextLine();

        System.out.println( "Имя игрока : " + ID + "." + Name);
    }


    public void ShowPlayer(){

        System.out.println(ID + "." + Name );
    }

    public String SW_Player(){

        return  ID + "." + Name;
    }

    public static void Change_Name(Player[] ct, int ch_p, String New_name){
        ct[ch_p].Name = New_name;
    }

    public static void Show_Stat(Player[] ct, int ch_p, int pl_nm){

        ct[ch_p].ShowPlayer();
        System.out.println("Пуля : " + ct[ch_p].Pula);
        System.out.println("Гора : " + ct[ch_p].Gora);

        if (pl_nm == 4) {
            switch (ch_p) {
                default:
                    break;
                case 1://Игрок 1
                    System.out.println("Висты на игрока " + ct[2].SW_Player() + " " + ct[ch_p].Vist[2]); //
                    System.out.println("Висты на игрока " + ct[3].SW_Player() + " " + ct[ch_p].Vist[3]); //
                    System.out.println("Висты на игрока " + ct[4].SW_Player() + " " + ct[ch_p].Vist[4]); //
                    break;
                case 2://Игрок 2
                    System.out.println("Висты на игрока " + ct[1].SW_Player() + " " + ct[ch_p].Vist[1]);
                    System.out.println("Висты на игрока " + ct[3].SW_Player() + " " + ct[ch_p].Vist[3]);
                    System.out.println("Висты на игрока " + ct[4].SW_Player() + " " + ct[ch_p].Vist[4]);
                    break;
                case 3://Игрок 3
                    System.out.println("Висты на игрока " + ct[1].SW_Player() + " " + ct[ch_p].Vist[1]);
                    System.out.println("Висты на игрока " + ct[2].SW_Player() + " " + ct[ch_p].Vist[2]);
                    System.out.println("Висты на игрока " + ct[4].SW_Player() + " " + ct[ch_p].Vist[4]);
                    break;
                case 4://Игрок 4
                    System.out.println("Висты на игрока " + ct[1].SW_Player() + " " + ct[ch_p].Vist[1]);
                    System.out.println("Висты на игрока " + ct[2].SW_Player() + " " + ct[ch_p].Vist[2]);
                    System.out.println("Висты на игрока " + ct[4].SW_Player() + " " + ct[ch_p].Vist[3]);
                    break;
            }
        }
        else if (pl_nm == 3){

            switch (ch_p) {
                default:
                    break;
                case 1://Игрок 1
                    System.out.println("Висты на игрока " + ct[2].SW_Player() + " " + ct[ch_p].Vist[2]); //
                    System.out.println("Висты на игрока " + ct[3].SW_Player() + " " + ct[ch_p].Vist[3]); //

                    break;
                case 2://Игрок 2
                    System.out.println("Висты на игрока " + ct[1].SW_Player() + " " + ct[ch_p].Vist[1]);
                    System.out.println("Висты на игрока " + ct[3].SW_Player() + " " + ct[ch_p].Vist[3]);

                    break;
                case 3://Игрок 3
                    System.out.println("Висты на игрока " + ct[1].SW_Player() + " " + ct[ch_p].Vist[1]);
                    System.out.println("Висты на игрока " + ct[3].SW_Player() + " " + ct[ch_p].Vist[2]);

                    break;
            }
        }
    }

    public static void Vist_on_player (Player[] ct, int pl_ch , int pl_id){

        System.out.print(" Висти на игрока " + ct[pl_id].SW_Player() + ": ");
        Scanner vist = new Scanner(System.in);
        ct[pl_ch].Vist[pl_id] = vist.nextInt() ;
    }
}
